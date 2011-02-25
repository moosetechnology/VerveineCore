// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.dude;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import fr.inria.verveine.core.gen.famix.Entity;
import ch.akuhn.fame.FamePackage;


@FamePackage("Dude")
@FameDescription("Duplication")
public class Duplication extends Entity {



    private Multiplication multiplicationInvolved;
    
    @FameProperty(name = "multiplicationInvolved", opposite = "duplications")
    public Multiplication getMultiplicationInvolved() {
        return multiplicationInvolved;
    }

    public void setMultiplicationInvolved(Multiplication multiplicationInvolved) {
        if (this.multiplicationInvolved != null) {
            if (this.multiplicationInvolved.equals(multiplicationInvolved)) return;
            this.multiplicationInvolved.getDuplications().remove(this);
        }
        this.multiplicationInvolved = multiplicationInvolved;
        if (multiplicationInvolved == null) return;
        multiplicationInvolved.getDuplications().add(this);
    }
    


}

