import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class SymbolTableBuilder extends LanguageBaseListener {
    private SymbolTable currentScope;
    private final SymbolTable globalTable = new SymbolTable("global", null);

    public SymbolTableBuilder() {
        this.currentScope = globalTable;
    }

    @Override
    public void enterClassDecl(LanguageParser.ClassDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        SymbolInfo cls = new SymbolInfo(name, "class");
        cls.access = getAccessModifier(ctx);
        cls.isAbstract = ctx.ABSTRACT() != null;

        if (ctx.type() != null)
            cls.parent = ctx.type().getText();

        if (ctx.typeList() != null) {
            for (LanguageParser.TypeContext t : ctx.typeList().type()) {
                cls.interfaces.add(t.getText());
            }
        }

        currentScope.insert(cls);
        SymbolTable classScope = new SymbolTable("class-" + name, currentScope);
        cls.parent = currentScope.scopeName;
        currentScope = classScope;
    }

    @Override
    public void exitClassDecl(LanguageParser.ClassDeclContext ctx) {
        currentScope = currentScope.parent;
    }

    @Override
    public void enterInterfaceDecl(LanguageParser.InterfaceDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        SymbolInfo iface = new SymbolInfo(name, "interface");
        iface.access = getAccessModifier(ctx);
        iface.isAbstract = true;

        if (ctx.typeList() != null) {
            for (LanguageParser.TypeContext t : ctx.typeList().type()) {
                iface.interfaces.add(t.getText());
            }
        }

        currentScope.insert(iface);
        SymbolTable interfaceScope = new SymbolTable("interface-" + name, currentScope);
        iface.parent = currentScope.scopeName;
        currentScope = interfaceScope;
    }

    @Override
    public void exitInterfaceDecl(LanguageParser.InterfaceDeclContext ctx) {
        currentScope = currentScope.parent;
    }

    @Override
    public void enterMethodDecl(LanguageParser.MethodDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        SymbolInfo method = new SymbolInfo(name, "method");
        method.access = getAccessModifier(ctx);
        method.isAbstract = ctx.ABSTRACT() != null;

        if (ctx.type() != null)
            method.dataType = ctx.type().getText();
        else if (ctx.VOID() != null)
            method.dataType = "void";

        boolean isStatic = ctx.STATIC() != null;
        method.value = isStatic ? "static=true" : "static=false";

        if (currentScope.scopeName.startsWith("interface-")) {
            method.access = "public";
            method.isAbstract = true;
            method.value = "static=false";
        }

        if (ctx.paramList() != null) {
            for (LanguageParser.ParamContext p : ctx.paramList().param()) {
                SymbolInfo param = new SymbolInfo(p.IDENTIFIER().getText(), "parameter");
                param.dataType = p.type().getText();
                method.parameters.add(param);
            }
        }

        currentScope.insert(method);

        for (SymbolInfo param : method.parameters) {
            param.parent = currentScope.scopeName;
        }

        if (ctx.block() != null) {
            SymbolTable methodScope = new SymbolTable("method-" + name, currentScope);
            method.parent = currentScope.scopeName;
            currentScope = methodScope;
        }
    }

    @Override
    public void exitMethodDecl(LanguageParser.MethodDeclContext ctx) {
        if (currentScope.scopeName.startsWith("method-")) {
            currentScope = currentScope.parent;
        }
    }

    @Override
    public void enterConstructorDecl(LanguageParser.ConstructorDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        SymbolInfo ctor = new SymbolInfo(name, "constructor");
        ctor.access = getAccessModifier(ctx);
        ctor.dataType = name;
        ctor.value = "static=false";

        if (ctx.paramList() != null) {
            for (LanguageParser.ParamContext p : ctx.paramList().param()) {
                SymbolInfo param = new SymbolInfo(p.IDENTIFIER().getText(), "parameter");
                param.dataType = p.type().getText();
                ctor.parameters.add(param);
            }
        }

        currentScope.insert(ctor);

        for (SymbolInfo param : ctor.parameters) {
            param.parent = currentScope.scopeName;
        }

        if (ctx.block() != null) {
            SymbolTable ctorScope = new SymbolTable("constructor-" + name, currentScope);
            ctor.parent = currentScope.scopeName;
            currentScope = ctorScope;

            for (LanguageParser.StatementContext stmt : ctx.block().statement()) {
                if (stmt.exprStatement() != null && stmt.exprStatement().expr() != null) {
                    LanguageParser.AssignmentExprContext assign = stmt.exprStatement().expr().assignmentExpr();
                    if (assign != null && assign.conditionalExpr() != null && assign.conditionalExpr().logicalOrExpr() != null) {
                        String left = assign.conditionalExpr().getText();
                        if (left.startsWith("this.")) {
                            String fieldName = left.substring(5);
                            String value = assign.assignmentExpr().getText();
                            SymbolInfo field = currentScope.parent.lookup(fieldName);
                            if (field != null && field.value.equals("null")) {
                                field.value = value;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void exitConstructorDecl(LanguageParser.ConstructorDeclContext ctx) {
        if (currentScope.scopeName.startsWith("constructor-")) {
            currentScope = currentScope.parent;
        }
    }

    @Override
    public void enterVarDecl(LanguageParser.VarDeclContext ctx) {
        if (currentScope.scopeName.equals("global")) return;

        SymbolInfo var = new SymbolInfo(ctx.IDENTIFIER().getText(), "variable");
        var.dataType = ctx.type().getText();
        var.access = getAccessModifier(ctx);
        var.parent = currentScope.scopeName;

        if (ctx.expr() != null) {
            String exprText = ctx.expr().getText();
            if (exprText.startsWith("new")) {
                var.value = exprText.replaceFirst("new\\s*", "new ");
            } else {
                var.value = exprText;
            }
        }

        currentScope.insert(var);
    }

    private String getAccessModifier(ParserRuleContext ctx) {
        String text = ctx.getText();
        if (text.contains("public")) return "public";
        if (text.contains("private")) return "private";
        if (text.contains("protected")) return "protected";
        return "default";
    }

    public SymbolTable getGlobalTable() {
        return globalTable;
    }
}