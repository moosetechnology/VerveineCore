// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

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
    
    @FameProperty(name = "annotationAttributeInstances", derived = true)
    public Collection<AnnotationInstanceAttribute> getAnnotationAttributeInstances() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
        


}

