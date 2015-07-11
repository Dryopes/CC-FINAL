package grammar;

import grammar.SymbolTable.Variable;
import grammar.SymbolTable.Function;

/** 
 * Class combining the information of a single scope level. 
 * 
 */
public class Scope {
	/** Current size of this scope (in bytes). 
	 * Used to calculate offsets of newly declared variables. */
	private int size;
	/** The symbolic table that holds the information about variables and functions */
	private final SymbolTable table;
	
	/** If this scope is within a function or not */
	private final boolean inFunction;
	
	/** Name of the scope */
	private final String name;
	
	/** Parent scope, can be null */
	private Scope parent;

	/** Constructs a fresh, initially empty scope.
	 * @ensure getName().equals("");
	 */
	public Scope() {
		this.name = "";
		this.parent = null;
		this.inFunction = false;
		
		this.table = new SymbolTable();
	}
	
	/** Constructs a scope with a parent. Values that carry over:
	 * parent.size, parent.inFunction and parent.name
	 * For a scope without parent, see {@link Scope#Scope()}
	 * @require parent != null
	 */
	public Scope(Scope parent) {
		this.parent = parent;
		this.size = parent.size;
		this.inFunction = parent.inFunction;
		this.name = parent.name;
		
		this.table = new SymbolTable();
	}
	
	/** Constructs a scope with a parent. Values that carry over:
	 * parent.size, parent.inFunction
	 * 
	 * The name of this scope will be the previous scope name + the new name, 
	 * if there was a previous scope name.
	 * 
	 * For a scope without parent, see {@link Scope#Scope()}
	 * @require parent != null
	 */
	public Scope(Scope parent, String name, boolean inFunction) {
		this.parent = parent;
		this.size = parent.size;
		this.inFunction = inFunction;
		this.name = parent.name.isEmpty() ? name : parent.name + "_" + name;
		
		this.table = new SymbolTable();
	}

	/**
	 * Checks if the given indentifier is declared as variable in this scope or
	 * a previous scope (see {@link Scope#parent})
	 * @param id the identifier of the variable
	 * @return true if the variable was declared in this scope or a previous scope
	 */
	public boolean contains(String id) {
		if(this.parent != null) 
			return this.table.containsVar(id) || parent.contains(id);
		
		return this.table.containsVar(id);
	}
	
	/**
	 * Checks if the given indentifier is declared as function in this scope or
	 * a previous scope (see {@link Scope#parent})
	 * @param id the identifier of the function
	 * @return true if the function was declared in this scope or a previous scope
	 */
	public boolean containsFunction(String id) {
		if(this.parent != null)
			return this.table.containsFunc(id) || parent.contains(id);
		
		return this.table.containsFunc(id);
	}

	/** Declares an identifier with a given type as a variable
	 * if the identifier is not yet in this scope.
	 * 
	 * @return <code>true</code> if the identifier was added;
	 * <code>false</code> if it was already declared.
	 */
	public boolean put(String id, Type type) {
		boolean result = !this.contains(id);
		if (result) {
			if(inFunction())
				this.table.putVar(id, type, this.size += type.size());
			else
				this.table.putVar(id, type);
		}
		return result;
	}
	
	/** Declares an identifier with a given type as a function or procedure,
	 * if the indentifier is not yet in this scope.
	 * 
	 * @param type if void then procedure else a function
	 * @return <code>true</code> if the identifier was added;
	 * <code>false</code> if it was already declared.
	 */
	public boolean putFunction(String id, Type type) {
		boolean result = !this.containsFunction(id);
		if(result) 
			this.table.putFunc(id, type);
		
		return result;
	}

	/** Returns the type of a given (presumably declared) identifier.
	 */
	public Type type(String id) {
		Variable result = this.table.getVar(id);
		if(this.parent != null && result == null) {
				return parent.type(id);
		}
		return result != null ? result.type : null;
	}

	/** Returns the type of a given function */
	public Type funcType(String id) {
		Function result = this.table.getFunc(id);
		if(this.parent != null && result == null) {
			return parent.type(id);
		}
		return result != null ? result.type : null;
	}
	
	/** Returns the offset of a given (presumably declared) identifier. 
	  * with respect to the beginning of this scope's activation record.
	  * Offsets are assigned in order of declaration. 
	  */
	public Integer offset(String id) {
		Variable result = this.table.getVar(id);
		return result != null ? result.offset : null;
	}
	
	/** 
	 * Creates a new scope with this as the parent scope
	 */
	public Scope openScope() {
		return new Scope(this);
	}
	
	/**
	 * Open a new function scope with this as parent scope
	 * @return new Scope(this, true)
	 */
	public Scope openFunctionScope(String name) {
		return new Scope(this, name, true);
	}
	
	/**
	 * Closes the scope and returns the previous scope
	 * @return this.parent
	 */
	public Scope closeScope() {
		return this.parent;
	}

	/**
	 * Is true if the scope in within a function
	 * @return {@link Scope#inFunction}
	 */
	public boolean inFunction() {
		return this.inFunction;
	}

	/**
	 * Returns the name of the scope. Used for function
	 * within function labeling.
	 * @return {@link Scope#name}
	 */
	public String getName() {
		return this.name;
	}
	
}