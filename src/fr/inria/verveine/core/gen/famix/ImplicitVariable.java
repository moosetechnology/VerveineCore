// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ImplicitVariable")
public class ImplicitVariable extends StructuralEntity {



    private ContainerEntity container;
    
    @FameProperty(name = "container")
    public ContainerEntity getContainer() {
        return container;
    }

    @Override
	public ContainerEntity getBelongsTo() {
		return getContainer();
	}

    public void setContainer(ContainerEntity container) {
        this.container = container;
    }
    


}

