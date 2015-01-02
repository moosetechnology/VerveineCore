// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import eu.synectique.verveine.core.gen.famix.SourcedEntity;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaVariableDeclarator")
public class JavaVariableDeclarator extends SourcedEntity {



    private Expression expression;
    
    @FameProperty(name = "expression")
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    
    private JavaVarDeclStatement parentNode;
    
    @FameProperty(name = "parentNode", opposite = "declarators")
    public JavaVarDeclStatement getParentNode() {
        return parentNode;
    }

    public void setParentNode(JavaVarDeclStatement parentNode) {
        if (this.parentNode != null) {
            if (this.parentNode.equals(parentNode)) return;
            this.parentNode.getDeclarators().remove(this);
        }
        this.parentNode = parentNode;
        if (parentNode == null) return;
        parentNode.getDeclarators().add(this);
    }
    
    private NamedEntity variable;
    
    @FameProperty(name = "variable")
    public NamedEntity getVariable() {
        return variable;
    }

    public void setVariable(NamedEntity variable) {
        this.variable = variable;
    }
    


}

