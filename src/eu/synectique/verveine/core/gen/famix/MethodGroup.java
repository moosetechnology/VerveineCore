// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import eu.synectique.verveine.core.gen.moose.Group;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("MethodGroup")
public class MethodGroup extends Group {



    private Number averageNumberOfLinesOfCode;
    
    @FameProperty(name = "averageNumberOfLinesOfCode")
    public Number getAverageNumberOfLinesOfCode() {
        return averageNumberOfLinesOfCode;
    }

    public void setAverageNumberOfLinesOfCode(Number averageNumberOfLinesOfCode) {
        this.averageNumberOfLinesOfCode = averageNumberOfLinesOfCode;
    }
    
    private Number averageNumberOfParameters;
    
    @FameProperty(name = "averageNumberOfParameters")
    public Number getAverageNumberOfParameters() {
        return averageNumberOfParameters;
    }

    public void setAverageNumberOfParameters(Number averageNumberOfParameters) {
        this.averageNumberOfParameters = averageNumberOfParameters;
    }
    
    private Number averageNumberOfInvocations;
    
    @FameProperty(name = "averageNumberOfInvocations")
    public Number getAverageNumberOfInvocations() {
        return averageNumberOfInvocations;
    }

    public void setAverageNumberOfInvocations(Number averageNumberOfInvocations) {
        this.averageNumberOfInvocations = averageNumberOfInvocations;
    }
    


}

