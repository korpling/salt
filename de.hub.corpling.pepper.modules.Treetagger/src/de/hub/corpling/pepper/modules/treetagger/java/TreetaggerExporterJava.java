package de.hub.corpling.pepper.modules.treetagger.java;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.component.ComponentContext;

import de.hub.corpling.pepper.pepperExceptions.PepperConvertException;
import de.hub.corpling.pepper.pepperExceptions.PepperModuleException;
import de.hub.corpling.pepper.pepperInterface.PepperExporter;
import de.hub.corpling.pepper.pepperInterface.impl.PepperExporterImpl;
import de.hub.corpling.pepper.treetagger.Annotation;
import de.hub.corpling.pepper.treetagger.Document;
import de.hub.corpling.pepper.treetagger.LemmaAnnotation;
import de.hub.corpling.pepper.treetagger.POSAnnotation;
import de.hub.corpling.pepper.treetagger.Token;
import de.hub.corpling.pepper.treetagger.TreetaggerFactory;
import de.hub.corpling.pepper.treetagger.resources.TabResourceFactory;
import de.hub.corpling.salt.modules.SAccessorModule;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;

public class TreetaggerExporterJava extends PepperExporterImpl implements PepperExporter
{
	public TreetaggerExporterJava()
	{
		super();
		this.name= "TreetaggerExporterJava";
		//for testing the symbolic name has to be set without osgi
		if (	(this.getSymbolicName()==  null) ||
				(this.getSymbolicName().equalsIgnoreCase("")))
			this.setSymbolicName("de.hub.corpling.pepper.modules.Treetagger");
		System.out.println(this.getName()+" is created...");
	}

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
	
	/**
	 * file extionsion in which format document shall be saved.
	 * 
	 */
	//TODO Can be set by prop file
	private String fileExtension= "tab";
	
	@Override
	public void start(SElementId sElementId) throws PepperModuleException 
	{
		if (	(sElementId!= null) &&
				(sElementId.getSIdentifiableElement()!= null) &&
				(sElementId.getSIdentifiableElement() instanceof SDocument))
		{	
			this.createFolderStructure(sElementId);
			if (((SDocument)sElementId.getSIdentifiableElement()).getSDocumentGraph()!= null)
			{
				Document tDocument= createDocument(((SDocument)sElementId.getSIdentifiableElement()));
				
				//create uri to save
				URI uri= URI.createFileURI(this.getCorpusDefinition().getCorpusPath().toFileString()+ "/" + sElementId.getSId()+ "/" + tDocument.getName()+ "."+fileExtension);
				try {
					this.saveToFile(uri, tDocument);
				} catch (IOException e) {
					throw new PepperConvertException("Cannot write document with id: '"+sElementId.getSElementPath().lastSegment()+"' into uri: '"+uri+"'.", e);
				}
			}	
		}
	}
	
	private Document createDocument(SDocument sDocument)
	{
		Document tDocument= TreetaggerFactory.eINSTANCE.createDocument();
		tDocument.setName(sDocument.getName());
		
		//create tokens
		for (SToken sToken: sDocument.getSDocumentGraph().getSTokens())
		{
			Token tToken= this.createToken(sToken, sDocument);
			tDocument.getTokens().add(tToken);
		}
		return(tDocument);
	}
	
	private Token createToken(SToken sToken, SDocument sDocument)
	{
		Token tToken= TreetaggerFactory.eINSTANCE.createToken();
		
		//Accessor-module to have better access to salt. 
		SAccessorModule sAccessor= new SAccessorModule();
		tToken.setText(sAccessor.getOverlappedText(sDocument, sToken));
		
		//adding annotations
		for (SAnnotation sAnno: sToken.getSAnnotations())
		{
			Annotation tAnno= this.createAnnotation(sAnno, sDocument);
			if (tAnno instanceof POSAnnotation)
				tToken.setPosAnnotation((POSAnnotation)tAnno);
			else if (tAnno instanceof LemmaAnnotation)
				tToken.setLemmaAnnotation((LemmaAnnotation)tAnno);
			else tToken.getAnnotations().add(tAnno);
		}	
		return(tToken);
	}
	
	private Annotation createAnnotation(SAnnotation sAnno, SDocument sDocument)
	{
		Annotation tAnnotation= null;
		
		//TODO changing for ISOCat
		// if annotation is pos annotation
		if (sAnno.getSName().equalsIgnoreCase("pos"))
		{
			tAnnotation= TreetaggerFactory.eINSTANCE.createPOSAnnotation();
			tAnnotation.setValue(sAnno.getSValue());
		}	
		// if annotation is lemma annotation
		else if (sAnno.getSName().equalsIgnoreCase("lemma"))
		{
			tAnnotation= TreetaggerFactory.eINSTANCE.createLemmaAnnotation();
			tAnnotation.setValue(sAnno.getSValue());
		}	
		// if annotation is any annotation
		else 
		{
			tAnnotation= TreetaggerFactory.eINSTANCE.createAnnotation();
			tAnnotation.setValue(sAnno.getSValue());
		}	
		
		return(tAnnotation);
	}
	
	private void saveToFile(URI uri, Document tDocument) throws IOException
	{
		// create resource set and resource 
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("treetagger",new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tab",new TabResourceFactory());
		//load resource 
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(tDocument);
		if (resource== null)
			throw new PepperConvertException("The resource is null.");
		resource.save(null);
	}
}
