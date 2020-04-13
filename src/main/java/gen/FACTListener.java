package gen;// Generated from D:/diplom/FormalizedAutomatedContractTool/FACT/src/main/java\FACT.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FACTParser}.
 */
public interface FACTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FACTParser#contract}.
	 * @param ctx the parse tree
	 */
	void enterContract(FACTParser.ContractContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#contract}.
	 * @param ctx the parse tree
	 */
	void exitContract(FACTParser.ContractContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(FACTParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(FACTParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#owes}.
	 * @param ctx the parse tree
	 */
	void enterOwes(FACTParser.OwesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#owes}.
	 * @param ctx the parse tree
	 */
	void exitOwes(FACTParser.OwesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#has}.
	 * @param ctx the parse tree
	 */
	void enterHas(FACTParser.HasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#has}.
	 * @param ctx the parse tree
	 */
	void exitHas(FACTParser.HasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#includes}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(FACTParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#includes}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(FACTParser.IncludesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#party}.
	 * @param ctx the parse tree
	 */
	void enterParty(FACTParser.PartyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#party}.
	 * @param ctx the parse tree
	 */
	void exitParty(FACTParser.PartyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#amount}.
	 * @param ctx the parse tree
	 */
	void enterAmount(FACTParser.AmountContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#amount}.
	 * @param ctx the parse tree
	 */
	void exitAmount(FACTParser.AmountContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(FACTParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(FACTParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FACTParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FACTParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(FACTParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(FACTParser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(FACTParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(FACTParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link FACTParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(FACTParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FACTParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(FACTParser.PropertyContext ctx);
}