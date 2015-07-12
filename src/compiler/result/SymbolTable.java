package compiler.result;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import compiler.type.Type;
import compiler.type.Type.Void;

public class SymbolTable {
	public static class Variable {
		public Type type;
		public int offset;
	}
	
	public static class Function {
		public Type type;
		public String[] params;
	}
	
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	private Map<String, Function> functions = new HashMap<String, Function>();
	
	public Variable putVar(String id, Type type) {
		return putVar(id, type, -1);
	}
	
	public Variable putVar(String id, Type type, int offset) {
		Variable var = new Variable();
		var.type = type;
		var.offset = offset;
		this.variables.put(id, var);
		return var;
	}
	
	public Function putProcedure(String id, String[] params) {
		return putFunc(id, new Type.Void(), params);
	}
	
	public Function putFunc(String id, Type type, String[] params) {		
		Function func = new Function();
		func.type = type;
		func.params = params;
		this.functions.put(id, func);
		return func;
	}
	
	public boolean containsVar(String id) {
		return this.variables.containsKey(id);
	}
	
	public boolean containsFunc(String id) {
		return this.functions.containsKey(id);
	}
	
	public Variable getVar(String id) {
		/*System.out.println("Variables:");
		for(Entry<String, Variable> entry : this.variables.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue().type.toString());*/
		
		return this.variables.get(id);
	}
	
	public Function getFunc(String id) {
		/*System.out.println("Functions: ");
		for(Entry<String, Function> entry : this.functions.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue().type.toString());*/

		return this.functions.get(id);
	}
	
	
}
