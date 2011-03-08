// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("ImplicitVariable")
public class ImplicitVariable extends StructuralEntity {



    private Type container;
    
    @FameProperty(name = "container")
    public Type getContainer() {
        return container;
    }

    @Override
	public ContainerEntity getBelongsTo() {
		return getContainer();
	}

    public void setContainer(Type container) {
        this.container = container;
    }
    


}

