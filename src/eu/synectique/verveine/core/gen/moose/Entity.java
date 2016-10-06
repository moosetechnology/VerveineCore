// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.moose;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import java.util.*;
import ch.akuhn.fame.FamePackage;


@FamePackage("Moose")
@FameDescription("Entity")
public class Entity  {



    private Collection<Object> tagAssociations; 

    @FameProperty(name = "tagAssociations")
    public Collection<Object> getTagAssociations() {
        if (tagAssociations == null) tagAssociations = new HashSet<Object>();
        return tagAssociations;
    }
    
    public void setTagAssociations(Collection<? extends Object> tagAssociations) {
        this.getTagAssociations().clear();
        this.getTagAssociations().addAll(tagAssociations);
    }                    

    public void addTagAssociations(Object one) {
        this.getTagAssociations().add(one);
    }   
    
    public void addTagAssociations(Object one, Object... many) {
        this.getTagAssociations().add(one);
        for (Object each : many)
            this.getTagAssociations().add(each);
    }   
    
    public void addTagAssociations(Iterable<? extends Object> many) {
        for (Object each : many)
            this.getTagAssociations().add(each);
    }   
                
    public void addTagAssociations(Object[] many) {
        for (Object each : many)
            this.getTagAssociations().add(each);
    }
    
    public int numberOfTagAssociations() {
        return getTagAssociations().size();
    }

    public boolean hasTagAssociations() {
        return !getTagAssociations().isEmpty();
    }
    
                


}

