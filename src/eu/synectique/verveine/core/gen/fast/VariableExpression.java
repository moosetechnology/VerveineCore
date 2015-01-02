// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("VariableExpression")
public class VariableExpression extends Expression {



    private NamedEntity variable;
    
    @FameProperty(name = "variable")
    public NamedEntity getVariable() {
        return variable;
    }

    public void setVariable(NamedEntity variable) {
        this.variable = variable;
    }
    


}

