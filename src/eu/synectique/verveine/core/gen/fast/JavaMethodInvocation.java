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
    
                
    private Expression receiver;
    
    @FameProperty(name = "receiver")
    public Expression getReceiver() {
        return receiver;
    }

    public void setReceiver(Expression receiver) {
        this.receiver = receiver;
    }
    
    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


}

