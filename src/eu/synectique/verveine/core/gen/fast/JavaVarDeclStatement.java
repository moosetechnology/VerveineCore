// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.internal.MultivalueSet;
import eu.synectique.verveine.core.gen.famix.Type;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("JavaVarDeclStatement")
public class JavaVarDeclStatement extends Statement {



    private Collection<JavaVariableDeclarator> declarators; 

    @FameProperty(name = "declarators", opposite = "parentNode")
    public Collection<JavaVariableDeclarator> getDeclarators() {
        if (declarators == null) {
            declarators = new MultivalueSet<JavaVariableDeclarator>() {
                @Override
                protected void clearOpposite(JavaVariableDeclarator e) {
                    e.setParentNode(null);
                }
                @Override
                protected void setOpposite(JavaVariableDeclarator e) {
                    e.setParentNode(JavaVarDeclStatement.this);
                }
            };
        }
        return declarators;
    }
    
    public void setDeclarators(Collection<? extends JavaVariableDeclarator> declarators) {
        this.getDeclarators().clear();
        this.getDeclarators().addAll(declarators);
    }                    
    
        
    public void addDeclarators(JavaVariableDeclarator one) {
        this.getDeclarators().add(one);
    }   
    
    public void addDeclarators(JavaVariableDeclarator one, JavaVariableDeclarator... many) {
        this.getDeclarators().add(one);
        for (JavaVariableDeclarator each : many)
            this.getDeclarators().add(each);
    }   
    
    public void addDeclarators(Iterable<? extends JavaVariableDeclarator> many) {
        for (JavaVariableDeclarator each : many)
            this.getDeclarators().add(each);
    }   
                
    public void addDeclarators(JavaVariableDeclarator[] many) {
        for (JavaVariableDeclarator each : many)
            this.getDeclarators().add(each);
    }
    
    public int numberOfDeclarators() {
        return getDeclarators().size();
    }

    public boolean hasDeclarators() {
        return !getDeclarators().isEmpty();
    }
    
                
    private Type type;
    
    @FameProperty(name = "type")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    


}

