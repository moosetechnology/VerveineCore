// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("Expression")
public class Expression extends Entity {



    private Entity fastParentEntity;
    
    @FameProperty(name = "fastParentEntity", opposite = "expression")
    public Entity getFastParentEntity() {
        return fastParentEntity;
    }

    public void setFastParentEntity(Entity fastParentEntity) {
        if (this.fastParentEntity == null ? fastParentEntity != null : !this.fastParentEntity.equals(fastParentEntity)) {
            Entity old_fastParentEntity = this.fastParentEntity;
            this.fastParentEntity = fastParentEntity;
            if (old_fastParentEntity != null) old_fastParentEntity.setExpression(null);
            if (fastParentEntity != null) fastParentEntity.setExpression(this);
        }
    }
    


}

