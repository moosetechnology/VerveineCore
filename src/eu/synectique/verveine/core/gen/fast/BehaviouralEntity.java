// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("BehaviouralEntity")
public class BehaviouralEntity extends Entity {



    @FameProperty(name = "statementsCount", derived = true)
    public Number getStatementsCount() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    
    @FameProperty(name = "statements", derived = true)
    public Collection<Statement> getStatements() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
        
    private StatementBlock statementBlock;
    
    @FameProperty(name = "statementBlock", opposite = "parentNode")
    public StatementBlock getStatementBlock() {
        return statementBlock;
    }

    public void setStatementBlock(StatementBlock statementBlock) {
        if (this.statementBlock == null ? statementBlock != null : !this.statementBlock.equals(statementBlock)) {
            StatementBlock old_statementBlock = this.statementBlock;
            this.statementBlock = statementBlock;
            if (old_statementBlock != null) old_statementBlock.setParentNode(null);
            if (statementBlock != null) statementBlock.setParentNode(this);
        }
    }
    
    private Collection<NamedEntity> localVariables; 

    @FameProperty(name = "localVariables")
    public Collection<NamedEntity> getLocalVariables() {
        if (localVariables == null) localVariables = new HashSet<NamedEntity>();
        return localVariables;
    }
    
    public void setLocalVariables(Collection<? extends NamedEntity> localVariables) {
        this.getLocalVariables().clear();
        this.getLocalVariables().addAll(localVariables);
    }                    

    public void addLocalVariables(NamedEntity one) {
        this.getLocalVariables().add(one);
    }   
    
    public void addLocalVariables(NamedEntity one, NamedEntity... many) {
        this.getLocalVariables().add(one);
        for (NamedEntity each : many)
            this.getLocalVariables().add(each);
    }   
    
    public void addLocalVariables(Iterable<? extends NamedEntity> many) {
        for (NamedEntity each : many)
            this.getLocalVariables().add(each);
    }   
                
    public void addLocalVariables(NamedEntity[] many) {
        for (NamedEntity each : many)
            this.getLocalVariables().add(each);
    }
    
    public int numberOfLocalVariables() {
        return getLocalVariables().size();
    }

    public boolean hasLocalVariables() {
        return !getLocalVariables().isEmpty();
    }
    
                
    private Collection<NamedEntity> parameters; 

    @FameProperty(name = "parameters")
    public Collection<NamedEntity> getParameters() {
        if (parameters == null) parameters = new HashSet<NamedEntity>();
        return parameters;
    }
    
    public void setParameters(Collection<? extends NamedEntity> parameters) {
        this.getParameters().clear();
        this.getParameters().addAll(parameters);
    }                    

    public void addParameters(NamedEntity one) {
        this.getParameters().add(one);
    }   
    
    public void addParameters(NamedEntity one, NamedEntity... many) {
        this.getParameters().add(one);
        for (NamedEntity each : many)
            this.getParameters().add(each);
    }   
    
    public void addParameters(Iterable<? extends NamedEntity> many) {
        for (NamedEntity each : many)
            this.getParameters().add(each);
    }   
                
    public void addParameters(NamedEntity[] many) {
        for (NamedEntity each : many)
            this.getParameters().add(each);
    }
    
    public int numberOfParameters() {
        return getParameters().size();
    }

    public boolean hasParameters() {
        return !getParameters().isEmpty();
    }
    
                
    @FameProperty(name = "cyclomaticComplexity", derived = true)
    public Number getCyclomaticComplexity() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    


}

