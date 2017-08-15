package eu.synectique.verveine.core;

import java.io.IOException;

import ch.akuhn.fame.Tower;
import ch.akuhn.fame.codegen.CodeGeneration;
import ch.akuhn.fame.parser.InputSource;


/**
 * Generates Java code from Famix Model in mse
 * The mse file may be generated in Pharo from the meta model:
 *       'famix30.mse' asFileReference writeStreamDo: [:stream | MooseModel meta exportOn: stream]
 */
public class GenerateFamix {
	
	public static final String FAMIX_MSE_FILE = "mse/famix30.mse";
	public static final String FAST_MSE_FILE  = "mse/fastJava.mse";
	
	public static final String OUTPUT_PACKAGE = "eu.synectique.verveine.core.gen";
	
	public static void main(String[] args) {
		System.out.print("[ENTER] to confirm generation of Famix classes ... ");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource input = InputSource.fromFilename(FAMIX_MSE_FILE);
        Tower t = new Tower();
        t.getMetamodel().importMSE(input);
        System.out.println("Imported " + t.getMetamodel().size() + " entities");
		CodeGeneration gen = new CodeGeneration(OUTPUT_PACKAGE, "src", "");
		gen.accept(t.getMetamodel());
	}

}
