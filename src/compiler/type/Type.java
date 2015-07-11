package compiler.type;

import iloc.eval.Machine;

/** Pascal data type. */
abstract public class Type {	
	private final TypeKind kind;
	private final boolean reference;
	private final boolean constant;

	public Type(TypeKind kind, boolean ref, boolean cnst) {
		this.kind = kind;
		this.reference = ref;
		this.constant = cnst;
	}

	public TypeKind getKind() {
		return this.kind;
	}
	
	public boolean isRef() {
		return this.reference;
	}
	
	public boolean isConst() {
		return this.constant;
	}

	/** returns the size (in bytes) of a value of this type. */
	abstract public int size();

	static public class Bool extends Type {
		public Bool(boolean ref, boolean cnst) {
			super(TypeKind.BOOL, ref, cnst);
		}

		@Override
		public int size() {
			return Machine.INT_SIZE;
		}

		@Override
		public String toString() {
			return "Boolean";
		}
	}

	static public class Int extends Type {
		public Int(boolean ref, boolean cnst) {
			super(TypeKind.INT, ref, cnst);
		}

		@Override
		public int size() {
			return Machine.INT_SIZE;
		}

		@Override
		public String toString() {
			return "Integer";
		}
	}
	
	static public class Char extends Type {
		public Char(boolean ref, boolean cnst) {
			super(TypeKind.CHR, ref, cnst);
		}

		@Override
		public int size() {
			return Machine.INT_SIZE;
		}

		@Override
		public String toString() {
			return "Char";
		}
	}
	
	static public class Void extends Type {
		public Void() {
			super(TypeKind.VOID, false, false);
		}
		
		@Override
		public int size() {
			return Machine.INT_SIZE;
		}
		
		@Override
		public String toString() {
			return "Void";
		}
	}

	static public class Array extends Type {
		private final int lower;
		private final int upper;
		private final Type elemType;

		public Array(int lower, int upper, Type elemType, boolean ref, boolean cnst) {
			super(TypeKind.ARRAY, ref, cnst);
			assert upper >= lower;
			this.lower = lower;
			this.upper = upper;
			this.elemType = elemType;
		}

		public int getLower() {
			return this.lower;
		}

		public int getUpper() {
			return this.upper;
		}

		public Type getElemType() {
			return this.elemType;
		}

		@Override
		public int size() {
			return (getUpper() - getLower() + 1) * this.elemType.size();
		}

		@Override
		public String toString() {
			return "Array [" + this.lower + ".." + this.upper + "] of "
					+ this.elemType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.elemType.hashCode();
			result = prime * result + this.lower;
			result = prime * result + this.upper;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Array)) {
				return false;
			}
			Array other = (Array) obj;
			if (!this.elemType.equals(other.elemType)) {
				return false;
			}
			if (this.lower != other.lower) {
				return false;
			}
			if (this.upper != other.upper) {
				return false;
			}
			return true;
		}

	}
}
