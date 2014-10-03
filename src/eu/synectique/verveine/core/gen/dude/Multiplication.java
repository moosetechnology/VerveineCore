// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.dude;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import eu.synectique.verveine.core.gen.famix.Entity;
import ch.akuhn.fame.FamePackage;


@FamePackage("Dude")
@FameDescription("Multiplication")
public class Multiplication extends Entity {



    private Collection<Duplication> duplications; 

    @FameProperty(name = "duplications", opposite = "multiplicationInvolved", derived = true)
    public Collection<Duplication> getDuplications() {
        if (duplications == null) {
            duplications = new MultivalueSet<Duplication>() {
                @Override
                protected void clearOpposite(Duplication e) {
                    e.setMultiplicationInvolved(null);
                }
                @Override
                protected void setOpposite(Duplication e) {
                    e.setMultiplicationInvolved(Multiplication.this);
                }
            };
        }
        return duplications;
    }
    
    public void setDuplications(Collection<? extends Duplication> duplications) {
        this.getDuplications().clear();
        this.getDuplications().addAll(duplications);
    }                    
    
        
    public void addDuplications(Duplication one) {
        this.getDuplications().add(one);
    }   
    
    public void addDuplications(Duplication one, Duplication... many) {
        this.getDuplications().add(one);
        for (Duplication each : many)
            this.getDuplications().add(each);
    }   
    
    public void addDuplications(Iterable<? extends Duplication> many) {
        for (Duplication each : many)
            this.getDuplications().add(each);
    }   
                
    public void addDuplications(Duplication[] many) {
        for (Duplication each : many)
            this.getDuplications().add(each);
    }
    
    public int numberOfDuplications() {
        return getDuplications().size();
    }

    public boolean hasDuplications() {
        return !getDuplications().isEmpty();
    }
    
                


}

