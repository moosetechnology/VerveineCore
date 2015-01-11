// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("VariableExpression")
public class VariableExpression extends Expression {



    private Expression receiver;
    
    @FameProperty(name = "receiver")
    public Expression getReceiver() {
        return receiver;
    }

    public void setReceiver(Expression receiver) {
        this.receiver = receiver;
    }
    
    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


}

