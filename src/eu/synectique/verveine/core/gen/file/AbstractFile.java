// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.file;

import eu.synectique.verveine.core.gen.famix.ContainerEntity;
import eu.synectique.verveine.core.gen.famix.Entity;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FILE")
@FameDescription("AbstractFile")
public class AbstractFile extends Entity {



    private Folder parentFolder;
    
    @FameProperty(name = "parentFolder", opposite = "childrenFileSystemEntities", container = true)
    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        if (this.parentFolder != null) {
            if (this.parentFolder.equals(parentFolder)) return;
            this.parentFolder.getChildrenFileSystemEntities().remove(this);
        }
        this.parentFolder = parentFolder;
        if (parentFolder == null) return;
        parentFolder.getChildrenFileSystemEntities().add(this);
    }
    
    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @FameProperty(name = "numberOfLinesOfText", derived = true)
    public Number getNumberOfLinesOfText() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }

	@FameProperty(name = "belongsTo", derived = true)
	public ContainerEntity getBelongsTo() {
		// should be getParentFolder() but the return type is not correct
		return null; 
	}
        


}

