// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("NamedBehaviouralEntity")
public class NamedBehaviouralEntity extends BehaviouralEntity {



    private eu.synectique.verveine.core.gen.famix.BehaviouralEntity famixBehaviouralEntity;
    
    @FameProperty(name = "parentNode", opposite = "fastBehaviouralEntity")
    public eu.synectique.verveine.core.gen.famix.BehaviouralEntity getFamixBehaviouralEntity() {
        return famixBehaviouralEntity;
    }

    public void setFamixBehaviouralEntity(eu.synectique.verveine.core.gen.famix.BehaviouralEntity famixBehaviouralEntity) {
        if (this.famixBehaviouralEntity == null ? famixBehaviouralEntity != null : !this.famixBehaviouralEntity.equals(famixBehaviouralEntity)) {
        	eu.synectique.verveine.core.gen.famix.BehaviouralEntity old_famixBehaviouralEntity = this.famixBehaviouralEntity;
            this.famixBehaviouralEntity = famixBehaviouralEntity;
            if (old_famixBehaviouralEntity != null) old_famixBehaviouralEntity.setFastBehaviouralEntity(null);
            if (famixBehaviouralEntity != null) famixBehaviouralEntity.setFastBehaviouralEntity(this);
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

