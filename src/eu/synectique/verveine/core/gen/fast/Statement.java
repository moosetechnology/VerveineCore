// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.fast;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAST")
@FameDescription("Statement")
public class Statement extends ScopableEntity {



    private StatementBlock statementContainer;
    
    @FameProperty(name = "statementContainer", opposite = "statements")
    public StatementBlock getStatementContainer() {
        return statementContainer;
    }

    public void setStatementContainer(StatementBlock statementContainer) {
        if (this.statementContainer != null) {
            if (this.statementContainer.equals(statementContainer)) return;
            this.statementContainer.getStatements().remove(this);
        }
        this.statementContainer = statementContainer;
        if (statementContainer == null) return;
        statementContainer.getStatements().add(this);
    }
    


}

