// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaIfStatement")
public class JavaIfStatement extends Statement {



    private Statement thenBody;
    
    @FameProperty(name = "thenBody")
    public Statement getThenBody() {
        return thenBody;
    }

    public void setThenBody(Statement thenBody) {
        this.thenBody = thenBody;
    }
    
    private Expression condition;
    
    @FameProperty(name = "condition")
    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }
    
    private Statement elseBody;
    
    @FameProperty(name = "elseBody")
    public Statement getElseBody() {
        return elseBody;
    }

    public void setElseBody(Statement elseBody) {
        this.elseBody = elseBody;
    }
    


}

