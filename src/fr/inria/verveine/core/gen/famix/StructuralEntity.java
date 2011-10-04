// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("StructuralEntity")
public class StructuralEntity extends LeafEntity {



    private Type declaredType;
    
    @FameProperty(name = "declaredType", opposite = "structuresWithDeclaredType")
    public Type getDeclaredType() {
        return declaredType;
    }

    public void setDeclaredType(Type declaredType) {
        if (this.declaredType != null) {
            if (this.declaredType.equals(declaredType)) return;
            this.declaredType.getStructuresWithDeclaredType().remove(this);
        }
        this.declaredType = declaredType;
        if (declaredType == null) return;
        declaredType.getStructuresWithDeclaredType().add(this);
    }
    
    private Collection<Access> incomingAccesses; 

    @FameProperty(name = "incomingAccesses", opposite = "variable", derived = true)
    public Collection<Access> getIncomingAccesses() {
        if (incomingAccesses == null) {
            incomingAccesses = new MultivalueSet<Access>() {
                @Override
                protected void clearOpposite(Access e) {
                    e.setVariable(null);
                }
                @Override
                protected void setOpposite(Access e) {
                    e.setVariable(StructuralEntity.this);
                }
            };
        }
        return incomingAccesses;
    }
    
    public void setIncomingAccesses(Collection<? extends Access> incomingAccesses) {
        this.getIncomingAccesses().clear();
        this.getIncomingAccesses().addAll(incomingAccesses);
    }                    
    
        
    public void addIncomingAccesses(Access one) {
        this.getIncomingAccesses().add(one);
    }   
    
    public void addIncomingAccesses(Access one, Access... many) {
        this.getIncomingAccesses().add(one);
        for (Access each : many)
            this.getIncomingAccesses().add(each);
    }   
    
    public void addIncomingAccesses(Iterable<? extends Access> many) {
        for (Access each : many)
            this.getIncomingAccesses().add(each);
    }   
                
    public void addIncomingAccesses(Access[] many) {
        for (Access each : many)
            this.getIncomingAccesses().add(each);
    }
    
    public int numberOfIncomingAccesses() {
        return getIncomingAccesses().size();
    }

    public boolean hasIncomingAccesses() {
        return !getIncomingAccesses().isEmpty();
    }
    
                


}

