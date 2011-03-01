// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ParameterizableClass")
public class ParameterizableClass extends Class {

    @FameProperty(name = "parameters", derived = true)
    public Collection<ParameterType> getParameters() {
        // this is a derived property, implement this method manually.
    	Collection<ParameterType> ret = new LinkedList<ParameterType>();
    	
        for (Type inner : getTypes()) {
        	if (inner instanceof ParameterType) {
        		ret.add((ParameterType) inner);
        	}
        }
        
        return ret;
    }
        


}

