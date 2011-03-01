package fr.inria.verveine.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.internal.compiler.batch.Main;

import ch.akuhn.fame.Repository;
import fr.inria.verveine.core.gen.famix.Entity;
import fr.inria.verveine.core.gen.famix.FAMIXModel;

public class VerveineParser extends Main {

	public final static String OUTPUT_FILE = "output.mse";
	
	private Repository famixRepo;

	public VerveineParser() {
		this(new PrintWriter(System.out),
				new PrintWriter(System.err),
				false/*systemExitWhenFinished*/,
				null/*customDefaultOptions*/,
				null/*compilationProgress*/);
		
	}

	public VerveineParser(PrintWriter outWriter, PrintWriter errWriter,	boolean systemExitWhenFinished, @SuppressWarnings("rawtypes")Map customDefaultOptions, CompilationProgress compilationProgress) {
		super(outWriter,
				errWriter,
				systemExitWhenFinished,
				customDefaultOptions,
				compilationProgress);
		
		setFamixRepo(new Repository(FAMIXModel.metamodel()));
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
			famixRepo.exportMSE(new FileWriter(OUTPUT_FILE));
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