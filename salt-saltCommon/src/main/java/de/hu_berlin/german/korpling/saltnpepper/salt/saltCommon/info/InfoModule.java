/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This Adapter class can extends the behavior of SDocument,SCorpus,
 * SaltProject. It keeps count of specific elements (mainly Node and Relation
 * elements from SaltCommon) and adds functions to generate a XML document from
 * these numbers.
 * 
 * TODO: refactor to simplify rules for writing the attributes
 * 
 * 
 * @author jschmolling
 * 
 */
public class InfoModule {
	private static final String SCHEMA_LOCATION = "noNamespaceSchemaLocation";
	private static final String XSI_SCHEMA_LOCATION = "xsi:" + SCHEMA_LOCATION;
	private static final String XMLNS_XSI = "xmlns:xsi";
	private static final String XMLNS_XLINK = "xmlns:xlink";
	private static final String XML_XLINK_SCHEMA_INSTANCE = "http://www.w3.org/TR/xlink/";
	private static final String XML_SCHEMA_INSTANCE = "http://www.w3.org/2001/XMLSchema-instance";
	private static final String ENTRY_TAG = "entry";
	private static final String SCORPUS_INFO_TAG = "sCorpusInfo";
	private static final String SDOCUMENT_INFO_TAG = "sDocumentInfo";
	private static final String STRUCTURAL_INFO_TAG = "structuralInfo";
	private static final String SNAME_TAG = "sName";
	private static final String SANNOTATION_INFO_TAG = "sAnnotationInfo";
	private static final String GENERATED_ON_TAG = "generatedOn";
	private static final String KEY_TAG = "key";
	private static final String SVALUE_TAG = "sValue";
	private static final String OCCURANCES_TAG = "occurrences";
	private static final String SLAYERINFO_TAG = "sLayerInfo";
	private static final String SID_TAG = "id";
	private static final String SPROJECT_TAG = "saltProjectInfo";
//	private static final String STYLESHEET_INSTRUCTION = "xml-stylesheet type=\"text/xsl\" href=\"https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10/salt-info.xslt\"";
	private static final String SALT_INFO_SCHEMA_LOCATION = "https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10";
	private static final String SCHEMA_LOCATION_SPROJECT_INFO   = SALT_INFO_SCHEMA_LOCATION + "/" + "saltProjectInfo.xsd";
	private static final String SCHEMA_LOCATION_SCORPUS_INFO    = SALT_INFO_SCHEMA_LOCATION + "/" + "sCorpusInfo.xsd";
	private static final String SCHEMA_LOCATION_SDOCUMENT_INFO  = SALT_INFO_SCHEMA_LOCATION + "/" + "sDocumentInfo.xsd";
//	private static final String SCHEMA_LOCATION_STRUCTURAL_INFO = SALT_INFO_SCHEMA_LOCATION + "/" + "StructuralInfo.xsd";
	private static final String META_DATA_INFO = "metaDataInfo";
	private static final String TYPE_ATTRIBUTE = "type";
//	private static final String TOTAL_ANNOTATION_INFO = "totalSAnnotationInfo";
	private static final String XML_VERSION = "1.0";
	private static final String XHREF_TAG = "rel-location";
	
	static private Logger log = Logger.getLogger(InfoModule.class);
	

	private XMLOutputFactory xmlOutFactory = null;
	private XMLInputFactory xmlInputFactory = null;
	private final Charset charset;
	
	private Map<SElementId, SDocumentInfo> resultCache = new HashMap<SElementId, SDocumentInfo>();
	
	private final InfoModuleOptions options = new InfoModuleOptions();

	public InfoModule(){
		this.charset = Charset.forName("UTF-8");
	}
	/**
	 * Creates a new InfoModule 
	 */
	public InfoModule(Charset charset) {
		this.charset = charset;
	}
	

	/**
	 * writes the sDocumentInfo for a single SDocument into a file
	 * 
	 * @param sdoc 
	 * @param pathName Target file
	 * @return 
	 * @return
	 * @throws IOException
	 */
	public SDocumentInfo writeInfoFile(final SDocument sdoc, final File fout, SDocumentInfo result){
		FileOutputStream out        = null;
		XMLStreamWriter  tempWriter = null;
		BufferedWriter   buffWriter = null;
		SDocumentInfo results = SDocumentInfo.init(sdoc);
		newXMLFactories();
		
		try {
			if (!fout.canWrite()){
				File parentFolder = fout.getParentFile();
				parentFolder.mkdirs();
			}
			out        = new FileOutputStream(fout);
			buffWriter = new BufferedWriter(new OutputStreamWriter(out,charset));
			tempWriter = xmlOutFactory.createXMLStreamWriter(buffWriter);
			
			if(result == null){
				results = saveElementCount(sdoc);
				results.addAllMetaData(sdoc.getSMetaAnnotations());
//				results.print();
				writeSDocumentInfo(sdoc,results,tempWriter);
				if(options.isCaching()){
					resultCache.put(sdoc.getSElementId(), results);
				}
			}else{
				writeSDocumentInfo(sdoc, result, tempWriter);
			}
			
		} catch (Exception e) {
			throw new SaltException("Could not write SDocument Info XML file: " + fout.getAbsolutePath(), e);
		} finally {
			try {
				if (tempWriter != null) {
					tempWriter.close();
				}
				if (buffWriter != null){
					buffWriter.close();
				}
			} catch (Exception e) {
				// TODO delete faulty file
				// e.printStackTrace();
				throw new SaltException("Could not close SDocument Info XML file stream", e);
			} 
		}

		return results;
	}
	
	
	public void writeInfoStream(final SDocument sdoc, final XMLStreamWriter writer) throws XMLStreamException{
		SDocumentInfo results = saveElementCount(sdoc);
//		writeSDocumentInfo(sdoc,results,writer,true);
		writeSDocumentData(results, writer);
//		resultCache.clear();
	}
	
	/**
	 * writes the SCorpusInfo-XML content into a stream.
	 * If needed, temporary SDocumentInfo files will be stored in the tempDir.
	 * 
	 * @param root Root Corpus Element
	 * @param writer 
	 * @param tempDir 
	 * @throws XMLStreamException 
	 * @throws IOException 
	 */
	public void writeInfoStream(final SCorpus root, final XMLStreamWriter writer, final URI outputDir) throws XMLStreamException, IOException{
		checkOutputDirectory(outputDir);
		writer.writeStartDocument(charset.name(),"1.0");
//		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		writer.writeStartElement(SCORPUS_INFO_TAG);
		writeRootAttributes(root.getSName(), writer, SCHEMA_LOCATION_SCORPUS_INFO);
		if (root.getSId() != null) {
			writer.writeAttribute(SID_TAG, root.getSId());
		}else{
			writer.writeAttribute(SID_TAG, root.getSName());
		}
		SDocumentInfo corpusCount = writeSCorpusTree(writer, root.getSCorpusGraph(), root, "", outputDir);
		writeSDocumentData(corpusCount, writer);
//		corpusCount.print();
		writer.writeEndElement();
		writer.writeEndDocument();
		if(options.isCaching()){
			resultCache.put(root.getSElementId(), corpusCount);
		}
	}


	
	/**
	 * writes the SaltProjectInfo-XML content into a stream.
	 * If needed, temporary SDocumentInfo files will be stored in the tempDir.
	 * 
	 * @param writer
	 * @param sp
	 * @param tempDir
	 * @throws XMLStreamException
	 * @throws IOException
	 */
	public void writeInfoStream(final SaltProject sp,final XMLStreamWriter writer, 
			final URI outputDir) throws XMLStreamException, IOException {
		newXMLFactories();
		checkOutputDirectory(outputDir);
		writer.writeStartDocument(charset.name(),"1.0");
//		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		writer.writeStartElement(SPROJECT_TAG);
		String sName = sp.getSName();
		if(sName == null){
			sName = "";
			for (SCorpusGraph sgraph : sp.getSCorpusGraphs()) {
				sName += sgraph.getSName();
			}
		}
		writeRootAttributes(sName, writer, SCHEMA_LOCATION_SPROJECT_INFO);
		SDocumentInfo saltProjectInfo = SDocumentInfo.init(sp);
		List<SDocumentInfo> subs = new LinkedList<SDocumentInfo>();
		subs.add(saltProjectInfo);
		for(SCorpusGraph sCorpGraph: sp.getSCorpusGraphs()){
			final SCorpus root = sCorpGraph.getSRootCorpus().get(0);
			SDocumentInfo subCount = writeSCorpusTree(writer, sCorpGraph, root, "", outputDir);
//			saltProjectInfo = SDocumentInfo.merge(saltProjectInfo, subCount);
			subs.add(subCount);
		}
		saltProjectInfo = mergeAllTo(saltProjectInfo,subs);
		writeSDocumentData(saltProjectInfo, writer);
		writer.writeEndElement(); // end saltProjectInfo
		writer.writeEndDocument();
		// SaltProject is always the top level and will not be cached
//		if(isCaching){
//			resultCache.put(sp.getS, saltProjectInfo);
//		}
//		resultCache.clear();
		
	}
	


	private SDocumentInfo mergeAllTo(SDocumentInfo sdocInfo,
			List<SDocumentInfo> subs) {
		SDocumentInfo ret = SDocumentInfo.init(sdocInfo.getName());
		for (SDocumentInfo sub : subs) {
			ret = SDocumentInfo.merge(ret, sub);
		}
		
		return ret;
	}

	/**
	 * writes SCorpusInfo-XML content into a file.
	 * If needed, temporary SDocumentInfo files will be stored in the tempDir.
	 * 
	 * @param sc
	 * @param f target that will contain the SCorpusInfo-XML content
	 * @param tempDir
	 * @throws XMLStreamException 
	 * @throws FileNotFoundException 
	 */
	public void writeInfoFile(final SCorpus root, final File f, final URI sdocInfoRoot){
		FileOutputStream   out     = null;
		XMLOutputFactory   xmlfac  = null;
		OutputStreamWriter osw     = null;
		BufferedWriter     bwriter = null;
		XMLStreamWriter    writer  = null;
		newXMLFactories();
		try {
			File parentFolder = f.getParentFile();
			parentFolder.mkdirs();
			out     = new FileOutputStream(f);                
			xmlfac  = XMLOutputFactory.newInstance();         
			osw     = new OutputStreamWriter(out,charset);            
			bwriter = new BufferedWriter(osw);                
			writer  = xmlfac.createXMLStreamWriter(bwriter);  
			writeInfoStream(root, writer, sdocInfoRoot);
		} catch (Exception e) {
			// TODO: delete faulty file
//			e.printStackTrace();
			throw new SaltException("Could not write SCorpusInfo XML file", e);
		}finally{
			try {
				writer.flush();
				writer.close();
				bwriter.close();
				osw.close();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new SaltException("Could not close XML stream", e);
			} 
		}

//		if (isDeletingTempDirsOnExit){
//			tempDir.deleteOnExit();
//		}
//		resultCache.clear();
	}
	
	/**
	 * writes SaltProjectInfo-XML content into a file.
	 * If needed, temporary SDocumentInfo files will be stored in the tempDir.
	 * 
	 * @param sp
	 * @param f
	 * @param tempDir
	 * @return
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public void writeInfoFile(final SaltProject sp, final File f, final URI outputDir) throws FileNotFoundException, XMLStreamException{
		FileOutputStream   out     = null;
		XMLOutputFactory   xmlfac  = null;
		OutputStreamWriter osw     = null;
		BufferedWriter     bwriter = null;
		XMLStreamWriter    writer  = null;
		newXMLFactories();
		try {
			File parentFolder = f.getParentFile();
			parentFolder.mkdirs();
			out     = new FileOutputStream(f);                
			xmlfac  = XMLOutputFactory.newInstance();         
			osw     = new OutputStreamWriter(out,charset);            
			bwriter = new BufferedWriter(osw);                
			writer  = xmlfac.createXMLStreamWriter(bwriter);
			writeInfoStream(sp, writer, outputDir);
			
		} catch (Exception e) {
			throw new SaltException("Could not write XML info File for SaltProject", e);
		} finally{
			try {
				writer.close();
			} catch (Exception e) {
				throw new SaltException("Could not write XML info File for SaltProject", e);
			}
		}
//		resultCache.clear();
	}

	private void writeSDocumentInfo(SDocument sdoc, SDocumentInfo results,
			XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartDocument(charset.name(), XML_VERSION);
//		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		{
			writer.writeStartElement(SDOCUMENT_INFO_TAG);
			writeRootAttributes(sdoc.getSName(), writer, SCHEMA_LOCATION_SDOCUMENT_INFO);
			if (sdoc.getSId() != null){
				writer.writeAttribute(SID_TAG, sdoc.getSElementId().getId());
			}else{
				writer.writeAttribute(SID_TAG, sdoc.getSName());
			}
			
			writeSDocumentData(results,writer);
			
			writer.writeEndElement();
		}
		writer.writeEndDocument();
		
	}

	/**
	 * writes the count data for all layers in the given {@link SDocumentInfo} containing:
	 *  * structural info for all layers
	 *  * annotations for all layers
	 * 
	 * @param results
	 * @param w
	 * @throws XMLStreamException
	 */
	private void writeSDocumentData(SDocumentInfo results,
			XMLStreamWriter w) throws XMLStreamException {
		Map<String, Integer> allTopLevels = results.getCounts(SDocumentInfo.ALL_LAYERS);
		
		writeMetaData(results, w);
		writeStructuralInfoData(w, allTopLevels);
		writeAnnotationData(results, w, SDocumentInfo.ALL_LAYERS, allTopLevels);
		
		for (String layerName : results.getLayerNames()) {
			Map<String, Integer> topLevel = results.getCounts(layerName);
			w.writeStartElement(SLAYERINFO_TAG);
			w.writeAttribute(SNAME_TAG, layerName);
			writeStructuralInfoData(w, topLevel);
			
			writeAnnotationData(results, w, layerName, topLevel);
			w.writeEndElement();// end SLAYER_INFO
		}

		if (results.getLayerNames().isEmpty()) {
			// TODO: dont write empty layer
		}
		
	}

	private void writeMetaData(SDocumentInfo results, XMLStreamWriter w)
			throws XMLStreamException {
		w.writeStartElement(META_DATA_INFO);
		for( Entry<String, String> metaElement: results.getMetaData().entrySet()){
			w.writeStartElement(ENTRY_TAG);
			w.writeAttribute(KEY_TAG, metaElement.getKey());
			w.writeCharacters(metaElement.getValue());
			w.writeEndElement();
		}
		w.writeEndElement();
	}

	/**
	 * writes the annotation data for all annotation in the defined layer 
	 * 
	 * @param results
	 * @param w
	 * @param layerName
	 * @param topLevel
	 * @throws XMLStreamException
	 */
	private void writeAnnotationData(SDocumentInfo results, XMLStreamWriter w,
			String layerName, Map<String, Integer> topLevel)
			throws XMLStreamException {
		for (Entry<String, Integer> count : topLevel.entrySet()) {
			Set<String> annotationTypes = results.getAnnotationCount(layerName,count.getKey());
			if(annotationTypes.isEmpty()){
				continue;
			}
			for (String annotationType : annotationTypes) {
				w.writeStartElement(SANNOTATION_INFO_TAG);
				w.writeAttribute(TYPE_ATTRIBUTE, count.getKey());
				w.writeAttribute(OCCURANCES_TAG, count.getValue().toString());
				w.writeAttribute(SNAME_TAG, annotationType);
				Map<String, Integer> annotationCounts = results.getCounts(layerName,count.getKey(),annotationType);
				for (Entry<String, Integer> anno : annotationCounts.entrySet()) {
					w.writeStartElement(SVALUE_TAG);
					w.writeAttribute(OCCURANCES_TAG, anno.getValue().toString());
					w.writeCharacters(anno.getKey());
					w.writeEndElement();
				}
				w.writeEndElement();
			}
			
		}
	}

	/**
	 * writes the structuralInfo-Tag with every entry in the countMap
	 * 
	 * @param w
	 * @param countMap
	 * @throws XMLStreamException
	 */
	private void writeStructuralInfoData(XMLStreamWriter w,
			Map<String, Integer> countMap) throws XMLStreamException {
		w.writeStartElement(STRUCTURAL_INFO_TAG);
		for (Entry<String, Integer> count : countMap.entrySet()) {
			w.writeStartElement(ENTRY_TAG);
			w.writeAttribute(KEY_TAG, count.getKey());
			w.writeCharacters(count.getValue().toString());
			w.writeEndElement();
		}
		w.writeEndElement();// end STRUCTURAL INFO TAG
	}


	/**
	 * @param outputDir
	 */
	private void checkOutputDirectory(final URI outputDir) {
//		if (!outputDir.is) {
			File tDir = new File(outputDir.toFileString());
			tDir.mkdir();
			if (tDir.isDirectory()) {
				
			}else{
				throw new SaltException("Please specify a correct temp folder: " + outputDir);
			}
			
//		}
	}
	
	private String getSimpleDateString() {
		Date date = new Date();
		DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dformat.format(date);
	}

	
	/**
	 * Saves the Structural Information of one sDocument into a XML-File
	 * @param sdoc
	 */
	private SDocumentInfo saveElementCount(final SDocument sdoc) {	
		SDocumentGraph graph = sdoc.getSDocumentGraph();
		if(graph == null){
			// cached result
//			if(resultCache.containsKey(sdoc.getSElementId())){
//				log.debug("Cache hit");
//				return resultCache.remove(sdoc.getSElementId());
//			}
			try {
				// empty result
				sdoc.loadSDocumentGraph();
			} catch (SaltResourceNotFoundException e) {
				log.debug("could not load " + sdoc);
				return SDocumentInfo.init("");
			}

			graph = sdoc.getSDocumentGraph();
		}else{
			
		}
		final SDocumentInfo sDocInfo = SDocumentInfo.init(graph);
//		Counting
//		TODO: Counting Strategy
		sDocInfo.addAllObjects(graph.getSNodes());
		sDocInfo.addAllObjects(graph.getSRelations());	
//		sDocInfo.addAllMetaData(graph.getSMetaAnnotations());
		return sDocInfo;
	}
	
	private void writeRootAttributes(final String sName,
			final XMLStreamWriter writer, final String schemaLocation) throws XMLStreamException {
		writer.writeAttribute(XMLNS_XSI, XML_SCHEMA_INSTANCE);
		writer.writeAttribute(XMLNS_XLINK, XML_XLINK_SCHEMA_INSTANCE);
		writer.writeAttribute(XSI_SCHEMA_LOCATION, schemaLocation);
		writer.writeAttribute(GENERATED_ON_TAG, getSimpleDateString());
		if (sName != null){
			writer.writeAttribute(SNAME_TAG, sName);
		}else{
			writer.writeAttribute(SNAME_TAG, "");
		}
		
	}
	
	private SDocumentInfo saveElementCountTraverse(final SDocument sdoc) {
		final SDocumentInfo sDocInfo = SDocumentInfo.init(sdoc.getSDocumentGraph());
		final GraphTraverserModule gtm = new GraphTraverserModule();
		final InfoTraverserModule traverser = new InfoTraverserModule(sDocInfo);
		final EList<Node> startNodes = sdoc.getSDocumentGraph().getRoots();
//		sDocInfo.addMetaData(sdoc);
		gtm.setGraph(sdoc.getSDocumentGraph());
	
//		for (Node root : sdoc.getSDocumentGraph().getRoots()) {
//			log.debug("Root: " + root);
//		}
		if (startNodes != null){
			gtm.traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "info_sdoc_traverse_TDBF", traverser, true);
		}else{
			//TODO: Fix problem with ridges corpus
			log.debug("No root nodes found: " + sdoc.getSName());
		}
		return sDocInfo;
	}
	
	
	/**
	 * Traverses all {@link SNode} and {@link SRelation} and passes them to the {@link SDocumentInfo}
	 * to count
	 * @author jschmolling
	 *
	 */
	class InfoTraverserModule implements GraphTraverseHandler{

//		private int counter = 0;
		private final SDocumentInfo sDocInfo;
		
		public InfoTraverserModule(final SDocumentInfo sDocInfo) {
			this.sDocInfo = sDocInfo;
		}

		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Node currNode, Edge edge, Node fromNode,
				long order) {
//			log.debug("Reached: " + currNode.getId() + " from " + fromNode + " over " + edge);
			sDocInfo.add(currNode);
			sDocInfo.add(edge);
			
		}

		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Node currNode, Edge edge, Node fromNode,
				long order) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Edge edge, Node currNode, long order) {
			return (currNode instanceof SNode || currNode instanceof SRelation);
		}
		
	}


	
	
	
	/**
	 * 
	 * Walks SCorpusTree and writes the InfoFile's XML Content into the stream.
	 * 
	 * @param writer
	 * @param bwriter
	 * @param sCorpusGraph
	 * @param sCorpusRoot
	 * @param message
	 * @param tempSDocFilesDir
	 * @return 
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private SDocumentInfo writeSCorpusTree(final XMLStreamWriter writer, final SCorpusGraph sCorpusGraph, final SCorpus sCorpusRoot,
			String message, final URI sdocInfoRoot) throws XMLStreamException, IOException {
		assert writer != null;
		List<SDocumentInfo> results = new LinkedList<SDocumentInfo>();
		SDocumentInfo ret = SDocumentInfo.init(sCorpusGraph.getSName());
//		results.add(ret);
		writeSCorpusTag(writer, sCorpusRoot);
		Iterator<EObject> corpusGraphIterator = new CorpusGraphIterator(sCorpusGraph);
		for (EObject out : sCorpusGraph.getOutEdges(sCorpusRoot.getId())) {
			log.debug(message + "sCorpusOutEdge: " + out.eClass().getName());
			SDocumentInfo result;
			SElementId id;
			URI partial;
			if (out instanceof SCorpusRelation) {
				SCorpusRelation corpRel = (SCorpusRelation) out;
				SCorpus scorpus = corpRel.getSSubCorpus();
				id = scorpus.getSElementId();
				partial = getDocumentLocationURI(scorpus,sdocInfoRoot);
				
				if(options.isCaching()){
					if (resultCache.containsKey(id)){
						result = resultCache.remove(id);
					} else {
						result = writeSCorpusTree(writer, sCorpusGraph,
								scorpus, message + "\t", sdocInfoRoot);
						resultCache.put(id, result);
					}
				}else{
					result = writeSCorpusTree(writer, sCorpusGraph, scorpus,
							message + "\t", sdocInfoRoot);
				}
				
				// TODO: Which meta data should be counted?
				result.addAllMetaData(scorpus.getSMetaAnnotations());
				results.add(result);

			} else if (out instanceof SCorpusDocumentRelation) {
				final SCorpusDocumentRelation corpDocRel = (SCorpusDocumentRelation) out;
				final SDocument sdoc = corpDocRel.getSDocument();
				id = sdoc.getSElementId();
				partial = getDocumentLocationURI(sdoc,sdocInfoRoot);
				
				writeSDocumentTag(writer,sdoc);
				
				if(options.isCaching()){
					if (resultCache.containsKey(id)){
						result = resultCache.remove(id);
					}else{
						result = saveElementCount(sdoc);
						resultCache.put(id, result);
					}
				}else{
					result = saveElementCount(sdoc);
				}
				log.debug(message + "sDocumentInfo: " + result);
				result.addAllMetaData(sdoc.getSMetaAnnotations());
				results.add(result);
				if (options.isWritingAllDocumentInfo()){
					log.debug(message + "writing SDocument Info= " + partial.toFileString() + " root was: " + sdocInfoRoot.toFileString());
					File sdocInfo = new File(partial.toFileString());
					writeInfoFile(sdoc, sdocInfo,result);
				}
			} else {
				log.debug(message + "what is this : " + out);
			}
		}
		writer.writeEndElement();// end scorpus tag
		
		ret = mergeAllTo(ret, results);
		ret.print(SDocumentInfo.META_DATA);
		return ret;
	}



	private void writeSDocumentTag(XMLStreamWriter writer, SDocument sdoc) throws XMLStreamException {
		writer.writeStartElement(SDOCUMENT_INFO_TAG);
		String sname;
		if(sdoc.getSName() != null){
			sname = sdoc.getSName();
			writer.writeAttribute(SNAME_TAG, sname);
		}else{
			sname = "this corpus has no name";
			writer.writeAttribute(SNAME_TAG, sname );
		}
		if(sdoc.getSId() != null){
			writer.writeAttribute(SID_TAG, sdoc.getSId());
		}else{
			writer.writeAttribute(SID_TAG, sname);
		}
		writer.writeAttribute(XHREF_TAG, getDocumentLocationURI(sdoc, null).toString());
		writer.writeEndElement();
		
	}

	private void writeSCorpusTag(final XMLStreamWriter writer,
			final SCorpus sCorpusRoot) throws XMLStreamException {
		writer.writeStartElement(SCORPUS_INFO_TAG);
		String sname;
		if(sCorpusRoot.getSName() != null){
			sname = sCorpusRoot.getSName();
			writer.writeAttribute(SNAME_TAG, sname );
		}else{
			sname = sCorpusRoot.getSName();
			writer.writeAttribute(SNAME_TAG, "this corpus has no name");
		}
		if(sCorpusRoot.getSId() != null){
			
			writer.writeAttribute(SID_TAG, sCorpusRoot.getSId());
		}else{
			writer.writeAttribute(SID_TAG, sname);
		}
		writer.writeAttribute(XHREF_TAG, getDocumentLocationURI(sCorpusRoot, null).toString());
	}
	
	/**
	 * The XML factories should created only once
	 */
	private void newXMLFactories(){
		if (xmlOutFactory == null) {
			xmlOutFactory = XMLOutputFactory.newInstance();
		}
		if (xmlInputFactory == null) {
			xmlInputFactory = XMLInputFactory.newInstance();
		}
	}
	

	/**
	 * Creates an URI for the SDocumentInfoXML based on the given SDocument's SElementsPath
	 * and resolve it to the root Folder
	 * Example
	 * SDocument: salt:/rootCorpus/doc1
	 * root: /InfoXMLOutput/
	 * Result: /InfoXMLOutput/rootCorpus/doc1
	 * @param sdoc
	 * @param root
	 * @return
	 */
	public static URI getDocumentLocationURI(final SIdentifiableElement sdoc,
			final URI root) {
		URI uri = URI.createURI(sdoc.getSElementId().getId());
		if (uri.hasAbsolutePath()){
			uri = URI.createURI(uri.path().substring(1));
		}
//		log.debug(uri);
//		log.debug(uri.hasAbsolutePath());
//		infoFileLocation = infoFileLocation.deresolve(infoFileLocation.));
		if(root != null ){
			if(!root.hasTrailingPathSeparator()){
				uri = uri.resolve(root.appendSegment(""));
			}else{
				uri = uri.resolve(root);
			}
		}
		return uri;
	}
	


	public void setWriteAll(boolean b) {
		this.options.setWritingAllDocumentInfo(b);
		
	}

	public void setCaching(boolean b) {
		// TODO Auto-generated method stub
		this.options.setCaching(b);
	}
	
	class CorpusGraphIterator implements Iterator<EObject>{

		public CorpusGraphIterator(SCorpusGraph sCorpusGraph) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public EObject next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}





//	public SDocumentInfo createSDocumentInfo(SaltProject sp) throws XMLStreamException, IOException {
//		// TODO Auto-generated method stub
//		StringWriter s = new StringWriter();
//		XMLStreamWriter writer = xmlOutFactory.createXMLStreamWriter(s); 
//		return writeSCorpusTree(writer, sp.getSCorpusGraphs().get(0), null, "", null);
//	}
	
	class InfoModuleOptions{
		private boolean isOverwriting = false;
		public boolean isOverwriting() {
			return isOverwriting;
		}

		public void setOverwriting(boolean isOverwriting) {
			this.isOverwriting = isOverwriting;
		}

		private boolean isWritingStyleSheet = true;
		private boolean isDeletingTempFilesOnExit = false;
		private boolean isDeletingTempDirsOnExit = false;
//		private boolean isWritingSDocumentInfo = false;
		private boolean isWritingAllDocumentInfo = false;
		private boolean isCaching = false;
		public boolean isWritingStyleSheet() {
			return isWritingStyleSheet;
		}

		public void setWritingStyleSheet(boolean isWritingStyleSheet) {
			this.isWritingStyleSheet = isWritingStyleSheet;
		}

		public boolean isDeletingTempFilesOnExit() {
			return isDeletingTempFilesOnExit;
		}

		public void setDeletingTempFilesOnExit(boolean isDeletingTempFilesOnExit) {
			this.isDeletingTempFilesOnExit = isDeletingTempFilesOnExit;
		}

		public boolean isDeletingTempDirsOnExit() {
			return isDeletingTempDirsOnExit;
		}

		public void setDeletingTempDirsOnExit(boolean isDeletingTempDirsOnExit) {
			this.isDeletingTempDirsOnExit = isDeletingTempDirsOnExit;
		}

		public boolean isWritingAllDocumentInfo() {
			return isWritingAllDocumentInfo;
		}

		public void setWritingAllDocumentInfo(boolean isWritingAllDocumentInfo) {
			this.isWritingAllDocumentInfo = isWritingAllDocumentInfo;
		}

		public boolean isCaching() {
			return isCaching;
		}

		public void setCaching(boolean isCaching) {
			this.isCaching = isCaching;
		}
		
		
	}





	public void setOverwriting(boolean b) {
		this.options.setOverwriting(b);
		
	}
}
