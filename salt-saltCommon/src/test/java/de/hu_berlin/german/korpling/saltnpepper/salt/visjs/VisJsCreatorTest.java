package de.hu_berlin.german.korpling.saltnpepper.salt.visjs;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.io.BufferedWriter;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs.VisJsCreator;

public class VisJsCreatorTest extends TestCase{
	String uriPath;
	static int NODES = 0;
	static int EDGES = 1;
	static int OPTIONS = 2;
	
	
	 @Override public void setUp() throws Exception
	  {
		 uriPath = "../pcc2_random_sentence/pcc2/match_0.salt";
	  }

	//@Test
	public void test() {
		
		URI uri = URI.createFileURI(uriPath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		visJsCreator.buildJSON();
		visJsCreator.buildOptions();
		
	
		
	}

}
