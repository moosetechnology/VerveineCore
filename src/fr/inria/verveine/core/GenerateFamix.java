package fr.inria.verveine.core;

import ch.akuhn.fame.Tower;
import ch.akuhn.fame.codegen.CodeGeneration;
import ch.akuhn.fame.parser.InputSource;


public class GenerateFamix {
	
	public static void main(String[] args) {
		generateCode();
	}
	
	public static void generateCode() {
		InputSource input = InputSource.fromFilename("mse/famix30_famix.mse");
        Tower t = new Tower();
        t.getMetamodel().importMSE(input);
		CodeGeneration gen = new CodeGeneration("fr.inria.verveine.core.gen", "src", "");
		gen.accept(t.getMetamodel());
	}

}
