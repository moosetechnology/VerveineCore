// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ImplicitVariable")
public class ImplicitVariable extends StructuralEntity {



    private BehaviouralEntity parentBehaviouralEntity;
    
    @FameProperty(name = "parentBehaviouralEntity")
    public BehaviouralEntity getParentBehaviouralEntity() {
        return parentBehaviouralEntity;
    }

    @Override
	public ContainerEntity getBelongsTo() {
		return getParentBehaviouralEntity();
	}

    public void setParentBehaviouralEntity(BehaviouralEntity parentBehaviouralEntity) {
        this.parentBehaviouralEntity = parentBehaviouralEntity;
    }
    


}

