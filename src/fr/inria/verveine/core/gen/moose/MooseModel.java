// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.moose;

import ch.akuhn.fame.MetaRepository;

public class MooseModel {

    public static MetaRepository metamodel() {
        MetaRepository metamodel = new MetaRepository();
        importInto(metamodel);
        return metamodel;
    }
    
    public static void importInto(MetaRepository metamodel) {
		metamodel.with(fr.inria.verveine.core.gen.moose.MooseGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.moose.HismoAccessHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.moose.MooseModel.class);
		metamodel.with(fr.inria.verveine.core.gen.moose.MooseAbsractGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.moose.MooseEntity.class);

    }

}

