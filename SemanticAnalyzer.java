import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * SemanticAnalyzer - تحلیلگر معنایی که از جدول نماد تولید شده توسط LanguageVisitorImpl استفاده می‌کند
 * این کلاس دیگر از LanguageBaseVisitor extend نمی‌کند و فقط روی جدول نماد کار می‌کند
 */
public class SemanticAnalyzer {
    private Scope symbolTable;
    private ParseTree parseTree;
    private List<SemanticError> errors = new ArrayList<>();
    private Map<String, Set<String>> scopeSymbols = new HashMap<>(); // Track symbols per scope
    private Set<String> definedClasses = new HashSet<>();
    private Set<String> definedInterfaces = new HashSet<>();
    private Map<String, String> classHierarchy = new HashMap<>(); // class -> parent class
    
    public SemanticAnalyzer(Scope symbolTable, ParseTree parseTree) {
        this.symbolTable = symbolTable;
        this.parseTree = parseTree;
    }
    
    /**
     * تحلیل معنایی بر اساس جدول نماد
     */
    public void analyze() {
        List<Symbol> allSymbols = symbolTable.getAllSymbols();
        
        // جمع‌آوری اطلاعات کلاس‌ها و اینترفیس‌ها
        collectClassAndInterfaceInfo(allSymbols);
        
        // بررسی خطاها
        checkDuplicateDefinitions(allSymbols);
        checkInheritanceCycles();
        checkImports();
        checkPrivateMethodAccess(allSymbols);
        checkMethodParameterMismatch(allSymbols);
        checkReturnTypeMismatch(allSymbols);
        checkAssignmentTypeMismatch();
        checkArrayIndexErrors();
        checkVariableAccessErrors();
    }
    
    /**
     * جمع‌آوری اطلاعات کلاس‌ها و اینترفیس‌ها از جدول نماد
     */
    private void collectClassAndInterfaceInfo(List<Symbol> symbols) {
        for (Symbol sym : symbols) {
            if ("class".equals(sym.getKind())) {
                definedClasses.add(sym.getName());
                if (sym.getParent() != null && !sym.getParent().isEmpty()) {
                    classHierarchy.put(sym.getName(), sym.getParent());
                }
            } else if ("interface".equals(sym.getKind())) {
                definedInterfaces.add(sym.getName());
            }
        }
    }
    
    /**
     * بررسی تعریف تکراری
     */
    private void checkDuplicateDefinitions(List<Symbol> symbols) {
        // برای کلاس‌ها و اینترفیس‌ها: بررسی در scope "global"
        Map<String, List<Symbol>> globalClasses = new HashMap<>();
        Map<String, List<Symbol>> globalInterfaces = new HashMap<>();
        
        // برای سایر موارد: بررسی در scope مربوطه
        Map<String, Map<String, List<Symbol>>> scopeKindNameMap = new HashMap<>();
        
        for (Symbol sym : symbols) {
            String scope = sym.getScope();
            String kind = sym.getKind();
            String name = sym.getName();
            
            // کلاس‌ها و اینترفیس‌ها در scope global بررسی می‌شوند
            if ("class".equals(kind)) {
                if (!globalClasses.containsKey(name)) {
                    globalClasses.put(name, new ArrayList<>());
                }
                List<Symbol> classList = globalClasses.get(name);
                if (classList.size() > 0) {
                    // تکراری است
                    int line = findLineNumberForSymbol(sym);
                    addError("خطای تعریف تکراری: کلاس '" + name + "' قبلاً تعریف شده است", line);
                }
                classList.add(sym);
            } else if ("interface".equals(kind)) {
                if (!globalInterfaces.containsKey(name)) {
                    globalInterfaces.put(name, new ArrayList<>());
                }
                List<Symbol> interfaceList = globalInterfaces.get(name);
                if (interfaceList.size() > 0) {
                    // تکراری است
                    int line = findLineNumberForSymbol(sym);
                    addError("خطای تعریف تکراری: اینترفیس '" + name + "' قبلاً تعریف شده است", line);
                }
                interfaceList.add(sym);
            } else {
                // برای سایر موارد (field, variable, method, etc.)
                // برای متدها، signature را در نظر بگیریم
                String key = name;
                if ("method".equals(kind) || "constructor".equals(kind) || "interface_method".equals(kind)) {
                    key = name + "(" + sym.getParameterList() + ")";
                }
                
                if (!scopeKindNameMap.containsKey(scope)) {
                    scopeKindNameMap.put(scope, new HashMap<>());
                }
                Map<String, List<Symbol>> kindMap = scopeKindNameMap.get(scope);
                if (!kindMap.containsKey(kind)) {
                    kindMap.put(kind, new ArrayList<>());
                }
                
                List<Symbol> nameList = kindMap.get(kind);
                // بررسی تکراری بودن
                for (Symbol existing : nameList) {
                    String existingKey = existing.getName();
                    if ("method".equals(kind) || "constructor".equals(kind) || "interface_method".equals(kind)) {
                        existingKey = existing.getName() + "(" + existing.getParameterList() + ")";
                    }
                    
                    if (existingKey.equals(key)) {
                        // پیدا کردن خط از parse tree
                        int line = findLineNumberForSymbol(sym);
                        addError("خطای تعریف تکراری: " + kind + " '" + name + "' قبلاً در این اسکوپ تعریف شده است", line);
                        break;
                    }
                }
                nameList.add(sym);
            }
        }
    }
    
    /**
     * بررسی دور در ارث‌بری
     */
    private void checkInheritanceCycles() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        
        for (String className : classHierarchy.keySet()) {
            if (!visited.contains(className)) {
                if (hasCycle(className, visited, recStack)) {
                    addError("خطای وجود دور در ارث‌بری: دور در سلسله مراتب ارث‌بری کلاس '" + className + "' تشخیص داده شد", 1);
                }
            }
        }
    }
    
    private boolean hasCycle(String className, Set<String> visited, Set<String> recStack) {
        visited.add(className);
        recStack.add(className);
        
        String parent = classHierarchy.get(className);
        if (parent != null) {
            if (!visited.contains(parent)) {
                if (hasCycle(parent, visited, recStack)) {
                    return true;
                }
            } else if (recStack.contains(parent)) {
                return true;
            }
        }
        
        recStack.remove(className);
        return false;
    }
    
    /**
     * بررسی ایمپورت کلاس‌های تعریف نشده
     */
    private void checkImports() {
        if (parseTree instanceof LanguageParser.ProgramContext) {
            LanguageParser.ProgramContext programCtx = (LanguageParser.ProgramContext) parseTree;
            if (programCtx.importDecl() != null) {
                for (var importDecl : programCtx.importDecl()) {
                    List<TerminalNode> identifiers = importDecl.Identifier();
                    if (identifiers.size() > 0) {
                        String importedClass = identifiers.get(identifiers.size() - 1).getText();
                        if (!definedClasses.contains(importedClass) && !definedInterfaces.contains(importedClass)) {
                            int line = importDecl.getStart().getLine();
                            addError("خطای ایمپورت: کلاس یا اینترفیس '" + importedClass + "' تعریف نشده است", line);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * بررسی دسترسی به متد private از خارج کلاس
     */
    private void checkPrivateMethodAccess(List<Symbol> symbols) {
        // این بررسی نیاز به parse tree دارد تا method calls را پیدا کنیم
        // برای سادگی، اینجا فقط متدهای private را لیست می‌کنیم
        // بررسی واقعی نیاز به traverse کردن parse tree دارد
        if (parseTree instanceof LanguageParser.ProgramContext) {
            checkMethodCallsInTree((LanguageParser.ProgramContext) parseTree, symbols);
        }
    }
    
    /**
     * بررسی فراخوانی متدها در parse tree
     */
    private void checkMethodCallsInTree(LanguageParser.ProgramContext ctx, List<Symbol> symbols) {
        // این متد باید parse tree را traverse کند تا method calls را پیدا کند
        // برای سادگی، از visitor pattern استفاده می‌کنیم اما فقط برای بررسی method calls
        MethodCallChecker checker = new MethodCallChecker(symbols, symbolTable, errors, this);
        checker.visit(ctx);
    }
    
    /**
     * بررسی عدم تطابق پارامترهای متد
     */
    private void checkMethodParameterMismatch(List<Symbol> symbols) {
        // این بررسی در checkMethodCallsInTree انجام می‌شود
    }
    
    /**
     * بررسی عدم تطابق نوع در بازگشت متد
     */
    private void checkReturnTypeMismatch(List<Symbol> symbols) {
        // این بررسی نیاز به parse tree دارد
        ReturnTypeChecker checker = new ReturnTypeChecker(symbols, symbolTable, errors, this);
        if (parseTree instanceof LanguageParser.ProgramContext) {
            checker.visit((LanguageParser.ProgramContext) parseTree);
        }
    }
    
    /**
     * بررسی عدم تطابق نوع در انتساب
     */
    private void checkAssignmentTypeMismatch() {
        AssignmentChecker checker = new AssignmentChecker(symbolTable, errors, this);
        if (parseTree instanceof LanguageParser.ProgramContext) {
            checker.visit((LanguageParser.ProgramContext) parseTree);
        }
    }
    
    /**
     * بررسی خطاهای اندیس آرایه
     */
    private void checkArrayIndexErrors() {
        ArrayIndexChecker checker = new ArrayIndexChecker(symbolTable, errors, this);
        if (parseTree instanceof LanguageParser.ProgramContext) {
            checker.visit((LanguageParser.ProgramContext) parseTree);
        }
    }
    
    /**
     * بررسی خطاهای دسترسی به متغیر
     */
    private void checkVariableAccessErrors() {
        VariableAccessChecker checker = new VariableAccessChecker(symbolTable, errors, this);
        if (parseTree instanceof LanguageParser.ProgramContext) {
            checker.visit((LanguageParser.ProgramContext) parseTree);
        }
    }
    
    /**
     * پیدا کردن شماره خط برای یک symbol
     */
    private int findLineNumberForSymbol(Symbol sym) {
        // جستجو در parse tree برای پیدا کردن خط
        SymbolLineFinder finder = new SymbolLineFinder(sym);
        finder.visit(parseTree);
        return finder.getLine() > 0 ? finder.getLine() : 1;
    }
    
    void addError(String message, int line) {
        errors.add(new SemanticError(message, line));
    }
    
    public List<SemanticError> getErrors() {
        return errors;
    }
    
    public void printErrors(String outputDir) {
        try (PrintWriter writer = new PrintWriter(outputDir + "/semantic_errors.txt", "UTF-8")) {
            System.out.println("\n=== SEMANTIC ERRORS ===");
            if (errors.isEmpty()) {
                System.out.println("هیچ خطای معنایی یافت نشد.");
                writer.println("هیچ خطای معنایی یافت نشد.");
            } else {
                for (SemanticError error : errors) {
                    String errorMsg = "خط " + error.getLine() + ": " + error.getMessage();
                    System.out.println(errorMsg);
                    writer.println(errorMsg);
                }
            }
        } catch (Exception e) {
            System.err.println("خطا در نوشتن فایل خطاها: " + e.getMessage());
        }
    }
    
    /**
     * متد استاتیک برای تحلیل فایل
     * این متد جدول نماد را از LanguageVisitorImpl می‌گیرد
     */
    public static void analyze(String inputFile, String outputDir) {
        try {
            InputStream is = new FileInputStream(inputFile);
            
            LanguageLexer lexer = new LanguageLexer(CharStreams.fromStream(is));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            ParseTree tree = parser.program();
            
            // استفاده از جدول نماد تولید شده توسط LanguageVisitorImpl
            LanguageVisitorImpl visitor = new LanguageVisitorImpl();
            visitor.visit(tree);
            Scope symbolTable = visitor.getSymbolTable();
            
            // تحلیل معنایی بر اساس جدول نماد
            SemanticAnalyzer analyzer = new SemanticAnalyzer(symbolTable, tree);
            analyzer.analyze();
            analyzer.printErrors(outputDir);
        } catch (Exception e) {
            System.err.println("خطا در تحلیل معنایی: " + e.getMessage());
            e.printStackTrace();
            // حتی در صورت بروز exception، فایل semantic_errors.txt را تولید می‌کنیم
            try (PrintWriter writer = new PrintWriter(outputDir + "/semantic_errors.txt", "UTF-8")) {
                writer.println("خطا در تحلیل معنایی: " + e.getMessage());
            } catch (Exception ex) {
                System.err.println("خطا در نوشتن فایل خطاها: " + ex.getMessage());
            }
        }
    }
    
    // Inner class for semantic errors
    static class SemanticError {
        private String message;
        private int line;
        
        public SemanticError(String message, int line) {
            this.message = message;
            this.line = line;
        }
        
        public String getMessage() {
            return message;
        }
        
        public int getLine() {
            return line;
        }
    }
    
    // Helper classes for checking different types of errors
    // این کلاس‌ها فقط برای traverse کردن parse tree و پیدا کردن خطاها استفاده می‌شوند
    // نه برای ساخت جدول نماد
    
    /**
     * کلاس برای پیدا کردن شماره خط یک symbol
     */
    private static class SymbolLineFinder extends LanguageBaseVisitor<Void> {
        private Symbol targetSymbol;
        private int line = 0;
        
        public SymbolLineFinder(Symbol targetSymbol) {
            this.targetSymbol = targetSymbol;
        }
        
        @Override
        public Void visitClassDecl(LanguageParser.ClassDeclContext ctx) {
            if (ctx.Identifier(0).getText().equals(targetSymbol.getName()) && "class".equals(targetSymbol.getKind())) {
                line = ctx.getStart().getLine();
                return null; // پیدا شد، دیگر ادامه نده
            }
            return super.visitClassDecl(ctx);
        }
        
        @Override
        public Void visitInterfaceDecl(LanguageParser.InterfaceDeclContext ctx) {
            if (ctx.Identifier().getText().equals(targetSymbol.getName()) && "interface".equals(targetSymbol.getKind())) {
                line = ctx.getStart().getLine();
                return null; // پیدا شد، دیگر ادامه نده
            }
            return super.visitInterfaceDecl(ctx);
        }
        
        @Override
        public Void visitFieldDecl(LanguageParser.FieldDeclContext ctx) {
            if (ctx.varDecl() != null && ctx.varDecl().Identifier().getText().equals(targetSymbol.getName()) && 
                ("field".equals(targetSymbol.getKind()) || "interface_field".equals(targetSymbol.getKind()))) {
                line = ctx.getStart().getLine();
                return null;
            }
            return super.visitFieldDecl(ctx);
        }
        
        @Override
        public Void visitInterfaceFieldDecl(LanguageParser.InterfaceFieldDeclContext ctx) {
            if (ctx.Identifier().getText().equals(targetSymbol.getName()) && "interface_field".equals(targetSymbol.getKind())) {
                line = ctx.getStart().getLine();
                return null;
            }
            return super.visitInterfaceFieldDecl(ctx);
        }
        
        @Override
        public Void visitMethodDecl(LanguageParser.MethodDeclContext ctx) {
            if (ctx.Identifier().getText().equals(targetSymbol.getName()) && "method".equals(targetSymbol.getKind())) {
                // بررسی signature
                String paramList = getParameterList(ctx.parameterList());
                if (paramList.equals(targetSymbol.getParameterList())) {
                    line = ctx.getStart().getLine();
                    return null;
                }
            }
            return super.visitMethodDecl(ctx);
        }
        
        @Override
        public Void visitInterfaceMethodDecl(LanguageParser.InterfaceMethodDeclContext ctx) {
            if (ctx.Identifier().getText().equals(targetSymbol.getName()) && "interface_method".equals(targetSymbol.getKind())) {
                String paramList = getParameterList(ctx.parameterList());
                if (paramList.equals(targetSymbol.getParameterList())) {
                    line = ctx.getStart().getLine();
                    return null;
                }
            }
            return super.visitInterfaceMethodDecl(ctx);
        }
        
        @Override
        public Void visitLocalDecl(LanguageParser.LocalDeclContext ctx) {
            if (ctx.Identifier().getText().equals(targetSymbol.getName()) && "variable".equals(targetSymbol.getKind())) {
                line = ctx.getStart().getLine();
                return null;
            }
            return super.visitLocalDecl(ctx);
        }
        
        private String getParameterList(LanguageParser.ParameterListContext paramListCtx) {
            if (paramListCtx == null) return "";
            List<String> params = new ArrayList<>();
            for (var param : paramListCtx.parameter()) {
                String type = getTypeText(param.type());
                String name = param.Identifier().getText();
                params.add(type + " " + name);
            }
            return String.join(", ", params);
        }
        
        private String getTypeText(LanguageParser.TypeContext typeCtx) {
            if (typeCtx == null) return "";
            String baseType = typeCtx.javaType() != null ? typeCtx.javaType().getText() :
                              typeCtx.Identifier() != null ? typeCtx.Identifier().getText() : "";
            if (typeCtx.LSB() != null) {
                baseType += "[]";
            }
            return baseType;
        }
        
        public int getLine() {
            return line;
        }
    }
    
    /**
     * کلاس برای بررسی فراخوانی متدها
     */
    private static class MethodCallChecker extends LanguageBaseVisitor<Void> {
        private List<Symbol> allSymbols;
        private Scope symbolTable;
        private List<SemanticError> errors;
        private SemanticAnalyzer analyzer;
        
        public MethodCallChecker(List<Symbol> symbols, Scope st, List<SemanticError> errs, SemanticAnalyzer ana) {
            this.allSymbols = symbols;
            this.symbolTable = st;
            this.errors = errs;
            this.analyzer = ana;
        }
        
        @Override
        public Void visitMethodCallExpr(LanguageParser.MethodCallExprContext ctx) {
            String methodName = ctx.Identifier().getText();
            int line = ctx.getStart().getLine();
            
            // پیدا کردن متد در جدول نماد
            List<String> argTypes = new ArrayList<>();
            if (ctx.expression() != null) {
                for (var expr : ctx.expression()) {
                    String argType = getExpressionType(expr);
                    if (argType != null) {
                        argTypes.add(argType);
                    }
                }
            }
            
            Symbol methodSym = findMethod(methodName, argTypes, allSymbols);
            if (methodSym != null) {
                // بررسی دسترسی private
                if ("private".equals(methodSym.getVisibility())) {
                    // بررسی اینکه آیا از خارج کلاس فراخوانی شده
                    String methodScope = methodSym.getScope();
                    String callScope = findCallScope(ctx);
                    
                    // اگر scope متد با scope فراخوانی متفاوت است، خطا است
                    if (!methodScope.equals(callScope) && !isInSameClass(methodScope, callScope)) {
                        analyzer.addError("خطای دسترسی: متد private '" + methodName + "' از خارج کلاس قابل دسترسی نیست", line);
                    }
                }
                
                // بررسی پارامترها
                String paramList = methodSym.getParameterList();
                List<String> expectedTypes = parseParameterTypes(paramList);
                if (expectedTypes.size() != argTypes.size()) {
                    analyzer.addError("خطای عدم تطابق تعداد پارامترها: متد '" + methodName + "' انتظار " + expectedTypes.size() + " پارامتر دارد اما " + argTypes.size() + " آرگومان دریافت کرده است", line);
                } else if (!expectedTypes.isEmpty()) {
                    for (int i = 0; i < expectedTypes.size(); i++) {
                        if (i < argTypes.size() && !isTypeCompatible(expectedTypes.get(i), argTypes.get(i))) {
                            analyzer.addError("خطای عدم تطابق نوع پارامتر: پارامتر " + (i + 1) + " متد '" + methodName + "' باید از نوع " + expectedTypes.get(i) + " باشد اما " + argTypes.get(i) + " دریافت شده است", line);
                        }
                    }
                }
            }
            // اگر متد پیدا نشد، خطا گزارش نمی‌دهیم چون ممکن است در جای دیگری بررسی شود
            
            return super.visitMethodCallExpr(ctx);
        }
        
        private Symbol findMethod(String methodName, List<String> argTypes, List<Symbol> symbols) {
            for (Symbol sym : symbols) {
                if ((sym.getKind().equals("method") || sym.getKind().equals("interface_method")) 
                    && sym.getName().equals(methodName)) {
                    String paramList = sym.getParameterList();
                    List<String> expectedTypes = parseParameterTypes(paramList);
                    if (expectedTypes.size() == argTypes.size()) {
                        boolean match = true;
                        for (int i = 0; i < expectedTypes.size(); i++) {
                            if (i >= argTypes.size() || !isTypeCompatible(expectedTypes.get(i), argTypes.get(i))) {
                                match = false;
                                break;
                            }
                        }
                        if (match) {
                            return sym;
                        }
                    }
                }
            }
            return null;
        }
        
        private List<String> parseParameterTypes(String paramList) {
            List<String> types = new ArrayList<>();
            if (paramList == null || paramList.isEmpty()) return types;
            String[] params = paramList.split(",");
            for (String param : params) {
                param = param.trim();
                String[] parts = param.split("\\s+");
                if (parts.length > 0) {
                    types.add(parts[0]);
                }
            }
            return types;
        }
        
        private String findCallScope(LanguageParser.MethodCallExprContext ctx) {
            // پیدا کردن scope فعلی از parse tree
            ParseTree parent = ctx.getParent();
            while (parent != null) {
                if (parent instanceof LanguageParser.MethodDeclContext) {
                    LanguageParser.MethodDeclContext methodCtx = (LanguageParser.MethodDeclContext) parent;
                    ParseTree classParent = methodCtx.getParent();
                    while (classParent != null) {
                        if (classParent instanceof LanguageParser.ClassDeclContext) {
                            LanguageParser.ClassDeclContext classCtx = (LanguageParser.ClassDeclContext) classParent;
                            return "class_" + classCtx.Identifier(0).getText();
                        }
                        classParent = classParent.getParent();
                    }
                    return "global";
                } else if (parent instanceof LanguageParser.MainClassContext) {
                    LanguageParser.MainClassContext mainCtx = (LanguageParser.MainClassContext) parent;
                    return "class_" + mainCtx.Identifier(0).getText();
                }
                parent = parent.getParent();
            }
            return "global";
        }
        
        private boolean isInSameClass(String scope1, String scope2) {
            if (scope1 == null || scope2 == null) return false;
            if (scope1.startsWith("class_") && scope2.startsWith("class_")) {
                return scope1.equals(scope2);
            }
            return false;
        }
        
        private boolean isTypeCompatible(String expected, String actual) {
            if (expected == null || actual == null) return false;
            if (expected.equals(actual)) return true;
            if ("null".equals(actual) && !expected.equals("int") && !expected.equals("boolean") && !expected.equals("char")) {
                return true;
            }
            return false;
        }
        
        private String getExpressionType(LanguageParser.ExpressionContext ctx) {
            if (ctx == null) return null;
            if (ctx.primaryExpression() != null) {
                return getPrimaryExpressionType(ctx.primaryExpression());
            }
            return "int"; // Default
        }
        
        private String getPrimaryExpressionType(LanguageParser.PrimaryExpressionContext ctx) {
            if (ctx instanceof LanguageParser.IntLitExprContext) {
                return "int";
            } else if (ctx instanceof LanguageParser.BoolLitExprContext) {
                return "boolean";
            } else if (ctx instanceof LanguageParser.CharLitExprContext) {
                return "char";
            } else if (ctx instanceof LanguageParser.StringLitExprContext) {
                return "String";
            } else if (ctx instanceof LanguageParser.NullLitExprContext) {
                return "null";
            } else if (ctx instanceof LanguageParser.IdentExprContext) {
                LanguageParser.IdentExprContext identCtx = (LanguageParser.IdentExprContext) ctx;
                String varName = identCtx.primaryDesignator().Identifier().getText();
                Symbol sym = symbolTable.getSymbol(varName);
                return sym != null ? sym.getType() : null;
            }
            return null;
        }
    }
    
    /**
     * کلاس برای بررسی نوع بازگشت متد
     */
    private static class ReturnTypeChecker extends LanguageBaseVisitor<Void> {
        private List<Symbol> allSymbols;
        private Scope symbolTable;
        private List<SemanticError> errors;
        private SemanticAnalyzer analyzer;
        private Stack<String> methodStack = new Stack<>();
        
        public ReturnTypeChecker(List<Symbol> symbols, Scope st, List<SemanticError> errs, SemanticAnalyzer ana) {
            this.allSymbols = symbols;
            this.symbolTable = st;
            this.errors = errs;
            this.analyzer = ana;
        }
        
        @Override
        public Void visitMethodDecl(LanguageParser.MethodDeclContext ctx) {
            String methodName = ctx.Identifier().getText();
            String scope = findCurrentScope(ctx);
            methodStack.push(methodName + ":" + scope);
            Void result = super.visitMethodDecl(ctx);
            methodStack.pop();
            return result;
        }
        
        @Override
        public Void visitMethodBody(LanguageParser.MethodBodyContext ctx) {
            if (!methodStack.isEmpty()) {
                String methodInfo = methodStack.peek();
                String methodName = methodInfo.split(":")[0];
                String methodScope = methodInfo.split(":")[1];
                
                Symbol methodSym = findMethodByNameAndScope(methodName, methodScope, allSymbols);
                if (methodSym != null) {
                    String expectedReturnType = methodSym.getType();
                    boolean hasReturn = ctx.RETURN() != null;
                    
                    if (hasReturn) {
                        if (ctx.expression() != null) {
                            String actualReturnType = getExpressionType(ctx.expression());
                            int line = ctx.RETURN().getSymbol().getLine();
                            if (actualReturnType != null && !isTypeCompatible(expectedReturnType, actualReturnType)) {
                                analyzer.addError("خطای عدم تطابق نوع در بازگشت متد: متد '" + methodName + "' باید " + expectedReturnType + " برگرداند اما " + actualReturnType + " برگردانده شده است", line);
                            }
                        } else if (!"void".equals(expectedReturnType)) {
                            int line = ctx.RETURN().getSymbol().getLine();
                            analyzer.addError("خطای عدم تطابق نوع در بازگشت متد: متد '" + methodName + "' باید مقدار برگرداند", line);
                        }
                    } else {
                        // بررسی اینکه آیا متد باید return داشته باشد یا نه
                        if (!"void".equals(expectedReturnType)) {
                            // متد باید return داشته باشد اما ندارد
                            int line = ctx.getStart().getLine();
                            analyzer.addError("خطای عدم تطابق نوع در بازگشت متد: متد '" + methodName + "' باید مقدار برگرداند", line);
                        }
                    }
                }
            }
            return super.visitMethodBody(ctx);
        }
        
        private String findCurrentScope(LanguageParser.MethodDeclContext ctx) {
            // پیدا کردن scope کلاس والد
            ParseTree parent = ctx.getParent();
            while (parent != null) {
                if (parent instanceof LanguageParser.ClassDeclContext) {
                    LanguageParser.ClassDeclContext classCtx = (LanguageParser.ClassDeclContext) parent;
                    return "class_" + classCtx.Identifier(0).getText();
                }
                parent = parent.getParent();
            }
            return "global";
        }
        
        private Symbol findMethodByNameAndScope(String methodName, String scope, List<Symbol> symbols) {
            for (Symbol sym : symbols) {
                if (sym.getKind().equals("method") && sym.getName().equals(methodName) && sym.getScope().equals(scope)) {
                    return sym;
                }
            }
            return null;
        }
        
        private Symbol findMethodByName(String methodName, List<Symbol> symbols) {
            for (Symbol sym : symbols) {
                if (sym.getKind().equals("method") && sym.getName().equals(methodName)) {
                    return sym;
                }
            }
            return null;
        }
        
        private boolean isTypeCompatible(String expected, String actual) {
            if (expected == null || actual == null) return false;
            if (expected.equals(actual)) return true;
            if ("null".equals(actual) && !expected.equals("int") && !expected.equals("boolean") && !expected.equals("char")) {
                return true;
            }
            return false;
        }
        
        private String getExpressionType(LanguageParser.ExpressionContext ctx) {
            if (ctx == null) return null;
            if (ctx.primaryExpression() != null) {
                return getPrimaryExpressionType(ctx.primaryExpression());
            }
            return "int";
        }
        
        private String getPrimaryExpressionType(LanguageParser.PrimaryExpressionContext ctx) {
            if (ctx instanceof LanguageParser.IntLitExprContext) {
                return "int";
            } else if (ctx instanceof LanguageParser.BoolLitExprContext) {
                return "boolean";
            } else if (ctx instanceof LanguageParser.CharLitExprContext) {
                return "char";
            } else if (ctx instanceof LanguageParser.StringLitExprContext) {
                return "String";
            } else if (ctx instanceof LanguageParser.NullLitExprContext) {
                return "null";
            } else if (ctx instanceof LanguageParser.IdentExprContext) {
                LanguageParser.IdentExprContext identCtx = (LanguageParser.IdentExprContext) ctx;
                String varName = identCtx.primaryDesignator().Identifier().getText();
                Symbol sym = symbolTable.getSymbol(varName);
                return sym != null ? sym.getType() : null;
            }
            return null;
        }
    }
    
    /**
     * کلاس برای بررسی نوع در انتساب
     */
    private static class AssignmentChecker extends LanguageBaseVisitor<Void> {
        private Scope symbolTable;
        private List<SemanticError> errors;
        private SemanticAnalyzer analyzer;
        
        public AssignmentChecker(Scope st, List<SemanticError> errs, SemanticAnalyzer ana) {
            this.symbolTable = st;
            this.errors = errs;
            this.analyzer = ana;
        }
        
        @Override
        public Void visitAssignment(LanguageParser.AssignmentContext ctx) {
            String leftType = getDesignatorType(ctx.designator());
            String rightType = getExpressionType(ctx.expression());
            int line = ctx.getStart().getLine();
            
            if (leftType != null && rightType != null && !isTypeCompatible(leftType, rightType)) {
                analyzer.addError("خطای عدم تطابق نوع در انتساب: نوع سمت چپ (" + leftType + ") با نوع سمت راست (" + rightType + ") سازگار نیست", line);
            }
            return super.visitAssignment(ctx);
        }
        
        @Override
        public Void visitLocalDecl(LanguageParser.LocalDeclContext ctx) {
            if (ctx.EQ() != null && ctx.expression() != null) {
                String varType = getTypeText(ctx.type());
                String exprType = getExpressionType(ctx.expression());
                int line = ctx.getStart().getLine();
                if (!isTypeCompatible(varType, exprType)) {
                    analyzer.addError("خطای عدم تطابق نوع در انتساب: نوع متغیر '" + ctx.Identifier().getText() + "' (" + varType + ") با نوع مقدار (" + exprType + ") سازگار نیست", line);
                }
            }
            return super.visitLocalDecl(ctx);
        }
        
        private String getDesignatorType(LanguageParser.DesignatorContext ctx) {
            String varName = ctx.primaryDesignator().Identifier().getText();
            Symbol sym = symbolTable.getSymbol(varName);
            if (sym != null) {
                String type = sym.getType();
                if (ctx.designatorPrime() != null) {
                    LanguageParser.DesignatorPrimeContext prime = ctx.designatorPrime();
                    if (prime.LSB() != null && !prime.LSB().isEmpty()) {
                        if (type.endsWith("[]")) {
                            type = type.substring(0, type.length() - 2);
                        }
                    }
                }
                return type;
            }
            return null;
        }
        
        private String getExpressionType(LanguageParser.ExpressionContext ctx) {
            if (ctx == null) return null;
            if (ctx.primaryExpression() != null) {
                return getPrimaryExpressionType(ctx.primaryExpression());
            }
            return "int";
        }
        
        private String getPrimaryExpressionType(LanguageParser.PrimaryExpressionContext ctx) {
            if (ctx instanceof LanguageParser.IntLitExprContext) {
                return "int";
            } else if (ctx instanceof LanguageParser.BoolLitExprContext) {
                return "boolean";
            } else if (ctx instanceof LanguageParser.CharLitExprContext) {
                return "char";
            } else if (ctx instanceof LanguageParser.StringLitExprContext) {
                return "String";
            } else if (ctx instanceof LanguageParser.NullLitExprContext) {
                return "null";
            } else if (ctx instanceof LanguageParser.IdentExprContext) {
                LanguageParser.IdentExprContext identCtx = (LanguageParser.IdentExprContext) ctx;
                String varName = identCtx.primaryDesignator().Identifier().getText();
                Symbol sym = symbolTable.getSymbol(varName);
                return sym != null ? sym.getType() : null;
            }
            return null;
        }
        
        private String getTypeText(LanguageParser.TypeContext typeCtx) {
            if (typeCtx == null) return "";
            String baseType = typeCtx.javaType() != null ? typeCtx.javaType().getText() :
                              typeCtx.Identifier() != null ? typeCtx.Identifier().getText() : "";
            if (typeCtx.LSB() != null) {
                baseType += "[]";
            }
            return baseType;
        }
        
        private boolean isTypeCompatible(String expected, String actual) {
            if (expected == null || actual == null) return false;
            if (expected.equals(actual)) return true;
            if ("null".equals(actual) && !expected.equals("int") && !expected.equals("boolean") && !expected.equals("char")) {
                return true;
            }
            return false;
        }
    }
    
    /**
     * کلاس برای بررسی خطاهای اندیس آرایه
     */
    private static class ArrayIndexChecker extends LanguageBaseVisitor<Void> {
        private Scope symbolTable;
        private List<SemanticError> errors;
        private SemanticAnalyzer analyzer;
        
        public ArrayIndexChecker(Scope st, List<SemanticError> errs, SemanticAnalyzer ana) {
            this.symbolTable = st;
            this.errors = errs;
            this.analyzer = ana;
        }
        
        @Override
        public Void visitArrayAccessExpr(LanguageParser.ArrayAccessExprContext ctx) {
            int line = ctx.getStart().getLine();
            
            if (ctx.expression() != null) {
                LanguageParser.ExpressionContext indexExpr = ctx.expression();
                String indexType = getExpressionType(indexExpr);
                if (indexType != null) {
                    if (!"int".equals(indexType)) {
                        analyzer.addError("خطای استفاده از اندیس: نوع اندیس باید int باشد اما " + indexType + " دریافت شده است", line);
                    } else {
                        Integer indexValue = getConstantIntegerValue(indexExpr);
                        if (indexValue != null) {
                            if (indexValue < 0) {
                                analyzer.addError("خطای استفاده از اندیس: اندیس منفی (" + indexValue + ") مجاز نیست", line);
                            } else {
                                // بررسی اینکه آیا اندیس بزرگتر از سایز آرایه است
                                // این بررسی فقط برای اندیس‌های ثابت انجام می‌شود
                                // برای سادگی، فقط اندیس‌های خیلی بزرگ را بررسی می‌کنیم
                                // در واقعیت باید سایز آرایه را از parse tree بگیریم
                            }
                        }
                    }
                }
            }
            
            return super.visitArrayAccessExpr(ctx);
        }
        
        private Integer getConstantIntegerValue(LanguageParser.ExpressionContext ctx) {
            if (ctx == null) return null;
            if (ctx.primaryExpression() != null) {
                LanguageParser.PrimaryExpressionContext primary = ctx.primaryExpression();
                if (primary instanceof LanguageParser.IntLitExprContext) {
                    LanguageParser.IntLitExprContext intCtx = (LanguageParser.IntLitExprContext) primary;
                    try {
                        return Integer.parseInt(intCtx.IntegerLiteral().getText());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
            return null;
        }
        
        private String getExpressionType(LanguageParser.ExpressionContext ctx) {
            if (ctx == null) return null;
            if (ctx.primaryExpression() != null) {
                return getPrimaryExpressionType(ctx.primaryExpression());
            }
            return "int";
        }
        
        private String getPrimaryExpressionType(LanguageParser.PrimaryExpressionContext ctx) {
            if (ctx instanceof LanguageParser.IntLitExprContext) {
                return "int";
            } else if (ctx instanceof LanguageParser.BoolLitExprContext) {
                return "boolean";
            } else if (ctx instanceof LanguageParser.CharLitExprContext) {
                return "char";
            } else if (ctx instanceof LanguageParser.StringLitExprContext) {
                return "String";
            } else if (ctx instanceof LanguageParser.IdentExprContext) {
                LanguageParser.IdentExprContext identCtx = (LanguageParser.IdentExprContext) ctx;
                String varName = identCtx.primaryDesignator().Identifier().getText();
                Symbol sym = symbolTable.getSymbol(varName);
                return sym != null ? sym.getType() : null;
            }
            return null;
        }
    }
    
    /**
     * کلاس برای بررسی دسترسی به متغیر
     */
    private static class VariableAccessChecker extends LanguageBaseVisitor<Void> {
        private Scope symbolTable;
        private List<SemanticError> errors;
        private SemanticAnalyzer analyzer;
        
        public VariableAccessChecker(Scope st, List<SemanticError> errs, SemanticAnalyzer ana) {
            this.symbolTable = st;
            this.errors = errs;
            this.analyzer = ana;
        }
        
        @Override
        public Void visitIdentExpr(LanguageParser.IdentExprContext ctx) {
            String varName = ctx.primaryDesignator().Identifier().getText();
            int line = ctx.getStart().getLine();
            
            Symbol sym = symbolTable.getSymbol(varName);
            if (sym == null) {
                analyzer.addError("خطای استفاده از متغیر: متغیر '" + varName + "' اعلان نشده است", line);
            }
            
            return super.visitIdentExpr(ctx);
        }
        
        @Override
        public Void visitDesignator(LanguageParser.DesignatorContext ctx) {
            String varName = ctx.primaryDesignator().Identifier().getText();
            int line = ctx.getStart().getLine();
            
            Symbol sym = symbolTable.getSymbol(varName);
            if (sym == null) {
                analyzer.addError("خطای استفاده از متغیر: متغیر '" + varName + "' اعلان نشده است", line);
            }
            
            return super.visitDesignator(ctx);
        }
    }
}
