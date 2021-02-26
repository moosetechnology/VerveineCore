//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;
import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.internal.MultivalueSet;
import java.util.Collection;
import java.util.Iterator;

@FamePackage("FAMIX")
@FameDescription("Template")
public class Template extends ParameterizableClass {
    private ContainerEntity generic;
    private Collection<NamedEntity> templateParameters;

    public Template() {
    }

    @FameProperty(
            name = "generic",
            opposite = "templateDescriptor",
            derived = true
    )
    public ContainerEntity getGeneric() {
        return this.generic;
    }

    public void setGeneric(ContainerEntity var1) {
        if (this.generic == null) {
            if (var1 == null) {
                return;
            }
        } else if (this.generic.equals(var1)) {
            return;
        }

        ContainerEntity var2 = this.generic;
        this.generic = var1;
        if (var2 != null) {
            var2.setTemplateDescriptor((Template)null);
        }

        if (var1 != null) {
            var1.setTemplateDescriptor(this);
        }

    }

    @FameProperty(
            name = "templateParameters",
            opposite = "parentTemplate",
            derived = true
    )
    public Collection<NamedEntity> getTemplateParameters() {
        if (this.templateParameters == null) {
            this.templateParameters = new MultivalueSet<NamedEntity>() {
                protected void clearOpposite(NamedEntity var1) {
                    var1.setParentTemplate((Template)null);
                }

                protected void setOpposite(NamedEntity var1) {
                    var1.setParentTemplate(Template.this);
                }
            };
        }

        return this.templateParameters;
    }

    public void setTemplateParameters(Collection<? extends NamedEntity> var1) {
        this.getTemplateParameters().clear();
        this.getTemplateParameters().addAll(var1);
    }

    public void addTemplateParameters(NamedEntity var1) {
        this.getTemplateParameters().add(var1);
    }

    public void addTemplateParameters(NamedEntity var1, NamedEntity... var2) {
        this.getTemplateParameters().add(var1);
        NamedEntity[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            NamedEntity var6 = var3[var5];
            this.getTemplateParameters().add(var6);
        }

    }

    public void addTemplateParameters(Iterable<? extends NamedEntity> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            NamedEntity var3 = (NamedEntity)var2.next();
            this.getTemplateParameters().add(var3);
        }

    }

    public void addTemplateParameters(NamedEntity[] var1) {
        NamedEntity[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            NamedEntity var5 = var2[var4];
            this.getTemplateParameters().add(var5);
        }

    }

    public int numberOfTemplateParameters() {
        return this.getTemplateParameters().size();
    }

    public boolean hasTemplateParameters() {
        return !this.getTemplateParameters().isEmpty();
    }
}
