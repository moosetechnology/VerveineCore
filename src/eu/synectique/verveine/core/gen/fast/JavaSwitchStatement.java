// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaSwitchStatement")
public class JavaSwitchStatement extends Statement {



    private Expression expression;
    
    @FameProperty(name = "expression")
    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    
    private Collection<Statement> statements; 

    @FameProperty(name = "statements")
    public Collection<Statement> getStatements() {
        if (statements == null) statements = new HashSet<Statement>();
        return statements;
    }
    
    public void setStatements(Collection<? extends Statement> statements) {
        this.getStatements().clear();
        this.getStatements().addAll(statements);
    }                    

    public void addStatements(Statement one) {
        this.getStatements().add(one);
    }   
    
    public void addStatements(Statement one, Statement... many) {
        this.getStatements().add(one);
        for (Statement each : many)
            this.getStatements().add(each);
    }   
    
    public void addStatements(Iterable<? extends Statement> many) {
        for (Statement each : many)
            this.getStatements().add(each);
    }   
                
    public void addStatements(Statement[] many) {
        for (Statement each : many)
            this.getStatements().add(each);
    }
    
    public int numberOfStatements() {
        return getStatements().size();
    }

    public boolean hasStatements() {
        return !getStatements().isEmpty();
    }
    
                


}

