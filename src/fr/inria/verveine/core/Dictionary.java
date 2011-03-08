package fr.inria.verveine.core;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jdt.core.dom.ITypeBinding;

import ch.akuhn.fame.Repository;

import fr.inria.verveine.core.gen.famix.Access;
import fr.inria.verveine.core.gen.famix.Association;
import fr.inria.verveine.core.gen.famix.Attribute;
import fr.inria.verveine.core.gen.famix.BehaviouralEntity;
import fr.inria.verveine.core.gen.famix.CaughtException;
import fr.inria.verveine.core.gen.famix.Comment;
import fr.inria.verveine.core.gen.famix.ContainerEntity;
import fr.inria.verveine.core.gen.famix.DeclaredException;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.ImplicitVariable;
import fr.inria.verveine.core.gen.famix.Inheritance;
import fr.inria.verveine.core.gen.famix.Invocation;
import fr.inria.verveine.core.gen.famix.LocalVariable;
import fr.inria.verveine.core.gen.famix.Method;
import fr.inria.verveine.core.gen.famix.NamedEntity;
import fr.inria.verveine.core.gen.famix.Namespace;
import fr.inria.verveine.core.gen.famix.Parameter;
import fr.inria.verveine.core.gen.famix.ParameterType;
import fr.inria.verveine.core.gen.famix.ParameterizableClass;
import fr.inria.verveine.core.gen.famix.PrimitiveType;
import fr.inria.verveine.core.gen.famix.Reference;
import fr.inria.verveine.core.gen.famix.SourcedEntity;
import fr.inria.verveine.core.gen.famix.StructuralEntity;
import fr.inria.verveine.core.gen.famix.ThrownException;
import fr.inria.verveine.core.gen.famix.Type;

enum Colors { Black,	Blue, Red };

/**
 * A dictionnary of Famix entities to help create them and find them back
 * @author anquetil
 *
 *Entities are mapped to keys. Typically the key will be a binding provided by the parser used
 * @param <B> The class of the keys, typically a JDT binding or a CDT binding, ...
 */
public class Dictionary<B> {

	Colors toto;
	
	public static final String DEFAULT_PCKG_NAME = "<Default Package>";
	public static final String STUB_METHOD_CONTAINER_NAME = "<StubMethodContainer>";
	public static final String SELF_NAME = "self";
	public static final String SUPER_NAME = "super";

	/**
	 * The FAMIX repository where all FAMIX entities are created and stored
	 */
	protected Repository famixRepo;

	/**
	 * A dictionary to map a key (provided by the user) to FAMIX Entity
	 */
	protected Map<B,NamedEntity> mapToKey;

	/**
	 * Another dictionary to map a name to FAMIX Entities with this name
	 */
	protected Map<String,Collection<NamedEntity>> mapName;

	/**
	 * Yet another dictionary for implicit variables ('self' and 'super')
	 * Because they are implicit, they may not have a binding provided by the parser,
	 * or may have the same binding than their associated class so they can't be kept easily in {@link Dictionary#mapToKey}
	 */
	protected Map<fr.inria.verveine.core.gen.famix.Class,ImplicitVars> mapImpVar;

	/**
	 * Used to keep the two possible ImplicitVariable for a given Class binding
	 * @author anquetil
	 */
	private class ImplicitVars {
		public ImplicitVariable self_iv;
		public ImplicitVariable super_iv;
	}
	
	/** Constructor taking a FAMIX repository
	 * @param famixRepo
	 */
	public Dictionary(Repository famixRepo) {
		this.famixRepo = famixRepo;
		
		this.mapToKey = new Hashtable<B,NamedEntity>();
		this.mapName = new Hashtable<String,Collection<NamedEntity>>();
		this.mapImpVar = new Hashtable<fr.inria.verveine.core.gen.famix.Class,ImplicitVars>();
		
		if (! this.famixRepo.isEmpty()) {
			recoverExistingRepository();
		}
	}

	protected void recoverExistingRepository() {
		for (Object obj : famixRepo.getElements()) {
			if (obj instanceof NamedEntity) {
				mapEntityToName( ((NamedEntity)obj).getName(), (NamedEntity) obj);
			}
		}
		
		for (Access acc : famixRepo.all(Access.class)) {
			try {
				if (acc.getIsWrite()) { }
			}
			catch (NullPointerException e) {
				acc.setIsWrite(Boolean.FALSE);
			}
		}

		for (Method meth : famixRepo.all(Method.class)) {
			try { if (meth.getIsStub()) { } }
			catch (NullPointerException e) { meth.setIsStub(Boolean.FALSE); }
		}

		for (Attribute att : famixRepo.all(Attribute.class)) {
			try { if (att.getIsStub()) { } }
			catch (NullPointerException e) { att.setIsStub(Boolean.FALSE); }
		}

	}
	
	protected void mapEntityToName(String name, NamedEntity ent) {
		Collection<NamedEntity> l_ent = mapName.get(name);
		if (l_ent == null) {
			l_ent = new LinkedList<NamedEntity>();
		}
		l_ent.add(ent);
		mapName.put(name, l_ent);
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
	 * To get an ImplicitVariable from the binding, uses {@link Dictionary#getImplicitVariableByBinding(Object, String)}
	 * @param bnd -- the binding
	 * @return the Famix Entity associated to the binding or null if not found
	 */
	public NamedEntity getEntityByKey(B bnd) {
		if (bnd == null) {
			return null;
		}
		else {
			return mapToKey.get(bnd);
		}
	}

	/**
	 * Creates and returns a FAMIX Entity of the type <b>fmxClass</b>.
	 * The Entity is always created (see {@link Dictionary#ensureFamixEntity(Class, Object, String)}).
	 * @param fmxClass -- the FAMIX class of the instance to create
	 * @param name -- the name of the new instance must not be null (and this is not tested)
	 * @return the FAMIX Entity or null in case of a FAMIX error
	 */
	protected <T extends NamedEntity> T createFamixEntity(Class<T> fmxClass, String name) {
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

			mapEntityToName(name, fmx);
			
			// put new entity in Famix repository
			this.famixRepo.add(fmx);
		}

		return fmx;
	}
	
	/**
	 * Returns a FAMIX Entity of the type <b>fmxClass</b> and maps it to its binding <b>bnd</b> (if not null).
	 * The Entity is created if it did not exist.
	 * <b>Note</b>: Should not be used to create ImplicitVariables and will silently fail if one tries. Use {@link Dictionary#ensureFamixImplicitVariable} instead.
	 * @param fmxClass -- the FAMIX class of the instance to create
	 * @param bnd -- the binding to map to the new instance
	 * @param name -- the name of the new instance (used if <tt>bnd == null</tt>)
	 * @return the FAMIX Entity or null if <b>bnd</b> was null or in case of a FAMIX error
	 */
	@SuppressWarnings("unchecked")
	protected <T extends NamedEntity> T ensureFamixEntity(Class<T> fmxClass, B bnd, String name) {
		T fmx = null;

		if (ImplicitVariable.class.isAssignableFrom(fmxClass)) {
			return null;
		}
		
		if (bnd != null) {
			fmx = (T) getEntityByKey(bnd);
			if (fmx != null) {
				return fmx;
			}
		}
		// else
		// Unfortunately different entities with the same name and same type may exist
		// e.g. 2 parameters of 2 different methods but having the same name
		// so we cannot recover just from the name

		fmx = createFamixEntity(fmxClass, name);
		if (bnd != null) {
			mapToKey.put(bnd, fmx);
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
	 * Returns a FAMIX Type with the given <b>name</b>, creating it if it does not exist yet.
	 * In the second case, sets some default properties: not Abstract, not Final, not Private, not Protected, not Public, not Interface
	 * @param key to which the entity will be mapped (may be null, but then it will be difficult to recover the entity)
	 * @param name -- the name of the Famix Type (MUST NOT be null, but this is not checked)
	 * @param owner -- entity defining the Famix Type (should not be null, but it will work if it is) 
	 * @return the FAMIX Class or null in case of a FAMIX error
	 */
	public Type ensureFamixType(B key, String name, ContainerEntity owner) {
		Type fmx = ensureFamixEntity(Type.class, key, name);
		fmx.setContainer(owner);
		return fmx;
	}

	/**
	 * Returns a FAMIX Class with the given <b>name</b>, creating it if it does not exist yet.
	 * @param key to which the entity Famix be mapped (may be null, but then it will be difficult to recover the entity)
	 * @param name -- the name of the FAMIX Class (MUST NOT be null, but this is not checked)
	 * @param owner -- entity defining the Famix class (should not be null, but it will work if it is) 
	 * @return the FAMIX Class or null in case of a FAMIX error
	 */
	public fr.inria.verveine.core.gen.famix.Class ensureFamixClass(B key, String name, ContainerEntity owner) {
		fr.inria.verveine.core.gen.famix.Class fmx = ensureFamixEntity(fr.inria.verveine.core.gen.famix.Class.class, key, name);
		fmx.setContainer(owner);
		return fmx;
	}

	/**
	 * Returns a FAMIX Class with the given <b>name</b>, creating it if it does not exist yet
	 * In the second case, sets some default properties: not Abstract, not Final, not Private, not Protected, not Public, not Interface
	 * @param name -- the name of the FAMIX Class
	 * @return the FAMIX Class or null in case of a FAMIX error
	 */
	public ParameterizableClass ensureFamixParameterizableClass(String name) {
		ParameterizableClass fmx = ensureFamixEntity(ParameterizableClass.class, null, name);
		fmx.setIsInterface(Boolean.FALSE);
		return fmx;
	}

	/**
	 * Returns a FAMIX ParameterType (created by a FAMIX ParameterizableClass) with the given <b>name</b>, creating it if it does not exist yet
	 * In the second case, sets some default properties: not Abstract, not Final, not Private, not Protected, not Public
	 * @param name -- the name of the FAMIX ParameterType
	 * @return the FAMIX ParameterType or null in case of a FAMIX error
	 */
	public ParameterType ensureFamixParameterType(String name) {
		ParameterType fmx = ensureFamixEntity(ParameterType.class, null, name);
		return fmx;
	}

	/**
	 * Returns a FAMIX Method with the given <b>name</b>, creating it if it does not exist yet
	 * @param key to which the entity will be mapped (may be null, but then it will be difficult to recover the entity)
	 * @param name -- the name of the FAMIX Method (MUST NOT be null, but this is not checked)
	 * @param sig -- method's signature, including type of parameters and return type (should not be null, but it will work if it is)
	 * @param ret -- Famix Type returned by the method (ideally should only be null in case of a constructor, but will accept it in any case)
	 * @param owner -- type defining the method (should not be null, but it will work if it is)
	 * @return the FAMIX Method or null in case of a FAMIX error
	 */
	public Method ensureFamixMethod(B key, String name, String sig, Type ret, Type owner) {
		Method fmx = (Method) ensureFamixEntity(Method.class, key, name);
		fmx.setSignature(sig);
		fmx.setDeclaredType(ret);
		fmx.setParentType(owner);
		return fmx;
	}

	/**
	 * Returns a FAMIX Attribute with the given <b>name</b>, creating it if it does not exist yet
	 * @param key to which the entity will be mapped (may be null, but then it will be difficult to recover the entity)
	 * @param name -- the name of the Famix Attribute (MUST NOT be null, but this is not checked)
	 * @param type -- Famix Type of the Famix Attribute (should not be null, but it will work if it is)
	 * @param owner -- Class defining the Famix Attribute (should not be null, but it will work if it is)
	 * @return the FAMIX Attribute or null in case of a FAMIX error
	 */
	public Attribute ensureFamixAttribute(B key, String name, Type type, Type owner) {
		Attribute fmx = ensureFamixEntity(Attribute.class, key, name);
		fmx.setParentType(owner);
		fmx.setDeclaredType(type);
		return fmx;
	}

	/**
	 * Returns a FAMIX LocalVariable with the given <b>name</b>, creating it if it does not exist yet
	 * @param key to which the entity will be mapped (may be null, but then it will be difficult to recover the entity)
	 * @param name -- the name of the Famix Variable (MUST NOT be null, but this is not checked)
	 * @param type -- Famix Type of the Famix Variable (should not be null, but it will work if it is)
	 * @param owner -- Entity defining the Famix Variable (should not be null, but it will work if it is)
	 * @return the FAMIX LocalVariable or null in case of a FAMIX error
	 */
	public LocalVariable ensureFamixLocalVariable(B key, String name, Type type, BehaviouralEntity owner) {
		LocalVariable fmx = ensureFamixEntity(LocalVariable.class, key, name);
		fmx.setParentBehaviouralEntity(owner);
		fmx.setDeclaredType(type);
		return fmx;
	}

	/**
	 * Creates and returns a FAMIX Comment
	 * @param cmt -- the content (String) of the comment 
	 * @return the FAMIX Comment
	 */
	public Comment createFamixComment(String cmt) {
		Comment fmx = new Comment();
		fmx.setContent(cmt);
		this.famixRepo.add(fmx);
		
		return fmx;
	}

	/**
	 * Creates and returns a FAMIX Comment and associates it with an Entity (ex: for Javadocs)
	 * @param cmt -- the content (String) of the comment 
	 * @param owner -- the entity concerned by this comment
	 * @return the FAMIX Comment
	 */
	public Comment createFamixComment(String cmt, SourcedEntity owner) {
		Comment fmx = new Comment();
		fmx.setContent(cmt);
		fmx.setContainer(owner);
		this.famixRepo.add(fmx);
		
		return fmx;
	}
	
	/**
	 * Creates and returns a FAMIX Parameter and associates it with a BehaviouralEntity
	 * @param identifier -- the name of the parameter
	 * @param owner -- the entity concerned by this parameter
	 * @param type -- the type of the parameter
	 * @return the FAMIX parameter
	 */
	public Parameter createFamixParameter(String identifier, BehaviouralEntity owner, Type type) {
		Parameter fmx = new Parameter();
		fmx.setName(identifier);
		fmx.setParentBehaviouralEntity(owner);
		fmx.setDeclaredType(type);
		this.famixRepo.add(fmx);
		
		return fmx;
	}
	
	///// ensure Famix Relationships /////

	/**
	 * Returns a Famix Inheritance relationship between two Famix Classes creating it if needed
	 * @param sup -- the super class
	 * @param sub -- the sub class
	 * @return the Inheritance relationship
	 */
	public Inheritance ensureFamixInheritance(Type sup, Type sub) {
		return ensureFamixInheritance(sup, sub, null);
	}
	
	public Inheritance ensureFamixInheritance(Type sup, Type sub, Association prev) {
		for (Inheritance i : sup.getSubInheritances()) {
			if (i.getSubclass() == sub) {
				return i;
			}
		}
		Inheritance inh = new Inheritance();
		inh.setSuperclass(sup);
		inh.setSubclass(sub);
		chainPrevNext(prev,inh);
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
		return ensureFamixReference(src, tgt, null);
	}
	
	public Reference ensureFamixReference(ContainerEntity src, ContainerEntity tgt, Association prev) {
		Reference ref = new Reference();
		ref.setTarget(tgt);
		ref.setSource(src);
		chainPrevNext(prev,ref);
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
		return ensureFamixInvocation(sender, invoked, receiver, null);
	}

	public Invocation ensureFamixInvocation(BehaviouralEntity sender, BehaviouralEntity invoked, NamedEntity receiver, Association prev) {
		Invocation invok = new Invocation();
		invok.setReceiver(receiver);
		invok.setSender(sender);
		invok.setSignature(invoked.getSignature());
		invok.addCandidates(invoked);
		chainPrevNext(prev,invok);
		famixRepoAdd(invok);
		
		return invok;
	}

	public Access ensureFamixAccess(BehaviouralEntity accessor, StructuralEntity var, boolean isWrite, Association prev) {
		/* We keep multiple accesses from one method to a field */
		Access acc = new Access();
		acc.setAccessor(accessor);
		acc.setVariable(var);
		acc.setIsWrite(new Boolean(isWrite));
		chainPrevNext(prev, acc);
		famixRepoAdd(acc);
		
		return acc;
	}

	public Access ensureFamixAccess(BehaviouralEntity accessor, StructuralEntity var, boolean isWrite) {
		return ensureFamixAccess(accessor, var, isWrite, null);
	}
	
	public Access ensureFamixAccess(BehaviouralEntity accessor, StructuralEntity var) {
		return ensureFamixAccess(accessor, var, false, null);  // must set some default for isWrite and this one seems safer than the opposite
	}

	private void chainPrevNext(Association prev, Association next) {
		if (prev != null) {
			next.setPrevious(prev);  // not yet implemented in importer
		}
	}
	
	/**
	 * Returns a Famix DeclaredException between a method and an Exception that it declares to throw
	 * @param meth -- the method throwing the exception
	 * @param excep -- the exception declared to be thrown
	 * @return the DeclaredException
	 */
	public DeclaredException ensureFamixDeclaredException(Method meth, fr.inria.verveine.core.gen.famix.Class excep) {
		DeclaredException decl = new DeclaredException();
		decl.setExceptionClass(excep);
		decl.setDefiningMethod(meth);
		famixRepoAdd(decl);
		return decl;
	}

	/**
	 * Returns a Famix CaughtException between a method and an Exception that is caught
	 * @param meth -- the method catching the exception
	 * @param excep -- the exception caught
	 * @return the CaughtException
	 */
	public CaughtException ensureFamixCaughtException(Method meth, fr.inria.verveine.core.gen.famix.Class excep) {
		CaughtException decl = new CaughtException();
		decl.setExceptionClass(excep);
		decl.setDefiningMethod(meth);
		famixRepoAdd(decl);
		return decl;
	}

	/**
	 * Returns a Famix ThrownException between a method and an Exception that it (actually) throws.
	 * Note: DeclaredException indicates that the method declares it can throw the exception,
	 * here we state that the exception is actually thrown
	 * @param meth -- the method throwing the exception
	 * @param excep -- the exception thrown
	 * @return the ThrownException
	 */
	public ThrownException ensureFamixThrownException(Method meth, fr.inria.verveine.core.gen.famix.Class excep) {
		ThrownException decl = new ThrownException();
		decl.setExceptionClass(excep);
		decl.setDefiningMethod(meth);
		famixRepoAdd(decl);
		return decl;
	}

	///// Special Case: ImplicitVariables /////

	/**
	 * Returns the Famix ImplicitVariable associated to the given binding and name (self or super).
	 * See also {@link Dictionary#getEntityByKey(Object)}
	 * @param bnd -- the binding
	 * @return the Famix Entity associated to the binding or null if not found
	 */
	public ImplicitVariable getImplicitVariableByBinding(B bnd, String iv_name) {
		return getImplicitVariableByClass((fr.inria.verveine.core.gen.famix.Class)getEntityByKey(bnd), iv_name);
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
	 * @param clazz -- the Famix Class for this ImplicitVariable (must not be null)
	 * @param name -- the name of the FAMIX ImplicitVariable (should be Dictionary.SELF_NAME or Dictionary.SUPER_NAME)
	 * @return the FAMIX ImplicitVariable or null in case of a FAMIX error
	 */
	public ImplicitVariable ensureFamixImplicitVariable(fr.inria.verveine.core.gen.famix.Class clazz, String name) {
		ImplicitVariable fmx = getImplicitVariableByClass(clazz, name);
		
		if (fmx == null) {
			fmx = (ImplicitVariable) createFamixEntity(ImplicitVariable.class, name);
			if (fmx!=null) {
				fmx.setContainer(clazz);

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
	 * @param key -- a potential binding for the entity
	 * @param name -- the name of the new instance (used if <tt>bnd == null</tt>)
	 * @return the uniq Famix Entity for this binding and/or name
	 */
	@SuppressWarnings("unchecked")
	public <T extends NamedEntity> T ensureFamixUniqEntity(Class<T> fmxClass, B key, String name) {
		T fmx = null;
		if (key != null) {
			fmx = (T) getEntityByKey(key);
		}
		
		if (fmx == null) {
			Collection<T> l = getEntityByName( fmxClass, name);
			if (l.size() > 0) {
				fmx = l.iterator().next();
			}
			else {
				fmx = createFamixEntity(fmxClass, name);
			}
			
			if (key != null) {
				// may happen for example if the entity was first created without binding
				// and we find a binding for it later
				mapToKey.put(key, fmx);
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
	public Namespace ensureFamixNamespace(B key, String name) {
		return  ensureFamixUniqEntity(Namespace.class, key, name);
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
	 * Returns a FAMIX PrimitiveType with the given <b>name</b>, creating it if it does not exist yet
	 * We assume that PrimitiveType must be uniq for a given name
	 * @param name -- the name of the FAMIX PrimitiveType
	 * @return the FAMIX PrimitiveType or null in case of a FAMIX error
	 */
	public PrimitiveType ensureFamixPrimitiveType(B key, String name) {
		return ensureFamixEntity(PrimitiveType.class, key, name);
	}
	
	/**
	 * Creates or recovers a Famix Class to contain the methods stubs (for which we ignore the real owner).
	 * @return a Famix class
	 */
	public fr.inria.verveine.core.gen.famix.Class ensureFamixClassStubOwner() {
		fr.inria.verveine.core.gen.famix.Class fmx =  ensureFamixUniqEntity(fr.inria.verveine.core.gen.famix.Class.class, null, STUB_METHOD_CONTAINER_NAME);
		if (fmx != null) {
			fmx.setContainer( ensureFamixNamespaceDefault());
		}

		return fmx;
	}
	
}
