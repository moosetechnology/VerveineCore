// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("CaughtException")
public class CaughtException extends Exception {



    private Method definingMethod;
    
    @FameProperty(name = "definingMethod", opposite = "caughtExceptions")
    public Method getDefiningMethod() {
        return definingMethod;
    }

    public void setDefiningMethod(Method definingMethod) {
        if (this.definingMethod != null) {
            if (this.definingMethod.equals(definingMethod)) return;
            this.definingMethod.getCaughtExceptions().remove(this);
        }
        this.definingMethod = definingMethod;
        if (definingMethod == null) return;
        definingMethod.getCaughtExceptions().add(this);
    }
    


}

