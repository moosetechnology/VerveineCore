// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.famix;

import ch.akuhn.fame.internal.MultivalueSet;
import java.util.*;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("NamedEntity")
public class NamedEntity extends SourcedEntity {



    public NamedEntity() {
		super();
		this.setIsFinal(Boolean.FALSE);
		this.setIsPrivate(Boolean.FALSE);
		this.setIsProtected(Boolean.FALSE);
		this.setIsPublic(Boolean.FALSE);
		this.setIsAbstract(Boolean.FALSE);
	}

	private Boolean isAbstract;
    
    @FameProperty(name = "isAbstract")
    public Boolean getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(Boolean isAbstract) {
        this.isAbstract = isAbstract;
    }
    
    private Boolean isPrivate;
    
    @FameProperty(name = "isPrivate")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    
    private Boolean isPackage;
    
    @FameProperty(name = "isPackage")
    public Boolean getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Boolean isPackage) {
        this.isPackage = isPackage;
    }
    
    private String name;
    
    @FameProperty(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private Package parentPackage;
    
    @FameProperty(name = "parentPackage", opposite = "childNamedEntities")
    public Package getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(Package parentPackage) {
        if (this.parentPackage != null) {
            if (this.parentPackage.equals(parentPackage)) return;
            this.parentPackage.getChildNamedEntities().remove(this);
        }
        this.parentPackage = parentPackage;
        if (parentPackage == null) return;
        parentPackage.getChildNamedEntities().add(this);
    }
    
    private Boolean isStub;
    
    @FameProperty(name = "isStub")
    public Boolean getIsStub() {
        return isStub;
    }

    public void setIsStub(Boolean isStub) {
        this.isStub = isStub;
    }
    
    private Boolean isPublic;
    
    @FameProperty(name = "isPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

      private Boolean isProtected;
    
    @FameProperty(name = "isProtected")
    public Boolean getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }
    
    private Collection<String> modifiers; 

    @FameProperty(name = "modifiers")
    public Collection<String> getModifiers() {
        if (modifiers == null) modifiers = new HashSet<String>();
        return modifiers;
    }
    
    public void setModifiers(Collection<? extends String> modifiers) {
        this.getModifiers().clear();
        this.getModifiers().addAll(modifiers);
    }                    

    public void addModifiers(String one) {
        this.getModifiers().add(one);
    }   
    
    public void addModifiers(String one, String... many) {
        this.getModifiers().add(one);
        for (String each : many)
            this.getModifiers().add(each);
    }   
    
    public void addModifiers(Iterable<? extends String> many) {
        for (String each : many)
            this.getModifiers().add(each);
    }   
                
    public void addModifiers(String[] many) {
        for (String each : many)
            this.getModifiers().add(each);
    }
    
    public int numberOfModifiers() {
        return getModifiers().size();
    }

    public boolean hasModifiers() {
        return !getModifiers().isEmpty();
    }
    
                    
    private Collection<Invocation> receivingInvocations; 

    @FameProperty(name = "receivingInvocations", opposite = "receiver", derived = true)
    public Collection<Invocation> getReceivingInvocations() {
        if (receivingInvocations == null) {
            receivingInvocations = new MultivalueSet<Invocation>() {
                @Override
                protected void clearOpposite(Invocation e) {
                    e.setReceiver(null);
                }
                @Override
                protected void setOpposite(Invocation e) {
                    e.setReceiver(NamedEntity.this);
                }
            };
        }
        return receivingInvocations;
    }
    
    public void setReceivingInvocations(Collection<? extends Invocation> receivingInvocations) {
        this.getReceivingInvocations().clear();
        this.getReceivingInvocations().addAll(receivingInvocations);
    }                    
    
        
    public void addReceivingInvocations(Invocation one) {
        this.getReceivingInvocations().add(one);
    }   
    
    public void addReceivingInvocations(Invocation one, Invocation... many) {
        this.getReceivingInvocations().add(one);
        for (Invocation each : many)
            this.getReceivingInvocations().add(each);
    }   
    
    public void addReceivingInvocations(Iterable<? extends Invocation> many) {
        for (Invocation each : many)
            this.getReceivingInvocations().add(each);
    }   
                
    public void addReceivingInvocations(Invocation[] many) {
        for (Invocation each : many)
            this.getReceivingInvocations().add(each);
    }
    
    public int numberOfReceivingInvocations() {
        return getReceivingInvocations().size();
    }

    public boolean hasReceivingInvocations() {
        return !getReceivingInvocations().isEmpty();
    }
    
                
    @FameProperty(name = "belongsTo", derived = true)
    public ContainerEntity getBelongsTo() {
        // this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("NamedEntity.getBelongsTo() Not implemented in this class, use the proper subclass ("+this.getClass().getName()+")"); 
    }
    
    private Boolean isFinal;
    
    @FameProperty(name = "isFinal")
    public Boolean getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(Boolean isFinal) {
        this.isFinal = isFinal;
    }
    

	@Override
	public String toString() {
		// mainly for debugging purposes (in Eclipse debugger)
		return "a " + this.getClass().getSimpleName() + " named: " + this.getName();
	}
    

}

