// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.dude;

import ch.akuhn.fame.MetaRepository;

public class DudeModel {

    public static MetaRepository metamodel() {
        MetaRepository metamodel = new MetaRepository();
        importInto(metamodel);
        return metamodel;
    }
    
    public static void importInto(MetaRepository metamodel) {
		metamodel.with(fr.inria.verveine.core.gen.dude.CodeFragment.class);
		metamodel.with(fr.inria.verveine.core.gen.dude.Multiplication.class);
		metamodel.with(fr.inria.verveine.core.gen.dude.DuplicationGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.dude.MultiplicationGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.dude.Duplication.class);
		metamodel.with(fr.inria.verveine.core.gen.dude.CodeLine.class);

    }

}

