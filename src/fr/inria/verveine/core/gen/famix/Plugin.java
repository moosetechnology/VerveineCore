// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Plugin")
public class Plugin extends NamedEntity {



    @Override
	public ContainerEntity getBelongsTo() {
		return null;
	}

	private Collection<Type> childNamedEntities; 

    @FameProperty(name = "childNamedEntities", opposite = "parentPlugin", derived = true)
    public Collection<Type> getChildNamedEntities() {
        if (childNamedEntities == null) {
            childNamedEntities = new MultivalueSet<Type>() {
                @Override
                protected void clearOpposite(Type e) {
                    e.setParentPlugin(null);
                }
                @Override
                protected void setOpposite(Type e) {
                    e.setParentPlugin(Plugin.this);
                }
            };
        }
        return childNamedEntities;
    }
    
    public void setChildNamedEntities(Collection<? extends Type> childNamedEntities) {
        this.getChildNamedEntities().clear();
        this.getChildNamedEntities().addAll(childNamedEntities);
    }                    
    
        
    public void addChildNamedEntities(Type one) {
        this.getChildNamedEntities().add(one);
    }   
    
    public void addChildNamedEntities(Type one, Type... many) {
        this.getChildNamedEntities().add(one);
        for (Type each : many)
            this.getChildNamedEntities().add(each);
    }   
    
    public void addChildNamedEntities(Iterable<? extends Type> many) {
        for (Type each : many)
            this.getChildNamedEntities().add(each);
    }   
                
    public void addChildNamedEntities(Type[] many) {
        for (Type each : many)
            this.getChildNamedEntities().add(each);
    }
    
    public int numberOfChildNamedEntities() {
        return getChildNamedEntities().size();
    }

    public boolean hasChildNamedEntities() {
        return !getChildNamedEntities().isEmpty();
    }
    
                


}

