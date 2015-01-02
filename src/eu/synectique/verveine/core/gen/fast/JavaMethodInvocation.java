// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaMethodInvocation")
public class JavaMethodInvocation extends Expression {



    private Collection<Expression> arguments; 

    @FameProperty(name = "arguments")
    public Collection<Expression> getArguments() {
        if (arguments == null) arguments = new HashSet<Expression>();
        return arguments;
    }
    
    public void setArguments(Collection<? extends Expression> arguments) {
        this.getArguments().clear();
        this.getArguments().addAll(arguments);
    }                    

    public void addArguments(Expression one) {
        this.getArguments().add(one);
    }   
    
    public void addArguments(Expression one, Expression... many) {
        this.getArguments().add(one);
        for (Expression each : many)
            this.getArguments().add(each);
    }   
    
    public void addArguments(Iterable<? extends Expression> many) {
        for (Expression each : many)
            this.getArguments().add(each);
    }   
                
    public void addArguments(Expression[] many) {
        for (Expression each : many)
            this.getArguments().add(each);
    }
    
    public int numberOfArguments() {
        return getArguments().size();
    }

    public boolean hasArguments() {
        return !getArguments().isEmpty();
    }
    
                
    @FameProperty(name = "receiver", derived = true)
    public Expression getReceiver() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    


}

