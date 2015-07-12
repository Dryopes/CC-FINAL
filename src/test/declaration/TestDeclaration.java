package test.declaration;

import test.TestAbstract;
import iloc.Simulator;

public class TestDeclaration extends TestAbstract{

	@Override
	public void test() throws Exception {
		success("succes", "", new String[]{"1", "" + (int)'a', "" + Simulator.TRUE, "2", "" + (int)'b', "" + Simulator.FALSE});
	}
	
}
