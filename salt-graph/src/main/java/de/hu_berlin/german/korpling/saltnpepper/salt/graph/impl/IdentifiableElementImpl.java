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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -624714790811799909L;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected IdentifiableElementImpl() 
	{
		super();
		init();
	}

	private void init()
	{
		//Adds a new empty identifier to the given identifiableElement
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		this.setIdentifier(identifier);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.IDENTIFIABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getId() 
	{
		if (this.getIdentifier()!= null)
			return(this.getIdentifier().getId());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setId(String newId) 
	{
		this.getIdentifier().setId(newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifier() {
		Identifier identifier = basicGetIdentifier();
		return identifier != null && identifier.eIsProxy() ? (Identifier)eResolveProxy((InternalEObject)identifier) : identifier;
	}

	/**
	 * An extra reference to the Identifier, for faster access, than searching in list of labels.
	 */
	private Identifier identifier= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Identifier basicGetIdentifier() 
	{
		return(this.identifier);
	}

	/**
	 * Overrides the parents method, for a special treating in case of an Identifier is given (it must be removed first).
	 * @param identifier
	 */
	@Override
	public void addLabel(Label label) 
	{
		if (	(label!= null) &&
				(label instanceof Identifier))
			this.getLabels().add(label);
		else 
			super.addLabel(label);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIdentifier(Identifier newIdentifier) 
	{
		this.getLabels().add(newIdentifier);
	}
	
	
	/**
	 * Returns a hashcode, created  out of the identifier-object of of this object.
	 * @return hashcode for this object 
	 */
	@Override
	public int hashCode() {
		Identifier id = getIdentifier();
		if(id == null || id.getId() == null)
		{
			return 0;
		}
		else
		{
			return id.getId().hashCode();
		}
	}
	
	/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	@Override
	public boolean equals(EList<String> differences, Object obj)
	{
		if (differences!= null)
		{
			super.equals(differences, obj);
		}
		else
		{
			if (!super.equals(differences, obj))
				return(false);
		}
		if (differences!= null)
		{//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
			if (!(obj instanceof IdentifiableElement))
				return(false);
		}//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
		IdentifiableElementImpl other = (IdentifiableElementImpl) obj;
		{//identifier
			if (this.getIdentifier() == null) 
			{
				if (other.getIdentifier() != null)
				{
					if (differences!= null)
						differences.add("The identifier of this element is null, but the identifier of the given one isn't.");
					else return false;
				}
			}
			else
			{
				if (differences!= null)
				{
					this.getIdentifier().equals(differences, other.getIdentifier());
				}
				else 
				{	
					if (!this.getIdentifier().equals(differences, other.getIdentifier()))
						return false;
				}
			}
		}//identifier
		return true;
	}
	/**
	 * Checks the equality of this object and a given one basing on the identifier object and the
	 * contained labels. 
	 * 
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
	}

	/**
	 * Listen on adding a Label to LabelableElement, to check if the added one is an Identifier. 
	 * In case of label is an Identifier, check if all references to the identifier are correctly set (remove old Identifier-object) and
	 * notify all interested objects. 
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		if(GraphPackage.Literals.LABELABLE_ELEMENT__LABELS.equals(notification.getFeature())) 
		{//if change happens in LabelableElement.getLabels()
			switch (notification.getEventType()) 
			{
				case Notification.ADD:
				{//if Label is added
					if (notification.getNewValue() instanceof Identifier)
					{//if added Label is Identifier
						Identifier removedIdentifier= null;
						Identifier newIdentifier= (Identifier) notification.getNewValue();
						if (this.identifier!= null)
						{//remove old identifier from list of labels (LabelableElement.getLabels)
							removedIdentifier= this.identifier;
							this.getLabels().remove(removedIdentifier);
						}//remove old identifier from list of labels (LabelableElement.getLabels)
						this.identifier= newIdentifier;
						//notify all interested objects, that the Identifier of this object has changed
						notification= new ENotificationImpl(this, Notification.SET, GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER, removedIdentifier, newIdentifier);
					}//if added Label is Identifier
				}//if Label is added
			}
		}//if change happens in LabelableElement.getLabels()
		
		super.eNotify(notification);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.IDENTIFIABLE_ELEMENT__ID:
				return getId();
			case GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.IDENTIFIABLE_ELEMENT__ID:
				setId((String)newValue);
				return;
			case GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER:
				setIdentifier((Identifier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.IDENTIFIABLE_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER:
				setIdentifier((Identifier)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.IDENTIFIABLE_ELEMENT__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER:
				return basicGetIdentifier() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Returns a String representation for this object. 
	 */
	@Override
	public String toString()
	{
		StringBuffer strBuffer= new StringBuffer();
		strBuffer.append("["+this.getClass().getSimpleName());
		strBuffer.append("("+ this.getId()+")");
		if (this.getLabels()!= null)
		{
			strBuffer.append(": ");
			for (Label label: this.getLabels())
			{
				if (!(label instanceof Identifier))
				{	
					if (label.getNamespace()!= null)
						strBuffer.append(label.getNamespace()+":");
					strBuffer.append(label.getName()+"=");
					strBuffer.append(label.getValue());
					strBuffer.append(", ");
				}
			}
		}
		strBuffer.append("]");
		return(strBuffer.toString());
	}
} //IdentifiableElementImpl
