// Generated from Language.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(LanguageParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(LanguageParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(LanguageParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(LanguageParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(LanguageParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(LanguageParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDecl(LanguageParser.InterfaceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDecl(LanguageParser.InterfaceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDecl(LanguageParser.InterfaceMethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDecl(LanguageParser.InterfaceMethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#interfaceFieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceFieldDecl(LanguageParser.InterfaceFieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#interfaceFieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceFieldDecl(LanguageParser.InterfaceFieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(LanguageParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(LanguageParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalDecl(LanguageParser.LocalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#localDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalDecl(LanguageParser.LocalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(LanguageParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(LanguageParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(LanguageParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(LanguageParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void enterCtorDecl(LanguageParser.CtorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void exitCtorDecl(LanguageParser.CtorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#abstractMethodDecl}.
	 * @param ctx the parse tree
	 */
	void enterAbstractMethodDecl(LanguageParser.AbstractMethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#abstractMethodDecl}.
	 * @param ctx the parse tree
	 */
	void exitAbstractMethodDecl(LanguageParser.AbstractMethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(LanguageParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(LanguageParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(LanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(LanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(LanguageParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(LanguageParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#javaType}.
	 * @param ctx the parse tree
	 */
	void enterJavaType(LanguageParser.JavaTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#javaType}.
	 * @param ctx the parse tree
	 */
	void exitJavaType(LanguageParser.JavaTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(LanguageParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(LanguageParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(LanguageParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(LanguageParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(LanguageParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(LanguageParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(LanguageParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(LanguageParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(LanguageParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(LanguageParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(LanguageParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(LanguageParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOnlyStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprOnlyStmt(LanguageParser.ExprOnlyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOnlyStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprOnlyStmt(LanguageParser.ExprOnlyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code localDeclStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclStmt(LanguageParser.LocalDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code localDeclStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclStmt(LanguageParser.LocalDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(LanguageParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(LanguageParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#localDeclNoSemi}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclNoSemi(LanguageParser.LocalDeclNoSemiContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#localDeclNoSemi}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclNoSemi(LanguageParser.LocalDeclNoSemiContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(LanguageParser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(LanguageParser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#primaryDesignator}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryDesignator(LanguageParser.PrimaryDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#primaryDesignator}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryDesignator(LanguageParser.PrimaryDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#designatorPrime}.
	 * @param ctx the parse tree
	 */
	void enterDesignatorPrime(LanguageParser.DesignatorPrimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#designatorPrime}.
	 * @param ctx the parse tree
	 */
	void exitDesignatorPrime(LanguageParser.DesignatorPrimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expressionOrString}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrString(LanguageParser.ExpressionOrStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expressionOrString}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrString(LanguageParser.ExpressionOrStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpr(LanguageParser.ArrayAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpr(LanguageParser.ArrayAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLengthExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterArrayLengthExpr(LanguageParser.ArrayLengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLengthExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitArrayLengthExpr(LanguageParser.ArrayLengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpr(LanguageParser.MethodCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpr(LanguageParser.MethodCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(LanguageParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(LanguageParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(LanguageParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(LanguageParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(LanguageParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(LanguageParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterModExpr(LanguageParser.ModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitModExpr(LanguageParser.ModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(LanguageParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(LanguageParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(LanguageParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(LanguageParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(LanguageParser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(LanguageParser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterLeExpr(LanguageParser.LeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitLeExpr(LanguageParser.LeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterGtExpr(LanguageParser.GtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitGtExpr(LanguageParser.GtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code geExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterGeExpr(LanguageParser.GeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code geExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitGeExpr(LanguageParser.GeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(LanguageParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(LanguageParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterNeqExpr(LanguageParser.NeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitNeqExpr(LanguageParser.NeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(LanguageParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(LanguageParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(LanguageParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(LanguageParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyExprTail}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterEmptyExprTail(LanguageParser.EmptyExprTailContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyExprTail}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitEmptyExprTail(LanguageParser.EmptyExprTailContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(LanguageParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(LanguageParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpr(LanguageParser.NewObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpr(LanguageParser.NewObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(LanguageParser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(LanguageParser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intArrayLiteralExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntArrayLiteralExpr(LanguageParser.IntArrayLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intArrayLiteralExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntArrayLiteralExpr(LanguageParser.IntArrayLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntLitExpr(LanguageParser.IntLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntLitExpr(LanguageParser.IntLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterCharLitExpr(LanguageParser.CharLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitCharLitExpr(LanguageParser.CharLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLitExpr(LanguageParser.BoolLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLitExpr(LanguageParser.BoolLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullLitExpr(LanguageParser.NullLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullLitExpr(LanguageParser.NullLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLitExpr(LanguageParser.StringLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLitExpr(LanguageParser.StringLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(LanguageParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(LanguageParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(LanguageParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(LanguageParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentExpr(LanguageParser.IdentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentExpr(LanguageParser.IdentExprContext ctx);
}