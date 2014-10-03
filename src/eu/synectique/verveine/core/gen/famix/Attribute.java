// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Attribute")
public class Attribute extends StructuralEntity {



    private Number hierarchyNestingLevel;
    
    @FameProperty(name = "hierarchyNestingLevel")
    public Number getHierarchyNestingLevel() {
        return hierarchyNestingLevel;
    }

    public void setHierarchyNestingLevel(Number hierarchyNestingLevel) {
        this.hierarchyNestingLevel = hierarchyNestingLevel;
    }
    
    private Boolean hasClassScope;
    
    @FameProperty(name = "hasClassScope")
    public Boolean getHasClassScope() {
        return hasClassScope;
    }

    public void setHasClassScope(Boolean hasClassScope) {
        this.hasClassScope = hasClassScope;
    }
    
    protected Type parentType;
    
    @FameProperty(name = "parentType", opposite = "attributes")
    public Type getParentType() {
        return parentType;
    }

    @Override
	public ContainerEntity getBelongsTo() {
		return getParentType();
	}

    public void setParentType(Type parentType) {
        if (this.parentType != null) {
            if (this.parentType.equals(parentType)) return;
            this.parentType.getAttributes().remove(this);
        }
        this.parentType = parentType;
        if (parentType == null) return;
        parentType.getAttributes().add(this);
    }
    


}

