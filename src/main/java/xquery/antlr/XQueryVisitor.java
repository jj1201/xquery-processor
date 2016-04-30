// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code VarAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAsXq(XQueryParser.VarAsXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagNameXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagNameXq(XQueryParser.TagNameXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisXq(XQueryParser.ParenthesisXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FlwrXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwrXq(XQueryParser.FlwrXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSlashSlashRp(XQueryParser.XqSlashSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAsXq(XQueryParser.StringAsXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSlashRp(XQueryParser.XqSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqCommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqCommaXq(XQueryParser.XqCommaXqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApAsXq(XQueryParser.ApAsXqContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#lwr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLwr(XQueryParser.LwrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(XQueryParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(XQueryParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(XQueryParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqValueEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqValueEqualCond(XQueryParser.XqValueEqualCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqIdEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqIdEqualCond(XQueryParser.XqIdEqualCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqSomeCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSomeCond(XQueryParser.XqSomeCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XqEmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqEmptyCond(XQueryParser.XqEmptyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisCond(XQueryParser.ParenthesisCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SomeCond}
	 * labeled alternative in {@link XQueryParser#some_cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeCond(XQueryParser.SomeCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DocSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocSlashRp(XQueryParser.DocSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DocSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocSlashSlashRp(XQueryParser.DocSlashSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlashRp(XQueryParser.RpSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(XQueryParser.StarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpWithFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpWithFilter(XQueryParser.RpWithFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(XQueryParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpCommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpCommaRp(XQueryParser.RpCommaRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(XQueryParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleDot(XQueryParser.DoubleDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisRp(XQueryParser.ParenthesisRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDEqualFilter(XQueryParser.IDEqualFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueEqualFilter(XQueryParser.ValueEqualFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisFilter(XQueryParser.ParenthesisFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#file_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_name(XQueryParser.File_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tag_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag_name(XQueryParser.Tag_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#att_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtt_name(XQueryParser.Att_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#str_const}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_const(XQueryParser.Str_constContext ctx);
}