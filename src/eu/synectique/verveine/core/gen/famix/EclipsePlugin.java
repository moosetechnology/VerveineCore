// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("EclipsePlugin")
public class EclipsePlugin extends Entity {



    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private Collection<EclipsePluginImport> incomingFAMIXEclipsePluginImport; 

    @FameProperty(name = "incomingFAMIXEclipsePluginImport", opposite = "target", derived = true)
    public Collection<EclipsePluginImport> getIncomingFAMIXEclipsePluginImport() {
        if (incomingFAMIXEclipsePluginImport == null) {
            incomingFAMIXEclipsePluginImport = new MultivalueSet<EclipsePluginImport>() {
                @Override
                protected void clearOpposite(EclipsePluginImport e) {
                    e.setTarget(null);
                }
                @Override
                protected void setOpposite(EclipsePluginImport e) {
                    e.setTarget(EclipsePlugin.this);
                }
            };
        }
        return incomingFAMIXEclipsePluginImport;
    }
    
    public void setIncomingFAMIXEclipsePluginImport(Collection<? extends EclipsePluginImport> incomingFAMIXEclipsePluginImport) {
        this.getIncomingFAMIXEclipsePluginImport().clear();
        this.getIncomingFAMIXEclipsePluginImport().addAll(incomingFAMIXEclipsePluginImport);
    }                    
    
        
    public void addIncomingFAMIXEclipsePluginImport(EclipsePluginImport one) {
        this.getIncomingFAMIXEclipsePluginImport().add(one);
    }   
    
    public void addIncomingFAMIXEclipsePluginImport(EclipsePluginImport one, EclipsePluginImport... many) {
        this.getIncomingFAMIXEclipsePluginImport().add(one);
        for (EclipsePluginImport each : many)
            this.getIncomingFAMIXEclipsePluginImport().add(each);
    }   
    
    public void addIncomingFAMIXEclipsePluginImport(Iterable<? extends EclipsePluginImport> many) {
        for (EclipsePluginImport each : many)
            this.getIncomingFAMIXEclipsePluginImport().add(each);
    }   
                
    public void addIncomingFAMIXEclipsePluginImport(EclipsePluginImport[] many) {
        for (EclipsePluginImport each : many)
            this.getIncomingFAMIXEclipsePluginImport().add(each);
    }
    
    public int numberOfIncomingFAMIXEclipsePluginImport() {
        return getIncomingFAMIXEclipsePluginImport().size();
    }

    public boolean hasIncomingFAMIXEclipsePluginImport() {
        return !getIncomingFAMIXEclipsePluginImport().isEmpty();
    }
    
                
    private Collection<EclipsePluginImport> outgoingFAMIXEclipsePluginImport; 

    @FameProperty(name = "outgoingFAMIXEclipsePluginImport", opposite = "source", derived = true)
    public Collection<EclipsePluginImport> getOutgoingFAMIXEclipsePluginImport() {
        if (outgoingFAMIXEclipsePluginImport == null) {
            outgoingFAMIXEclipsePluginImport = new MultivalueSet<EclipsePluginImport>() {
                @Override
                protected void clearOpposite(EclipsePluginImport e) {
                    e.setSource(null);
                }
                @Override
                protected void setOpposite(EclipsePluginImport e) {
                    e.setSource(EclipsePlugin.this);
                }
            };
        }
        return outgoingFAMIXEclipsePluginImport;
    }
    
    public void setOutgoingFAMIXEclipsePluginImport(Collection<? extends EclipsePluginImport> outgoingFAMIXEclipsePluginImport) {
        this.getOutgoingFAMIXEclipsePluginImport().clear();
        this.getOutgoingFAMIXEclipsePluginImport().addAll(outgoingFAMIXEclipsePluginImport);
    }                    
    
        
    public void addOutgoingFAMIXEclipsePluginImport(EclipsePluginImport one) {
        this.getOutgoingFAMIXEclipsePluginImport().add(one);
    }   
    
    public void addOutgoingFAMIXEclipsePluginImport(EclipsePluginImport one, EclipsePluginImport... many) {
        this.getOutgoingFAMIXEclipsePluginImport().add(one);
        for (EclipsePluginImport each : many)
            this.getOutgoingFAMIXEclipsePluginImport().add(each);
    }   
    
    public void addOutgoingFAMIXEclipsePluginImport(Iterable<? extends EclipsePluginImport> many) {
        for (EclipsePluginImport each : many)
            this.getOutgoingFAMIXEclipsePluginImport().add(each);
    }   
                
    public void addOutgoingFAMIXEclipsePluginImport(EclipsePluginImport[] many) {
        for (EclipsePluginImport each : many)
            this.getOutgoingFAMIXEclipsePluginImport().add(each);
    }
    
    public int numberOfOutgoingFAMIXEclipsePluginImport() {
        return getOutgoingFAMIXEclipsePluginImport().size();
    }

    public boolean hasOutgoingFAMIXEclipsePluginImport() {
        return !getOutgoingFAMIXEclipsePluginImport().isEmpty();
    }
    
                
    private Collection<Type> types; 

    @FameProperty(name = "types", opposite = "parentEclipsePlugin", derived = true)
    public Collection<Type> getTypes() {
        if (types == null) {
            types = new MultivalueSet<Type>() {
                @Override
                protected void clearOpposite(Type e) {
                    e.setParentEclipsePlugin(null);
                }
                @Override
                protected void setOpposite(Type e) {
                    e.setParentEclipsePlugin(EclipsePlugin.this);
                }
            };
        }
        return types;
    }
    
    public void setTypes(Collection<? extends Type> types) {
        this.getTypes().clear();
        this.getTypes().addAll(types);
    }                    
    
        
    public void addTypes(Type one) {
        this.getTypes().add(one);
    }   
    
    public void addTypes(Type one, Type... many) {
        this.getTypes().add(one);
        for (Type each : many)
            this.getTypes().add(each);
    }   
    
    public void addTypes(Iterable<? extends Type> many) {
        for (Type each : many)
            this.getTypes().add(each);
    }   
                
    public void addTypes(Type[] many) {
        for (Type each : many)
            this.getTypes().add(each);
    }
    
    public int numberOfTypes() {
        return getTypes().size();
    }

    public boolean hasTypes() {
        return !getTypes().isEmpty();
    }
    
                


}

