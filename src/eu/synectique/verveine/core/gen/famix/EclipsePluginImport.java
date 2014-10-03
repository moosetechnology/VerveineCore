// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("EclipsePluginImport")
public class EclipsePluginImport extends Entity {



    private EclipsePlugin source;
    
    @FameProperty(name = "source", opposite = "outgoingFAMIXEclipsePluginImport")
    public EclipsePlugin getSource() {
        return source;
    }

    public void setSource(EclipsePlugin source) {
        if (this.source != null) {
            if (this.source.equals(source)) return;
            this.source.getOutgoingFAMIXEclipsePluginImport().remove(this);
        }
        this.source = source;
        if (source == null) return;
        source.getOutgoingFAMIXEclipsePluginImport().add(this);
    }
    
    private EclipsePlugin target;
    
    @FameProperty(name = "target", opposite = "incomingFAMIXEclipsePluginImport")
    public EclipsePlugin getTarget() {
        return target;
    }

    public void setTarget(EclipsePlugin target) {
        if (this.target != null) {
            if (this.target.equals(target)) return;
            this.target.getIncomingFAMIXEclipsePluginImport().remove(this);
        }
        this.target = target;
        if (target == null) return;
        target.getIncomingFAMIXEclipsePluginImport().add(this);
    }
    


}

