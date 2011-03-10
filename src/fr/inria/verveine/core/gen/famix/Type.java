// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Type")
public class Type extends ContainerEntity {



    private Collection<Method> methods; 

    @FameProperty(name = "methods", opposite = "parentType", derived = true)
    public Collection<Method> getMethods() {
        if (methods == null) {
            methods = new MultivalueSet<Method>() {
                @Override
                protected void clearOpposite(Method e) {
                    e.setParentType(null);
                }
                @Override
                protected void setOpposite(Method e) {
                    e.setParentType(Type.this);
                }
            };
        }
        return methods;
    }
    
    public void setMethods(Collection<? extends Method> methods) {
        this.getMethods().clear();
        this.getMethods().addAll(methods);
    }                    
    
        
    public void addMethods(Method one) {
        this.getMethods().add(one);
    }   
    
    public void addMethods(Method one, Method... many) {
        this.getMethods().add(one);
        for (Method each : many)
            this.getMethods().add(each);
    }   
    
    public void addMethods(Iterable<? extends Method> many) {
        for (Method each : many)
            this.getMethods().add(each);
    }   
                
    public void addMethods(Method[] many) {
        for (Method each : many)
            this.getMethods().add(each);
    }
    
    public int numberOfMethods() {
        return getMethods().size();
    }

    public boolean hasMethods() {
        return !getMethods().isEmpty();
    }
    
                
    private Collection<Inheritance> superInheritances; 

    @FameProperty(name = "superInheritances", opposite = "subclass", derived = true)
    public Collection<Inheritance> getSuperInheritances() {
        if (superInheritances == null) {
            superInheritances = new MultivalueSet<Inheritance>() {
                @Override
                protected void clearOpposite(Inheritance e) {
                    e.setSubclass(null);
                }
                @Override
                protected void setOpposite(Inheritance e) {
                    e.setSubclass(Type.this);
                }
            };
        }
        return superInheritances;
    }
    
    public void setSuperInheritances(Collection<? extends Inheritance> superInheritances) {
        this.getSuperInheritances().clear();
        this.getSuperInheritances().addAll(superInheritances);
    }                    
    
        
    public void addSuperInheritances(Inheritance one) {
        this.getSuperInheritances().add(one);
    }   
    
    public void addSuperInheritances(Inheritance one, Inheritance... many) {
        this.getSuperInheritances().add(one);
        for (Inheritance each : many)
            this.getSuperInheritances().add(each);
    }   
    
    public void addSuperInheritances(Iterable<? extends Inheritance> many) {
        for (Inheritance each : many)
            this.getSuperInheritances().add(each);
    }   
                
    public void addSuperInheritances(Inheritance[] many) {
        for (Inheritance each : many)
            this.getSuperInheritances().add(each);
    }
    
    public int numberOfSuperInheritances() {
        return getSuperInheritances().size();
    }

    public boolean hasSuperInheritances() {
        return !getSuperInheritances().isEmpty();
    }
    
                
    private ContainerEntity container;
    
    @FameProperty(name = "container", opposite = "types")
    public ContainerEntity getContainer() {
        return container;
    }

    @Override
	public ContainerEntity getBelongsTo() {
		return getContainer();
	}

    public void setContainer(ContainerEntity container) {
        if (this.container != null) {
            if (this.container.equals(container)) return;
            this.container.getTypes().remove(this);
        }
        this.container = container;
        if (container == null) return;
        container.getTypes().add(this);
    }
    
    private Collection<Attribute> attributes; 

    @FameProperty(name = "attributes", opposite = "parentType", derived = true)
    public Collection<Attribute> getAttributes() {
        if (attributes == null) {
            attributes = new MultivalueSet<Attribute>() {
                @Override
                protected void clearOpposite(Attribute e) {
                    e.setParentType(null);
                }
                @Override
                protected void setOpposite(Attribute e) {
                    e.setParentType(Type.this);
                }
            };
        }
        return attributes;
    }
    
    public void setAttributes(Collection<? extends Attribute> attributes) {
        this.getAttributes().clear();
        this.getAttributes().addAll(attributes);
    }                    
    
        
    public void addAttributes(Attribute one) {
        this.getAttributes().add(one);
    }   
    
    public void addAttributes(Attribute one, Attribute... many) {
        this.getAttributes().add(one);
        for (Attribute each : many)
            this.getAttributes().add(each);
    }   
    
    public void addAttributes(Iterable<? extends Attribute> many) {
        for (Attribute each : many)
            this.getAttributes().add(each);
    }   
                
    public void addAttributes(Attribute[] many) {
        for (Attribute each : many)
            this.getAttributes().add(each);
    }
    
    public int numberOfAttributes() {
        return getAttributes().size();
    }

    public boolean hasAttributes() {
        return !getAttributes().isEmpty();
    }
    
                
    private Collection<Inheritance> subInheritances; 

    @FameProperty(name = "subInheritances", opposite = "superclass", derived = true)
    public Collection<Inheritance> getSubInheritances() {
        if (subInheritances == null) {
            subInheritances = new MultivalueSet<Inheritance>() {
                @Override
                protected void clearOpposite(Inheritance e) {
                    e.setSuperclass(null);
                }
                @Override
                protected void setOpposite(Inheritance e) {
                    e.setSuperclass(Type.this);
                }
            };
        }
        return subInheritances;
    }
    
    public void setSubInheritances(Collection<? extends Inheritance> subInheritances) {
        this.getSubInheritances().clear();
        this.getSubInheritances().addAll(subInheritances);
    }                    
    
        
    public void addSubInheritances(Inheritance one) {
        this.getSubInheritances().add(one);
    }   
    
    public void addSubInheritances(Inheritance one, Inheritance... many) {
        this.getSubInheritances().add(one);
        for (Inheritance each : many)
            this.getSubInheritances().add(each);
    }   
    
    public void addSubInheritances(Iterable<? extends Inheritance> many) {
        for (Inheritance each : many)
            this.getSubInheritances().add(each);
    }   
                
    public void addSubInheritances(Inheritance[] many) {
        for (Inheritance each : many)
            this.getSubInheritances().add(each);
    }
    
    public int numberOfSubInheritances() {
        return getSubInheritances().size();
    }

    public boolean hasSubInheritances() {
        return !getSubInheritances().isEmpty();
    }
    
                


}

