package test.conditional;

import test.TestAbstract;

public class TestCompound extends TestAbstract {

	@Override
	public void test() throws Exception {
		success("fib", "10", new String[]{"89"});
		success("ifelse", "", new String[]{"25", "12", "5", "5", "3", "4", "3", "14"});		
	}
	
}
