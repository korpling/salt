package de.hub.corpling.pepper.modules.treetagger.java;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.component.ComponentContext;

import de.hub.corpling.pepper.pepperExceptions.PepperConvertException;
import de.hub.corpling.pepper.pepperExceptions.PepperModuleException;
import de.hub.corpling.pepper.pepperInterface.FormatDefinition;
import de.hub.corpling.pepper.pepperInterface.PepperImporter;
import de.hub.corpling.pepper.pepperInterface.PepperInterfaceFactory;
import de.hub.corpling.pepper.pepperInterface.RETURNING_MODE;
import de.hub.corpling.pepper.pepperInterface.impl.PepperImporterImpl;
import de.hub.corpling.pepper.treetagger.Annotation;
import de.hub.corpling.pepper.treetagger.Document;
import de.hub.corpling.pepper.treetagger.Token;
import de.hub.corpling.pepper.treetagger.resources.TabResourceFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;

public class TreetaggerImporterJava extends PepperImporterImpl implements PepperImporter
{
	//TODO there shall be a possibility to read from Property-file
	/**
	 * Specifies the seperator, which has to be set between to the texts of two token.
	 */
	private String sepreator= " ";
	
	public TreetaggerImporterJava()
	{
		super();
		this.name= "TreetaggerImporterJava";
		//for testing the symbolic name has to be set without osgi
		if (	(this.getSymbolicName()==  null) ||
				(this.getSymbolicName().equalsIgnoreCase("")))
			this.setSymbolicName("de.hub.corpling.pepper.modules.Treetagger");
		this.init();
		System.out.println(this.getName()+" is created...");
	}

	protected void init()
	{
		this.supportedFormats= new BasicEList<FormatDefinition>();
		FormatDefinition formatDef= PepperInterfaceFactory.eINSTANCE.createFormatDefinition();
		formatDef.setFormatName("treetagger");
		formatDef.setFormatVersion("1.0");
		this.supportedFormats.add(formatDef);
	}
	
	private EList<FormatDefinition> supportedFormats= null;
	
	@Override
	public EList<FormatDefinition> getSupportedFormats() 
	{
		return(this.supportedFormats);
	}

	/**
	 * Stores relation between documents and their resource 
	 */
	private Map<SElementId, URI> documentResourceTable= null;
	
	@Override
	public void importCorpusStructure(SCorpusGraph corpusGraph)
			throws PepperModuleException 
	{
		this.setSCorpusGraph(corpusGraph);
		if (this.getSCorpusGraph()== null)
			throw new PepperModuleException(this.name+": Cannot start with importing corpus, because salt project isn´t set.");
		
		if (this.getCorpusDefinition()== null)
			throw new PepperModuleException(this.name+": Cannot start with importing corpus, because no corpus definition to import is given.");
		if (this.getCorpusDefinition().getCorpusPath()== null)
			throw new PepperModuleException(this.name+": Cannot start with importing corpus, because the path of given corpus definition is null.");
		
		if (this.getCorpusDefinition().getCorpusPath().isFile())
		{
			this.documentResourceTable= new Hashtable<SElementId, URI>();
			System.out.println("uri before trim: "+this.getCorpusDefinition().getCorpusPath());
			//clean uri in corpus path (if it is a folder and ends with/, / has to be removed)
			if (	(this.getCorpusDefinition().getCorpusPath().toFileString().endsWith("/")) || 
					(this.getCorpusDefinition().getCorpusPath().toFileString().endsWith("\\")))
			{
				this.getCorpusDefinition().setCorpusPath(this.getCorpusDefinition().getCorpusPath().trimSegments(1));
			}
			
			System.out.println("uri after trim: "+this.getCorpusDefinition().getCorpusPath());
			try {
				this.createCorpusStructure(this.getCorpusDefinition().getCorpusPath(), null);
			} catch (IOException e) {
				throw new PepperModuleException(this.name+": Cannot start with importing corpus, because saome exception occurs: ",e);
			}
		}	
		System.out.println("table of documents and resources: "+this.documentResourceTable);
		System.out.println("corpus graph: "+ this.getSCorpusGraph());
	}
	
	private void createCorpusStructure(URI currURI, SElementId parentsID) throws IOException
	{
		String corpGraphName= null;
		File currFile= new File(currURI.toFileString());
		//if uri is a directory, create a corpus and one document
		if (currFile.isDirectory())
		{
//			if (parentsID== null)
//			{//if there is no corpus given, create one with name of document
//				parentsID = SaltCommonFactory.eINSTANCE.createSElementId();
//				parentsID.setSId(currURI.lastSegment().replace("."+currURI.fileExtension(), "")); 
//				//create corpus
//				SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
//				sCorpus.setSElementId(parentsID);	
//				sCorpus.setName(parentsID.getSId());
//			}
//			corpGraphName=parentsID.getSId();
			//create new id
			SElementId currId= SaltCommonFactory.eINSTANCE.createSElementId();
			if (parentsID== null)
				currId.setSId("/"+currURI.lastSegment());
			else currId.setSId(parentsID.getSId()+"/"+currURI.lastSegment());
			//create corpus
			SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
			sCorpus.setSElementId(currId);
			sCorpus.setName(currURI.lastSegment());
			this.getSCorpusGraph().getSCorpora().add(sCorpus);
			System.out.println("adding corpus:  "+ sCorpus);
			//if corpus has a parent
			if (parentsID!= null)
			{
				SCorpus parentCorpus= this.getSCorpusGraph().getSCorpus(parentsID);
				SCorpusRelation sCorpRel= SaltCommonFactory.eINSTANCE.createSCorpusRelation();
				sCorpRel.setSSuperCorpus(parentCorpus);
				sCorpRel.setSSubCorpus(sCorpus);
				this.getSCorpusGraph().getSCorpusRelations().add(sCorpRel);
			}	
			for (File file: currFile.listFiles())
			{
				this.createCorpusStructure(URI.createFileURI(file.getCanonicalPath()), currId);
			}
		}	
		//if uri is a file document and possibly a corpus 
		else 
		{
			SElementId currId= SaltCommonFactory.eINSTANCE.createSElementId();
			
			if (parentsID== null)
			{//if there is no corpus given, create one with name of document
				parentsID = SaltCommonFactory.eINSTANCE.createSElementId();
				parentsID.setSId(currURI.lastSegment().replace("."+currURI.fileExtension(), ""));
				//create corpus
				SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
				sCorpus.setSElementId(parentsID);	
				this.getSCorpusGraph().getSCorpora().add(sCorpus);
				sCorpus.setName(parentsID.getSId());
			}
			currId.setSId(parentsID.getSId()+"/"+currURI.lastSegment().replace("."+currURI.fileExtension(), ""));			
			
			{//create a new document
				SDocument sDocument= SaltCommonFactory.eINSTANCE.createSDocument();
				sDocument.setSElementId(currId);
				sDocument.setName(currURI.lastSegment().replace("."+currURI.fileExtension(), ""));
				this.getSCorpusGraph().getSDocuments().add(sDocument);
				SCorpusDocumentRelation sCorpDocRel= SaltCommonFactory.eINSTANCE.createSCorpusDocumentRelation();
				sCorpDocRel.setSCorpus(this.getSCorpusGraph().getSCorpus(parentsID));
				sCorpDocRel.setSDocument(sDocument);
				this.getSCorpusGraph().getSCorpusDocumentRelations().add(sCorpDocRel);
			}
			corpGraphName=parentsID.getSId();
			//link documentId with resource
			this.documentResourceTable.put(currId, currURI);
			
			//setting name for corpus graph
			if (	(this.getSCorpusGraph().getName()== null) || 
					(this.getSCorpusGraph().getName().equalsIgnoreCase("")))
				this.getSCorpusGraph().setName(corpGraphName);
		}
	}
	
//	@Override
//	public void start() throws PepperModuleException 
//	{
//		// TODO Auto-generated method stub
//		System.out.println("START() OF TREETAGGERJAVA WAS CALLED.");
//	}
	
	@Override
	public void start(SElementId sElementId) throws PepperModuleException 
	{
		System.out.println("---------------------------------> START("+sElementId.getSId()+") OF TREETAGGERJAVA WAS CALLED.");
		this.returningMode= RETURNING_MODE.PUT;
		URI uri= this.documentResourceTable.get(sElementId);
		Document tDocument= null;
		try {
			tDocument= this.loadFromFile(uri);
		} catch (IOException e) {
			throw new PepperConvertException(this.getName()+": Problems with loading ressource occurs. ", e);
		}
		this.createSDocument(tDocument, this.getSCorpusGraph().getSDocument(sElementId));
	}

	private Document loadFromFile(URI uri) throws IOException
	{
		Document retVal= null;
		// create resource set and resource 
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("treetagger",new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tab",new TabResourceFactory());

		System.out.println("URI of TREETAGGER resource: "+uri);
		
		//load resource 
		Resource resource = resourceSet.createResource(uri);
		
		if (resource== null)
			throw new PepperConvertException("The resource is null.");
		resource.load(null);
		
		retVal= (Document) resource.getContents().get(0);
		
		return(retVal);
	}
	
// ============================ start Mapping ============================
	//TODO put all mappings in other class
	private void createSDocument(Document tDocument, SDocument sDocument)
	{
		sDocument.setSDocumentGraph(SaltCommonFactory.eINSTANCE.createSDocumentGraph());
		sDocument.getSDocumentGraph().setName(tDocument.getName()+"_graph");
		STextualDS sText= this.createSTextualDS(tDocument.getTokens(), sDocument);
		sDocument.getSDocumentGraph().getSTextualDSs().add(sText);	
	}
	
	private STextualDS createSTextualDS(EList<Token> tTokens, SDocument sDocument)
	{
		STextualDS sText= SaltCommonFactory.eINSTANCE.createSTextualDS();
		String text= null;
		int start= 0;
		int end= 0; 
		for (Token tToken: tTokens)
		{
			if (text== null)
			{
				start= 0;
				end= tToken.getText().length();
				text= tToken.getText();
			}
			else 
			{
				start= text.length() + sepreator.length();
				end= start + tToken.getText().length();				
				text= text+ this.sepreator + tToken.getText();
			}
			SToken sToken= this.createSToken(tToken);
			sDocument.getSDocumentGraph().getSTokens().add(sToken);
			STextualRelation sTextRel= this.createSTextualRelation(sToken, sText, start, end);
			sDocument.getSDocumentGraph().getSTextualRelations().add(sTextRel);
		}	
		sText.setSText(text);
		return(sText);
	}
	
	
	private SToken createSToken(Token tToken)
	{
		SToken retVal= null;
		retVal= SaltCommonFactory.eINSTANCE.createSToken();
		for (Annotation tAnnotation: tToken.getAnnotations())
		{
			retVal.getSAnnotations().add(this.createSAnnotation(tAnnotation));
		}	
		return(retVal);
	}
	
	private SAnnotation createSAnnotation(Annotation tAnnotation)
	{
		SAnnotation retVal= null;
		retVal= SaltCommonFactory.eINSTANCE.createSAnnotation();
		retVal.setSName(tAnnotation.getName());
		retVal.setSValue(tAnnotation.getValue());
		return(retVal);
	}
	
	private STextualRelation createSTextualRelation(SToken sToken, STextualDS sText, int start, int end)
	{
		STextualRelation retVal= null;
		retVal= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		retVal.setSTextualDS(sText);
		retVal.setSToken(sToken);
		retVal.setSStart(start);
		retVal.setSEnd(end);
		return(retVal);
	}
// ============================ end Mapping ============================
	
	protected void activate(ComponentContext componentContext) 
	{
		this.setSymbolicName(componentContext.getBundleContext().getBundle().getSymbolicName());
		System.out.println(this.getName()+" is activated...");
	}

	/**
	 * Wird von der Service Component Runtime vor der Deaktivierung der Komponente
	 * aufgerufen und gibt noch eine Abschiedsbotschaft aus
	 * 
	 * @param componentContext
	 *          Der Kontext der Komponente
	 */
	protected void deactivate(ComponentContext componentContext) {
		System.out.println(this.getName()+" is deactivated...");

	}
}
