import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class LanguageVisitorImpl extends LanguageBaseVisitor<Void> {
    private Scope symbolTable = new Scope();

    @Override
    public Void visitProgram(LanguageParser.ProgramContext ctx) {
        if (ctx.importDecl() != null) {
            for (var importDecl : ctx.importDecl()) visit(importDecl);
        }
        visit(ctx.mainClass());
        if (ctx.classDecl() != null) {
            for (var classDecl : ctx.classDecl()) visit(classDecl);
        }
        if (ctx.interfaceDecl() != null) {
            for (var interfaceDecl : ctx.interfaceDecl()) visit(interfaceDecl);
        }
        return null;
    }

    @Override
    public Void visitMainClass(LanguageParser.MainClassContext ctx) {
        String className = ctx.Identifier(0).getText();
        symbolTable.pushScope("class_" + className);

        // Add class symbol (main class is not abstract, no parent/interfaces)
        Symbol classSym = new Symbol(className, "class", "class", symbolTable.currentScopeName(), "public", null, null, false, false, null, null);
        symbolTable.addSymbol(classSym);

        // Add main method
        String mainScope = symbolTable.currentScopeName();
        symbolTable.pushScope("method_main");
        String params = "String[] args"; // Fixed for main
        Symbol mainSym = new Symbol("main", "void", "method", mainScope, "public", null, null, false, false, params, null);
        symbolTable.addSymbol(mainSym);
        symbolTable.addSymbol(new Symbol("args", "String[]", "parameter", symbolTable.currentScopeName(), null, null, null, false, false, null, null));

        // Visit statements for locals
        if (ctx.statement() != null) {
            for (var stmt : ctx.statement()) {
                visit(stmt);
            }
        }

        symbolTable.popScope(); // pop method_main
        symbolTable.popScope(); // pop class
        return null;
    }

    @Override
    public Void visitClassDecl(LanguageParser.ClassDeclContext ctx) {
        String className = ctx.Identifier(0).getText();
        symbolTable.pushScope("class_" + className);

        // Extract parent and interfaces
        String parent = null;
        String interfacesStr = null;
        boolean isAbstract = (ctx.getChildCount() > 0 && ctx.getChild(0).getText().equals("abstract"));
        List<String> intfs = new ArrayList<>();
        if (ctx.getText().contains("extends")) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child.getText().equals("extends")) {
                    ParseTree next = ctx.getChild(i + 1);
                    if (next instanceof TerminalNode) {
                        parent = next.getText();
                    }
                    break;
                }
            }
        }
        if (ctx.getText().contains("implements")) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                ParseTree child = ctx.getChild(i);
                if (child.getText().equals("implements")) {
                    for (int j = i + 1; j < ctx.getChildCount(); j++) {
                        ParseTree intChild = ctx.getChild(j);
                        if (intChild.getText().equals(",")) continue;
                        if (intChild instanceof TerminalNode) {
                            int tokenType = ((TerminalNode) intChild).getSymbol().getType();
                            String tokenName = LanguageLexer.VOCABULARY.getSymbolicName(tokenType);
                            if (tokenName != null && tokenName.equals("Identifier")) {
                                intfs.add(intChild.getText());
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            interfacesStr = String.join(", ", intfs);
        }

        // Add class symbol
        Symbol classSym = new Symbol(className, "class", "class", symbolTable.currentScopeName(), null, parent, interfacesStr, isAbstract, false, null, null);
        symbolTable.addSymbol(classSym);

        // Fields
        if (ctx.fieldDecl() != null) {
            for (var fieldDecl : ctx.fieldDecl()) {
                visit(fieldDecl);
            }
        }

        // Constructor
        if (ctx.ctorDecl() != null) {
            visit(ctx.ctorDecl());
        }

        // Methods
        if (ctx.methodDecl() != null) {
            for (var methodDecl : ctx.methodDecl()) {
                visit(methodDecl);
            }
        }

        // Abstract methods
        if (ctx.abstractMethodDecl() != null) {
            for (var absMethod : ctx.abstractMethodDecl()) {
                visit(absMethod);
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitInterfaceDecl(LanguageParser.InterfaceDeclContext ctx) {
        String interfaceName = ctx.Identifier().getText();
        symbolTable.pushScope("interface_" + interfaceName);

        // Add interface symbol
        Symbol intSym = new Symbol(interfaceName, "interface", "interface", symbolTable.currentScopeName(), "public", null, null, false, false, null, null);
        symbolTable.addSymbol(intSym);

        // Interface fields
        if (ctx.interfaceFieldDecl() != null) {
            for (var field : ctx.interfaceFieldDecl()) {
                visit(field);
            }
        }

        // Interface methods
        if (ctx.interfaceMethodDecl() != null) {
            for (var method : ctx.interfaceMethodDecl()) {
                visit(method);
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitFieldDecl(LanguageParser.FieldDeclContext ctx) {
        return visitVarDecl(ctx.varDecl(), "field");
    }

    private Void visitVarDecl(LanguageParser.VarDeclContext ctx, String kind) {
        String access = ctx.accessModifier() != null ? ctx.accessModifier().getText() : null;
        String type = getTypeText(ctx.type());
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        String initialValue = null; // Fields no EQ in grammar

        Symbol sym = new Symbol(name, type, kind, scopeName, access, null, null, false, false, null, initialValue);
        symbolTable.addSymbol(sym);
        return null;
    }

    @Override
    public Void visitLocalDecl(LanguageParser.LocalDeclContext ctx) {
        String type = getTypeText(ctx.type());
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        String initialValue = ctx.EQ() != null ? ctx.expression().getText() : null; // Optional EQ

        Symbol sym = new Symbol(name, type, "variable", scopeName, null, null, null, false, false, null, initialValue);
        symbolTable.addSymbol(sym);
        return null;
    }

    @Override
    public Void visitMethodDecl(LanguageParser.MethodDeclContext ctx) {
        String access = ctx.accessModifier() != null ? ctx.accessModifier().getText() : null;
        String returnType = ctx.type() != null ? getTypeText(ctx.type()) : "void";
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        boolean isOverride = ctx.getText().contains("@Override");
        boolean isAbstract = false; // methodDecl has body

        // Parameters list
        String paramsList = getParameterList(ctx.parameterList());

        Symbol methodSym = new Symbol(name, returnType, "method", scopeName, access, null, null, isAbstract, isOverride, paramsList, null);
        symbolTable.addSymbol(methodSym);

        symbolTable.pushScope("method_" + name);

        // Add params as symbols
        if (ctx.parameterList() != null) {
            for (var param : ctx.parameterList().parameter()) {
                visit(param);
            }
        }

        // Body locals
        if (ctx.methodBody() != null) {
            List<ParseTree> bodyChildren = ctx.methodBody().children;
            if (bodyChildren != null) {
                for (var child : bodyChildren) {
                    if (child instanceof LanguageParser.LocalDeclContext) {
                        visitLocalDecl((LanguageParser.LocalDeclContext) child);
                    } else if (child instanceof LanguageParser.StatementContext) {
                        visit((LanguageParser.StatementContext) child);
                    }
                }
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitCtorDecl(LanguageParser.CtorDeclContext ctx) {
        String access = ctx.accessModifier() != null ? ctx.accessModifier().getText() : null;
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        boolean isOverride = ctx.getText().contains("@Override");

        String paramsList = getParameterList(ctx.parameterList());

        Symbol ctorSym = new Symbol(name, "constructor", "constructor", scopeName, access, null, null, false, isOverride, paramsList, null);
        symbolTable.addSymbol(ctorSym);

        symbolTable.pushScope("ctor_" + name);

        if (ctx.parameterList() != null) {
            for (var param : ctx.parameterList().parameter()) {
                visit(param);
            }
        }

        if (ctx.methodBody() != null) {
            List<ParseTree> bodyChildren = ctx.methodBody().children;
            if (bodyChildren != null) {
                for (var child : bodyChildren) {
                    if (child instanceof LanguageParser.LocalDeclContext) {
                        visitLocalDecl((LanguageParser.LocalDeclContext) child);
                    } else if (child instanceof LanguageParser.StatementContext) {
                        visit((LanguageParser.StatementContext) child);
                    }
                }
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitAbstractMethodDecl(LanguageParser.AbstractMethodDeclContext ctx) {
        String access = ctx.accessModifier() != null ? ctx.accessModifier().getText() : null;
        String returnType = ctx.type() != null ? getTypeText(ctx.type()) : "void";
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        boolean isOverride = ctx.getText().contains("@Override");
        boolean isAbstract = true;

        String paramsList = getParameterList(ctx.parameterList());

        Symbol absSym = new Symbol(name, returnType, "method", scopeName, access, null, null, isAbstract, isOverride, paramsList, null);
        symbolTable.addSymbol(absSym);

        symbolTable.pushScope("abstract_method_" + name);

        if (ctx.parameterList() != null) {
            for (var param : ctx.parameterList().parameter()) {
                visit(param);
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitInterfaceMethodDecl(LanguageParser.InterfaceMethodDeclContext ctx) {
        String returnType = ctx.type() != null ? getTypeText(ctx.type()) : "void";
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        boolean isAbstract = true; // Interface methods are abstract

        String paramsList = getParameterList(ctx.parameterList());

        Symbol intSym = new Symbol(name, returnType, "interface_method", scopeName, "public", null, null, isAbstract, false, paramsList, null);
        symbolTable.addSymbol(intSym);

        symbolTable.pushScope("interface_method_" + name);

        if (ctx.parameterList() != null) {
            for (var param : ctx.parameterList().parameter()) {
                visit(param);
            }
        }

        symbolTable.popScope();
        return null;
    }

    @Override
    public Void visitParameter(LanguageParser.ParameterContext ctx) {
        String type = getTypeText(ctx.type());
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();

        Symbol paramSym = new Symbol(name, type, "parameter", scopeName, null, null, null, false, false, null, null);
        symbolTable.addSymbol(paramSym);
        return null;
    }

    @Override
    public Void visitInterfaceFieldDecl(LanguageParser.InterfaceFieldDeclContext ctx) {
        String type = getTypeText(ctx.type());
        String name = ctx.Identifier().getText();
        String scopeName = symbolTable.currentScopeName();
        String initialValue = ctx.expression().getText(); // Always EQ in grammar

        Symbol fieldSym = new Symbol(name, type, "interface_field", scopeName, "public", null, null, false, false, null, initialValue);
        symbolTable.addSymbol(fieldSym);
        return null;
    }

    @Override
    public Void visitLocalDeclStmt(LanguageParser.LocalDeclStmtContext ctx) {
        return visitLocalDecl(ctx.localDecl());
    }

    private String getParameterList(LanguageParser.ParameterListContext paramListCtx) {
        if (paramListCtx == null) return null;
        List<String> params = new ArrayList<>();
        for (var param : paramListCtx.parameter()) {
            String type = getTypeText(param.type());
            String name = param.Identifier().getText();
            params.add(type + " " + name);
        }
        return String.join(", ", params);
    }

    // Helper to get type text
    private String getTypeText(LanguageParser.TypeContext typeCtx) {
        if (typeCtx == null) return "";
        String baseType = typeCtx.javaType() != null ? typeCtx.javaType().getText() :
                          typeCtx.Identifier() != null ? typeCtx.Identifier().getText() : "";
        if (typeCtx.LSB() != null) {
            baseType += "[]";
        }
        return baseType;
    }

    // Getter for symbol table
    public Scope getSymbolTable() {
        return symbolTable;
    }

    // Default visit for others
    @Override
    public Void visit(ParseTree tree) {
        return super.visit(tree);
    }
}