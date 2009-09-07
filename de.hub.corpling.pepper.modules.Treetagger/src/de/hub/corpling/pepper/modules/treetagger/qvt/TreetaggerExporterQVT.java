package de.hub.corpling.pepper.modules.treetagger.qvt;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.service.component.ComponentContext;

import de.hub.corpling.pepper.pepperExceptions.PepperModuleException;
import de.hub.corpling.pepper.pepperInterface.ExtensionFactoryPair;
import de.hub.corpling.pepper.pepperInterface.PepperInterfaceFactory;
import de.hub.corpling.pepper.pepperInterface.PepperQVTExporter;
import de.hub.corpling.pepper.pepperInterface.RETURNING_MODE;
import de.hub.corpling.pepper.pepperInterface.impl.PepperQVTExporterImpl;
import de.hub.corpling.pepper.treetagger.TreetaggerPackage;
import de.hub.corpling.pepper.treetagger.resources.TabResourceFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class TreetaggerExporterQVT extends PepperQVTExporterImpl implements PepperQVTExporter
{
	public TreetaggerExporterQVT()
	{
		super();
		this.name= "TreetaggerExporterQVT";
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
				File targetFile= new File(this.getCorpusDefinition().getCorpusPath().toFileString()+"/"+sElementId.getSElementPath()); 
				URI targetURI= URI.createFileURI(targetFile.getAbsolutePath()+"/"+sElementId.getSElementPath().lastSegment()+"."+fileExtension);
				System.out.println("target: "+ targetURI);
				
				URI qvtURI= URI.createFileURI(this.getResources().toFileString() + "/salt2treetagger.qvt");		
				
				{//initial Qvt-Transformer with needed values
					//qvt script
					this.getQvtTransformer().setQvtURI(qvtURI);
					
					//meta models
					this.getQvtTransformer().getMetaModelPackages().add(SaltCorePackage.eINSTANCE);
					this.getQvtTransformer().getMetaModelPackages().add(SaltCommonPackage.eINSTANCE);
					this.getQvtTransformer().getMetaModelPackages().add(TreetaggerPackage.eINSTANCE);
					
					//adding resource factories
					ExtensionFactoryPair pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
					pair.setFileExtension(fileExtension);
					pair.setResourceFactory(new TabResourceFactory());
					this.getQvtTransformer().getExtensionFactoryPairs().add(pair);
					pair= PepperInterfaceFactory.eINSTANCE.createExtensionFactoryPair();
					pair.setFileExtension(Resource.Factory.Registry.DEFAULT_EXTENSION);
					pair.setResourceFactory(new XMIResourceFactoryImpl());
					this.getQvtTransformer().getExtensionFactoryPairs().add(pair);
					
					//source model
					URI sourceURI= URI.createFileURI(tmpFolder.getAbsolutePath()+ "/"+ ((SDocument)sElementId.getSIdentifiableElement()).getName() + ".xmi");
					Resource source = this.getQvtTransformer().getResource(sourceURI);
					System.out.println("source: "+ source);
					source.getContents().add(sDocGraph);
//					try {
//						source.save(null);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					this.getQvtTransformer().setSource(source);
					//target model
					this.getQvtTransformer().setTarget(this.getQvtTransformer().getResource(targetURI));
					//set uri for temprorary data
					this.getQvtTransformer().setTmpURI(tmpFolderURI);
				}
			
			
				//real transforming
				String transformation= "salt2treetagger";
				String direction= "tt";
//				Resource resource= this.getQvtTransformer().transform(transformation, direction);
				this.getQvtTransformer().transform(transformation, direction);
				//save resource as target
				try {
					this.getQvtTransformer().getTarget().save(null);
				} catch (IOException e) {
					throw new PepperModuleException("Cannot save target '"+targetURI+"'.");
				}
			}
		}
	}
}
