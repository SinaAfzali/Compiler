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
	 * Enter a parse tree produced by {@link LanguageParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(LanguageParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(LanguageParser.PackageDeclContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(LanguageParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(LanguageParser.QualifiedNameContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(LanguageParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(LanguageParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(LanguageParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(LanguageParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(LanguageParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(LanguageParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(LanguageParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(LanguageParser.TypeParametersContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDecl(LanguageParser.ConstructorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#constructorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDecl(LanguageParser.ConstructorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(LanguageParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(LanguageParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(LanguageParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(LanguageParser.ParamContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(LanguageParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(LanguageParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(LanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(LanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(LanguageParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(LanguageParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(LanguageParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(LanguageParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(LanguageParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(LanguageParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(LanguageParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(LanguageParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpr(LanguageParser.AssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpr(LanguageParser.AssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(LanguageParser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(LanguageParser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(LanguageParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(LanguageParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(LanguageParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(LanguageParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(LanguageParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(LanguageParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(LanguageParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(LanguageParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(LanguageParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(LanguageParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(LanguageParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(LanguageParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(LanguageParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(LanguageParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(LanguageParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(LanguageParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(LanguageParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(LanguageParser.ArgListContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(LanguageParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(LanguageParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LanguageParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LanguageParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(LanguageParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(LanguageParser.AnnotationContext ctx);
}