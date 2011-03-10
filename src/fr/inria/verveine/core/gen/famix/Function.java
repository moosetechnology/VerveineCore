// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Function")
public class Function extends BehaviouralEntity {



    private ScopingEntity parentScope;
    
    @FameProperty(name = "parentScope")
    public ScopingEntity getParentScope() {
        return parentScope;
    }

    public void setParentScope(ScopingEntity parentScope) {
        this.parentScope = parentScope;
    }
    
    private Module parentModule;
    
    @FameProperty(name = "parentModule", opposite = "functions")
    public Module getParentModule() {
        return parentModule;
    }

    public void setParentModule(Module parentModule) {
        if (this.parentModule != null) {
            if (this.parentModule.equals(parentModule)) return;
            this.parentModule.getFunctions().remove(this);
        }
        this.parentModule = parentModule;
        if (parentModule == null) return;
        parentModule.getFunctions().add(this);
    }
    


}

