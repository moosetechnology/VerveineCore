// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("ExpressionStatement")
public class ExpressionStatement extends Statement {



    private Expression expression;
    
    @FameProperty(name = "expression", opposite = "parentNode")
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        if (this.expression == null ? expression != null : !this.expression.equals(expression)) {
            Expression old_expression = this.expression;
            this.expression = expression;
            if (old_expression != null) old_expression.setParentNode(null);
            if (expression != null) expression.setParentNode(this);
        }
    }
    


}

