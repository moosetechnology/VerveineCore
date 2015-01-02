// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaDoStatement")
public class JavaDoStatement extends Statement {



    private Statement body;
    
    @FameProperty(name = "body")
    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }
    
    private Expression condition;
    
    @FameProperty(name = "condition")
    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }
    


}

