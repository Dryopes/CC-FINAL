package test;

import iloc.Simulator;
import iloc.model.Program;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import compiler.Result;
import compiler.compiler.LyCompiler;
import compiler.exception.ParseException;

public abstract class TestAbstract {
	protected final static boolean DEBUG = true;
	protected final static String extension = ".ly";
	protected final LyCompiler compiler = LyCompiler
			.instance();
	
	@Test
	public abstract void test() throws Exception;
	
	protected void success(String filename, String input, String[] output) throws ParseException, IOException {
		Program prog = compile(filename);
		if(DEBUG) {
			System.out.println("Pretty Print Basic:");
			System.out.println(prog.prettyPrint());
		}
		
		String out = sim(prog, input);
		assertArrayEquals(out.split("\n"), output);
	}
	
	protected void success(ParseTree tree, String input, String[] output) throws ParseException, IOException {
		Program prog = this.compiler.compile(tree);
		if(DEBUG) {
			System.out.println("Pretty Print Basic:");
			System.out.println(prog.prettyPrint());
		}
		
		String out = sim(prog, input);
		assertArrayEquals(out.split("\n"), output);
	}
	
	protected void failChecker(String filename) throws IOException {
		try {
			check(filename);
			fail(filename + " shouldn't check but did");
		} catch (ParseException exc) {
			// this is the expected behaviour
		}
	}
	
	protected void failChecker(ParseTree tree) throws IOException {
		try {
			this.compiler.check(tree);
			fail(tree.toString() + " shouldn't check but did");
		} catch (ParseException exc) {
			// this is the expected behaviour
		}
	}
	
	protected String sim(Program prog, String input) {
		Simulator sim = new Simulator(prog);
		sim.setIn(new ByteArrayInputStream(input.getBytes()));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		sim.setOut(out);
		sim.run();
		return out.toString();
	}
	
	protected Result check(String filename) throws ParseException, IOException {
		return this.compiler.check(this.compiler.parse(new File(getBaseDir(), filename + extension)));
	}
	
	protected Program compile(String filename) throws ParseException, IOException {
		return this.compiler.compile(new File(getBaseDir(), filename + extension));
	}
	
	protected String getBaseDir() {
		return "src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/");
	}
}
