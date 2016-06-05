// Generated from /home/lichkkkk/git/xquery-processor/src/main/resource/XQueryReduced.g4 by ANTLR 4.5.1
package xquery.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryReducedParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, DOC=21, QUOTED_STRING=22, STRING=23, WS=24;
	public static final int
		RULE_xq = 0, RULE_path = 1, RULE_ret = 2, RULE_cond = 3, RULE_var2 = 4, 
		RULE_constant = 5, RULE_var = 6, RULE_tag = 7, RULE_slash = 8;
	public static final String[] ruleNames = {
		"xq", "path", "ret", "cond", "var2", "constant", "var", "tag", "slash"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'for'", "'in'", "','", "'where'", "'return'", "'('", "')'", "'node()'", 
		"'text()'", "'<'", "'>'", "'{'", "'}'", "'/'", "'eq'", "'='", "'and'", 
		"'AND'", "'$'", "'//'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "DOC", "QUOTED_STRING", 
		"STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQueryReduced.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryReducedParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XqContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		XqContext _localctx = new XqContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(19);
			var();
			setState(20);
			match(T__1);
			setState(21);
			path();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(22);
				match(T__2);
				setState(23);
				var();
				setState(24);
				match(T__1);
				setState(25);
				path();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(T__3);
			setState(33);
			cond();
			setState(34);
			match(T__4);
			setState(35);
			ret(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode DOC() { return getToken(XQueryReducedParser.DOC, 0); }
		public TerminalNode QUOTED_STRING() { return getToken(XQueryReducedParser.QUOTED_STRING, 0); }
		public List<SlashContext> slash() {
			return getRuleContexts(SlashContext.class);
		}
		public SlashContext slash(int i) {
			return getRuleContext(SlashContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(XQueryReducedParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(XQueryReducedParser.STRING, i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_path);
		int _la;
		try {
			int _alt;
			setState(68);
			switch (_input.LA(1)) {
			case DOC:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(DOC);
				setState(38);
				match(T__5);
				setState(39);
				match(QUOTED_STRING);
				setState(40);
				match(T__6);
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(41);
						slash();
						setState(42);
						match(STRING);
						}
						} 
					}
					setState(48);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(52);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(49);
					slash();
					setState(50);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==T__8) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				var();
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(55);
						slash();
						setState(56);
						match(STRING);
						}
						} 
					}
					setState(62);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(66);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(63);
					slash();
					setState(64);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==T__8) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
	 
		public RetContext() { }
		public void copyFrom(RetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetRetContext extends RetContext {
		public List<RetContext> ret() {
			return getRuleContexts(RetContext.class);
		}
		public RetContext ret(int i) {
			return getRuleContext(RetContext.class,i);
		}
		public RetRetContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitRetRet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RetVarContext extends RetContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public RetVarContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitRetVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RetPathContext extends RetContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public RetPathContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitRetPath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RetTagContext extends RetContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public RetTagContext(RetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitRetTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		return ret(0);
	}

	private RetContext ret(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RetContext _localctx = new RetContext(_ctx, _parentState);
		RetContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_ret, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new RetVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				var();
				}
				break;
			case 2:
				{
				_localctx = new RetTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(T__9);
				setState(73);
				tag();
				setState(74);
				match(T__10);
				setState(75);
				match(T__11);
				setState(76);
				ret(0);
				setState(77);
				match(T__12);
				setState(78);
				match(T__9);
				setState(79);
				match(T__13);
				setState(80);
				tag();
				setState(81);
				match(T__10);
				}
				break;
			case 3:
				{
				_localctx = new RetPathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				path();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RetRetContext(new RetContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_ret);
					setState(86);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(87);
					match(T__2);
					setState(88);
					ret(4);
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<Var2Context> var2() {
			return getRuleContexts(Var2Context.class);
		}
		public Var2Context var2(int i) {
			return getRuleContext(Var2Context.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			var();
			setState(95);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(96);
			var2();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				{
				setState(97);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(98);
				var();
				setState(99);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(100);
				var2();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var2Context extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Var2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitVar2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var2Context var2() throws RecognitionException {
		Var2Context _localctx = new Var2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_var2);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case QUOTED_STRING:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				constant();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode QUOTED_STRING() { return getToken(XQueryReducedParser.QUOTED_STRING, 0); }
		public TerminalNode STRING() { return getToken(XQueryReducedParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !(_la==QUOTED_STRING || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryReducedParser.STRING, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__18);
			setState(114);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryReducedParser.STRING, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlashContext extends ParserRuleContext {
		public SlashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryReducedVisitor ) return ((XQueryReducedVisitor<? extends T>)visitor).visitSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlashContext slash() throws RecognitionException {
		SlashContext _localctx = new SlashContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_slash);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return ret_sempred((RetContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ret_sempred(RetContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3\3\3\3\3\5\3"+
		"\67\n\3\3\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3\3\3\3\3\5\3E\n\3\5"+
		"\3G\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4W\n"+
		"\4\3\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5i\n\5\f\5\16\5l\13\5\3\6\3\6\5\6p\n\6\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\2\3\6\13\2\4\6\b\n\f\16\20\22\2\7\3\2\n\13\3\2\21\22\3"+
		"\2\23\24\3\2\30\31\4\2\20\20\26\26|\2\24\3\2\2\2\4F\3\2\2\2\6V\3\2\2\2"+
		"\b`\3\2\2\2\no\3\2\2\2\fq\3\2\2\2\16s\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2"+
		"\24\25\7\3\2\2\25\26\5\16\b\2\26\27\7\4\2\2\27\37\5\4\3\2\30\31\7\5\2"+
		"\2\31\32\5\16\b\2\32\33\7\4\2\2\33\34\5\4\3\2\34\36\3\2\2\2\35\30\3\2"+
		"\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7"+
		"\6\2\2#$\5\b\5\2$%\7\7\2\2%&\5\6\4\2&\3\3\2\2\2\'(\7\27\2\2()\7\b\2\2"+
		")*\7\30\2\2*\60\7\t\2\2+,\5\22\n\2,-\7\31\2\2-/\3\2\2\2.+\3\2\2\2/\62"+
		"\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\66\3\2\2\2\62\60\3\2\2\2\63\64\5"+
		"\22\n\2\64\65\t\2\2\2\65\67\3\2\2\2\66\63\3\2\2\2\66\67\3\2\2\2\67G\3"+
		"\2\2\28>\5\16\b\29:\5\22\n\2:;\7\31\2\2;=\3\2\2\2<9\3\2\2\2=@\3\2\2\2"+
		"><\3\2\2\2>?\3\2\2\2?D\3\2\2\2@>\3\2\2\2AB\5\22\n\2BC\t\2\2\2CE\3\2\2"+
		"\2DA\3\2\2\2DE\3\2\2\2EG\3\2\2\2F\'\3\2\2\2F8\3\2\2\2G\5\3\2\2\2HI\b\4"+
		"\1\2IW\5\16\b\2JK\7\f\2\2KL\5\20\t\2LM\7\r\2\2MN\7\16\2\2NO\5\6\4\2OP"+
		"\7\17\2\2PQ\7\f\2\2QR\7\20\2\2RS\5\20\t\2ST\7\r\2\2TW\3\2\2\2UW\5\4\3"+
		"\2VH\3\2\2\2VJ\3\2\2\2VU\3\2\2\2W]\3\2\2\2XY\f\5\2\2YZ\7\5\2\2Z\\\5\6"+
		"\4\6[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\7\3\2\2\2_]\3\2\2\2`a\5"+
		"\16\b\2ab\t\3\2\2bj\5\n\6\2cd\t\4\2\2de\5\16\b\2ef\t\3\2\2fg\5\n\6\2g"+
		"i\3\2\2\2hc\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lj\3\2\2\2"+
		"mp\5\f\7\2np\5\16\b\2om\3\2\2\2on\3\2\2\2p\13\3\2\2\2qr\t\5\2\2r\r\3\2"+
		"\2\2st\7\25\2\2tu\7\31\2\2u\17\3\2\2\2vw\7\31\2\2w\21\3\2\2\2xy\t\6\2"+
		"\2y\23\3\2\2\2\f\37\60\66>DFV]jo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}