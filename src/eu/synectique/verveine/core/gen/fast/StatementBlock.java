// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("StatementBlock")
public class StatementBlock extends Statement {



    private BehaviouralEntity fastBehaviouralParent;
    
    @FameProperty(name = "fastBehaviouralParent", opposite = "statementBlock")
    public BehaviouralEntity getFastBehaviouralParent() {
        return fastBehaviouralParent;
    }

    public void setFastBehaviouralParent(BehaviouralEntity fastBehaviouralParent) {
        if (this.fastBehaviouralParent == null ? fastBehaviouralParent != null : !this.fastBehaviouralParent.equals(fastBehaviouralParent)) {
            BehaviouralEntity old_fastBehaviouralParent = this.fastBehaviouralParent;
            this.fastBehaviouralParent = fastBehaviouralParent;
            if (old_fastBehaviouralParent != null) old_fastBehaviouralParent.setStatementBlock(null);
            if (fastBehaviouralParent != null) fastBehaviouralParent.setStatementBlock(this);
        }
    }
    
    private Collection<Statement> statements; 

    @FameProperty(name = "statements", opposite = "statementContainer", derived = true)
    public Collection<Statement> getStatements() {
        if (statements == null) {
            statements = new MultivalueSet<Statement>() {
                @Override
                protected void clearOpposite(Statement e) {
                    e.setStatementContainer(null);
                }
                @Override
                protected void setOpposite(Statement e) {
                    e.setStatementContainer(StatementBlock.this);
                }
            };
        }
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

