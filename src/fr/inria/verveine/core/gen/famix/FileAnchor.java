// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("FileAnchor")
public class FileAnchor extends SourceAnchor {



    private Number startLine;
    
    @FameProperty(name = "startLine")
    public Number getStartLine() {
        return startLine;
    }

    public void setStartLine(Number startLine) {
        this.startLine = startLine;
    }
    
    private Number endLine;
    
    @FameProperty(name = "endLine")
    public Number getEndLine() {
        return endLine;
    }

    public void setEndLine(Number endLine) {
        this.endLine = endLine;
    }
    
    private Number startColumn;
    
    @FameProperty(name = "startColumn")
    public Number getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(Number startColumn) {
        this.startColumn = startColumn;
    }
    
    private String fileName;
    
    @FameProperty(name = "fileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    private Number endColumn;
    
    @FameProperty(name = "endColumn")
    public Number getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(Number endColumn) {
        this.endColumn = endColumn;
    }
    


}

