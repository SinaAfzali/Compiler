// Generated from Language.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(LanguageParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(LanguageParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(LanguageParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#interfaceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDecl(LanguageParser.InterfaceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDecl(LanguageParser.InterfaceMethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#interfaceFieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceFieldDecl(LanguageParser.InterfaceFieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(LanguageParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#localDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDecl(LanguageParser.LocalDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(LanguageParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(LanguageParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ctorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtorDecl(LanguageParser.CtorDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#abstractMethodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractMethodDecl(LanguageParser.AbstractMethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(LanguageParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(LanguageParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(LanguageParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LanguageParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#javaType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaType(LanguageParser.JavaTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(LanguageParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(LanguageParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(LanguageParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(LanguageParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(LanguageParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(LanguageParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOnlyStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOnlyStmt(LanguageParser.ExprOnlyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code localDeclStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDeclStmt(LanguageParser.LocalDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(LanguageParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#localDeclNoSemi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDeclNoSemi(LanguageParser.LocalDeclNoSemiContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(LanguageParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(LanguageParser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#primaryDesignator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryDesignator(LanguageParser.PrimaryDesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#designatorPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignatorPrime(LanguageParser.DesignatorPrimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#expressionOrString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrString(LanguageParser.ExpressionOrStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LanguageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpr(LanguageParser.ArrayAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthExpr(LanguageParser.ArrayLengthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpr(LanguageParser.MethodCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(LanguageParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(LanguageParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(LanguageParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpr(LanguageParser.ModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(LanguageParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(LanguageParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpr(LanguageParser.LtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeExpr(LanguageParser.LeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtExpr(LanguageParser.GtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeExpr(LanguageParser.GeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(LanguageParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqExpr(LanguageParser.NeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(LanguageParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(LanguageParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyExprTail}
	 * labeled alternative in {@link LanguageParser#expressionPrime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyExprTail(LanguageParser.EmptyExprTailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(LanguageParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObjectExpr(LanguageParser.NewObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpr(LanguageParser.NewArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intArrayLiteralExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntArrayLiteralExpr(LanguageParser.IntArrayLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLitExpr(LanguageParser.IntLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLitExpr(LanguageParser.CharLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLitExpr(LanguageParser.BoolLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLitExpr(LanguageParser.NullLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLitExpr(LanguageParser.StringLitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(LanguageParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(LanguageParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link LanguageParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentExpr(LanguageParser.IdentExprContext ctx);
}