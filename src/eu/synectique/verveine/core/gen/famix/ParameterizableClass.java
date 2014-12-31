// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ParameterizableClass")
public class ParameterizableClass extends Class {



    private Collection<ParameterizedType> parameterizedTypes; 

    @FameProperty(name = "parameterizedTypes", opposite = "parameterizableClass", derived = true)
    public Collection<ParameterizedType> getParameterizedTypes() {
        if (parameterizedTypes == null) {
            parameterizedTypes = new MultivalueSet<ParameterizedType>() {
                @Override
                protected void clearOpposite(ParameterizedType e) {
                    e.setParameterizableClass(null);
                }
                @Override
                protected void setOpposite(ParameterizedType e) {
                    e.setParameterizableClass(ParameterizableClass.this);
                }
            };
        }
        return parameterizedTypes;
    }
    
    public void setParameterizedTypes(Collection<? extends ParameterizedType> parameterizedTypes) {
        this.getParameterizedTypes().clear();
        this.getParameterizedTypes().addAll(parameterizedTypes);
    }                    
    
        
    public void addParameterizedTypes(ParameterizedType one) {
        this.getParameterizedTypes().add(one);
    }   
    
    public void addParameterizedTypes(ParameterizedType one, ParameterizedType... many) {
        this.getParameterizedTypes().add(one);
        for (ParameterizedType each : many)
            this.getParameterizedTypes().add(each);
    }   
    
    public void addParameterizedTypes(Iterable<? extends ParameterizedType> many) {
        for (ParameterizedType each : many)
            this.getParameterizedTypes().add(each);
    }   
                
    public void addParameterizedTypes(ParameterizedType[] many) {
        for (ParameterizedType each : many)
            this.getParameterizedTypes().add(each);
    }
    
    public int numberOfParameterizedTypes() {
        return getParameterizedTypes().size();
    }

    public boolean hasParameterizedTypes() {
        return !getParameterizedTypes().isEmpty();
    }
    
                
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

