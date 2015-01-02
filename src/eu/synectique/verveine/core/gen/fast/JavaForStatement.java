// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaForStatement")
public class JavaForStatement extends Statement {



    private Collection<Statement> initializers; 

    @FameProperty(name = "initializers")
    public Collection<Statement> getInitializers() {
        if (initializers == null) initializers = new HashSet<Statement>();
        return initializers;
    }
    
    public void setInitializers(Collection<? extends Statement> initializers) {
        this.getInitializers().clear();
        this.getInitializers().addAll(initializers);
    }                    

    public void addInitializers(Statement one) {
        this.getInitializers().add(one);
    }   
    
    public void addInitializers(Statement one, Statement... many) {
        this.getInitializers().add(one);
        for (Statement each : many)
            this.getInitializers().add(each);
    }   
    
    public void addInitializers(Iterable<? extends Statement> many) {
        for (Statement each : many)
            this.getInitializers().add(each);
    }   
                
    public void addInitializers(Statement[] many) {
        for (Statement each : many)
            this.getInitializers().add(each);
    }
    
    public int numberOfInitializers() {
        return getInitializers().size();
    }

    public boolean hasInitializers() {
        return !getInitializers().isEmpty();
    }
    
                
    private Collection<Statement> incrementors; 

    @FameProperty(name = "incrementors")
    public Collection<Statement> getIncrementors() {
        if (incrementors == null) incrementors = new HashSet<Statement>();
        return incrementors;
    }
    
    public void setIncrementors(Collection<? extends Statement> incrementors) {
        this.getIncrementors().clear();
        this.getIncrementors().addAll(incrementors);
    }                    

    public void addIncrementors(Statement one) {
        this.getIncrementors().add(one);
    }   
    
    public void addIncrementors(Statement one, Statement... many) {
        this.getIncrementors().add(one);
        for (Statement each : many)
            this.getIncrementors().add(each);
    }   
    
    public void addIncrementors(Iterable<? extends Statement> many) {
        for (Statement each : many)
            this.getIncrementors().add(each);
    }   
                
    public void addIncrementors(Statement[] many) {
        for (Statement each : many)
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

