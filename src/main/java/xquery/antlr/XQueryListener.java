// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQuery.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XQueryParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XQueryParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XQueryParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XQueryParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(XQueryParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(XQueryParser.FContext ctx);
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