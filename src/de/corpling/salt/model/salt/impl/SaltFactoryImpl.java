/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import java.io.File;
import java.util.Collection;
import java.util.Vector;

import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SaltCorePackage;
import de.corpling.salt.model.salt.*;
import de.corpling.salt.model.saltCore.impl.SaltCoreFactoryImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;


import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class SaltFactoryImpl extends SaltCoreFactoryImpl implements SaltFactory 
{
//	private static final String MSG_ERR=	"Error("+SaltFactoryImpl.class+"): ";
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SaltFactory init() {
		try {
			SaltFactory theSaltConcreteFactory = (SaltFactory)EPackage.Registry.INSTANCE.getEFactory("SaltConcrete"); 
			if (theSaltConcreteFactory != null) {
				return theSaltConcreteFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SaltFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SaltFactoryImpl() 
	{
		super();
		this.setSettingLocation(new File("./settings/"));
		this.initObject();
	}

	/**
	 * Initializes this object:
	 * setting predefined stereotypes
	 */
	private void initObject()
	{
		this.setPredefinedSStereotypes();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SaltPackage.STOKEN: return createSToken();
			case SaltPackage.SDATA_SOURCE: return createSDataSource();
			case SaltPackage.STEXTUAL_DATA_SOURCE: return createSTextualDataSource();
			case SaltPackage.SDOCUMENT_GRAPH: return createSDocumentGraph();
			case SaltPackage.STEXTUAL_RELATION: return createSTextualRelation();
			case SaltPackage.SSTRUCTURE: return createSStructure();
			case SaltPackage.SSPAN_RELATION: return createSSpanRelation();
			case SaltPackage.SPROJECT: return createSProject();
			case SaltPackage.SCORPUS: return createSCorpus();
			case SaltPackage.SCORPUS_GRAPH: return createSCorpusGraph();
			case SaltPackage.SDOCUMENT: return createSDocument();
			case SaltPackage.SCORPUS_RELATION: return createSCorpusRelation();
			case SaltPackage.SCORP_DOC_RELATION: return createSCorpDocRelation();
			case SaltPackage.SDOMINANCE_RELATION: return createSDominanceRelation();
			case SaltPackage.SPOINTING_RELATION: return createSPointingRelation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SaltPackage.SSTEREOTYPES:
				return createSSTEREOTYPESFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SaltPackage.SSTEREOTYPES:
				return convertSSTEREOTYPESToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

//	=========================== Start stereotype handling
	private File settingDir= null;
	/**
	 * sets the directory where to find setting files.
	 */
	public void setSettingLocation(File dir)
	{
		this.settingDir= dir;
	}
	
	private Collection<SStereotype> predefinedSStereotypes= null;
	private static final String FILE_STEREOTYPES= "/stereotypes.properties";
	
	private void setPredefinedSStereotypes()
	{
		predefinedSStereotypes= new Vector<SStereotype>();
		SStereotype sStereotype= null;
		
		//SELEMENTS
		
		//SCORPUS
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SCORPUS.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SDOCUMENT
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SDOCUMENT.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SDATA_SOURCE
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SDATASOURCE.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//STEXTUAL_DATA_SOURCE
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//STOKEN
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.STOKEN.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SSTRUCTURE
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SSTRUCTURE.toString());
		predefinedSStereotypes.add(sStereotype);
		
		
		//SRELATIONS
		//SCORPUS_RELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SCORPUS_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SCORPDOCRELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SCORPDOC_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//STEXTUAL_RELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.STEXTUAL_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SSPAN_RELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SSPAN_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SDOMINANCE_RELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SDOMINANCE_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
		
		//SPOINTING_RELATION
		sStereotype= this.createSStereotype();
		sStereotype.setName(SSTEREOTYPES.SPOINTING_RELATION.toString());
		predefinedSStereotypes.add(sStereotype);
	}
	
	/**
	 * Returns a list of all predefined stereotypes.
	 * @return a list of all predefined stereotypes
	 */
	public Collection<SStereotype> getPredefinedStereotypes()
	{
		return(this.predefinedSStereotypes);
	}
	
	/**
	 * Returns the Stereotype applicable to the given stereotype name
	 * @param sStereotypeName
	 * @return
	 */
	public SStereotype getPredefinedStereotype(String sStereotypeName)
	{
		SStereotype retVal= null;
		for (SStereotype sStereotype: predefinedSStereotypes)
		{
			if (sStereotype.getName().equalsIgnoreCase(sStereotypeName))
			{	
				retVal= sStereotype;
				break;
			}
		}
		return(retVal);
	}
	
	/**
	 * Adds the correct Stereotype to a given Element.
	 * @param sElement
	 */
	private void addStereotype(SElement sElement)
	{
		//SCORPUS
		if (SCorpus.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SCORPUS.toString()));
		//SDOCUMENT
		else if (SDocument.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SDOCUMENT.toString()));
		//STEXTUAL_DATASOURCE
		else if (STextualDataSource.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()));
		//SDATASOURCE
		else if (SDataSource.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SDATASOURCE.toString()));
		//STOKEN
		else if (SToken.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.STOKEN.toString()));
		//SSTRUCTURE
		else if (SStructure.class.isInstance(sElement))
			sElement.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SSTRUCTURE.toString()));
	}
	
	/**
	 * Adds the correct Stereotype to a given Element.
	 * @param sElement
	 */
	private void addStereotype(SRelation sRelation)
	{
		//SCORPUS_RELATION
		if (SCorpusRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SCORPUS_RELATION.toString()));
		//SCORPDOC_RELATION
		else if (SCorpDocRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SCORPDOC_RELATION.toString()));
		//TEXTUAL_RELATION
		else if (STextualRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.STEXTUAL_RELATION.toString()));
		//SSPAN_RELATION
		else if (SSpanRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SSPAN_RELATION.toString()));
		//SDOMINANCE_RELATION
		else if (SDominanceRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SDOMINANCE_RELATION.toString()));
		//SPOINTING_RELATION
		else if (SPointingRelation.class.isInstance(sRelation))
			sRelation.setSStereotype(this.getPredefinedStereotype(SSTEREOTYPES.SPOINTING_RELATION.toString()));
	}
//	=========================== End stereotype handling

// ---------------------- start: creating elements	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus createSCorpus() {
		SCorpusImpl sCorpus = new SCorpusImpl();
		this.addStereotype(sCorpus);
		return sCorpus;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocument createSDocument() {
		SDocumentImpl sDocument = new SDocumentImpl();
		sDocument.setSDocumentGraph(this.createSDocumentGraph());
		this.addStereotype(sDocument);	
		return sDocument;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SToken createSToken() 
	{
		STokenImpl sToken = new STokenImpl();
		this.addStereotype(sToken);
		return sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDataSource createSDataSource() {
		SDataSourceImpl sDataSource = new SDataSourceImpl();
		this.addStereotype(sDataSource);		
		return sDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STextualDataSource createSTextualDataSource() 
	{
		STextualDataSourceImpl sTextualDataSource = new STextualDataSourceImpl();
		this.addStereotype(sTextualDataSource);
		return sTextualDataSource;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	  */
	public SStructure createSStructure() 
	{
		SStructureImpl sStructure = new SStructureImpl();
		this.addStereotype(sStructure);
		return sStructure;
	}
// ---------------------- end: creating elements
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph createSDocumentGraph() {
		SDocumentGraphImpl sDocumentGraph = new SDocumentGraphImpl();
		return sDocumentGraph;
	}

// ---------------------- start: creating relations
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusRelation createSCorpusRelation() {
		SCorpusRelationImpl sCorpusRelation = new SCorpusRelationImpl();
		this.addStereotype(sCorpusRelation);	
		return sCorpusRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpDocRelation createSCorpDocRelation() {
		SCorpDocRelationImpl sCorpDocRelation = new SCorpDocRelationImpl();
		this.addStereotype(sCorpDocRelation);	
		return sCorpDocRelation;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STextualRelation createSTextualRelation() {
		STextualRelationImpl sTextualRelation = new STextualRelationImpl();
		this.addStereotype(sTextualRelation);
		return sTextualRelation;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SSpanRelation createSSpanRelation() 
	{
		SSpanRelationImpl sSpanRelation = new SSpanRelationImpl();
		this.addStereotype(sSpanRelation);
		return sSpanRelation;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDominanceRelation createSDominanceRelation() 
	{
		SDominanceRelationImpl sDominanceRelation = new SDominanceRelationImpl();
		this.addStereotype(sDominanceRelation);
		return sDominanceRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SPointingRelation createSPointingRelation() 
	{
		SPointingRelationImpl sPointingRelation = new SPointingRelationImpl();
		this.addStereotype(sPointingRelation);
		return sPointingRelation;
	}
// ---------------------- end: creating relations

	//old since 12.2.09 
	//private SProject sProject= null;
	/**
	 * The object SProject is singleton.
	 * @return returns a SProject (always the same).
	 */
	public SProject createSProject() 
	{
		SProject sProject= new SProjectImpl();
		for (SStereotype sStereotype:  this.getPredefinedStereotypes())
		{
			sProject.getSStereotypes().add(sStereotype);
		}
		return(sProject);
		//old since 12.2.09
		/*
		if (this.sProject== null)
		{	
			this.sProject = new SProjectImpl();
			if (this.settingDir== null)
				throw new NullPointerException(MSG_ERR+"Cannot a new SProject, please set the setting directory first.");
			File stereotypeFile= new File(settingDir.getAbsolutePath() + FILE_STEREOTYPES);
			Properties props= new Properties();
			
			String fileLocation= null;
			try 
			{
				fileLocation = stereotypeFile.getCanonicalPath();
				if (!stereotypeFile.exists())
					throw new NullPointerException(MSG_ERR+"Cannot create a new SProject, because i can not find the stereotypes property file at location "+fileLocation+".");
				
				props.load(new FileInputStream(stereotypeFile));
			} 
			catch (FileNotFoundException e) 
			{throw new NullPointerException(MSG_ERR+"Cannot create a new SProject, because i can not find the stereotypes property file at location "+fileLocation+": "+e.getMessage());} 
			catch (IOException e) 
			{throw new NullPointerException(MSG_ERR+"Cannot create a new SProject, because i can not find the stereotypes property file at location "+fileLocation+": "+e.getMessage());}
			this.sProject.setSStereotypes(props);
		}
		return this.sProject;
		*/
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraph createSCorpusGraph() {
		SCorpusGraphImpl sCorpusGraph = new SCorpusGraphImpl();
		return sCorpusGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSTEREOTYPES createSSTEREOTYPESFromString(EDataType eDataType, String initialValue) {
		SSTEREOTYPES result = SSTEREOTYPES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSSTEREOTYPESToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltPackage getSaltConcretePackage() {
		return (SaltPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * 
	 */
	@Deprecated
	public static SaltCorePackage getPackage() {
		return (SaltCorePackage)SaltPackage.eINSTANCE;
	}

} //SaltConcreteFactoryImpl
