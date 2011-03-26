package fr.inria.verveine.core;

import java.util.Stack;

import fr.inria.verveine.core.gen.famix.Access;
import fr.inria.verveine.core.gen.famix.AnnotationType;
import fr.inria.verveine.core.gen.famix.AnnotationTypeAttribute;
import fr.inria.verveine.core.gen.famix.Class;
import fr.inria.verveine.core.gen.famix.ContainerEntity;
import fr.inria.verveine.core.gen.famix.Invocation;
import fr.inria.verveine.core.gen.famix.Method;
import fr.inria.verveine.core.gen.famix.NamedEntity;
import fr.inria.verveine.core.gen.famix.Namespace;
import fr.inria.verveine.core.gen.famix.Reference;

/** A stack of FAMIX Entities so that we know in what container each new Entity is declared
 * @author anquetil
 */
public class EntityStack {
	public static final int EMPTY_CYCLO = 0;
	public static final int EMPTY_NOS = 0;
	
	private Namespace fmxPckg;
	private Stack<ClassStack> fmxType;

	/**
	 * A structure to hold a Famix class and its current method
	 */
	public class ClassStack {
		private NamedEntity fmxType;  // can be a FamixClass or a FamixAnnotationType
		private NamedEntity fmxMember; // can be a FamixMethod or a FamixAnnotationAttribute
		private int metric_cyclo = EMPTY_CYCLO;  // Cyclomatic Complexity
		private int metric_nos = EMPTY_NOS;      // Number Of Statements
		
		
 		public ClassStack(NamedEntity e) {
			fmxType = e;
			clearFmxMember();
		}

		public fr.inria.verveine.core.gen.famix.Class getFmxClass() {
			if (fmxType instanceof fr.inria.verveine.core.gen.famix.Class) {
				return (fr.inria.verveine.core.gen.famix.Class) fmxType;
			}
			else {
				return null;
			}
		}

		public AnnotationType getFmxAnnotationType() {
			if (fmxType instanceof AnnotationType) {
				return (AnnotationType) fmxType;
			}
			else {
				return null;
			}
		}

		/**
		 * Returns the Famix  Method on top of the context stack
		 */
		public Method getFmxMethod() {
			if (fmxMember instanceof Method) {
				return (Method) fmxMember;
			}
			else {
				return null;
			}
		}

		public AnnotationTypeAttribute getFmxAnnotationAttribute() {
			if (fmxMember instanceof AnnotationTypeAttribute) {
				return (AnnotationTypeAttribute) fmxMember;
			}
			else {
				return null;
			}
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
			clearFmxMember();
			this.fmxMember = fmxMethod;
		}

		public void setFmxAnnotationAttribute(AnnotationTypeAttribute fmxAtt) {
			clearFmxMember();
			this.fmxMember = fmxAtt;
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
		public void clearFmxType() {
			fmxType = null;
			clearFmxMember();
		}
		
		/**
		 * Empties the Famix Method on top of the context stack
		 */
		public void clearFmxMember() {
			fmxMember = null;
			metric_cyclo = EMPTY_CYCLO;
			metric_nos = EMPTY_NOS;
			setLastInvocation(null);
			setLastAccess(null);
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

	private ClassStack getTopType() {
		if (fmxType.isEmpty()) {
			return null;
		}
		else {
			return fmxType.peek();
		}
	}

	// WRITE ON THE STACK
	
	/**
	 * Pushes an entity on top of the "context stack"
	 * @param e -- the entity
	 */
	public void push(NamedEntity e) {
		if (e instanceof Method) {
			pushMethod((Method) e);
		}
		else if (e instanceof fr.inria.verveine.core.gen.famix.Class) {
			pushClass((fr.inria.verveine.core.gen.famix.Class) e);
		}
		else if (e instanceof AnnotationTypeAttribute) {
			pushAnnotationMember((AnnotationTypeAttribute) e);
		}
		else if (e instanceof AnnotationType) {
			pushAnnotationType((AnnotationType) e);
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
		clearTypes();
		fmxPckg = e;
	}

	/**
	 * Pushes a Famix class on top of the "context class stack"
	 * @param e -- the Famix class
	 */
	public void pushClass(fr.inria.verveine.core.gen.famix.Class e) {
		fmxType.push(new ClassStack(e));
	}

	public void pushAnnotationType(AnnotationType e) {
		fmxType.push(new ClassStack(e));
	}

	/**
	 * Pushes a Famix method on top of the "context stack" for the current Famix class
	 * @param e -- the Famix method
	 */
	public void pushMethod(Method e) {
		getTopType().setFmxMethod(e);
	}

	public void pushAnnotationMember(AnnotationTypeAttribute fmx) {
		getTopType().setFmxAnnotationAttribute(fmx);	
	}
	
	/**
	 * Empties the context stack of package and associated classes
	 */
	public void clearPckg() {
		clearTypes();
		fmxPckg = null;
	}

	/**
	 * Empties the context stack of Famix classes
	 */
	public void clearTypes() {
		fmxType = new Stack<ClassStack>();
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
		return ret;
	}

	/**
	 * Pops the top Famix class from the "context stack"
	 * Note: does not check that there is such a class, so could possibly throw an EmptyStackException
	 * @return the Famix class
	 */
	public fr.inria.verveine.core.gen.famix.Class popClass() {
		ClassStack tmp = fmxType.pop();
		return tmp.getFmxClass();
	}
	
	public AnnotationType popAnnotationType() {
		ClassStack tmp = fmxType.pop();
		return tmp.getFmxAnnotationType();
	}

	/**
	 * Pops the top Famix method of the current class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an Exception
	 * @return the Famix method
	 */
	public Method popMethod() {
		ClassStack tmp = getTopType();
		Method ret = tmp.getFmxMethod();
		tmp.clearFmxMember();
		return ret;
	}
	
	public AnnotationTypeAttribute popAnnotationMember() {
		ClassStack tmp = getTopType();
		AnnotationTypeAttribute ret = tmp.getFmxAnnotationAttribute();
		tmp.clearFmxMember();
		return ret;
	}

	/**
	 * Returns the Famix entity on top of the "context stack"
	 * Note: does not check that there is such an entity
	 * @return the Famix entity
	 */
	public ContainerEntity top() {
		ContainerEntity ret = null;
		ClassStack topc = getTopType();
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
		return ( getTopType() == null) ? null : getTopType().getFmxClass();
	}

	public AnnotationType topAnnotationType() {
		return ( getTopType() == null) ? null : getTopType().getFmxAnnotationType();
	}
	
	/**
	 * Returns the Famix method  of the Famix class on top of the "context stack"
	 * Note: does not check that there is such a class or method, so could possibly throw an EmptyStackException
	 * @return the Famix method
	 */
	public Method topMethod() {
		return ( getTopType() == null) ? null : getTopType().getFmxMethod();
	}

	public AnnotationTypeAttribute topAnnotationMember() {
		return ( getTopType() == null) ? null : getTopType().getFmxAnnotationAttribute();
	}

	// PROPERTIES OF THE TOP METHOD

	/**
	 * Returns the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public int getTopMethodCyclo() {
		if (getTopType() != null) {
			return getTopType().getFmxMethodCyclo();
		}
		else {
			return EMPTY_CYCLO;
		}
	}

	/**
	 * Returns the Number of Statements of the Famix Method on top of the context stack
	 */
	public int getTopMethodNOS() {
		if (getTopType() != null) {
			return getTopType().getFmxMethodNOS();
		}
		else {
			return EMPTY_NOS;
		}
	}

	/**
	 * Sets the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void setTopMethodCyclo(int c) {
		if (getTopType() != null) {
			getTopType().setFmxMethodCyclo(c);
		}
	}

	/**
	 * Sets to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void setTopMethodNOS(int n) {
		if (getTopType() != null) {
			getTopType().setFmxMethodNOS(n);
		}
	}
	
	/**
	 * Adds to the Cyclomatic complexity of the Famix Method on top of the context stack
	 */
	public void addTopMethodCyclo(int c) {
		if (getTopType() != null) {
			getTopType().addFmxMethodCyclo(c);
		}
	}

	/**
	 * Adds to the Number of Statements of the Famix Method on top of the context stack
	 */
	public void addTopMethodNOS(int n) {
		if (getTopType() != null) {
			getTopType().addFmxMethodNOS(n);
		}
	}

}

