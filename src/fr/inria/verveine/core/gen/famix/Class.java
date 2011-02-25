// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Class")
public class Class extends Type {



    @FameProperty(name = "isAbstract", derived = true)
    public Boolean getIsAbstract() {
        // TODO: this is a derived property, implement this method manually.
        return this.getModifiers().contains("abstract");
    }
    
    private Boolean isInterface;
    
    @FameProperty(name = "isInterface")
    public Boolean getIsInterface() {
        return isInterface;
    }

    public void setIsInterface(Boolean isInterface) {
        this.isInterface = isInterface;
    }
    


}

