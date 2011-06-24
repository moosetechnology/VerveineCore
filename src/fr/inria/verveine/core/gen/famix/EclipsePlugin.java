// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("EclipsePlugin")
public class EclipsePlugin extends Entity {



    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

                
    private Collection<Type> types; 

    @FameProperty(name = "types", opposite = "parentEclipsePlugin", derived = true)
    public Collection<Type> getTypes() {
        if (types == null) {
            types = new MultivalueSet<Type>() {
                @Override
                protected void clearOpposite(Type e) {
                    e.setParentEclipsePlugin(null);
                }
                @Override
                protected void setOpposite(Type e) {
                    e.setParentEclipsePlugin(EclipsePlugin.this);
                }
            };
        }
        return types;
    }
    
    public void setTypes(Collection<? extends Type> types) {
        this.getTypes().clear();
        this.getTypes().addAll(types);
    }                    
    
        
    public void addTypes(Type one) {
        this.getTypes().add(one);
    }   
    
    public void addTypes(Type one, Type... many) {
        this.getTypes().add(one);
        for (Type each : many)
            this.getTypes().add(each);
    }   
    
    public void addTypes(Iterable<? extends Type> many) {
        for (Type each : many)
            this.getTypes().add(each);
    }   
                
    public void addTypes(Type[] many) {
        for (Type each : many)
            this.getTypes().add(each);
    }
    
    public int numberOfTypes() {
        return getTypes().size();
    }

    public boolean hasTypes() {
        return !getTypes().isEmpty();
    }

}

