package fr.inria.verveine.core;

import java.util.Stack;

import fr.inria.verveine.core.gen.famix.ContainerEntity;
import fr.inria.verveine.core.gen.famix.Method;
import fr.inria.verveine.core.gen.famix.Namespace;

/** A stack of FAMIX Entities so that we know in what container each new Entity is declared
 * @author anquetil
 */
public class EntityStack {
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
		
		public ClassStack(fr.inria.verveine.core.gen.famix.Class e) {
			fmxClass = e;
			fmxMethod = null;
		}

		public fr.inria.verveine.core.gen.famix.Class getFmxClass() {
			return fmxClass;
		}

		public Method getFmxMethod() {
			return fmxMethod;
		}

		public void setFmxMethod(Method fmxMethod) {
			this.fmxMethod = fmxMethod;
		}

		/**
		 * Empties the context stack of Famix classes
		 */
		public void clearFmxClass() {
			fmxClass = null;
			clearFmxMethod();
		}
		
		/**
		 * Empties the context stack of Famix Methods
		 */
		public void clearFmxMethod() {
			fmxMethod = null;
		}

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
	 * Sets the Famix namespace on top of the "context stack"
	 * Not really a push, but keep the same convention as the others
	 * @param e -- the Famix method
	 */
	public void pushPckg(Namespace e) {
		if (this.tracing) {
			System.out.println("TRACE: pushPckg "+e.getName());
		}
		clearClasses();
		fmxPckg = e;
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
	 * Empties the context stack of Famix classes
	 */
	public void clearClasses() {
		fmxClass = new Stack<ClassStack>();
	}
	
	/**
	 * Empties the context stack of package and associated classes
	 */
	public void clearPckg() {
		clearClasses();
		fmxPckg = null;
	}
	
	/**
	 * Returns the Famix method  of the Famix class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an EmptyStackException
	 * @return the Famix method
	 */
	public Method topMethod() {
		return getTopClass().getFmxMethod();
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
	 * Returns the Famix package on top of the "context stack"
	 * Note: does not check that there is such a package
	 * @return the Famix namespace
	 */
	public Namespace topPckg() {
		return fmxPckg;
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

	private ClassStack getTopClass() {
		if (fmxClass.isEmpty()) {
			return null;
		}
		else {
			return fmxClass.peek();
		}
	}
}

