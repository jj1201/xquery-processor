// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQueryReduced.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryReducedParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryReducedVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq(XQueryReducedParser.XqContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(XQueryReducedParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetRet}
	 * labeled alternative in {@link XQueryReducedParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetRet(XQueryReducedParser.RetRetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetVar}
	 * labeled alternative in {@link XQueryReducedParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetVar(XQueryReducedParser.RetVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetPath}
	 * labeled alternative in {@link XQueryReducedParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetPath(XQueryReducedParser.RetPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetTag}
	 * labeled alternative in {@link XQueryReducedParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetTag(XQueryReducedParser.RetTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(XQueryReducedParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#var2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar2(XQueryReducedParser.Var2Context ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(XQueryReducedParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryReducedParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(XQueryReducedParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryReducedParser#slash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlash(XQueryReducedParser.SlashContext ctx);
}