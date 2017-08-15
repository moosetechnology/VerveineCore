// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("NamedBehaviouralEntity")
public class NamedBehaviouralEntity extends BehaviouralEntity {


    private eu.synectique.verveine.core.gen.famix.BehaviouralEntity famixNamedEntity;

    @FameProperty(name = "famixNamedEntity", opposite = "fastBehaviouralEntity")
    public eu.synectique.verveine.core.gen.famix.BehaviouralEntity getFamixNamedEntity() {
        return famixNamedEntity;
    }

    public void setFamixNamedEntity(eu.synectique.verveine.core.gen.famix.BehaviouralEntity famixNamedEntity) {
        if (this.famixNamedEntity == null ? famixNamedEntity != null : !this.famixNamedEntity.equals(famixNamedEntity)) {
            eu.synectique.verveine.core.gen.famix.BehaviouralEntity old_famixNamedEntity = this.famixNamedEntity;
            this.famixNamedEntity = famixNamedEntity;
            if (old_famixNamedEntity != null) old_famixNamedEntity.setFastBehaviouralEntity(null);
            if (famixNamedEntity != null) famixNamedEntity.setFastBehaviouralEntity(this);
        }
    }
    
    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


}

