package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentInfo.AnnoInfoEntry;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentInfo.InfoEntry;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This Adapter class can extends the behavior of SDocument,SCorpus,
 * SaltProject. It keeps count of specific elements (mainly Node and Relation
 * elements from SaltCommon) and adds functions to generate a XML document from
 * these numbers.
 * 
 * loaded as a hole
 * 
 * @author jschmolling
 * 
 */
public class InfoModule {
	private static final String SCHEMA_LOCATION = "noNamespaceSchemaLocation";
	private static final String XSI_SCHEMA_LOCATION = "xsi:" + SCHEMA_LOCATION;
	private static final String XMLNS_XSI = "xmlns:xsi";
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
	private static final String OCCURANCES_TAG = "occurances";
	private static final String SLAYERINFO_TAG = "sLayerInfo";
	private static final String SID_TAG = "id";
	private static final String SPROJECT_TAG = "saltProjectInfo";
	private static final String STYLESHEET_INSTRUCTION = "xml-stylesheet type=\"text/xsl\" href=\"https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10/salt-info.xslt\"";
	private static final String SALT_INFO_SCHEMA_LOCATION = "https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10";
	private static final String SCHEMA_LOCATION_SPROJECT_INFO   = SALT_INFO_SCHEMA_LOCATION + "/" + "saltProjectInfo.xsd";
//	private static final String SCHEMA_LOCATION_SCORPUS_INFO    = SALT_INFO_SCHEMA_LOCATION + "/" + "sCorpusInfo.xsd";
	private static final String SCHEMA_LOCATION_SDOCUMENT_INFO  = SALT_INFO_SCHEMA_LOCATION + "/" + "sDocumentInfo.xsd";
//	private static final String SCHEMA_LOCATION_STRUCTURAL_INFO = SALT_INFO_SCHEMA_LOCATION + "/" + "StructuralInfo.xsd";
	private static final String META_DATA_INFO = "metaDataInfo";
	private static final String TYPE_ATTRIBUTE = "type";
	private static final String TOTAL_ANNOTATION_INFO = "totalSAnnotationInfo";
	
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

	private XMLOutputFactory xmlOutFactory = null;
	private XMLInputFactory xmlInputFactory = null;

	/**
	 * Creates a new InfoModule 
	 */
	public InfoModule() {
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
	 * writes the sDocumentInfo for a single SDocument into a file
	 * 
	 * @param sdoc 
	 * @param pathName Target file
	 * @return 
	 * @return
	 * @throws IOException
	 */
	private SDocumentInfo writeInfoFile(final SDocument sdoc, final File fout, final boolean spHeader){
		FileOutputStream out        = null;
		XMLStreamWriter  tempWriter = null;
		BufferedWriter   buffWriter = null;
		newXMLFactories();
		SDocumentInfo results = null;
		
		try {
			File parentFolder = fout.getParentFile();
			parentFolder.mkdirs();
			out        = new FileOutputStream(fout);
			buffWriter = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
			tempWriter = xmlOutFactory.createXMLStreamWriter(buffWriter);

			results = saveElementCount(sdoc);
			writeSDocumentInfo(sdoc,results,tempWriter,spHeader);
		} catch (Exception e) {
			// TODO: Delete Faulty file
//			e.printStackTrace();
			throw new SaltException("Could not write SDocument Info XML file: " + fout.getAbsolutePath(), e);
		} finally {
			try {
				if (tempWriter != null) {
					tempWriter.flush();
					tempWriter.close();
				}
				if (buffWriter != null){
					buffWriter.flush();
					buffWriter.close();
				}
			} catch (Exception e) {
				//TODO delete faulty file 
//				e.printStackTrace();
				throw new SaltException("Could not close SDocument Info XML file stream", e);
			} 
		}
		return results;
	}
	
	public void writeInfoStream(final SDocument sdoc, final XMLStreamWriter writer) throws XMLStreamException{
		SDocumentInfo results = saveElementCount(sdoc);
		writeSDocumentInfo(sdoc,results,writer,true);
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
		writer.writeStartDocument("UTF-8","1.0");
		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		writer.writeStartElement(SPROJECT_TAG);
		writer.writeAttribute(XMLNS_XSI, XML_SCHEMA_INSTANCE);
		writer.writeAttribute(XSI_SCHEMA_LOCATION, SCHEMA_LOCATION_SPROJECT_INFO);
		writer.writeAttribute(GENERATED_ON_TAG, getSimpleDateString());
		writer.writeAttribute(SNAME_TAG, root.getSName());
		writeSCorpusTree(writer, root.getSCorpusGraph(), root, "", outputDir);

		writer.writeEndElement();
		writer.writeEndDocument();
	}
	private int writeXMLHeader() {
		return 0;
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
		writer.writeStartDocument("UTF-8","1.0");
		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		writer.writeStartElement(SPROJECT_TAG);
		writer.writeAttribute(XMLNS_XSI, XML_SCHEMA_INSTANCE);
		writer.writeAttribute(XSI_SCHEMA_LOCATION, SCHEMA_LOCATION_SPROJECT_INFO);
		writer.writeAttribute(GENERATED_ON_TAG, getSimpleDateString());
		String sName = sp.getSName();
		if(sName == null){
			sName = "";
			for (SCorpusGraph sgraph : sp.getSCorpusGraphs()) {
				sName += sgraph.getSName();
			}
		}
		writer.writeAttribute(SNAME_TAG, sName);
		for(SCorpusGraph sCorpGraph: sp.getSCorpusGraphs()){
			final SCorpus root = sCorpGraph.getSRootCorpus().get(0);
			writeSCorpusTree(writer, sCorpGraph, root, "", outputDir);
		}

		writer.writeEndElement();
		writer.writeEndDocument();
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
			osw     = new OutputStreamWriter(out,"UTF-8");            
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
			osw     = new OutputStreamWriter(out,"UTF-8");            
			bwriter = new BufferedWriter(osw);                
			writer  = xmlfac.createXMLStreamWriter(bwriter);
			writeInfoStream(sp, writer, outputDir);
			
		} catch (Exception e) {
			throw new SaltException("Could not write XML info File for SaltProject", e);
		} finally{
			try {
				writer.flush();
				writer.close();
				bwriter.close();
				osw.close();
				out.close();
			} catch (Exception e) {
				throw new SaltException("Could not write XML info File for SaltProject", e);
			}
		}

//		if (isDeletingTempDirsOnExit){
//			tempDir.deleteOnExit();
//		}
	}

	public void writeInfoFile(final SDocument sDocument, final File file) {
		writeInfoFile(sDocument, file,true);
	}	
	/**
	 * Writes content for the sDocumentInfoTag
	 * 
	 * @param sdoc
	 * @param results
	 * @param writer
	 * @throws XMLStreamException
	 */
	private void writeSDocumentInfo(final SDocument sdoc, final SDocumentInfo results,
			final XMLStreamWriter writer, final boolean spHeader) throws XMLStreamException {
		writer.writeStartDocument();
		writer.writeProcessingInstruction(STYLESHEET_INSTRUCTION);
		String fakeName = (sdoc.getSName()==null)?"unamed SDocument":sdoc.getSName();
		if (spHeader) {
			writer.writeStartElement(SPROJECT_TAG);
			writer.writeAttribute(XMLNS_XSI, XML_SCHEMA_INSTANCE);
			writer.writeAttribute(XSI_SCHEMA_LOCATION, SCHEMA_LOCATION_SDOCUMENT_INFO);
			writer.writeAttribute(GENERATED_ON_TAG, getSimpleDateString());
			writer.writeAttribute(SNAME_TAG, fakeName);
			
		}
		if (spHeader){//Fake SCorpus
			writer.writeStartElement(SCORPUS_INFO_TAG);
			writer.writeAttribute(SNAME_TAG, fakeName);
			writer.writeAttribute(SID_TAG, fakeName + "_id");
		}
		writer.writeStartElement(SDOCUMENT_INFO_TAG);
		writer.writeAttribute(SID_TAG, sdoc.getSId());
		if (sdoc.getSName() != null) {
			writer.writeAttribute(SNAME_TAG, sdoc.getSName());
		}else{
			writer.writeAttribute(SNAME_TAG, "Error: Unnamed SDocument");
		}
//		writer.writeAttribute(SID_TAG, sdoc.getSId());
		writerMetaData(sdoc,writer);
		Collection<InfoEntry> allEntries = results.getAllEntries();
		writeTotalSAnnotations(results,writer);
		writeStructuralInfoElement(allEntries,writer);
		for (String sLayerId : results.getLayerNames()) {
			writeSLayerInfoElement(results, writer, sLayerId);
		}
//		writeSLayerInfoElement(results, writer,NOSLAYER_TAG);
		writer.writeEndElement();
		if(spHeader){
			writer.writeEndElement();
		}
		if(spHeader){
			writer.writeEndElement();
		}
		writer.writeEndDocument();
	}

//	/**
//	 * 
//	 * @param results
//	 * @param writer
//	 * @throws XMLStreamException
//	 */
//	private void writerMetaData(SDocumentInfo results, XMLStreamWriter writer) throws XMLStreamException {
//		if(results.metaData != null && !results.metaData.isEmpty()){
//			writer.writeStartElement(META_DATA_INFO);
//			for (Entry<String, String> name : results.metaData.entrySet()) {
//				writer.writeStartElement(ENTRY_TAG);
//				writer.writeAttribute(KEY_TAG,name.getKey());
//				writer.writeCharacters(name.getValue());
//				writer.writeEndElement();
//			}
//			writer.writeEndElement();
//		}
//		
//	}
//
//	private void writeTotalSAnnotations(SDocumentInfo resultsList,
//			XMLStreamWriter writer) throws XMLStreamException {
//		writer.writeStartElement(TOTAL_ANNOTATION_INFO);
//		for (AnnoInfoEntry results : res) {
//			for (String sLayerId : results.layeredInfoEntries.keySet()) {
//				for (AnnoInfoEntry annoEntry : results.getAnnoEntries(sLayerId)) {
//					writeSAnnotationInfoElement(annoEntry,writer);
//				}
//			}
//		}
//		writer.writeEndElement();
//		
//	}
	/**
	 * Writes result for all Annotations on document Level
	 * Should be used with merged results
	 * @param results
	 * @param writer
	 * @throws XMLStreamException
	 */
	private void writeTotalSAnnotations(SDocumentInfo results,
			XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(TOTAL_ANNOTATION_INFO);
//		for (String sLayerId : results.layeredInfoEntries.keySet()) {
		System.out.println(results);
			for (AnnoInfoEntry annoEntry : results.getAllAnnoInfoEntries()) {
				writeSAnnotationInfoElement(annoEntry,writer);
			}
//		}
		writer.writeEndElement();
	}

	/**
	 * writes a SLayerInfoTag
	 * 
	 * @param results
	 * @param writer
	 * @throws XMLStreamException
	 */
	private void writeSLayerInfoElement(final SDocumentInfo results,
			final XMLStreamWriter writer, final String sLayerIdentifier) throws XMLStreamException {
		writer.writeStartElement(SLAYERINFO_TAG);
		writer.writeAttribute(SNAME_TAG, sLayerIdentifier);
//		writer.writeAttribute(SID_TAG, sLayerId);
//		System.out.println("Anno entries for " + sLayerIdentifier +" :" + results.getAnnoEntries(sLayerIdentifier).size());
//		List<AnnoInfoEntry> tokenAnnos = new BasicEList<InfoModule.AnnoInfoEntry>();
		
		// TODO: Groups
//		for (AnnoInfoEntry annoEntry : results.getAnnoEntries(sLayerIdentifier)) {
//			if (annoEntry.type.equals("SToken")){
//				tokenAnnos.add(annoEntry);
//			}
//		}
		
//		writer.writeStartElement("tokenAnnos");
//		for (AnnoInfoEntry annoEntry : tokenAnnos) {
//			writeSAnnotationInfoElement(annoEntry,writer);
//		}
//		writer.writeEndElement();
		writeStructuralInfoElement(results.getEntries(sLayerIdentifier), writer);
		
		for (AnnoInfoEntry annoEntry : results.getAnnoEntries(sLayerIdentifier)) {
			writeSAnnotationInfoElement(annoEntry,writer);
		}
		writer.writeEndElement();
	}

	private void writeSAnnotationInfoElement(final AnnoInfoEntry annoEntry,
			final XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(SANNOTATION_INFO_TAG);
		writer.writeAttribute(SNAME_TAG, annoEntry.name);
		writer.writeAttribute(TYPE_ATTRIBUTE, annoEntry.type);
		writer.writeAttribute(OCCURANCES_TAG, String.valueOf(annoEntry.getCount()));
		for (InfoEntry sValueInfoEntries : annoEntry.getSValuesInfoEntries()) {
			writer.writeStartElement(SVALUE_TAG);
			writer.writeAttribute(OCCURANCES_TAG, Long.toString(sValueInfoEntries.getCount()));
			writer.writeCharacters(sValueInfoEntries.name);
			writer.writeEndElement();
		}
		writer.writeEndElement();
		
	}

	/**
	 * writes an structuralInfo-Tag to the {@link XMLStreamWriter}
	 * if there are any entries to write
	 * @param allEntries
	 * @param writer
	 * @throws XMLStreamException
	 */
	private void writeStructuralInfoElement(final Collection<InfoEntry> allEntries,
			final XMLStreamWriter writer) throws XMLStreamException {
		if (allEntries != null && !allEntries.isEmpty()){
			writer.writeStartElement(STRUCTURAL_INFO_TAG);
			for (InfoEntry infoEntry : allEntries) {
				writer.writeStartElement(ENTRY_TAG);
				writer.writeAttribute(KEY_TAG, infoEntry.name);
				writer.writeCharacters(String.valueOf(infoEntry.getCount()));
				writer.writeEndElement();
			}
			writer.writeEndElement();
		}
		
	}

	/**
	 * Saves the Structural Information of one sDocument into a XML-File
	 * @param sdoc
	 */
	private SDocumentInfo saveElementCount(final SDocument sdoc) {		
		final SDocumentInfo sDocInfo = SDocumentInfo.init(sdoc.getSDocumentGraph());
		final SDocumentGraph sdocgraph = sdoc.getSDocumentGraph();
//		Counting
//		TODO: Counting Strategy
		sDocInfo.addAllObjects(sdocgraph.getSNodes());
		sDocInfo.addAllObjects(sdocgraph.getSRelations());
//		sDocInfo.addAllObjects(sdocgraph.getSTokens());
//		sDocInfo.addAllObjects(sdocgraph.getSSpans());
//		sDocInfo.addAllObjects(sdocgraph.getSTextualRelations());
//		sDocInfo.addAllObjects(sdocgraph.getSSpanningRelations());
//		sDocInfo.addAllObjects(sdocgraph.getSPointingRelations());
//		si.addAllObjects(si.sdocgraph.getSDominanceRelations());		
		return sDocInfo;
	}
	
	private SDocumentInfo saveElementCountTraverse(final SDocument sdoc) {
		final SDocumentInfo sDocInfo = SDocumentInfo.init(sdoc.getSDocumentGraph());
		final GraphTraverserModule gtm = new GraphTraverserModule();
		final InfoTraverserModule traverser = new InfoTraverserModule(sDocInfo);
		final EList<Node> startNodes = sdoc.getSDocumentGraph().getRoots();
//		sDocInfo.addMetaData(sdoc);
		gtm.setGraph(sdoc.getSDocumentGraph());
	
//		for (Node root : sdoc.getSDocumentGraph().getRoots()) {
//			System.out.println("Root: " + root);
//		}
		if (startNodes != null){
			gtm.traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "info_sdoc_traverse_TDBF", traverser, true);
		}else{
			//TODO: Fix problem with ridges corpus
			System.out.println("No root nodes found: " + sdoc.getSName());
		}
		return sDocInfo;
	}
	
	/**
	 * This class counts {@link SNode}  and {@link SRelation} and their {@link SAnnotation} objects.
	 * Counts and SValueText 
	 * Annotations and SNode/SRelations are counted in every layer they appear.
	 * 
	 * @author jschmolling
	 *
	 */
	
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
//			System.out.println("Reached: " + currNode.getId() + " from " + fromNode + " over " + edge);
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
		SDocumentInfo results = null;
		writer.writeStartElement(SCORPUS_INFO_TAG);
		if(sCorpusRoot.getSName() != null){
			writer.writeAttribute(SNAME_TAG, sCorpusRoot.getSName());
		}else{
			writer.writeAttribute(SNAME_TAG, "his corpus has no name");
		}
		writer.writeAttribute(SID_TAG, sCorpusRoot.getSId());
		writerMetaData(sCorpusGraph, writer);

		for (EObject out : sCorpusGraph.getOutEdges(sCorpusRoot.getId())) {
			if (out instanceof SCorpusRelation) {
				SCorpusRelation corpRel = (SCorpusRelation) out;
				SDocumentInfo result = writeSCorpusTree(writer, sCorpusGraph, corpRel.getSSubCorpus(),
						message + "\t", sdocInfoRoot);
//				results.merge(result);
				
			} else if (out instanceof SCorpusDocumentRelation) {
				final SCorpusDocumentRelation corpDocRel = (SCorpusDocumentRelation) out;
				final SDocument sdoc = corpDocRel.getSDocument();
				
				URI partial = getDocumentLocationURI(sdoc,sdocInfoRoot);
				System.out.println("Insert partial:" + partial.toFileString() + " root was: " + sdocInfoRoot.toFileString());
				File sdocInfo = new File(partial.toFileString());
				
				if(!this.isOverwriting() && sdocInfo.canRead() ){
					// File exist and should not be overwritten 
					System.out.println("File was already generated");
				} else if (isOverwriting) {
					System.out.println("Generating partial to document: " + partial.toFileString());
					sdoc.printInfo(partial);
				} else {
					throw new SaltException("Can't find sDocumentInfo file:" + sdocInfo);
				}
//				if (sdoc.getSDocumentGraphLocation() != null){
//					System.out.println("Generating partial to document: " + partial.toFileString());
//					sdoc.printInfo(partial);
////				}else if(this.isOverwriting){
////					System.out.println("Deleting old file " + sdocInfo.getAbsolutePath());
////					sdocInfo.delete();
////					sdoc.printInfo(partial);
//				}else{
//					System.out.println("File was already generated");
//				}
				insertSDocumentTempFile(writer,sdocInfo);
				
			}
		}
//		writeTotalSAnnotations(results, writer);
		writer.writeEndElement();
		return results;
	}

	/**
	 * Creates an URI for the SDocumentInfoXML based on the given SDocument's SElementsPath
	 * and resolve it to the root Folder
	 * Example
	 * SDocument: salt:/rootCorpus/doc1
	 * root: /InfoXMLOutput/
	 * Result: /InfoXMLOutput/rootCorpus/doc1.xml
	 * @param sdoc
	 * @param root
	 * @return
	 */
	public static URI getDocumentLocationURI(final SIdentifiableElement sdoc,
			final URI root) {
		URI infoFileLocation =  URI.createFileURI("." + sdoc.getSElementPath().path()).appendFileExtension("xml");
		URI partial = infoFileLocation.resolve(root);
		return partial;
	}

	private void writerMetaData(SMetaAnnotatableElement annotatable,
			XMLStreamWriter writer) throws XMLStreamException {
		EList<SMetaAnnotation> metaAnnos = annotatable.getSMetaAnnotations();
		if (metaAnnos != null && !metaAnnos.isEmpty()){
			writer.writeStartElement(META_DATA_INFO);
			for (SMetaAnnotation metaAnno : metaAnnos) {
				writer.writeStartElement(ENTRY_TAG);
				writer.writeAttribute(KEY_TAG, metaAnno.getName());
				writer.writeCharacters(metaAnno.getSValueSTEXT());
				writer.writeEndElement();
			}
			writer.writeEndElement();
		}
	}

	/**
	 * 
	 * 
	 * @param writer
	 * @param bwriter
	 * @param tempFile
	 * @param sDocument
	 * @throws IOException
	 * @throws XMLStreamException
	 */
	private void insertSDocumentTempFile(final XMLStreamWriter writer, final File tempFile)  {
		FileInputStream in = null;
		InputStreamReader reader = null;
		BufferedReader breader = null;
		XMLEventReader xmlReader = null;
//		File tempFile = null;
		if(!tempFile.canRead()){
			throw new SaltException("Can't read sDocument temp file: " + tempFile);
		}
		try {
//			tempFile = sDocInfoPartial.get();
			in = new FileInputStream(tempFile);
			reader = new InputStreamReader(in);
			breader = new BufferedReader(reader);
			xmlReader = xmlInputFactory.createXMLEventReader(breader);
			XMLEvent event = xmlReader.nextEvent();
			int c = 0;
			while(event.getEventType() != XMLEvent.END_DOCUMENT){
				c = addEventToXMLStream(writer, event, c);
				event = xmlReader.nextEvent();
			}
		} catch (FileNotFoundException e) {
			throw new SaltException("tried to insert infoFile into stream: Can't find tempory file",e);
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			//TODO: abort: Delete File
			tempFile.deleteOnExit();
			throw new SaltException("Exception while writing to the XML Stream",e);
			
		}finally{
			try {
				xmlReader.close();
				breader.close();
				reader.close();
				in.close();
			} catch (Exception e) {
				throw new SaltException("Could not close stream while reading to " + tempFile.getAbsolutePath(),e);
			}
		}
	}

	/**
	 * Similar to XMLEventWriter.add()
	 * This function returns the number of tags that are open,
	 * because certain elements (sCorpusInfo and saltProjectInfo) should not be inserted into
	 * another SaltInfo-XML
	 * Caution: No test code 
	 * @param writer
	 * @param event
	 * @return 
	 * @throws XMLStreamException
	 */
	private int addEventToXMLStream(final XMLStreamWriter writer,
			XMLEvent event, int elementCounter) throws XMLStreamException {
		switch (event.getEventType()) {
			case XMLEvent.DTD:{
				//Do nothing
				break;
			}
			case XMLEvent.START_DOCUMENT:{
				// Do nothing
				break;
			}
			case XMLEvent.START_ELEMENT:{
				StartElement startElement = (StartElement) event;
				QName qname = startElement.getName();
				if(qname.getLocalPart().equals(SPROJECT_TAG) ||
				   qname.getLocalPart().equals(SCORPUS_INFO_TAG)){
					
				} else {
					++elementCounter;
					writer.writeStartElement(qname.getPrefix(), qname.getLocalPart(), qname.getNamespaceURI());
					//TODO:Namespaces
					Iterator<?> attributes = startElement.getAttributes();
					while(attributes.hasNext()){
						Attribute attribute = (Attribute) attributes.next();
						QName qnameAtt = attribute.getName();
						if(qnameAtt.getLocalPart().equals(SCHEMA_LOCATION) ||
						   qnameAtt.getLocalPart().equals(GENERATED_ON_TAG)){
							// Ignore
						}else{
							writer.writeAttribute(qnameAtt.getPrefix(),qnameAtt.getNamespaceURI(), qnameAtt.getLocalPart(), attribute.getValue());
						}
					}
				}
				break;
			}
			case XMLEvent.NAMESPACE:{
				//Do nothing
				break;
			}
			case XMLEvent.COMMENT:{
				//Do nothing
				break;
			}
			case XMLEvent.PROCESSING_INSTRUCTION:{
				// Do nothing
				break;
			}
			case XMLEvent.CHARACTERS:
			case XMLEvent.CDATA:{
				Characters chararcters = (Characters) event;
				if(chararcters.isCData()){
					writer.writeCData(chararcters.getData());
				}else{
					writer.writeCharacters(chararcters.getData());
				}
				break;
			}
			case XMLEvent.ENTITY_REFERENCE:{
				EntityReference entRef = (EntityReference) event;
				writer.writeEntityRef(entRef.getName());
				break;
			}
			case XMLEvent.ATTRIBUTE:{
				Attribute att = (Attribute) event;
				QName qname = att.getName();
				writer.writeAttribute(qname.getPrefix(), qname.getNamespaceURI(), qname.getLocalPart(), att.getValue());
				break;
			}
			case XMLEvent.END_ELEMENT:{
				//Do Something
				--elementCounter;
				if (elementCounter >= 0) {
					writer.writeEndElement();
				}
				break;
			}
			case XMLEvent.END_DOCUMENT:{
				//Do nothing
				break;
			}
			default:
				break;
		}
		return elementCounter;
	}	
}
