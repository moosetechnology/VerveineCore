// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Namespace")
public class Namespace extends ScopingEntity {



    private Number numberOfAttributes;
    
    @FameProperty(name = "numberOfAttributes")
    public Number getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public void setNumberOfAttributes(Number numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
    }
    
    private Number numberOfClasses;
    
    @FameProperty(name = "numberOfClasses")
    public Number getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(Number numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }
    
    private Number numberOfMethods;
    
    @FameProperty(name = "numberOfMethods")
    public Number getNumberOfMethods() {
        return numberOfMethods;
    }

    public void setNumberOfMethods(Number numberOfMethods) {
        this.numberOfMethods = numberOfMethods;
    }
    
    private Number numberOfLinesOfCode;
    
    @FameProperty(name = "numberOfLinesOfCode")
    public Number getNumberOfLinesOfCode() {
        return numberOfLinesOfCode;
    }

    public void setNumberOfLinesOfCode(Number numberOfLinesOfCode) {
        this.numberOfLinesOfCode = numberOfLinesOfCode;
    }
    


}

