package eu.synectique.verveine.core;

import java.util.Stack;

import eu.synectique.verveine.core.gen.famix.Access;
import eu.synectique.verveine.core.gen.famix.AnnotationTypeAttribute;
import eu.synectique.verveine.core.gen.famix.Invocation;
import eu.synectique.verveine.core.gen.famix.Method;
import eu.synectique.verveine.core.gen.famix.NamedEntity;
import eu.synectique.verveine.core.gen.famix.Namespace;
import eu.synectique.verveine.core.gen.famix.Reference;

/** A stack of FAMIX Entities so that we know in what container each new Entity is declared
 * @author anquetil
 */
public class EntityStack {
	public static final int EMPTY_CYCLO = 0;
	public static final int EMPTY_NOS = 0;

	private Stack<NamedEntity> stack;
	
	private class MetricHolder extends NamedEntity {
		private int metric_cyclo = EMPTY_CYCLO;  // Cyclomatic Complexity
		private int metric_nos = EMPTY_NOS;      // Number Of Statements
		private Method meth;

		protected MetricHolder(Method meth) {
			this.meth = meth;
		}
		protected int getCyclo() {
			return metric_cyclo;
		}
		protected void setCyclo(int metric_cyclo) {
			this.metric_cyclo = metric_cyclo;
		}
		protected int getNos() {
			return metric_nos;
		}
		protected void setNos(int metric_nos) {
			this.metric_nos = metric_nos;
		}
		protected Method getMeth() {
			return meth;
		}
	}

	/**
	 * last Invocation registered to set the previous/next
	 */
	Invocation lastInvocation = null;
	
	/**
	 * last Access registered to set the previous/next
	 */
	Access lastAccess = null;
	
	/**
	 * last Reference registered to set the previous/next
	 */
	Reference lastReference = null;
	
	public Access getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Access lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Reference getLastReference() {
		return lastReference;
	}

	public void setLastReference(Reference lastReference) {
		this.lastReference = lastReference;
	}

	public Invocation getLastInvocation() {
		return lastInvocation;
	}

	public void setLastInvocation(Invocation lastInvocation) {
		this.lastInvocation = lastInvocation;
	}

	public EntityStack() {
		clearPckg();  // initializes (to empty) Pckgs, classes and methods
	}

	// WRITE ON THE STACK
	
	/**
	 * Pushes an entity on top of the "context stack"
	 * @param e -- the entity
	 */
	public void push(NamedEntity e) {
		stack.push(e);
	}

	/**
	 * Sets the Famix namespace on top of the "context stack"
	 * Not really a push, but keep the same convention as the others
	 * @param e -- the Famix method
	 */
	public void pushPckg(Namespace e) {
		push(e);
	}

	/**
	 * Pushes a Famix Type on top of the "context type stack"
	 * @param t -- the FamixType
	 */
	public void pushType(eu.synectique.verveine.core.gen.famix.Type t) {
		push(t);
	}

	/**
	 * Pushes a Famix method on top of the "context stack" for the current Famix Type
	 * @param e -- the Famix method
	 */
	public void pushMethod(Method e) {
		push(e);
		push( new MetricHolder(e) );
	}

	public void pushAnnotationMember(AnnotationTypeAttribute fmx) {
		push(fmx);	
	}
	
	/**
	 * Empties the context stack of package and associated classes
	 */
	public void clearPckg() {
		stack = new Stack<NamedEntity>();
	}

	/**
	 * Empties the context stack of Famix classes
	 */
	public void clearTypes() {
		while (! (this.top() instanceof Namespace)) {
			this.popUpto(eu.synectique.verveine.core.gen.famix.Type.class);			
		}
	}
	
	// READ FROM THE STACK

	private <T extends NamedEntity> T popUpto(Class<T> clazz) {
		NamedEntity ent = null;
		while ( (! stack.isEmpty()) && (! clazz.isInstance(ent)) ) {
			ent = this.pop();
		}

		if (stack.isEmpty()) {
			return null;
		}
		else {
			return (T) ent;
		}
	}

	private <T extends NamedEntity> T lookUpto(Class<T> clazz) {
		int i=this.stack.size()-1;

		while ( (i >= 0) && (! clazz.isInstance(stack.get(i))) ) {
			i--;
		}

		if (i < 0) {
			return null;
		}
		else {
			return (T)stack.get(i);
		}
	}

	public NamedEntity pop() {
		if (stack.isEmpty()) {
			return null;
		}
		else {
			NamedEntity e = stack.pop();
			if (e instanceof MetricHolder) {
				return stack.pop();
			}
			else {
				return e;
			}
		}
	}

	/**
	 * Removes and returns the Famix package from the "context stack"
	 * Also empties the class stack (which was presumably associated to this package)
	 * Note: does not check that there is such a namespace
	 * @return the Famix method
	 */
	public Namespace popPckg() {
		return this.popUpto(Namespace.class);
	}

	/**
	 * Pops the top Famix type from the "context stack"<BR>
	 * Note: does not check that there is such a type, so could possibly throw an EmptyStackException
	 * @return the Famix class
	 */
	public eu.synectique.verveine.core.gen.famix.Type popType() {
		return this.popUpto(eu.synectique.verveine.core.gen.famix.Type.class);
	}

	/**
	 * Pops the top Famix method of the current class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an Exception
	 * @return the Famix method
	 */
	public Method popMethod() {
		return this.popUpto(Method.class);
	}
	
	public AnnotationTypeAttribute popAnnotationMember() {
		return this.popUpto(AnnotationTypeAttribute.class);
	}

	/**
	 * Returns the Famix entity on top of the "context stack"
	 * Note: does not check that there is such an entity
	 * @return the Famix entity
	 */
	public NamedEntity top() {
		if (stack.isEmpty()) {
			return null;
		}
		else {
			NamedEntity e = stack.peek();
			if (e instanceof MetricHolder) {
				return ((MetricHolder) e).getMeth();
			}
			else {
				return e;
			}
		}
	}

	/**
	 * Returns the Famix package on top of the "context stack"
	 * Note: does not check that there is such a package
	 * @return the Famix namespace
	 */
	public Namespace topPckg() {
		return this.lookUpto(Namespace.class);
	}

	/**
	 * Returns the Famix type on top of the "context stack"
	 * Note: does not check that there is such a class, so could possibly throw an EmptyStackException
	 * @return the Famix class
	 */
	public eu.synectique.verveine.core.gen.famix.Type topType() {
		return this.lookUpto(eu.synectique.verveine.core.gen.famix.Type.class);
	}

	/**
	 * Returns the Famix method  of the Famix class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an EmptyStackException
	 * @return the Famix method
	 */
	public Method topMethod() {
		return this.lookUpto(Method.class);
	}

	public AnnotationTypeAttribute topAnnotationMember() {
		return this.lookUpto(AnnotationTypeAttribute.class);
	}

	// PROPERTIES OF THE TOP METHOD

	/**
	 * Returns the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public int getTopMethodCyclo() {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			return met.getCyclo();
		}
		else {
			return EMPTY_CYCLO;
		}
	}

	/**
	 * Returns the Number of Statements of the Famix Method on top of the context stack
	 */
	public int getTopMethodNOS() {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			return met.getNos();
		}
		else {
			return EMPTY_NOS;
		}
	}

	/**
	 * Sets the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void setTopMethodCyclo(int c) {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			met.setCyclo(c);
		}
	}

	/**
	 * Sets to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void setTopMethodNOS(int n) {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			met.setNos(n);
		}
	}
	
	/**
	 * Adds to the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void addTopMethodCyclo(int c) {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			met.setCyclo( met.getCyclo()+c );
		}
	}

	/**
	 * Adds to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void addTopMethodNOS(int n) {
		MetricHolder met = this.lookUpto(MetricHolder.class);

		if (met != null) {
			met.setNos( met.getNos()+n );
		}
	}

}

