// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Entity")
public class Entity  {



    private Collection<AnnotationInstance> annotationInstances; 

    @FameProperty(name = "annotationInstances", opposite = "annotatedEntity", derived = true)
    public Collection<AnnotationInstance> getAnnotationInstances() {
        if (annotationInstances == null) {
            annotationInstances = new MultivalueSet<AnnotationInstance>() {
                @Override
                protected void clearOpposite(AnnotationInstance e) {
                    e.setAnnotatedEntity(null);
                }
                @Override
                protected void setOpposite(AnnotationInstance e) {
                    e.setAnnotatedEntity(Entity.this);
                }
            };
        }
        return annotationInstances;
    }
    
    public void setAnnotationInstances(Collection<? extends AnnotationInstance> annotationInstances) {
        this.getAnnotationInstances().clear();
        this.getAnnotationInstances().addAll(annotationInstances);
    }                    
    
        
    public void addAnnotationInstances(AnnotationInstance one) {
        this.getAnnotationInstances().add(one);
    }   
    
    public void addAnnotationInstances(AnnotationInstance one, AnnotationInstance... many) {
        this.getAnnotationInstances().add(one);
        for (AnnotationInstance each : many)
            this.getAnnotationInstances().add(each);
    }   
    
    public void addAnnotationInstances(Iterable<? extends AnnotationInstance> many) {
        for (AnnotationInstance each : many)
            this.getAnnotationInstances().add(each);
    }   
                
    public void addAnnotationInstances(AnnotationInstance[] many) {
        for (AnnotationInstance each : many)
            this.getAnnotationInstances().add(each);
    }
    
    public int numberOfAnnotationInstances() {
        return getAnnotationInstances().size();
    }

    public boolean hasAnnotationInstances() {
        return !getAnnotationInstances().isEmpty();
    }
    
                


}

