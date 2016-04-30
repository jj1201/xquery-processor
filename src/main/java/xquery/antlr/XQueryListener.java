// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code VarAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarAsXq(XQueryParser.VarAsXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarAsXq(XQueryParser.VarAsXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagNameXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagNameXq(XQueryParser.TagNameXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagNameXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagNameXq(XQueryParser.TagNameXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisXq(XQueryParser.ParenthesisXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisXq(XQueryParser.ParenthesisXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FlwrXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterFlwrXq(XQueryParser.FlwrXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FlwrXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitFlwrXq(XQueryParser.FlwrXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqSlashSlashRp(XQueryParser.XqSlashSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqSlashSlashRp(XQueryParser.XqSlashSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetXq(XQueryParser.LetXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStringAsXq(XQueryParser.StringAsXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStringAsXq(XQueryParser.StringAsXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqSlashRp(XQueryParser.XqSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqSlashRp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqSlashRp(XQueryParser.XqSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqCommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqCommaXq(XQueryParser.XqCommaXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqCommaXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqCommaXq(XQueryParser.XqCommaXqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApAsXq(XQueryParser.ApAsXqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApAsXq}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApAsXq(XQueryParser.ApAsXqContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 */
	void enterFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 */
	void exitFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#lwr}.
	 * @param ctx the parse tree
	 */
	void enterLwr(XQueryParser.LwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#lwr}.
	 * @param ctx the parse tree
	 */
	void exitLwr(XQueryParser.LwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(XQueryParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(XQueryParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(XQueryParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(XQueryParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(XQueryParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(XQueryParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqValueEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXqValueEqualCond(XQueryParser.XqValueEqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqValueEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXqValueEqualCond(XQueryParser.XqValueEqualCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(XQueryParser.OrCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqIdEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXqIdEqualCond(XQueryParser.XqIdEqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqIdEqualCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXqIdEqualCond(XQueryParser.XqIdEqualCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(XQueryParser.AndCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(XQueryParser.NotCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqSomeCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXqSomeCond(XQueryParser.XqSomeCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqSomeCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXqSomeCond(XQueryParser.XqSomeCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqEmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXqEmptyCond(XQueryParser.XqEmptyCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqEmptyCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXqEmptyCond(XQueryParser.XqEmptyCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisCond(XQueryParser.ParenthesisCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisCond(XQueryParser.ParenthesisCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SomeCond}
	 * labeled alternative in {@link XQueryParser#some_cond}.
	 * @param ctx the parse tree
	 */
	void enterSomeCond(XQueryParser.SomeCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SomeCond}
	 * labeled alternative in {@link XQueryParser#some_cond}.
	 * @param ctx the parse tree
	 */
	void exitSomeCond(XQueryParser.SomeCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DocSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDocSlashRp(XQueryParser.DocSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DocSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDocSlashRp(XQueryParser.DocSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DocSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDocSlashSlashRp(XQueryParser.DocSlashSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DocSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDocSlashSlashRp(XQueryParser.DocSlashSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlashRp(XQueryParser.RpSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlashRp(XQueryParser.RpSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterStar(XQueryParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Star}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitStar(XQueryParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpSlashSlashRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlashSlashRp(XQueryParser.RpSlashSlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpWithFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpWithFilter(XQueryParser.RpWithFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpWithFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpWithFilter(XQueryParser.RpWithFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDot(XQueryParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDot(XQueryParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpCommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpCommaRp(XQueryParser.RpCommaRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpCommaRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpCommaRp(XQueryParser.RpCommaRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(XQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(XQueryParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleDot(XQueryParser.DoubleDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleDot}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleDot(XQueryParser.DoubleDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisRp(XQueryParser.ParenthesisRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisRp(XQueryParser.ParenthesisRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIDEqualFilter(XQueryParser.IDEqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIDEqualFilter(XQueryParser.IDEqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterValueEqualFilter(XQueryParser.ValueEqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueEqualFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitValueEqualFilter(XQueryParser.ValueEqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisFilter(XQueryParser.ParenthesisFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisFilter(XQueryParser.ParenthesisFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#file_name}.
	 * @param ctx the parse tree
	 */
	void enterFile_name(XQueryParser.File_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#file_name}.
	 * @param ctx the parse tree
	 */
	void exitFile_name(XQueryParser.File_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tag_name}.
	 * @param ctx the parse tree
	 */
	void enterTag_name(XQueryParser.Tag_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tag_name}.
	 * @param ctx the parse tree
	 */
	void exitTag_name(XQueryParser.Tag_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#att_name}.
	 * @param ctx the parse tree
	 */
	void enterAtt_name(XQueryParser.Att_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#att_name}.
	 * @param ctx the parse tree
	 */
	void exitAtt_name(XQueryParser.Att_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#str_const}.
	 * @param ctx the parse tree
	 */
	void enterStr_const(XQueryParser.Str_constContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#str_const}.
	 * @param ctx the parse tree
	 */
	void exitStr_const(XQueryParser.Str_constContext ctx);
}