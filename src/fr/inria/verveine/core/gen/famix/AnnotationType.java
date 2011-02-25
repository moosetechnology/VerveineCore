// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("AnnotationType")
public class AnnotationType extends NamedEntity {



    private ContainerEntity container;
    
    @FameProperty(name = "container", opposite = "definedAnnotationTypes")
    public ContainerEntity getContainer() {
        return container;
    }

    public void setContainer(ContainerEntity container) {
        if (this.container != null) {
            if (this.container.equals(container)) return;
            this.container.getDefinedAnnotationTypes().remove(this);
        }
        this.container = container;
        if (container == null) return;
        container.getDefinedAnnotationTypes().add(this);
    }
    
    private Collection<AnnotationTypeAttribute> attributes; 

    @FameProperty(name = "attributes", opposite = "parentAnnotationType", derived = true)
    public Collection<AnnotationTypeAttribute> getAttributes() {
        if (attributes == null) {
            attributes = new MultivalueSet<AnnotationTypeAttribute>() {
                @Override
                protected void clearOpposite(AnnotationTypeAttribute e) {
                    e.setParentAnnotationType(null);
                }
                @Override
                protected void setOpposite(AnnotationTypeAttribute e) {
                    e.setParentAnnotationType(AnnotationType.this);
                }
            };
        }
        return attributes;
    }
    
    public void setAttributes(Collection<? extends AnnotationTypeAttribute> attributes) {
        this.getAttributes().clear();
        this.getAttributes().addAll(attributes);
    }                    
    
        
    public void addAttributes(AnnotationTypeAttribute one) {
        this.getAttributes().add(one);
    }   
    
    public void addAttributes(AnnotationTypeAttribute one, AnnotationTypeAttribute... many) {
        this.getAttributes().add(one);
        for (AnnotationTypeAttribute each : many)
            this.getAttributes().add(each);
    }   
    
    public void addAttributes(Iterable<? extends AnnotationTypeAttribute> many) {
        for (AnnotationTypeAttribute each : many)
            this.getAttributes().add(each);
    }   
                
    public void addAttributes(AnnotationTypeAttribute[] many) {
        for (AnnotationTypeAttribute each : many)
            this.getAttributes().add(each);
    }
    
    public int numberOfAttributes() {
        return getAttributes().size();
    }

    public boolean hasAttributes() {
        return !getAttributes().isEmpty();
    }
    
                
    private Collection<AnnotationInstance> instances; 

    @FameProperty(name = "instances", opposite = "annotationType", derived = true)
    public Collection<AnnotationInstance> getInstances() {
        if (instances == null) {
            instances = new MultivalueSet<AnnotationInstance>() {
                @Override
                protected void clearOpposite(AnnotationInstance e) {
                    e.setAnnotationType(null);
                }
                @Override
                protected void setOpposite(AnnotationInstance e) {
                    e.setAnnotationType(AnnotationType.this);
                }
            };
        }
        return instances;
    }
    
    public void setInstances(Collection<? extends AnnotationInstance> instances) {
        this.getInstances().clear();
        this.getInstances().addAll(instances);
    }                    
    
        
    public void addInstances(AnnotationInstance one) {
        this.getInstances().add(one);
    }   
    
    public void addInstances(AnnotationInstance one, AnnotationInstance... many) {
        this.getInstances().add(one);
        for (AnnotationInstance each : many)
            this.getInstances().add(each);
    }   
    
    public void addInstances(Iterable<? extends AnnotationInstance> many) {
        for (AnnotationInstance each : many)
            this.getInstances().add(each);
    }   
                
    public void addInstances(AnnotationInstance[] many) {
        for (AnnotationInstance each : many)
            this.getInstances().add(each);
    }
    
    public int numberOfInstances() {
        return getInstances().size();
    }

    public boolean hasInstances() {
        return !getInstances().isEmpty();
    }
    
                


}

