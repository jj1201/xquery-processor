// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XQueryParser.IsFilterContext ctx);
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
}