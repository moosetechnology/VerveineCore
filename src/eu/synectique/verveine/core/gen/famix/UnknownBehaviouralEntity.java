//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;
import ch.akuhn.fame.FameProperty;

@FamePackage("FAMIX")
@FameDescription("UnknownBehaviouralEntity")
public class UnknownBehaviouralEntity extends BehaviouralEntity {
    private ContainerEntity belongsTo;

    public UnknownBehaviouralEntity() {
    }

    @FameProperty(
            name = "belongsTo",
            container = true
    )
    public ContainerEntity getBelongsTo() {
        return this.belongsTo;
    }

    public void setBelongsTo(ContainerEntity var1) {
        this.belongsTo = var1;
    }
}
