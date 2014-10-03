package eu.synectique.verveine.core;

import ch.akuhn.fame.Tower;
import ch.akuhn.fame.codegen.CodeGeneration;
import ch.akuhn.fame.parser.InputSource;


public class GenerateFamix {
	
	public static void main(String[] args) {
		generateCode();
	}
	
	/**
	 * Generates Java code from Famix Model in mse
	 * The mse file may be generated in Pharo from the meta model: 'MooseModel meta exportString'
	 */
	public static void generateCode() {
		InputSource input = InputSource.fromFilename("mse/famix30_plugins.mse");
        Tower t = new Tower();
        t.getMetamodel().importMSE(input);
		CodeGeneration gen = new CodeGeneration("eu.synectique.verveine.core.gen", "src", "");
		gen.accept(t.getMetamodel());
	}

}
