/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import de.corpling.salt.model.salt.SCorpus;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SSTEREOTYPES;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.STextualRelation;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.STRAVERSAL_MODE;
import de.corpling.salt.saltFW.SaltAccessorModule;
import de.corpling.salt.saltFW.SaltFWPackage;
import de.util.graph.Edge;
import de.util.graph.Node;
import de.util.graph.TRAVERSAL_MODE;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accessor Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SaltAccessorModuleImpl extends SaltModuleImpl implements SaltAccessorModule 
{
	private enum TRAVERSAL_REASON {TOKENS, TEXTUAL_DS, CORPUS_PATH};
	private TRAVERSAL_REASON currTraversalReason= null;
	
	private static String MSG_ERR= 	"Error("+SaltAccessorModuleImpl.class+"): ";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltAccessorModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltFWPackage.Literals.SALT_ACCESSOR_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SToken> getTokenByPos(SDocument sDocument) 
	{
		if (sDocument == null)
			throw new NullPointerException(MSG_ERR + "Cannot search for tokens in an empty document.");
		if (sDocument.getSDocumentGraph() == null)
			throw new NullPointerException(MSG_ERR + "Cannot search for tokens in an document without document graph.");
		EList<SToken> tokens= null; 
		if ((sDocument.getSDocumentGraph().getSTokens()!= null) && (sDocument.getSDocumentGraph().getSTokens().size()!= 0))
		{	
			tokens= this.sortTokenList(sDocument.getSDocumentGraph().getSTokens());
		}
		return(tokens);
	}
	
	private EList<SToken> sortTokenList(EList<SToken> list2Sort)
	{
		EList<SToken> tokens= null;
		
		//SStereotype stereotypeTextRel= this.getSaltProject().getSStereotypeByName(SSTEREOTYPES.STEXTUAL_RELATION.toString());
		Object[][] tokenPosArray= new Object[ list2Sort.size()][3];
		int posArrayIdx= 0;
		//search through all tokens in document, and store them with left and right span info in an array
		SDocumentGraph contentDocGraph= null;
		for (SToken sToken : list2Sort)
		{
			if (contentDocGraph== null)
				contentDocGraph= sToken.getSDocumentGraph();
			if (contentDocGraph != sToken.getSDocumentGraph())
				throw new NullPointerException(MSG_ERR + "Cannot sort the given list of token, because they belong to different documents: "+ list2Sort);
			tokenPosArray[posArrayIdx][0]= sToken;
			for (Edge edge : contentDocGraph.getOutEdges(sToken.getId()))
			{
				if (((SRelation) edge).getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_RELATION.toString()))
				{
					tokenPosArray[posArrayIdx][1]= ((STextualRelation)edge).getSLeftPos();
					tokenPosArray[posArrayIdx][2]= ((STextualRelation)edge).getSRightPos();
				}
					
			}
			posArrayIdx++;
			
		}
		tokens= new BasicEList<SToken>();
		
		long numOfTok= tokenPosArray.length;
		boolean changed= false;
		do
		{
			changed= false;
			for (int i= 0; i< tokenPosArray.length-1; i++)
			{
				if (((Long)tokenPosArray[i][1]) > ((Long)tokenPosArray[i+1][1]))
				{
					//temprorary data
					SToken tmpToken= (SToken)tokenPosArray[i][0];
					Long tmpLeft= (Long) tokenPosArray[i][1];
					Long tmpRight= (Long) tokenPosArray[i][2];
					//override
					tokenPosArray[i][0]= tokenPosArray[i+1][0];
					tokenPosArray[i][1]= tokenPosArray[i+1][1];
					tokenPosArray[i][2]= tokenPosArray[i+1][2];
					//write back temprorary data
					tokenPosArray[i+1][0]= tmpToken;
					tokenPosArray[i+1][1]= tmpLeft;
					tokenPosArray[i+1][2]= tmpRight;
					changed= true;
				}
				numOfTok--;
			}
		} while ((changed) && (numOfTok >= 1));
		
		for (int i= 0; i < tokenPosArray.length; i++)
		{
			tokens.add((SToken)tokenPosArray[i][0]);
		}
		return(tokens);
	}
	
	/**
	 * Returns the first document in which an Element is included. Element shall not be
	 * a document or corpus
	 * @param sElement
	 * @return
	 */
	//TODO muss ersetzt werden durch ELementPath
	private SDocument findDocument(SElement sElement)
	{
		if ((sElement.getSStereotype().getName().equals(SSTEREOTYPES.SCORPUS.toString())) ||
				(sElement.getSStereotype().getName().equals(SSTEREOTYPES.SDOCUMENT.toString())) )
			throw new NullPointerException(MSG_ERR + "Cannot search a document for a corpus or a document");
		
		SDocument retSDocument= null;
		//STEXTUAL_DATASOURCE
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
			retSDocument= ((STextualDataSource)sElement).getSDocumentGraph().getSDocument();
		//STOKEN
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
			retSDocument= ((SToken)sElement).getSDocumentGraph().getSDocument();
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
			retSDocument= ((SStructure)sElement).getSDocumentGraph().getSDocument();
		return(retSDocument);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getOverlapedText(SElement sElement) 
	{
		SDocument sDocument= this.findDocument(sElement);
		String retStr= null;
		//TEXTUAL_DS
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
		{
			retStr= sElement.getSFeature("sText").toString();
		}
		//STOKEN
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
		{
			EList<Edge> edges= sDocument.getSDocumentGraph().getOutEdges(sElement.getId());
			for (Edge edge: edges)
			{
				if (((SRelation) edge).getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_RELATION.toString()))
				{
					Long left= ((STextualRelation) edge).getSLeftPos();
					Long right= ((STextualRelation) edge).getSRightPos();
					if ((left== null) || (right== null))
						throw new NullPointerException(MSG_ERR +"Cannot return overlaped text, because left or right value of given textual data source aren´t set.");
					retStr= ((STextualDataSource)edge.getDestination()).getSText().substring(left.intValue(), right.intValue());
					break;
				}
			}
		}	
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
		{
			//TODO implementing this method, but before it has to be clear what it means semantically to resolve the overlapped text (whitespaces)
		}
		else
		{
			
		}
		return(retStr);
	}

	private STextualDataSource dominatedText= null;
	/**
	 * Returns textual data source element which is dominated directly or indirectly 
	 * by the given sElement.
	 */
	public STextualDataSource getSTextualDataSource(SElement sElement) 
	{
		SDocument sDocument= this.findDocument(sElement);
		STextualDataSource retVal= null;
		//TEXTUAL_DS
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
		{
			retVal= (STextualDataSource)sElement;
		}
		//STOKEN
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
		{
			EList<Edge> edges= sDocument.getSDocumentGraph().getOutEdges(sElement.getId());
			for (Edge edge: edges)
			{
				if (((SRelation) edge).getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_RELATION.toString()))
				{
					retVal= (STextualDataSource) edge.getDestination();
					break;
				}
			}
		}	
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
		{
			this.currTraversalReason= TRAVERSAL_REASON.TEXTUAL_DS;
			sElement.getSGraph().traverseSGraph(STRAVERSAL_MODE.DEPTH_FIRST, sElement, this, null);
			retVal= this.dominatedText;
		}
		else
		{
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getSLeftPos(SElement sElement) 
	{
		SDocument sDocument= this.findDocument(sElement);
		Long retVal= null;
		//TEXTUAL_DS
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
		{
			retVal= 0L;
		}
		//STOKEN
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
		{
			EList<Edge> edges= sDocument.getSDocumentGraph().getOutEdges(sElement.getId());
			for (Edge edge: edges)
			{
				if (((SRelation) edge).getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_RELATION.toString()))
				{
					retVal= ((STextualRelation) edge).getSLeftPos();
					break;
				}
			}
		}	
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
		{
			EList<SToken> dominancedTokens= this.getDominancedTokens((SStructure)sElement);
			if (( dominancedTokens== null)|| (dominancedTokens.size()== 0))
				throw new NullPointerException(MSG_ERR + "Cannot compute left pos, because this element does not dominate a token.");
			//recursive call for token
			retVal= this.getSLeftPos((SElement)dominancedTokens.get(0));
		}
		else
		{
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getSRightPos(SElement sElement) 
	{
		SDocument sDocument= this.findDocument(sElement);
		Long retVal= null;
		//TEXTUAL_DS
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
		{
			retVal= new Long(((STextualDataSource)sElement).getSText().length());
		}
		//STOKEN
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
		{
			EList<Edge> edges= sDocument.getSDocumentGraph().getOutEdges(sElement.getId());
			for (Edge edge: edges)
			{
				if (((SRelation) edge).getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_RELATION.toString()))
				{
					retVal= ((STextualRelation) edge).getSRightPos();
					break;
				}
			}
		}	
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
		{
			EList<SToken> dominancedTokens= this.getDominancedTokens((SStructure)sElement);
			if (( dominancedTokens== null)|| (dominancedTokens.size()== 0))
				throw new NullPointerException(MSG_ERR + "Cannot compute right pos, because this element does not dominate a token.");
			//recursive call for token
			retVal= this.getSRightPos((SElement)dominancedTokens.get(dominancedTokens.size()-1));
		}
		else
		{
		}
		return(retVal);
	}

	/**
	 * Traverses the subgraph beyond the given element and returns if this element
	 * overlaps a continuous span of token (that means, that there is no token between 
	 * the overlapped span of token, which is not overlapped). Only dominating relation
	 * are used for traversal.
	 * An element is not continuous if any element in its subgraph isn´t continuous. 
	 */
	public boolean isContinuous(SElement sElement) 
	{
		if (sElement== null)
			throw new NullPointerException(MSG_ERR + "Can not return continuousness of an empty element.");
		boolean retVal= false;
		//TEXTUAL_DS (always have to be continuous)
		if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
			retVal= true;
		//STOKEN (always have to be continuous)
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
			retVal= true;
		//SSTRUCTURE
		else if (sElement.getSStereotype().getName().equals(SSTEREOTYPES.SSTRUCTURE.toString()))
		{
			EList<SToken> dominancedTokens= this.getDominancedTokens((SStructure)sElement);
			if ((dominancedTokens== null) || (dominancedTokens.size()== 0))
				throw new NullPointerException(MSG_ERR + "Can not return continuousness, because the given element does not dominate any token: "+sElement);
			else if (dominancedTokens.size()== 1)
				retVal= true;
			else 
			{
				dominancedTokens= this.sortTokenList(dominancedTokens);
				EList<SToken> allTokens= this.getTokenByPos(((SStructure)sElement).getSDocumentGraph().getSDocument());
				int first= allTokens.indexOf(dominancedTokens.get(0));
				int last= allTokens.indexOf(dominancedTokens.get(dominancedTokens.size()-1));
				
				//if set of dominanced tokens has equal size as all tokens in range return true
				// +1 is necessary, because last element of sublist is exclusive
				if (dominancedTokens.size()== allTokens.subList(first, last+1).size())
					retVal= true;
				else retVal= false;
			}
		}
		else
			throw new UnsupportedOperationException(MSG_ERR + "This method does not support paramter of kind: "+ sElement.getSStereotype().getName());
		return(retVal);
	}

	private EList<SToken> dominancedTokens= null;
	/**
	 * Traverses graph beginning at the given sStructure-element and searches 
	 * all token-elements beyond given element and gives them back.  
	 * While traversing only dominating relations are used.
	 * !!!Attention: in moment all relations are used!!!
	 */
	public EList<SToken> getDominancedTokens(SStructure sStructure) 
	{
		SDocument sDocument= this.findDocument(sStructure);
		if (sDocument.getSDocumentGraph()!= null)
		{
			this.dominancedTokens= new BasicEList<SToken>();
			this.currTraversalReason= TRAVERSAL_REASON.TOKENS;
			sDocument.getSDocumentGraph().traverseSGraph(STRAVERSAL_MODE.DEPTH_FIRST, sStructure, this, null);
			dominancedTokens= this.sortTokenList(dominancedTokens);
		}
		return(this.dominancedTokens);
	}

	/**
	 * Stores a corpus path if it shall be created.
	 */
	private EList<SElement> currCorpusPath= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SElement> getCorpusPathAsList(SElement sElement) 
	{
		EList<SElement> path= null;
		if ((sElement instanceof SDocument) || (sElement instanceof SCorpus))
		{
			this.currCorpusPath= new BasicEList<SElement>();
			this.currTraversalReason= TRAVERSAL_REASON.CORPUS_PATH;
			sElement.getSGraph().traverseSGraph(STRAVERSAL_MODE.BOTTOM_UP, sElement, this, null);
			if (this.currCorpusPath!= null)
			{
				path= this.currCorpusPath;
			}	
		}	
		return(path);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void sElementReached(STRAVERSAL_MODE traversalMode, SElement currSElement, SRelation sRelation, SElement fromSElement, long order) 
	{
		//searching for dominanced token
		if (this.currTraversalReason== TRAVERSAL_REASON.TOKENS)
		{
			if (currSElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
			{
				if (!this.dominancedTokens.contains((SToken)currSElement))
						this.dominancedTokens.add((SToken)currSElement);
			}
		}
		else if (this.currTraversalReason== TRAVERSAL_REASON.CORPUS_PATH)
		{
			this.currCorpusPath.add(0,currSElement);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void sElementLeft(STRAVERSAL_MODE traversalMode, SElement currSElement, SRelation sRelation, SElement fromSElement, long order) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean checkConstraint(STRAVERSAL_MODE traversalMode, SRelation sRelation, SElement currSElement, long order) 
	{
		if (this.currTraversalReason== TRAVERSAL_REASON.TEXTUAL_DS)
		{
			if (currSElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
			{
				this.dominatedText= (STextualDataSource)currSElement;
				return(false);
			}
		}
		return true;
	}

	public boolean checkConstraint(TRAVERSAL_MODE traversalMode, Edge edge,
			Node currNode, long order) 
	{
		throw new UnsupportedOperationException();
		
//		SElement currSElement= (SElement) currNode;
//		if (this.currTraversalReason== TRAVERSAL_REASON.TEXTUAL_DS)
//		{
//			if (currSElement.getSStereotype().getName().equals(SSTEREOTYPES.STEXTUAL_DATASOURCE.toString()))
//			{
//				this.dominatedText= (STextualDataSource)currSElement;
//				return(false);
//			}
//		}
//		return true;
	}

	public void nodeLeft(TRAVERSAL_MODE traversalMode, Node currNode,
			Edge edge, Node fromNode, long order) 
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void nodeReached(TRAVERSAL_MODE traversalMode, Node currNode,
			Edge edge, Node fromNode, long order) 
	{
		throw new UnsupportedOperationException();
//		SElement currSElement= (SElement) currNode;
//		//searching for dominanced token
//		if (this.currTraversalReason== TRAVERSAL_REASON.TOKENS)
//		{
//			if (currSElement.getSStereotype().getName().equals(SSTEREOTYPES.STOKEN.toString()))
//			{
//				if (!this.dominancedTokens.contains((SToken)currNode))
//						this.dominancedTokens.add((SToken)currSElement);
//			}
//		}
		
	}

} //SaltAccessorModuleImpl
