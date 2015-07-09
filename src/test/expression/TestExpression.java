package test.expression;

import java.io.IOException;

import grammar.lyParser;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.exception.ParseException;
import test.TestAbstract;

public class TestExpression extends TestAbstract {

	@Override
	public void test() throws Exception {
		testDifferentTypeFail();
		
	}
	
	public void testDifferentTypeFail() throws IOException, ParseException {
		testFailOperator(lyParser.AND);
		testFailOperator(lyParser.OR);
		
		testFailOperator(lyParser.EQ);
		testFailOperator(lyParser.NE);
		testFailOperator(lyParser.GE);
		testFailOperator(lyParser.LE);
		testFailOperator(lyParser.LT);
		testFailOperator(lyParser.GT);
		
		testFailOperator(lyParser.PLUS);
		testFailOperator(lyParser.MINUS);
		
		testFailOperator(lyParser.ASS);
	}
	
	public void testFailOperator(int operator) throws IOException, ParseException {
		failChecker(createProgram(new Integer(1), new Character('a'), operator));
		failChecker(createProgram(new Integer(1), new Boolean(true), operator));
		
		failChecker(createProgram(new Character('a'), new Integer(1), operator));
		failChecker(createProgram(new Character('a'), new Boolean(true), operator));
		
		failChecker(createProgram(new Boolean(true), new Integer(1), operator));
		failChecker(createProgram(new Boolean(true), new Character('a'), operator));
	}
	
	public ParseTree createProgram(Object first, Object second, int op) throws ParseException {		
		String program = "";
		Vocabulary voc = lyParser.VOCABULARY;
		
		if(first instanceof Character) program += voc.getLiteralName(lyParser.CHAR).replaceAll("'", "");
		if(first instanceof Integer) program += voc.getLiteralName(lyParser.INT).replaceAll("'", "");
		if(first instanceof Boolean) program += voc.getLiteralName(lyParser.BOOL).replaceAll("'", "");
		program += " var1;";
		
		if(second instanceof Character) program += voc.getLiteralName(lyParser.CHAR).replaceAll("'", "");
		if(second instanceof Integer) program += voc.getLiteralName(lyParser.INT).replaceAll("'", "");
		if(second instanceof Boolean) program += voc.getLiteralName(lyParser.BOOL).replaceAll("'", "");
		program += " var2;";
		
		program += "var1 " + voc.getLiteralName(lyParser.ASS).replaceAll("'", "") + " " + first.toString() + ";";
		program += "var2 " + voc.getLiteralName(lyParser.ASS).replaceAll("'", "") + " " + second.toString() + ";";
		
		program += voc.getLiteralName(lyParser.PRINT).replaceAll("'", "") + "(var1 " + voc.getLiteralName(op).replaceAll("'", "") + " var2);";
		
		return this.compiler.parse(program);
	}

}
