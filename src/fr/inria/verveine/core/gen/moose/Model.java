// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.moose;

import fr.inria.verveine.core.gen.famix.SourceLanguage;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("Moose")
@FameDescription("Model")
public class Model extends AbsractGroup {



    private SourceLanguage sourceLanguage;
    
    @FameProperty(name = "sourceLanguage")
    public SourceLanguage getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(SourceLanguage sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }
    


}

