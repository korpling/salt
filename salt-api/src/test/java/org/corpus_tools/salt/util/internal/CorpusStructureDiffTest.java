/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

public class CorpusStructureDiffTest {

	private SCorpusGraph template;
	private SCorpusGraph other;
	
	@Before
	public void beforeEach(){
		template= SaltFactory.createSCorpusGraph();
		other= SaltFactory.createSCorpusGraph();
	}
	
	@Test
	public void whenTwoCorpusStructuresAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenTwoCorpusStructuresWithDocumentsAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenTwoCorpusStructuresAreIdenticalButDocumentStructuresDont_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph();
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).hasSize(4);
	}
	
	@Test
	public void whenTwoCorpusStructuresAreNotIdentical_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).hasSize(1);
	}

	@Test
	public void whenTwoCorpusStructuresWithMultipleRootsAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		template.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		other.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenComparingOneCorpusStructureWithMultipleRootsAndOneWithout_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		template.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).andFindDiffs()).hasSize(3);
	}
}
