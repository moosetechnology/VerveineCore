// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("NamedEntity")
public class NamedEntity extends Entity {



    @FameProperty(name = "nameByPolicy", derived = true)
    public String getNameByPolicy() {
        return this.getName();  
    }

    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private eu.synectique.verveine.core.gen.famix.NamedEntity famixNamedEntity;
    
    @FameProperty(name = "famixNamedEntity", opposite = "fastNamedEntities")
    public eu.synectique.verveine.core.gen.famix.NamedEntity getFamixNamedEntity() {
        return famixNamedEntity;
    }

    public void setFamixNamedEntity(eu.synectique.verveine.core.gen.famix.NamedEntity famixNamedEntity) {
        if (this.famixNamedEntity != null) {
            if (this.famixNamedEntity.equals(famixNamedEntity)) return;
            this.famixNamedEntity.getFastNamedEntities().remove(this);
        }
        this.famixNamedEntity = famixNamedEntity;
        if (famixNamedEntity == null) return;
        famixNamedEntity.getFastNamedEntities().add(this);
    }
    


}

