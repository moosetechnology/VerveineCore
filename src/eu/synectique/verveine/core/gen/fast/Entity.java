// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import eu.synectique.verveine.core.gen.famix.SourcedEntity;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("Entity")
public class Entity extends SourcedEntity {



    private Expression expression;
    
    @FameProperty(name = "expression", opposite = "fastParentEntity")
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        if (this.expression == null ? expression != null : !this.expression.equals(expression)) {
            Expression old_expression = this.expression;
            this.expression = expression;
            if (old_expression != null) old_expression.setFastParentEntity(null);
            if (expression != null) expression.setFastParentEntity(this);
        }
    }
    


}

