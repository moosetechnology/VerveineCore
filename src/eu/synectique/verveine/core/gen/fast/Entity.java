// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import eu.synectique.verveine.core.gen.famix.SourcedEntity;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("Entity")
public class Entity extends SourcedEntity {



    private Entity parentNode;
    
    @FameProperty(name = "parentNode", opposite = "statementBlock")
    public Entity getParentNode() {
        return parentNode;
    }

    public void setParentNode(Entity parentNode) {
    	this.parentNode = parentNode;
    }
    


}

