// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("Class")
public class Class extends Type {

    @FameProperty(name = "lcom2", derived = true)
    public Number getLcom2() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    private Boolean isInterface;
    
    @FameProperty(name = "isInterface")
    public Boolean getIsInterface() {
        return this.isInterface != null && this.isInterface;
    }

    public void setIsInterface(Boolean isInterface) {
        this.isInterface = isInterface;
    }
    
    @FameProperty(name = "lcom3", derived = true)
    public Number getLcom3() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }

    private Collection<Exception> exceptions; 

    @FameProperty(name = "exceptions", opposite = "exceptionClass", derived = true)
    public Collection<Exception> getExceptions() {
        if (exceptions == null) {
            exceptions = new MultivalueSet<Exception>() {
                @Override
                protected void clearOpposite(Exception e) {
                    e.setExceptionClass(null);
                }
                @Override
                protected void setOpposite(Exception e) {
                    e.setExceptionClass(Class.this);
                }
            };
        }
        return exceptions;
    }
    
    public void setExceptions(Collection<? extends Exception> exceptions) {
        this.getExceptions().clear();
        this.getExceptions().addAll(exceptions);
    }                    
    
        
    public void addExceptions(Exception one) {
        this.getExceptions().add(one);
    }   
    
    public void addExceptions(Exception one, Exception... many) {
        this.getExceptions().add(one);
        for (Exception each : many)
            this.getExceptions().add(each);
    }   
    
    public void addExceptions(Iterable<? extends Exception> many) {
        for (Exception each : many)
            this.getExceptions().add(each);
    }   
                
    public void addExceptions(Exception[] many) {
        for (Exception each : many)
            this.getExceptions().add(each);
    }
    
    public int numberOfExceptions() {
        return getExceptions().size();
    }

    public boolean hasExceptions() {
        return !getExceptions().isEmpty();
    }
    
                
    
    @FameProperty(name = "numberOfExternalDuplications", derived = true)
    public Number getNumberOfExternalDuplications() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    
    @FameProperty(name = "isIgnored", derived = true)
    public Collection<Boolean> getIsIgnored() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
        
    @FameProperty(name = "numberOfInternalDuplications", derived = true)
    public Number getNumberOfInternalDuplications() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
    


}

