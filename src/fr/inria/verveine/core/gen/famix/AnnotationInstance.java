// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("AnnotationInstance")
public class AnnotationInstance extends Entity {



    private Entity annotatedEntity;
    
    @FameProperty(name = "annotatedEntity", opposite = "annotationInstances")
    public Entity getAnnotatedEntity() {
        return annotatedEntity;
    }

    public void setAnnotatedEntity(Entity annotatedEntity) {
        if (this.annotatedEntity != null) {
            if (this.annotatedEntity.equals(annotatedEntity)) return;
            this.annotatedEntity.getAnnotationInstances().remove(this);
        }
        this.annotatedEntity = annotatedEntity;
        if (annotatedEntity == null) return;
        annotatedEntity.getAnnotationInstances().add(this);
    }
    
    private AnnotationType annotationType;
    
    @FameProperty(name = "annotationType", opposite = "instances")
    public AnnotationType getAnnotationType() {
        return annotationType;
    }

    public void setAnnotationType(AnnotationType annotationType) {
        if (this.annotationType != null) {
            if (this.annotationType.equals(annotationType)) return;
            this.annotationType.getInstances().remove(this);
        }
        this.annotationType = annotationType;
        if (annotationType == null) return;
        annotationType.getInstances().add(this);
    }
    
    @FameProperty(name = "attributes", derived = true)
    public Collection<AnnotationInstanceAttribute> getAttributes() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
        


}

