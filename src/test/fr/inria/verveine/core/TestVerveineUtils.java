package test.fr.inria.verveine.core;

import java.util.Collection;
import java.util.Vector;

import ch.akuhn.fame.Repository;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.NamedEntity;

/**
 * Some utilities to help test extractors derived from verveine.core
 * @author anquetil
 */
public class TestVerveineUtils {

	/** Returns a Collection of all FAMIXEntities in repository of the given fmxClass
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Entity> Collection<T> selectElementsOfType(Repository repository, Class<T> fmxClass) {
		Collection<T> selection = new Vector<T>();
		for (Object obj : repository.getElements()) {
			if (fmxClass.isInstance(obj)) {
				selection.add((T) obj);
			}
		}
		return selection;
	}

	/** Returns the first FAMIXEntities in repository of the given fmxClass and with the given name
	 */
	@SuppressWarnings("unchecked")
	public static <T extends NamedEntity> T detectElement(Repository repository, Class<T> fmxClass, String name) {
		for (Object obj : repository.getElements()) {
			if (fmxClass.isInstance(obj)
				&& ((T) obj).getName().equals(name) ) {
				return (T) obj;
			}
		}
		return null;
	}

	/** Returns a Collection of FAMIXEntities in repository of the given fmxClass and with the given name
	 */
	@SuppressWarnings("unchecked")
	public static <T extends NamedEntity> Collection<T> listElements(Repository repository, Class<T> fmxClass, String name) {
		Collection<T> selection = new Vector<T>();
		for (Object obj : repository.getElements()) {
			if (fmxClass.isInstance(obj)
				&& ((T) obj).getName().equals(name) ) {
				selection.add((T) obj);
			}
		}
		return selection;
	}

}
