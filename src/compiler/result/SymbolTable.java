package compiler.result;

import java.util.HashMap;
import java.util.Map;

import compiler.type.Type;
import compiler.type.Type.Void;

public class SymbolTable {
	public static class Variable {
		public Type type;
		public int offset;
	}
	
	public static class Function {
		public Type type;
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
	
	public Function putProcedure(String id) {
		return putFunc(id, new Type.Void());
	}
	
	public Function putFunc(String id, Type type) {
		Function func = new Function();
		func.type = type;
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
		return this.variables.get(id);
	}
	
	public Function getFunc(String id) {
		return this.functions.get(id);
	}
	
	
}
