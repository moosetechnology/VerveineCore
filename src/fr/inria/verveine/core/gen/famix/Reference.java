// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Reference")
public class Reference extends Association {



    private ContainerEntity source;
    
    @FameProperty(name = "source", opposite = "outgoingReferences")
    public ContainerEntity getSource() {
        return source;
    }

    public void setSource(ContainerEntity source) {
        if (this.source != null) {
            if (this.source.equals(source)) return;
            this.source.getOutgoingReferences().remove(this);
        }
        this.source = source;
        if (source == null) return;
        source.getOutgoingReferences().add(this);
    }
    
    private ContainerEntity target;
    
    @FameProperty(name = "target", opposite = "incomingReferences")
    public ContainerEntity getTarget() {
        return target;
    }

    public void setTarget(ContainerEntity target) {
        if (this.target != null) {
            if (this.target.equals(target)) return;
            this.target.getIncomingReferences().remove(this);
        }
        this.target = target;
        if (target == null) return;
        target.getIncomingReferences().add(this);
    }

	@Override
	public NamedEntity getFrom() {
		return getSource();
	}

	@Override
	public NamedEntity getTo() {
		return getTarget();
	}
    


}

