package org.corpus_tools.salt.util.tests;

import static org.junit.Assert.*;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

public class SaltUtilTest {
	/**
	 * Checks if {@link SMetaAnnotation} objects are moved correctly from one {@link SMetaAnnotatableElement} object
	 * to another {@link SMetaAnnotatableElement} object.
	 * @throws Exception
	 */
	@Test
	public void testMoveSMetaAnnotations() throws Exception {
		SCorpus sCorp = SaltFactory.createSCorpus();
		SDocument sDoc = SaltFactory.createSDocument();
		
		String annoName = "metaAnno";
		String annoValue= "metaValue";
		sCorp.createMetaAnnotation(null, annoName, annoValue);
		
		SaltUtil.moveMetaAnnotations(sCorp, sDoc);
		
		assertNull(sCorp.getMetaAnnotation(annoName));
		
		// sDoc contains a SMetaAnnotation
		assertEquals(1, sDoc.getMetaAnnotations().size());
		// the SMetaAnnotation is "metaAnno"
		assertNotNull(sDoc.getMetaAnnotation(annoName));
		assertEquals(annoName, sDoc.getMetaAnnotation(annoName).getName());
		assertEquals(annoValue, sDoc.getMetaAnnotation(annoName).getValue());
		
		sCorp = SaltFactory.createSCorpus();
		String annoName2 = "metaAnno";
		String annoValue2= "metaValue_1";
		sCorp.createMetaAnnotation(null, annoName2, annoValue2);
		
		SaltUtil.moveMetaAnnotations(sCorp, sDoc);
		
		// assert that there are 2 SMetaAnnotation objects in the target document
		assertEquals(2, sDoc.getMetaAnnotations().size());
		// assert that there is a SMetaAnnotation object with name "metaAnno"
		assertNotNull(sDoc.getMetaAnnotation(annoName2));
		// assert that there is a SMetaAnnotation object with name "metaAnno_1"
		assertEquals(annoName2 + "_1", sDoc.getMetaAnnotation(annoName2 + "_1").getName());
		assertEquals(annoValue2, sDoc.getMetaAnnotation(annoName2 + "_1").getValue());
	}
	
	/**
	 * Checks if {@link SAnnotation} objects are moved correctly from one {@link SAnnotatableElement} object
	 * to another {@link SAnnotatableElement} object.
	 * @throws Exception
	 */
	@Test
	public void testMoveSAnnotations() throws Exception {
		SCorpus sCorp = SaltFactory.createSCorpus();
		SDocument sDoc = SaltFactory.createSDocument();
		
		String annoName = "anno";
		String annoValue= "value";
		sCorp.createAnnotation(null, annoName, annoValue);
		
		SaltUtil.moveAnnotations(sCorp, sDoc);
		
		assertNull(sCorp.getAnnotation(annoName));
		
		// sDoc contains a SAnnotation
		assertEquals(1, sDoc.getAnnotations().size());
		// the SAnnotation is "metaAnno"
		assertNotNull(sDoc.getAnnotation(annoName));
		assertEquals(annoName, sDoc.getAnnotation(annoName).getName());
		assertEquals(annoValue, sDoc.getAnnotation(annoName).getValue());
		
		sCorp = SaltFactory.createSCorpus();
		String annoName2 = "anno";
		String annoValue2= "value_1";
		sCorp.createAnnotation(null, annoName2, annoValue2);
		
		SaltUtil.moveAnnotations(sCorp, sDoc);
		
		// assert that there are 2 SAnnotation objects in the target document
		assertEquals(2, sDoc.getAnnotations().size());
		// assert that there is a SAnnotation object with name "metaAnno"
		assertNotNull(sDoc.getAnnotation(annoName2));
		// assert that there is a SAnnotation object with name "metaAnno_1"
		assertEquals(annoName2 + "_1", sDoc.getAnnotation(annoName2 + "_1").getName());
		assertEquals(annoValue2, sDoc.getAnnotation(annoName2 + "_1").getValue());
	}


}
