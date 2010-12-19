package fr.inria.verveine.core;

import java.util.Stack;

import fr.inria.verveine.core.gen.famix.Association;
import fr.inria.verveine.core.gen.famix.ContainerEntity;
import fr.inria.verveine.core.gen.famix.Method;
import fr.inria.verveine.core.gen.famix.Namespace;

/** A stack of FAMIX Entities so that we know in what container each new Entity is declared
 * @author anquetil
 */
public class EntityStack {
	public static final int EMPTY_CYCLO = 0;
	public static final int EMPTY_NOS = 0;
	
	private Namespace fmxPckg;
	private Stack<ClassStack> fmxClass;
	
	// for debugging
	private boolean tracing = false;;

	/**
	 * A structure to hold a Famix class and its current method
	 */
	public class ClassStack {
		private fr.inria.verveine.core.gen.famix.Class fmxClass;
		private Method fmxMethod;
		private int metric_cyclo = EMPTY_CYCLO;  // Cyclomatic Complexity
		private int metric_nos = EMPTY_NOS;    // Number Of Statements
		
 		public ClassStack(fr.inria.verveine.core.gen.famix.Class e) {
			fmxClass = e;
			clearFmxMethod();
		}

		public fr.inria.verveine.core.gen.famix.Class getFmxClass() {
			return fmxClass;
		}

		/**
		 * Returns the Famix  Method on top of the context stack
		 */
		public Method getFmxMethod() {
			return fmxMethod;
		}

		/**
		 * Returns the Cyclomatic complexity of the Famix Method on top of the context stack
		 */
		public int getFmxMethodCyclo() {
			return metric_cyclo;
		}

		/**
		 * Returns the Number of Statements of the Famix Method on top of the context stack
		 */
		public int getFmxMethodNOS() {
			return metric_nos;
		}
		
		/**
		 * Reset the Famix Method on top of the context stack
		 */
		public void setFmxMethod(Method fmxMethod) {
			clearFmxMethod();
			this.fmxMethod = fmxMethod;
		}

		/**
		 * Sets the Cyclomatic complexity of the Famix Method on top of the context stack
		 */
		public void setFmxMethodCyclo(int c) {
			metric_cyclo = c;
		}

		/**
		 * Sets to the Number of Statements of the Famix Method on top of the context stack
		 */
		public void setFmxMethodNOS(int n) {
			metric_nos = n;
		}
		
		/**
		 * Adds to the Cyclomatic complexity of the Famix Method on top of the context stack
		 */
		public void addFmxMethodCyclo(int c) {
			metric_cyclo += c;
		}

		/**
		 * Adds to the Number of Statements of the Famix Method on top of the context stack
		 */
		public void addFmxMethodNOS(int n) {
			metric_nos += n;
		}
		
		/**
		 * Empties the context stack of Famix classes
		 */
		public void clearFmxClass() {
			fmxClass = null;
			clearFmxMethod();
		}
		
		/**
		 * Empties the Famix Method on top of the context stack
		 */
		public void clearFmxMethod() {
			fmxMethod = null;
			metric_cyclo = EMPTY_CYCLO;
			metric_nos = EMPTY_NOS;
		}

	}
	
	/**
	 * last Association registered to set the previous/next
	 */
	Association lastAssoc = null;
	
	public Association getLastAssoc() {
		return lastAssoc;
	}

	public void setLastAssoc(Association lastAssoc) {
		this.lastAssoc = lastAssoc;
	}

	public EntityStack() {
		clearPckg();  // initializes (to empty) Pckgs, classes and methods
	}

	public boolean isTracing() {
		return tracing;
	}

	public void setTracing(boolean tracing) {
		this.tracing = tracing;
	}

	private ClassStack getTopClass() {
		if (fmxClass.isEmpty()) {
			return null;
		}
		else {
			return fmxClass.peek();
		}
	}

	// WRITE ON THE STACK
	
	/**
	 * Pushes an entity on top of the "context stack"
	 * @param e -- the entity
	 */
	public void push(ContainerEntity e) {
		if (e instanceof Method) {
			pushMethod((Method) e);
		}
		else if (e instanceof fr.inria.verveine.core.gen.famix.Class) {
			pushClass((fr.inria.verveine.core.gen.famix.Class) e);
		}
		else if (e instanceof Namespace) {
			pushPckg((Namespace) e);
		}
	}

	/**
	 * Sets the Famix namespace on top of the "context stack"
	 * Not really a push, but keep the same convention as the others
	 * @param e -- the Famix method
	 */
	public void pushPckg(Namespace e) {
		if (this.tracing) {
			System.out.println("TRACE: pushPckg "+e.getName());
		}
		clearClasses();
		setLastAssoc(null);
		fmxPckg = e;
	}

	/**
	 * Pushes a Famix class on top of the "context class stack"
	 * @param e -- the Famix class
	 */
	public void pushClass(fr.inria.verveine.core.gen.famix.Class e) {
		if (this.tracing) {
			System.out.println("TRACE: pushClass "+e.getName());
		}
		fmxClass.push(new ClassStack(e));
	}

	/**
	 * Pushes a Famix method on top of the "context stack" for the current Famix class
	 * @param e -- the Famix method
	 */
	public void pushMethod(Method e) {
		if (this.tracing) {
			System.out.println("TRACE: pushMethod "+e.getName());
		}
		getTopClass().setFmxMethod(e);
	}

	/**
	 * Empties the context stack of package and associated classes
	 */
	public void clearPckg() {
		clearClasses();
		fmxPckg = null;
	}

	/**
	 * Empties the context stack of Famix classes
	 */
	public void clearClasses() {
		fmxClass = new Stack<ClassStack>();
	}
	
	// READ FROM THE STACK

	/**
	 * Removes and returns the Famix package from the "context stack"
	 * Also empties the class stack (which was presumably associated to this package)
	 * Note: does not check that there is such a namespace
	 * @return the Famix method
	 */
	public Namespace popPckg() {
		Namespace ret = fmxPckg;
		clearPckg();
		if (this.tracing) {
			System.out.println("TRACE: popPckg "+ret.getName());
		}
		return ret;
	}

	/**
	 * Pops the top Famix class from the "context stack"
	 * Note: does not check that there is such a class, so could possibly throw an EmptyStackException
	 * @return the Famix class
	 */
	public fr.inria.verveine.core.gen.famix.Class popClass() {
		ClassStack tmp = fmxClass.pop();
		if (this.tracing) {
			System.out.println("TRACE: popClass "+tmp.getFmxClass().getName());
		}
		return tmp.getFmxClass();
	}

	/**
	 * Pops the top Famix method of the current class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an Exception
	 * @return the Famix method
	 */
	public Method popMethod() {
		ClassStack tmp = getTopClass();
		Method ret = tmp.getFmxMethod();
		tmp.clearFmxMethod();
		
		if (this.tracing) {
			System.out.println("TRACE: popMethod "+ret.getName());
		}
		return ret;
	}

	/**
	 * Returns the Famix entity on top of the "context stack"
	 * Note: does not check that there is such an entity
	 * @return the Famix entity
	 */
	public ContainerEntity top() {
		ContainerEntity ret = null;
		ClassStack topc = getTopClass();
		if (topc != null) {
			ret = topc.getFmxMethod();
			if (ret == null) {
				ret = topc.getFmxClass();
			}
		}
		else {
			ret = topPckg();
		}

		return ret;
	}

	/**
	 * Returns the Famix package on top of the "context stack"
	 * Note: does not check that there is such a package
	 * @return the Famix namespace
	 */
	public Namespace topPckg() {
		return fmxPckg;
	}

	/**
	 * Returns the Famix class on top of the "context stack"
	 * Note: does not check that there is such a class, so could possibly throw an EmptyStackException
	 * @return the Famix class
	 */
	public fr.inria.verveine.core.gen.famix.Class topClass() {
		return getTopClass().getFmxClass();
	}
	
	/**
	 * Returns the Famix method  of the Famix class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an EmptyStackException
	 * @return the Famix method
	 */
	public Method topMethod() {
		return getTopClass().getFmxMethod();
	}

	// PROPERTIES OF THE TOP METHOD

	/**
	 * Returns the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public int getTopMethodCyclo() {
		if (getTopClass() != null) {
			return getTopClass().getFmxMethodCyclo();
		}
		else {
			return EMPTY_CYCLO;
		}
	}

	/**
	 * Returns the Number of Statements of the Famix Method on top of the context stack
	 */
	public int getTopMethodNOS() {
		if (getTopClass() != null) {
			return getTopClass().getFmxMethodNOS();
		}
		else {
			return EMPTY_NOS;
		}
	}

	/**
	 * Sets the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void setTopMethodCyclo(int c) {
		if (getTopClass() != null) {
			getTopClass().setFmxMethodCyclo(c);
		}
	}

	/**
	 * Sets to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void setTopMethodNOS(int n) {
		if (getTopClass() != null) {
			getTopClass().setFmxMethodNOS(n);
		}
	}
	
	/**
	 * Adds to the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void addTopMethodCyclo(int c) {
		if (getTopClass() != null) {
			getTopClass().addFmxMethodCyclo(c);
		}
	}

	/**
	 * Adds to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void addTopMethodNOS(int n) {
		if (getTopClass() != null) {
			getTopClass().addFmxMethodNOS(n);
		}
	}
	
}

