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
package org.corpus_tools.salt.util.internal.persistence;

public interface SaltXML10Dictionary {
	/** constant to address the xml-namespace prefix'saltCore'. **/
	public static final String NS_SALTCORE = "saltCore";
	/** constant to address the xml-namespace 'saltCore'. **/
	public static final String NS_VALUE_SALTCORE = "saltCore";
	/** constant to address the xml-namespace prefix'saltCommon'. **/
	public static final String NS_SALTCOMMON = "saltCommon";
	/** constant to address the xml-namespace 'saltCommon'. **/
	public static final String NS_VALUE_SALTCOMMON = "saltCommon";
	/** constant to address the xml-namespace prefix'sDocumentStructure'. **/
	public static final String NS_SDOCUMENTSTRUCTURE = "sDocumentStructure";
	/** constant to address the xml-namespace 'sDocumentStructure'. **/
	public static final String NS_VALUE_SDOCUMENTSTRUCTURE = "sDocumentStructure";
	/** constant to address the xml-namespace prefix'sCorpusStructure'. **/
	public static final String NS_SCORPUSSTRUCTURE = "sCorpusStructure";
	/** constant to address the xml-namespace 'sCorpusStructure'. **/
	public static final String NS_VALUE_SCORPUSSTRUCTURE = "sCorpusStructure";
	/** constant to address the xml-namespace prefix'xmi'. **/
	public static final String NS_XMI = "xmi";
	/** constant to address the xml-namespace 'http://www.omg.org/XMI'. **/
	public static final String NS_VALUE_XMI = "http://www.omg.org/XMI";
	/** constant to address the xml-namespace prefix'xsi'. **/
	public static final String NS_XSI = "xsi";
	/**
	 * constant to address the xml-namespace
	 * 'http://www.w3.org/2001/XMLSchema-instance'.
	 **/
	public static final String NS_VALUE_XSI = "http://www.w3.org/2001/XMLSchema-instance";

	/** constant to address the xml-element 'edges'. **/
	public static final String TAG_EDGES = "edges";
	/** constant to address the xml-element 'nodes'. **/
	public static final String TAG_NODES = "nodes";
	/**
	 * constant to address the xml-element 'sDocumentStructure:SDocumentGraph'.
	 **/
	public static final String TAG_SDOCUMENTSTRUCTURE_SDOCUMENTGRAPH = "SDocumentGraph";
	/** constant to address the xml-element 'sCorpusGraphs'. **/
	public static final String TAG_SCORPUSGRAPH = "sCorpusGraphs";
	/** constant to address the xml-element 'layers'. **/
	public static final String TAG_LAYERS = "layers";
	/** constant to address the xml-element 'labels'. **/
	public static final String TAG_LABELS = "labels";
	/** constant to address the xml-element 'sDocument'. **/
	public static final String TAG_SDOCUMENT = "sDocument";
	/** constant to address the xml-element 'SaltProject'. **/
	public static final String TAG_SALT_PROJECT = "SaltProject";

	/** constant to address the xml-attribute 'edges'. **/
	public static final String ATT_EDGES = "edges";
	/** constant to address the xml-attribute 'source'. **/
	public static final String ATT_SOURCE = "source";
	/** constant to address the xml-attribute 'nodes'. **/
	public static final String ATT_NODES = "nodes";
	/** constant to address the xml-attribute 'layers'. **/
	public static final String ATT_LAYERS = "layers";
	/** constant to address the xml-attribute 'name'. **/
	public static final String ATT_NAME = "name";
	/** constant to address the xml-attribute 'target'. **/
	public static final String ATT_TARGET = "target";
	/** constant to address the xml-attribute 'value'. **/
	public static final String ATT_VALUE = "value";
	/** constant to address the xml-attribute 'xsi:type'. **/
	public static final String ATT_XSI_TYPE = "type";
	/** constant to address the xml-attribute 'href'. **/
	public static final String ATT_HREF = "href";
	/** constant to address the xml-attribute 'namespace'. **/
	public static final String ATT_NAMESPACE = "namespace";
	/** constant to address the xml-attribute 'xmi:version'. **/
	public static final String ATT_XMI_VERSION = "version";

	public static final String ATT_TYPE = "xsi:type";

	public static final String ATT_VALUE_STRING = "valueString";

	// salt-saltCore
	public static final String TYPE_SFEATURE = "saltCore:SFeature";
	public static final String TYPE_SELEMENTID = "saltCore:SElementId";
	public static final String TYPE_SANNOTATION = "saltCore:SAnnotation";
	public static final String TYPE_SMETAANNOTATION = "saltCore:SMetaAnnotation";
	public static final String TYPE_SPROCESSINGANNOTATION = "saltCore:SProcessingAnnotation";

	// salt-saltCommon
	public static final String TAG_SDOCUMENT_GRAPH = "sDocumentStructure:SDocumentGraph";
	public static final String TAG_SALT_PROJECT_FULL = "saltCommon:SaltProject";
	public static final String TAG_SCORPUS_GRAPH = "sCorpusGraphs";

	public static final String ATT_SNAME = "sName";

	public static final String TYPE_SCORPUS = "sCorpusStructure:SCorpus";
	public static final String TYPE_SDOCUMENT = "sCorpusStructure:SDocument";
	public static final String TYPE_SCORPUS_DOCUMENT_RELATION = "sCorpusStructure:SCorpusDocumentRelation";
	public static final String TYPE_SCORPUS_RELATION = "sCorpusStructure:SCorpusRelation";

	public static final String TYPE_STIMELINE = "sDocumentStructure:STimeline";
	public static final String TYPE_SAUDIODS = "sDocumentStructure:SAudioDS";
	public static final String TYPE_STEXTUALDS = "sDocumentStructure:STextualDS";
	public static final String TYPE_STOKEN = "sDocumentStructure:SToken";
	public static final String TYPE_SSPAN = "sDocumentStructure:SSpan";
	public static final String TYPE_SSTRUCTURE = "sDocumentStructure:SStructure";
	public static final String TYPE_STEXTUAL_RELATION = "sDocumentStructure:STextualRelation";
	public static final String TYPE_SAUDIO_RELATION = "sDocumentStructure:SAudioRelation";
	public static final String TYPE_STIMELINE_RELATION = "sDocumentStructure:STimelineRelation";
	public static final String TYPE_SSPANNING_RELATION = "sDocumentStructure:SSpanningRelation";
	public static final String TYPE_SORDER_RELATION = "sDocumentStructure:SOrderRelation";
	public static final String TYPE_SDOMINANCE_RELATION = "sDocumentStructure:SDominanceRelation";
	public static final String TYPE_SPOINTING_RELATION = "sDocumentStructure:SPointingRelation";

	public static final String TYPE_SPOS = "saltSemantics:SPOSAnnotation";
	public static final String TYPE_SLEMMA = "saltSemantics:SLemmaAnnotation";
	public static final String TYPE_SCAT = "saltSemantics:SCatAnnotation";
	public static final String TYPE_SSENTENCE = "saltSemantics:SentenceAnnotation";
	public static final String TYPE_SWORD = "saltSemantics:SWordAnnotation";
	public static final String TYPE_STYPE = "saltSemantics:STypeAnnotation";
}
