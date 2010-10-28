package fr.inria.verveine.core;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import ch.akuhn.fame.Repository;

import fr.inria.verveine.core.gen.famix.Access;
import fr.inria.verveine.core.gen.famix.Attribute;
import fr.inria.verveine.core.gen.famix.BehaviouralEntity;
import fr.inria.verveine.core.gen.famix.ContainerEntity;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.ImplicitVariable;
import fr.inria.verveine.core.gen.famix.Inheritance;
import fr.inria.verveine.core.gen.famix.Invocation;
import fr.inria.verveine.core.gen.famix.LocalVariable;
import fr.inria.verveine.core.gen.famix.Method;
import fr.inria.verveine.core.gen.famix.NamedEntity;
import fr.inria.verveine.core.gen.famix.Namespace;
import fr.inria.verveine.core.gen.famix.Reference;
import fr.inria.verveine.core.gen.famix.StructuralEntity;

/**
 * A dictionnary of Famix entities to help create them and find them back
 * @author anquetil
 *
 * @param <B> The super class of all bindings. Different for JDT, PDT, ... bindings
 */
public class Dictionary<B> {

	public static final String DEFAULT_PCKG_NAME = "<Default Package>";
	public static final String STUB_METHOD_CONTAINER_NAME = "<StubMethodContainer>";
	public static final String SELF_NAME = "self";
	public static final String SUPER_NAME = "super";

	/**
	 * The FAMIX repository where all FAMIX entities are created and stored
	 */
	protected Repository famixRepo;

	/**
	 * A dictionary to map an IBinding to FAMIX Entity
	 */
	protected Map<B,NamedEntity> mapBind;

	/**
	 * Another dictionary to map a name to FAMIX Entities with this name
	 */
	protected Map<String,Collection<NamedEntity>> mapName;

	/**
	 * Yet another dictionary for implicit variables
	 * 'self' and 'super' have the same binding than their associated class so they can't be kept easily in bindFmxDico
	 */
	protected Map<fr.inria.verveine.core.gen.famix.Class,ImplicitVars> mapImpVar;

	/**
	 * Used to keep the two possible ImplicitVariable for a given Class binding
	 * @author anquetil
	 */
	protected class ImplicitVars {
		public ImplicitVariable self_iv;
		public ImplicitVariable super_iv;
	}
	
	/** Constructor taking a FAMIX repository
	 * @param famixRepo
	 */
	public Dictionary(Repository famixRepo) {
		this.famixRepo = famixRepo;
		
		this.mapBind = new Hashtable<B,NamedEntity>();
		this.mapName = new Hashtable<String,Collection<NamedEntity>>();
		this.mapImpVar = new Hashtable<fr.inria.verveine.core.gen.famix.Class,ImplicitVars>();
	}

	/**
	 * Returns all the Famix Entity with the given name and class 
	 * @param fmxClass -- the subtype of Famix Entity we are looking for
	 * @param name -- the name of the entity
	 * @return the Collection of Famix Entities with the given name and class (possibly empty)
	 */
	@SuppressWarnings("unchecked")
	public <T extends NamedEntity> Collection<T> getEntityByName(Class<T> fmxClass, String name) {
		Collection<T> ret = new LinkedList<T>();
		Collection<NamedEntity> l_name = mapName.get(name);
		
		if (l_name != null ) {
			for (NamedEntity obj : l_name) {
				if (fmxClass.isInstance(obj)) {
					ret.add((T) obj);
				}
			}
		}

		return ret;
	}

	/**
	 * Returns the Famix Entity associated to the given binding.
	 * <b>Note</b>: Be careful than ImplicitVariables share the same binding than their associated Class and cannot be retrieved with this method.
	 * In such a case, this method will always retrieve the Class associated to the binding.
	 * To get an ImplicitVariable from the binding, use {@link Dictionary#getImplicitVariableByBinding(Object, String)}
	 * @param bnd -- the binding
	 * @return the Famix Entity associated to the binding or null if not found
	 */
	public NamedEntity getEntityByBinding(B bnd) {
		if (bnd == null) {
			return null;
		}
		else {
			return mapBind.get(bnd);
		}
	}

	/**
	 * Creates and returns a FAMIX Entity of the type <b>fmxClass</b>.
	 * The Entity is always created (see {@link Dictionary#ensureFamixStub(Class, Object, String)}).
	 * @param fmxClass -- the FAMIX class of the instance to create
	 * @param name -- the name of the new instance
	 * @return the FAMIX Entity or null in case of a FAMIX error
	 */
	protected <T extends NamedEntity> T createFamixStub(Class<T> fmxClass, String name) {
		T fmx = null;

		try {
			fmx = fmxClass.newInstance();
		} catch (Exception e) {
			System.err.println("Unexpected error, could not create a FAMIX entity: "+e.getMessage());
			e.printStackTrace();
		}
		
		if (fmx != null) {
			fmx.setName(name);
			fmx.setIsStub(Boolean.TRUE);

			// put new entity in mappers
			Collection<NamedEntity> l_ent = mapName.get(name);
			if (l_ent == null) {
				l_ent = new LinkedList<NamedEntity>();
			}
			l_ent.add(fmx);
			mapName.put(name, l_ent);

			// put new entity in Famix repository
			this.famixRepo.add(fmx);
		}

		return fmx;
	}
	
	/**
	 * Returns a FAMIX Entity of the type <b>fmxClass</b> and maps it to its binding <b>bnd</b> (if not null).
	 * The Entity is created if it did not exist.
	 * <b>Note</b>: Should not be used to create ImplicitVariables and will silently fail if one tries. Use ensureFamixImplicitVariable instead.
	 * @param fmxClass -- the FAMIX class of the instance to create
	 * @param bnd -- the binding to map to the new instance
	 * @param name -- the name of the new instance (used if <tt>bnd == null</tt>)
	 * @return the FAMIX Entity or null if <b>bnd</b> was null or in case of a FAMIX error
	 * 
	 * TODO Make public and remove ensureFamixClass(name), ensureFamixAttribute(name), ... ????
	 */
	@SuppressWarnings("unchecked")
	protected <T extends NamedEntity> T ensureFamixStub(Class<T> fmxClass, B bnd, String name) {
		T fmx = null;
		
		if (ImplicitVariable.class.isAssignableFrom(fmxClass)) {
			return null;
		}
		
		if (bnd != null) {
			fmx = (T) getEntityByBinding(bnd);
		}
		else {
			// Unfortunately different entities with the same name and same type may exist
			// e.g. 2 parameters of 2 different methods but having the same name
			// so we must recreate a new entity each time

			//fmxEnt = getEntityByName(fmxClass, name);
		}

		if (fmx != null) {
			return fmx;
		}

		fmx = createFamixStub(fmxClass, name);
		// put new entity in mappers
		if (bnd != null) {
			mapBind.put(bnd, fmx);
		}
		
		return fmx;
	}

	/**
	 * Adds an already created Entity to the FAMIX repository
	 * Used mainly for non-NamedEntity, for example relationships
	 * @param e -- the FAMIX entity to add to the repository
	 */
	public void famixRepoAdd(Entity e) {
		this.famixRepo.add(e);
	}

	///// ensure Famix Entities /////

	/**
	 * Returns a FAMIX Class with the given <b>name</b>, creating it if it does not exist yet
	 * @param name -- the name of the FAMIX Class
	 * @return the FAMIX Class or null in case of a FAMIX error
	 */
	public fr.inria.verveine.core.gen.famix.Class ensureFamixClass(String name) {
		return (fr.inria.verveine.core.gen.famix.Class) ensureFamixStub(fr.inria.verveine.core.gen.famix.Class.class, null, name);
	}

	/**
	 * Returns a FAMIX Method with the given <b>name</b>, creating it if it does not exist yet
	 * @param name -- the name of the FAMIX Method
	 * @return the FAMIX Method or null in case of a FAMIX error
	 */
	public Method ensureFamixMethod(String name) {
		return (Method) ensureFamixStub(Method.class, null, name);
	}

	/**
	 * Returns a FAMIX Attribute with the given <b>name</b>, creating it if it does not exist yet
	 * @param name -- the name of the FAMIX Attribute
	 * @return the FAMIX Attribute or null in case of a FAMIX error
	 */
	public Attribute ensureFamixAttribute(String name) {
		return (Attribute) ensureFamixStub(Attribute.class, null, name);
	}

	/**
	 * Returns a FAMIX LocalVariable with the given <b>name</b>, creating it if it does not exist yet
	 * @param name -- the name of the FAMIX LocalVariable
	 * @return the FAMIX LocalVariable or null in case of a FAMIX error
	 */
	public LocalVariable ensureFamixLocalVariable(String name) {
		return (LocalVariable) ensureFamixStub(LocalVariable.class, null, name);
	}

	///// ensure Famix Relationships /////

	/**
	 * Returns a Famix Inheritance relationship between two Famix Classes creating it if needed
	 * @param sup -- the super class
	 * @param sub -- the sub class
	 * @return the Inheritance relationship
	 */
	public Inheritance ensureFamixInheritance(fr.inria.verveine.core.gen.famix.Class sup, fr.inria.verveine.core.gen.famix.Class sub) {
		for (Inheritance i : sup.getSubInheritances()) {
			if (i.getSubclass() == sub) {
				return i;
			}
		}
		Inheritance inh = new Inheritance();
		inh.setSuperclass(sup);
		inh.setSubclass(sub);
		famixRepoAdd(inh);
		return inh;
	}

	/**
	 * Returns a Famix Reference between two Famix Entities creating it if needed
	 * @param src -- source of the reference
	 * @param tgt -- target of the reference
	 * @return the Reference
	 */
	public Reference ensureFamixReference(ContainerEntity src, ContainerEntity tgt) {
		/* We want to keep multiple references between the same entities...
		   for (Reference r : src.getOutgoingReferences()) {
			if (r.getTarget() == tgt) {
				return r;
			}
		}
		*/

		Reference ref = new Reference();
		ref.setTarget(tgt);
		ref.setSource(src);
		famixRepoAdd(ref);
		
		return ref;
	}

	/**
	 * Returns a Famix Invocation between two Famix Entities creating it if needed
	 * @param sender of the invocation
	 * @param invoked -- method invoked
	 * @param receiver of the invocation
	 * @return the Invocation
	 */
	public Invocation ensureFamixInvocation(BehaviouralEntity sender, BehaviouralEntity invoked, NamedEntity receiver) {
		/* We keep multiple invocations from one method to another
		   for (Invocation i : sender.getOutgoingInvocations()) {
			if  (i.getReceiver() == receiver) {
				if (i.getCandidates().contains(invoked)) {
					return i;
				}				
			}
		}
		*/
		
		Invocation invok = new Invocation();
		invok.setReceiver(receiver);
		invok.setSender(sender);
		invok.setSignature(invoked.getSignature());
		invok.addCandidates(invoked);
		famixRepoAdd(invok);
		
		return invok;
	}
	
	public Access ensureFamixAccess(BehaviouralEntity accessor, StructuralEntity var) {
		/* We keep multiple accesses from one method to a field */
		Access acc = new Access();
		acc.setAccessor(accessor);
		acc.setVariable(var);
		acc.setIsWrite(false);  // must be some default and this one seems safer than the opposite
		famixRepoAdd(acc);
		
		return acc;
	}

	///// Special Case: ImplicitVariables /////

	/**
	 * Returns the Famix ImplicitVariable associated to the given binding and name (self or super).
	 * See also {@link Dictionary#getEntityByBinding(Object)}
	 * @param bnd -- the binding
	 * @return the Famix Entity associated to the binding or null if not found
	 */
	public ImplicitVariable getImplicitVariableByBinding(B bnd, String iv_name) {
		return getImplicitVariableByClass((fr.inria.verveine.core.gen.famix.Class)getEntityByBinding(bnd), iv_name);
	}
	
	/**
	 * Returns the Famix ImplicitVariable associated to the given Famix Class.
	 * @param clazz -- the FamixClass
	 * @param name -- name of the ImplicitVariable (should be Dictionary.SELF_NAME or Dictionary.SUPER_NAME)
	 * @return the Famix ImplicitVariable associated to the Class or null if not found
	 */
	public ImplicitVariable getImplicitVariableByClass(fr.inria.verveine.core.gen.famix.Class clazz, String name) {
		ImplicitVars iv = mapImpVar.get(clazz);
		ImplicitVariable ret = null;
		
		if (iv == null) {
			iv = new ImplicitVars();
		}
		
		if (name.equals(SELF_NAME)) {
			ret = iv.self_iv;
		}
		else if (name.equals(SUPER_NAME)) {
			ret = iv.super_iv;
		}

		return ret;
	}

	/**
	 * Returns a FAMIX ImplicitVariable with the given <b>name</b> (self or super) and corresponding to the <b>clazz</b>.
	 * If this ImplicitVariable does not exist yet, it is created
	 * @param clazz -- the Famix Class for this ImplicitVariable (should not be null)
	 * @param name -- the name of the FAMIX ImplicitVariable (should be Dictionary.SELF_NAME or Dictionary.SUPER_NAME)
	 * @return the FAMIX ImplicitVariable or null in case of a FAMIX error
	 */
	public ImplicitVariable ensureFamixImplicitVariable(fr.inria.verveine.core.gen.famix.Class clazz, String name) {
		ImplicitVariable fmx = getImplicitVariableByClass(clazz, name);
		
		if (fmx == null) {
			fmx = (ImplicitVariable) createFamixStub(ImplicitVariable.class, name);
			if (fmx!=null) {
				fmx.setContainer(clazz);
				fmx.setIsStub(Boolean.FALSE);

				ImplicitVars iv = mapImpVar.get(clazz);				
				if (iv == null) {
					iv = new ImplicitVars();
				}

				if (name.equals(SELF_NAME)) {
					iv.self_iv = fmx;
				}
				else if (name.equals(SUPER_NAME)) {
					iv.super_iv = fmx;
				}
				
				mapImpVar.put(clazz, iv);
			}
		}

		return fmx;
	}

	///// Special Case: "Uniq" Entities /////

	/**
	 * Creates or recovers a Famix Named Entity uniq for the given name.
	 * For some specific entities we don't allow two of them with the same name.
	 * This is the case e.g. for the default package, or the Java class "Object" and its package "java.lang".
	 * @param fmxClass -- the FAMIX class of the instance to create
	 * @param bnd -- a potential binding for the entity
	 * @param name -- the name of the new instance (used if <tt>bnd == null</tt>)
	 * @return the uniq Famix Entity for this binding and/or name
	 */
	@SuppressWarnings("unchecked")
	public <T extends NamedEntity> T ensureFamixUniqEntity(Class<T> fmxClass, B bnd, String name) {
		T fmx = null;
		if (bnd != null) {
			fmx = (T) getEntityByBinding(bnd);
		}
		
		if (fmx == null) {
			Collection<T> l = getEntityByName( fmxClass, name);
			if (l.size() > 0) {
				fmx = l.iterator().next();
			}
			else {
				fmx = createFamixStub(fmxClass, name);
			}
			
			if (bnd != null) {
				// may happen for example if the entity was first created without binding
				// and we find a binding for it later
				mapBind.put(bnd, fmx);
			}
		}

		return fmx;
	}

	/**
	 * Returns a FAMIX Namespace with the given <b>name</b>, creating it if it does not exist yet
	 * We assume that Namespaces must be uniq for a given name
	 * @param name -- the name of the FAMIX Namespace
	 * @return the FAMIX Namespace or null in case of a FAMIX error
	 */
	public Namespace ensureFamixNamespace(String name) {
		return (Namespace) ensureFamixUniqEntity(Namespace.class, null, name);
	}

	/**
	 * Creates or recovers a default Famix Namespace.
	 * Because this package does not really exist, it has no binding.
	 * @return a Famix Namespace
	 */
	public Namespace ensureFamixNamespaceDefault() {
		Namespace fmx =  ensureFamixUniqEntity(Namespace.class, null, DEFAULT_PCKG_NAME);

		return fmx;
	}

	/**
	 * Creates or recovers a Famix Class to contain the methods stubs (for which we ignore the real owner).
	 * Because this package does not really exist, it has no binding.
	 * @return a Famix class
	 */
	public fr.inria.verveine.core.gen.famix.Class ensureFamixClassStubOwner() {
		fr.inria.verveine.core.gen.famix.Class fmx =  ensureFamixUniqEntity(fr.inria.verveine.core.gen.famix.Class.class, null, STUB_METHOD_CONTAINER_NAME);
		fmx.setContainer( ensureFamixNamespaceDefault());

		return fmx;
	}
	
}
