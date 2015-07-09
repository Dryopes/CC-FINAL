package test.compound;

import test.TestAbstract;

public class TestCompound extends TestAbstract {

	@Override
	public void test() throws Exception {
		success("succes", "", new String[]{});
		failChecker("voidfail");
		
	}
	
}
