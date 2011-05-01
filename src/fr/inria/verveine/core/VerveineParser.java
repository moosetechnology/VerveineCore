package fr.inria.verveine.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import ch.akuhn.fame.Repository;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.FAMIXModel;
import fr.inria.verveine.core.gen.famix.SourceLanguage;

public class VerveineParser {

	public final static String OUTPUT_FILE = "output.mse";
	
	private Repository famixRepo;

	SourceLanguage myLgge = null;

	public VerveineParser() {
		Repository repo = new Repository(FAMIXModel.metamodel());
		setFamixRepo(repo);
		if (myLgge != null) {
			repo.add( myLgge);
		}
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
	
	/**
	 * Outputting repository to a file
	 */
	public void outputMSE() {
		// * --- Outputting to a file -----------------------------------------------
		try {
			//famixRepo.exportMSE(new FileWriter(OUTPUT_FILE));
			famixRepo.exportMSE(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE),"UTF8")));
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