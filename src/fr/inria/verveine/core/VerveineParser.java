package fr.inria.verveine.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Vector;

import ch.akuhn.fame.Repository;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.FAMIXModel;
import fr.inria.verveine.core.gen.famix.SourceLanguage;

public abstract class VerveineParser {

	public final static String OUTPUT_FILE = "output.mse";
	
	private Repository famixRepo;

	public VerveineParser() {
		Repository repo = new Repository(FAMIXModel.metamodel());
		setFamixRepo(repo);
	}

	public boolean linkToExisting() {
		File existingMSE = new File(OUTPUT_FILE);
		if (existingMSE.exists()) {
			this.getFamixRepo().importMSEFile(OUTPUT_FILE);
			return true;
		}
		else {
			return false;
		}
	}
	
	abstract protected SourceLanguage getMyLgge();

	/**
	 * "closes" the repository, by adding to it a SourceLanguage entity if their is none.
	 * The SourceLanguage entity is the one return by getMyLgge().
	 * Also outputs repository to a MSE file
	 */
	public void emitMSE(String outputFile) {
		try {
			emitMSE(new FileOutputStream(outputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void emitMSE(OutputStream output) {
		// Adds default SourceLanguage for the repository
		if ( (listAll(SourceLanguage.class).size() == 0) && (getMyLgge() != null) ) {
			getFamixRepo().add( getMyLgge());
		}

		// Outputting to a file
		try {
			//famixRepo.exportMSE(new FileWriter(OUTPUT_FILE));
			famixRepo.exportMSE(new BufferedWriter(new OutputStreamWriter(output,"UTF8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a Collection of all FAMIXEntities in the repository of the given fmxClass
	 */
	@SuppressWarnings("unchecked")
	public <T extends Entity> Collection<T> listAll(Class<T> fmxClass) {
		Collection<T> selection = new Vector<T>();
		for (Object obj : getFamixRepo().getElements()) {
			if (fmxClass.isInstance(obj)) {
				selection.add((T) obj);
			}
		}
		return selection;
	}

	public Repository getFamixRepo() {
		return famixRepo;
	}

	public void setFamixRepo(Repository famixRepo) {
		this.famixRepo = famixRepo;
	}

}