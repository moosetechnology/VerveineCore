package tests.eu.synectique.verveine.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import ch.akuhn.fame.Repository;
import eu.synectique.verveine.core.Dictionary;
import eu.synectique.verveine.core.VerveineParser;
import eu.synectique.verveine.core.VerveineUtilsForTests;
import eu.synectique.verveine.core.gen.famix.Entity;
import eu.synectique.verveine.core.gen.famix.Namespace;
import eu.synectique.verveine.core.gen.famix.SourceLanguage;

/**
 * Some utilities to help test extractors derived from verveine.core
 * @author anquetil
 */
public class VerveineTest_CommandLineArgs {
	

	protected Repository repo;
	protected VerveineParser parser;
	protected Dictionary<Object> dico;

	@Before
	public void setUp() {
		parser = new VerveineParser() {
			@Override
			protected SourceLanguage getMyLgge() {
				return null;
			}
		};
		
		repo = parser.getFamixRepo();
		dico = new Dictionary<Object>(repo);
	}

	@ Test
	public void testOutputArg() {
		String fileNameArg = "__test_output__.test";
		File outputFile = null;

		outputFile = new File(fileNameArg);
		outputFile.delete();
		assertFalse( outputFile.exists());
		outputFile = null;
		
		parser.setOption(1, new String[] {"verveineParser" , "-o" , fileNameArg});
		repo.add(dico.ensureFamixNamespaceDefault());
		parser.emitMSE();
		outputFile = new File(fileNameArg);
		assertTrue( outputFile.exists());
		assertTrue( outputFile.isFile());
		assertTrue( outputFile.length() > 0);
		outputFile.delete();
	}

	@ Test
	public void testNoOutputArg() {
		File outputFile = null;

		outputFile = new File(VerveineParser.OUTPUT_FILE);
		outputFile.delete();
		assertFalse( outputFile.exists());
		outputFile = null;
		
		parser.setOption(0, new String[] {"verveineParser"});
		repo.add(dico.ensureFamixNamespaceDefault());
		parser.emitMSE();
		outputFile = new File(VerveineParser.OUTPUT_FILE);
		assertTrue( outputFile.exists());
		assertTrue( outputFile.isFile());
		assertTrue( outputFile.length() > 0);
		outputFile.delete();
	}

	@ Test
	public void testIncrementArg() {
		File outputFile = null;
		long fileSz1 = 0;
		Namespace defNS = null;

		new File(VerveineParser.OUTPUT_FILE).delete();
		
		// first parser: empties the output file
		parser.setOption(0, new String[] {"verveineParser"});
		assertFalse( parser.linkToExisting());
		assertEquals(0, VerveineUtilsForTests.selectElementsOfType(repo, Entity.class).size());
		
		repo.add(dico.ensureFamixNamespaceDefault());
		parser.emitMSE();
		
		outputFile = new File(VerveineParser.OUTPUT_FILE);
		fileSz1 = outputFile.length();
		outputFile = null;
		
		// second parser: adds to the output file
		this.setUp();   // create a new parser
		parser.setOption(1, new String[] {"verveineParser" , "-i"});
		assertTrue( parser.linkToExisting());
		assertEquals(1, VerveineUtilsForTests.selectElementsOfType(repo, Namespace.class).size());
		defNS = VerveineUtilsForTests.selectElementsOfType(repo, Namespace.class).iterator().next();
		assertEquals(Dictionary.DEFAULT_PCKG_NAME, defNS.getName());

		repo.add(dico.ensureFamixClass(null, "AClass", defNS, true));
		parser.emitMSE();
		
		outputFile = new File(VerveineParser.OUTPUT_FILE);
		assertTrue( fileSz1 < outputFile.length());
		outputFile = null;

		// third parser: recreates a new output file
		this.setUp();   // create a new parser
		parser.setOption(0, new String[] {"verveineParser"});
		assertFalse( parser.linkToExisting());
		assertEquals(0, VerveineUtilsForTests.selectElementsOfType(repo, Entity.class).size());
		
		repo.add(dico.ensureFamixNamespaceDefault());
		parser.emitMSE();

		outputFile = new File(VerveineParser.OUTPUT_FILE);
		assertEquals(fileSz1, outputFile.length());
		outputFile.delete();
	}

}
