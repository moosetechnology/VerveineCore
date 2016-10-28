// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("PreprocessorIfdef")
public class PreprocessorIfdef extends PreprocessorStatement {



    private String macro;
    
    @FameProperty(name = "macro")
    public String getMacro() {
        return macro;
    }

    public void setMacro(String macro) {
        this.macro = macro;
    }
    
    private Boolean isNegated;
    
    @FameProperty(name = "isNegated")
    public Boolean getIsNegated() {
        return isNegated;
    }

    public void setIsNegated(Boolean isNegated) {
        this.isNegated = isNegated;
    }
    


}

