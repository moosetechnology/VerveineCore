// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaForStatement")
public class JavaForStatement extends Statement {



    private Collection<Expression> initializers; 

    @FameProperty(name = "initializers")
    public Collection<Expression> getInitializers() {
        if (initializers == null) initializers = new HashSet<Expression>();
        return initializers;
    }
    
    public void setInitializers(Collection<? extends Expression> initializers) {
        this.getInitializers().clear();
        this.getInitializers().addAll(initializers);
    }                    

    public void addInitializers(Expression one) {
        this.getInitializers().add(one);
    }   
    
    public void addInitializers(Expression one, Expression... many) {
        this.getInitializers().add(one);
        for (Expression each : many)
            this.getInitializers().add(each);
    }   
    
    public void addInitializers(Iterable<? extends Expression> many) {
        for (Expression each : many)
            this.getInitializers().add(each);
    }   
                
    public void addInitializers(Expression[] many) {
        for (Expression each : many)
            this.getInitializers().add(each);
    }
    
    public int numberOfInitializers() {
        return getInitializers().size();
    }

    public boolean hasInitializers() {
        return !getInitializers().isEmpty();
    }
    
                
    private Collection<Expression> incrementors; 

    @FameProperty(name = "incrementors")
    public Collection<Expression> getIncrementors() {
        if (incrementors == null) incrementors = new HashSet<Expression>();
        return incrementors;
    }
    
    public void setIncrementors(Collection<? extends Expression> incrementors) {
        this.getIncrementors().clear();
        this.getIncrementors().addAll(incrementors);
    }                    
    
        
    public void addIncrementors(Expression one) {
        this.getIncrementors().add(one);
    }   
    
    public void addIncrementors(Expression one, Expression... many) {
        this.getIncrementors().add(one);
        for (Expression each : many)
            this.getIncrementors().add(each);
    }   
    
    public void addIncrementors(Iterable<? extends Expression> many) {
        for (Expression each : many)
            this.getIncrementors().add(each);
    }   
                
    public void addIncrementors(Expression[] many) {
        for (Expression each : many)
            this.getIncrementors().add(each);
    }
    
    public int numberOfIncrementors() {
        return getIncrementors().size();
    }

    public boolean hasIncrementors() {
        return !getIncrementors().isEmpty();
    }
    
                
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

