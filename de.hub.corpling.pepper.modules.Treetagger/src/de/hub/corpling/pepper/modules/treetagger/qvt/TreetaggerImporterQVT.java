package de.hub.corpling.pepper.modules.treetagger.qvt;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.component.ComponentContext;

import de.hub.corpling.pepper.pepperExceptions.PepperModuleException;
import de.hub.corpling.pepper.pepperInterface.ExtensionFactoryPair;
import de.hub.corpling.pepper.pepperInterface.FormatDefinition;
import de.hub.corpling.pepper.pepperInterface.PepperInterfaceFactory;
import de.hub.corpling.pepper.pepperInterface.PepperQVTImporter;
import de.hub.corpling.pepper.pepperInterface.RETURNING_MODE;
import de.hub.corpling.pepper.pepperInterface.impl.PepperQVTImporterImpl;
import de.hub.corpling.pepper.treetagger.TreetaggerPackage;
import de.hub.corpling.pepper.treetagger.resources.TabResourceFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class TreetaggerImporterQVT extends PepperQVTImporterImpl implements PepperQVTImporter
{
	//TODO there shall be a possibility to read from Property-file
	/**
	 * Specifies the seperator, which has to be set between to the texts of two token.
	 */
	private String sepreator= " ";
	
	public TreetaggerImporterQVT()
	{
		super();
		this.name= "TreetaggerImporterQVT";
		//for testing the symbolic name has to be set without osgi
		if (	(this.getSymbolicName()==  null) ||
				(this.getSymbolicName().equalsIgnoreCase("")))
			this.setSymbolicName("de.hub.corpling.pepper.modules.Treetagger");
		System.out.println(this.getName()+" is created...");
		this.init();
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
			//clean uri in corpus path (if it is a folder and ends with/, / has to be removed)
			if (	(this.getCorpusDefinition().getCorpusPath().toFileString().endsWith("/")) || 
					(this.getCorpusDefinition().getCorpusPath().toFileString().endsWith("\\")))
			{
				this.getCorpusDefinition().setCorpusPath(this.getCorpusDefinition().getCorpusPath().trimSegments(1));
			}
			try {
				this.createCorpusStructure(this.getCorpusDefinition().getCorpusPath(), null);
			} catch (IOException e) {
				throw new PepperModuleException(this.name+": Cannot start with importing corpus, because saome exception occurs: ",e);
			}
		}	
	}
	
	private void createCorpusStructure(URI currURI, SElementId parentsID) throws IOException
	{
		String corpGraphName= null;
		File currFile= new File(currURI.toFileString());
		//if uri is a directory, create a corpus and one document
		if (currFile.isDirectory())
		{
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
		
	@Override
	public void start(SElementId sElementId) throws PepperModuleException 
	{
		if (this.getTemproraries()== null)
			throw new PepperModuleException("Cannot start module '"+this.getName()+"', because the temproraries aren´t set.");
		if (this.getResources()== null)
			throw new PepperModuleException("Cannot start module '"+this.getName()+"', because the resource path aren´t set.");
		this.returningMode= RETURNING_MODE.PUT;
		URI uri= this.documentResourceTable.get(sElementId);
		URI sourceURI= null;
		sourceURI = uri;
		URI tmpFolderURI= URI.createFileURI(this.getTemproraries().toFileString()+"/" +sElementId.getSElementPath());
		File tmpFolder= new File(tmpFolderURI.toFileString());
		if (!tmpFolder.exists())
			tmpFolder.mkdirs();
		URI targetURI= URI.createFileURI(tmpFolderURI.toFileString()+"/"+sElementId.getSElementPath().lastSegment()+".xmi");
		
		URI qvtURI= URI.createFileURI(this.getResources().toFileString() + "/treetagger2saltv1.qvt");		
		
		{//initial Qvt-Transformer with needed values
			if (this.getQvtTransformer()== null)
				throw new PepperModuleException("Cannot start importing data, because no qvt-transformer is given. This moght be an internal error.");
			//qvt script
			this.getQvtTransformer().setQvtURI(qvtURI);
			
			//meta models
			this.getQvtTransformer().getMetaModelPackages().add(SaltCorePackage.eINSTANCE);
			this.getQvtTransformer().getMetaModelPackages().add(SaltCommonPackage.eINSTANCE);
			this.getQvtTransformer().getMetaModelPackages().add(TreetaggerPackage.eINSTANCE);
			
			//adding resource factories
			ExtensionFactoryPair pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
			pair.setFileExtension("tab");
			pair.setResourceFactory(new TabResourceFactory());
			this.getQvtTransformer().getExtensionFactoryPairs().add(pair);
			pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
			pair.setFileExtension(Resource.Factory.Registry.DEFAULT_EXTENSION);
			pair.setResourceFactory(new XMIResourceFactoryImpl());
			this.getQvtTransformer().getExtensionFactoryPairs().add(pair);
			
			//source model
			this.getQvtTransformer().setSource(this.getQvtTransformer().getResource(sourceURI));
			//target model
			this.getQvtTransformer().setTarget(this.getQvtTransformer().getResource(targetURI));
			//set uri for temprorary data
			this.getQvtTransformer().setTmpURI(tmpFolderURI);
		}
		
		//real transforming
		String transformation= "treetagger2salt";
		String direction= "salt";
		Resource resource= this.getQvtTransformer().transform(transformation, direction);
		
		//put document graph into the corpus graph
		SDocumentGraph sDocumentGraph= (SDocumentGraph) resource.getContents().get(0);
		this.getSCorpusGraph().getSDocument(sElementId).setSDocumentGraph(sDocumentGraph);
	}

// ============================ start: bundle-stuff ============================
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
	
// ============================ end: bundle-stuff ============================
	
	
}
