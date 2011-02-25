// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ParameterizedType")
public class ParameterizedType extends Type {



    private Collection<Type> arguments; 

    @FameProperty(name = "arguments")
    public Collection<Type> getArguments() {
        if (arguments == null) arguments = new HashSet<Type>();
        return arguments;
    }
    
    public void setArguments(Collection<? extends Type> arguments) {
        this.getArguments().clear();
        this.getArguments().addAll(arguments);
    }                    

    public void addArguments(Type one) {
        this.getArguments().add(one);
    }   
    
    public void addArguments(Type one, Type... many) {
        this.getArguments().add(one);
        for (Type each : many)
            this.getArguments().add(each);
    }   
    
    public void addArguments(Iterable<? extends Type> many) {
        for (Type each : many)
            this.getArguments().add(each);
    }   
                
    public void addArguments(Type[] many) {
        for (Type each : many)
            this.getArguments().add(each);
    }
    
    public int numberOfArguments() {
        return getArguments().size();
    }

    public boolean hasArguments() {
        return !getArguments().isEmpty();
    }
    
                
    private ParameterizableClass parameterizableClass;
    
    @FameProperty(name = "parameterizableClass")
    public ParameterizableClass getParameterizableClass() {
        return parameterizableClass;
    }

    public void setParameterizableClass(ParameterizableClass parameterizableClass) {
        this.parameterizableClass = parameterizableClass;
    }
    


}

