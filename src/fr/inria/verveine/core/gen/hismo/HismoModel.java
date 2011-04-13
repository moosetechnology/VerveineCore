// Automagically generated code, please do not change
package fr.inria.verveine.core.gen.hismo;

import ch.akuhn.fame.MetaRepository;

public class HismoModel {

    public static MetaRepository metamodel() {
        MetaRepository metamodel = new MetaRepository();
        importInto(metamodel);
        return metamodel;
    }
    
    public static void importInto(MetaRepository metamodel) {
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoMethodHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoAbstractVersion.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoClassVersion.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoClassHierarchy.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoFileHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoAbstractHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoMethodHistoryGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoCoChangeHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoClassHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoClassHistoryGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoInheritanceDefinitionHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoCoChangeVersion.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoNamespaceHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoModelHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoHistoryGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoAccessHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoEntityVersion.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoInvocationHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoAttributeHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoFolderHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoNamespaceHistoryGroup.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoMethodVersion.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoPackageHistory.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoCoChangePattern.class);
		metamodel.with(fr.inria.verveine.core.gen.hismo.HismoNamespaceVersion.class);

    }

}

