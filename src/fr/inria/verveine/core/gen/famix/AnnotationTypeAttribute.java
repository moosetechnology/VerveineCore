// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("AnnotationTypeAttribute")
public class AnnotationTypeAttribute extends NamedEntity {



    private Type declaredType;
    
    @FameProperty(name = "declaredType")
    public Type getDeclaredType() {
        return declaredType;
    }

    public void setDeclaredType(Type declaredType) {
        this.declaredType = declaredType;
    }
    
    private AnnotationType parentAnnotationType;
    
    @FameProperty(name = "parentAnnotationType", opposite = "attributes")
    public AnnotationType getParentAnnotationType() {
        return parentAnnotationType;
    }

    public void setParentAnnotationType(AnnotationType parentAnnotationType) {
        if (this.parentAnnotationType != null) {
            if (this.parentAnnotationType.equals(parentAnnotationType)) return;
            this.parentAnnotationType.getAttributes().remove(this);
        }
        this.parentAnnotationType = parentAnnotationType;
        if (parentAnnotationType == null) return;
        parentAnnotationType.getAttributes().add(this);
    }
    
    private Collection<AnnotationInstanceAttribute> annotationAttributeInstances; 

    @FameProperty(name = "annotationAttributeInstances", opposite = "annotationTypeAttribute", derived = true)
    public Collection<AnnotationInstanceAttribute> getAnnotationAttributeInstances() {
        if (annotationAttributeInstances == null) {
            annotationAttributeInstances = new MultivalueSet<AnnotationInstanceAttribute>() {
                @Override
                protected void clearOpposite(AnnotationInstanceAttribute e) {
                    e.setAnnotationTypeAttribute(null);
                }
                @Override
                protected void setOpposite(AnnotationInstanceAttribute e) {
                    e.setAnnotationTypeAttribute(AnnotationTypeAttribute.this);
                }
            };
        }
        return annotationAttributeInstances;
    }
    
    public void setAnnotationAttributeInstances(Collection<? extends AnnotationInstanceAttribute> annotationAttributeInstances) {
        this.getAnnotationAttributeInstances().clear();
        this.getAnnotationAttributeInstances().addAll(annotationAttributeInstances);
    }                    
    
        
    public void addAnnotationAttributeInstances(AnnotationInstanceAttribute one) {
        this.getAnnotationAttributeInstances().add(one);
    }   
    
    public void addAnnotationAttributeInstances(AnnotationInstanceAttribute one, AnnotationInstanceAttribute... many) {
        this.getAnnotationAttributeInstances().add(one);
        for (AnnotationInstanceAttribute each : many)
            this.getAnnotationAttributeInstances().add(each);
    }   
    
    public void addAnnotationAttributeInstances(Iterable<? extends AnnotationInstanceAttribute> many) {
        for (AnnotationInstanceAttribute each : many)
            this.getAnnotationAttributeInstances().add(each);
    }   
                
    public void addAnnotationAttributeInstances(AnnotationInstanceAttribute[] many) {
        for (AnnotationInstanceAttribute each : many)
            this.getAnnotationAttributeInstances().add(each);
    }
    
    public int numberOfAnnotationAttributeInstances() {
        return getAnnotationAttributeInstances().size();
    }

    public boolean hasAnnotationAttributeInstances() {
        return !getAnnotationAttributeInstances().isEmpty();
    }
    
                


}

