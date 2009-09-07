package de.hub.corpling.pepper.modules.treetagger.xslt;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.component.ComponentContext;

import de.hub.corpling.pepper.pepperExceptions.PepperModuleException;
import de.hub.corpling.pepper.pepperInterface.ExtensionFactoryPair;
import de.hub.corpling.pepper.pepperInterface.PepperInterfaceFactory;
import de.hub.corpling.pepper.pepperInterface.RETURNING_MODE;
import de.hub.corpling.pepper.pepperInterface.xsltModules.PepperXSLTExporter;
import de.hub.corpling.pepper.pepperInterface.xsltModules.impl.PepperXSLTExporterImpl;
import de.hub.corpling.pepper.treetagger.resources.TabResourceFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCore.SElementId;

public class TreetaggerExporterXSLT extends PepperXSLTExporterImpl implements PepperXSLTExporter
{
	public TreetaggerExporterXSLT()
	{
		super();
		this.name= "TreetaggerExporterXSLT";
		//for testing the symbolic name has to be set without osgi
		if (	(this.getSymbolicName()==  null) ||
				(this.getSymbolicName().equalsIgnoreCase("")))
			this.setSymbolicName("de.hub.corpling.pepper.modules.Treetagger");
		System.out.println(this.getName()+" is created...");
	}

// ===================== start: bundle-stuff ===================== 
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
	// ===================== end: bundle-stuff =====================
	
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
			
			SDocumentGraph sDocGraph= ((SDocument)sElementId.getSIdentifiableElement()).getSDocumentGraph();
			if (sDocGraph!= null)
			{	
				if (this.getTemproraries()== null)
					throw new PepperModuleException("Cannot start module '"+this.getName()+"', because the temproraries aren´t set.");
				if (this.getResources()== null)
					throw new PepperModuleException("Cannot start module '"+this.getName()+"', because the resource path aren´t set.");
				this.returningMode= RETURNING_MODE.PUT;
				
				URI tmpFolderURI= URI.createFileURI(this.getTemproraries().toFileString()+"/" +sElementId.getSElementPath());
				File tmpFolder= new File(tmpFolderURI.toFileString());
				if (!tmpFolder.exists())
					tmpFolder.mkdirs();
				File tmpFile= new File(tmpFolder.getAbsolutePath()+"/"+sElementId.getSElementPath()+".xmi");
				URI tmpModelURI= URI.createFileURI(tmpFile.getAbsolutePath());
//				URI tmpCorpusModelURI= URI.createFileURI(tmpFolder.getAbsolutePath()+ "/"+sElementId.getSElementPath()+"_corpus.xmi");
				File targetFolder= new File(this.getCorpusDefinition().getCorpusPath().toFileString()+"/"+sElementId.getSElementPath()); 
				URI targetURI= URI.createFileURI(targetFolder.getAbsolutePath()+"/"+sElementId.getSElementPath().lastSegment()+"."+fileExtension);
				System.out.println("target: "+ targetURI);
				
				URI xsltURI= URI.createFileURI(this.getResources().toFileString() + "/salt2treetagger.xslt");		
				
				{//adding resource factories
					ExtensionFactoryPair pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
					pair.setFileExtension(fileExtension);
					pair.setResourceFactory(new TabResourceFactory());
					this.getXsltTransformer().getExtensionFactoryPairs().add(pair);
					pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
					pair.setFileExtension(Resource.Factory.Registry.DEFAULT_EXTENSION);
					pair.setResourceFactory(new XMIResourceFactoryImpl());
					this.getXsltTransformer().getExtensionFactoryPairs().add(pair);
				}
				
//				this.getXsltTransformer().save(this.getSaltProject(), tmpCorpusModelURI);
				//workaraund, to store just a single document, without other resources
				SDocument sDocument= sDocGraph.getSDocument();
				sDocGraph.setSDocument(null);
				System.out.println("taret file: "+ targetFolder);
				System.out.println("taret uri: "+ targetURI);
				
				this.getXsltTransformer().save(sDocGraph, tmpModelURI);
				this.getXsltTransformer().transform(tmpModelURI, targetURI, xsltURI);
				sDocGraph.setSDocument(sDocument);
			}
		}
	}
}
