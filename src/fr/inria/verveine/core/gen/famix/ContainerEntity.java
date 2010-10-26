// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ContainerEntity")
public class ContainerEntity extends NamedEntity {



    private Collection<AnnotationType> definedAnnotationTypes; 

    @FameProperty(name = "definedAnnotationTypes", opposite = "container", derived = true)
    public Collection<AnnotationType> getDefinedAnnotationTypes() {
        if (definedAnnotationTypes == null) {
            definedAnnotationTypes = new MultivalueSet<AnnotationType>() {
                @Override
                protected void clearOpposite(AnnotationType e) {
                    e.setContainer(null);
                }
                @Override
                protected void setOpposite(AnnotationType e) {
                    e.setContainer(ContainerEntity.this);
                }
            };
        }
        return definedAnnotationTypes;
    }
    
    public void setDefinedAnnotationTypes(Collection<? extends AnnotationType> definedAnnotationTypes) {
        this.getDefinedAnnotationTypes().clear();
        this.getDefinedAnnotationTypes().addAll(definedAnnotationTypes);
    }                    
    
        
    public void addDefinedAnnotationTypes(AnnotationType one) {
        this.getDefinedAnnotationTypes().add(one);
    }   
    
    public void addDefinedAnnotationTypes(AnnotationType one, AnnotationType... many) {
        this.getDefinedAnnotationTypes().add(one);
        for (AnnotationType each : many)
            this.getDefinedAnnotationTypes().add(each);
    }   
    
    public void addDefinedAnnotationTypes(Iterable<? extends AnnotationType> many) {
        for (AnnotationType each : many)
            this.getDefinedAnnotationTypes().add(each);
    }   
                
    public void addDefinedAnnotationTypes(AnnotationType[] many) {
        for (AnnotationType each : many)
            this.getDefinedAnnotationTypes().add(each);
    }
    
    public int numberOfDefinedAnnotationTypes() {
        return getDefinedAnnotationTypes().size();
    }

    public boolean hasDefinedAnnotationTypes() {
        return !getDefinedAnnotationTypes().isEmpty();
    }
    
                
    private Collection<Reference> outgoingReferences; 

    @FameProperty(name = "outgoingReferences", opposite = "source", derived = true)
    public Collection<Reference> getOutgoingReferences() {
        if (outgoingReferences == null) {
            outgoingReferences = new MultivalueSet<Reference>() {
                @Override
                protected void clearOpposite(Reference e) {
                    e.setSource(null);
                }
                @Override
                protected void setOpposite(Reference e) {
                    e.setSource(ContainerEntity.this);
                }
            };
        }
        return outgoingReferences;
    }
    
    public void setOutgoingReferences(Collection<? extends Reference> outgoingReferences) {
        this.getOutgoingReferences().clear();
        this.getOutgoingReferences().addAll(outgoingReferences);
    }                    
    
        
    public void addOutgoingReferences(Reference one) {
        this.getOutgoingReferences().add(one);
    }   
    
    public void addOutgoingReferences(Reference one, Reference... many) {
        this.getOutgoingReferences().add(one);
        for (Reference each : many)
            this.getOutgoingReferences().add(each);
    }   
    
    public void addOutgoingReferences(Iterable<? extends Reference> many) {
        for (Reference each : many)
            this.getOutgoingReferences().add(each);
    }   
                
    public void addOutgoingReferences(Reference[] many) {
        for (Reference each : many)
            this.getOutgoingReferences().add(each);
    }
    
    public int numberOfOutgoingReferences() {
        return getOutgoingReferences().size();
    }

    public boolean hasOutgoingReferences() {
        return !getOutgoingReferences().isEmpty();
    }
    
                
    private Collection<Type> types; 

    @FameProperty(name = "types", opposite = "container", derived = true)
    public Collection<Type> getTypes() {
        if (types == null) {
            types = new MultivalueSet<Type>() {
                @Override
                protected void clearOpposite(Type e) {
                    e.setContainer(null);
                }
                @Override
                protected void setOpposite(Type e) {
                    e.setContainer(ContainerEntity.this);
                }
            };
        }
        return types;
    }
    
    public void setTypes(Collection<? extends Type> types) {
        this.getTypes().clear();
        this.getTypes().addAll(types);
    }                    
    
        
    public void addTypes(Type one) {
        this.getTypes().add(one);
    }   
    
    public void addTypes(Type one, Type... many) {
        this.getTypes().add(one);
        for (Type each : many)
            this.getTypes().add(each);
    }   
    
    public void addTypes(Iterable<? extends Type> many) {
        for (Type each : many)
            this.getTypes().add(each);
    }   
                
    public void addTypes(Type[] many) {
        for (Type each : many)
            this.getTypes().add(each);
    }
    
    public int numberOfTypes() {
        return getTypes().size();
    }

    public boolean hasTypes() {
        return !getTypes().isEmpty();
    }
    
                
    private Collection<Reference> incomingReferences; 

    @FameProperty(name = "incomingReferences", opposite = "target", derived = true)
    public Collection<Reference> getIncomingReferences() {
        if (incomingReferences == null) {
            incomingReferences = new MultivalueSet<Reference>() {
                @Override
                protected void clearOpposite(Reference e) {
                    e.setTarget(null);
                }
                @Override
                protected void setOpposite(Reference e) {
                    e.setTarget(ContainerEntity.this);
                }
            };
        }
        return incomingReferences;
    }
    
    public void setIncomingReferences(Collection<? extends Reference> incomingReferences) {
        this.getIncomingReferences().clear();
        this.getIncomingReferences().addAll(incomingReferences);
    }                    
    
        
    public void addIncomingReferences(Reference one) {
        this.getIncomingReferences().add(one);
    }   
    
    public void addIncomingReferences(Reference one, Reference... many) {
        this.getIncomingReferences().add(one);
        for (Reference each : many)
            this.getIncomingReferences().add(each);
    }   
    
    public void addIncomingReferences(Iterable<? extends Reference> many) {
        for (Reference each : many)
            this.getIncomingReferences().add(each);
    }   
                
    public void addIncomingReferences(Reference[] many) {
        for (Reference each : many)
            this.getIncomingReferences().add(each);
    }
    
    public int numberOfIncomingReferences() {
        return getIncomingReferences().size();
    }

    public boolean hasIncomingReferences() {
        return !getIncomingReferences().isEmpty();
    }
    
                


}

