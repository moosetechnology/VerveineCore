// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("UnknownVariable")
public class UnknownVariable extends StructuralEntity {



    @Override
	public ContainerEntity getBelongsTo() {
		return getParentPackage();
	}
    
    @Override
    public void setBelongsTo(ContainerEntity container) {
    	if (container instanceof BehaviouralEntity) {
    		setParentPackage( (Package) container);
    	}
    }


}

