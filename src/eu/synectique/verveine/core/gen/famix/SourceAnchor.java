// Automagically generated code, please do not change
package eu.synectique.verveine.core.gen.famix;

import ch.akuhn.fame.FameProperty;
import ch.akuhn.fame.FameDescription;
import ch.akuhn.fame.FamePackage;


@FamePackage("FAMIX")
@FameDescription("SourceAnchor")
public class SourceAnchor extends Entity {



    private SourcedEntity element;
    
    @FameProperty(name = "element", opposite = "sourceAnchor", container = true)
    public SourcedEntity getElement() {
        return element;
    }

    public void setElement(SourcedEntity element) {
        if (this.element == null ? element != null : !this.element.equals(element)) {
            SourcedEntity old_element = this.element;
            this.element = element;
            if (old_element != null) old_element.setSourceAnchor(null);
            if (element != null) element.setSourceAnchor(this);
        }
    }
/*    
    @FameProperty(name = "lineCount", derived = true)
    public Number getLineCount() {
        // TODO: this is a derived property, implement this method manually.
        throw new UnsupportedOperationException("Not yet implemented!");  
    }
*/

}

