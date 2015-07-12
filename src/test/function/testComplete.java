package test.function;

import java.io.IOException;

import org.junit.Test;

import test.TestAbstract;
import compiler.compiler.LyCompiler;
import compiler.exception.ParseException;

public class testComplete extends TestAbstract {
	
	@Override 
	public void test() throws ParseException, IOException {
		//success("success_simple", "", new String[]{"15"});
		//success("success_inline", "", new String[]{"12"});
		success("success_fib", "11", new String[]{"89"});
	}
	
}
