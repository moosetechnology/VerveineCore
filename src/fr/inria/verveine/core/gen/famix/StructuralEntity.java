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
    
    @FameProperty(name = "declaredType")
    public Type getDeclaredType() {
        return declaredType;
    }

    public void setDeclaredType(Type declaredType) {
        this.declaredType = declaredType;
    }
    
    private Collection<Type> declaredArgumentTypes;
    
    @FameProperty(name = "declaredArgumentTypes")
    public Collection<Type> getDeclaredArgumentTypes() {
        return declaredArgumentTypes;
    }

    public void setDeclaredArgumentTypes(Collection<Type> declaredArgumentTypes) {
        this.declaredArgumentTypes = declaredArgumentTypes;
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

