package test.decleration;

import test.TestAbstract;
import iloc.Simulator;

public class TestDecleration extends TestAbstract{

	@Override
	public void test() throws Exception {
		success("succes.ly", "", new String[]{"1", "" + (int)'a', "" + Simulator.TRUE, "2", "" + (int)'b', "" + Simulator.FALSE});
	}
	
}
