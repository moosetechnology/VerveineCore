// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Class")
public class Class extends Type {

    public Class() {
		super();
		this.setIsInterface(Boolean.FALSE);  // by default assume a real class
	}

/*
    @FameProperty(name = "lcom2", derived = true)
    public Number getLcom2() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
*/    
    private Boolean isInterface;
    
    @FameProperty(name = "isInterface")
    public Boolean getIsInterface() {
        return isInterface;
    }

    public void setIsInterface(Boolean isInterface) {
        this.isInterface = isInterface;
    }
/*    
    @FameProperty(name = "lcom3", derived = true)
    public Number getLcom3() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
*/    


}

