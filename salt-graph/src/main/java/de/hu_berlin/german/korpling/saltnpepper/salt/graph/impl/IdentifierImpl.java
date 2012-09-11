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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl#getIdentifiableElement <em>Identifiable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifierImpl extends LabelImpl implements Identifier {
	
	//TODO to delete
	public static Long equalTime= 0l;
	
	/**
	 * The cached value of the '{@link #getIdentifiableElement() <em>Identifiable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiableElement()
	 * @generated
	 * @ordered
	 */
//	protected IdentifiableElement identifiableElement;
	
	/**
	 * The cached value of the '{@link #getIdentifiableElement() <em>Identifiable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiableElement()
	 * @generated
	 * @ordered
	 */
//	protected IdentifiableElement identifiableElement;
	/**
	 * The cached value of the '{@link #getIdentifiableElement() <em>Identifiable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiableElement()
	 * @generated
	 * @ordered
	 */
//	protected IdentifiableElement identifiableElement;
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
	protected IdentifierImpl() 
	{
		super();
		init();
	}
	
	private void init()
	{
		this.setName(NAME_DEFAULT);
		this.setNamespace(NAMESPACE_DEFAULT);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GraphPackage.Literals.IDENTIFIER;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getId() 
	{
		return(this.getValueString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setId(String newId) 
	{
		this.setValue(newId);
	}
	
	/**
	 * Override the parents methode to notify all objects, that id has changed.
	 */
	@Override
	public void setValue(Object newId) 
	{
		String oldId= this.getId();
		super.setValue(newId);
		if (eNotificationRequired()) 
		{
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.IDENTIFIER__ID, oldId, newId));
		}
	}
	
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * A namespace for this class cannot be set, therefore, the method does nothing.
	 * The namespace for an identifier is always "graph".
	 */
	public void setNamespace(String namespace)
	{
		this.namespace= NAMESPACE_DEFAULT;
//		throw new GraphException("You can't set the namespace for an object of class "+this.getClass().getName()+". The namespace must be set to "+Identifier.NAMESPACE_DEFAULT+".");
	}
	
	/**
	 * A name for this class cannot be set, therefore, the method does nothing.
	 * The name for an identifier is always "identifier".
	 */
	public void setName(String name)
	{
		this.name= NAME_DEFAULT;
//		throw new GraphException("You can't set the namespace for an object of class "+this.getClass().getName()+". The namespace must be set to "+Identifier.NAMESPACE_DEFAULT+".");
	}
	
	/**
	 * Returns a hashcode, created  id-value of this object.
	 * 
	 * @return hashcode for this object
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
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
		{//start: must be checked in case of differences is given
			if (!(obj instanceof Label))
				return(false);
		}//end: must be checked in case of differences is given
		Identifier other= null;
		try{
			other = (Identifier) obj;
		}catch (ClassCastException e) {
			if (differences!= null)
				differences.add("The given object shall be compared with an object of type '"+this.getClass()+"', but is of type '"+obj.getClass()+"'.");
			return(false);
		}

		//start: check id
			if (this.getId() == null) 
			{
				if (other.getId() != null)
				{
					if (differences!= null)
						differences.add("The id of this is null, but the one of the given object is '"+other.getId()+"'.");
					else return false;
				}
			} 
			else if (other.getId()== null)
			{
				if (differences!= null)
					differences.add("The id of this is '"+this.getId()+"', but the one of the given object is null.");
				else return(false);
			}
			else if (this.getId().hashCode()!= other.getId().hashCode())
			{
				if (differences!= null)
					differences.add("The hashcode of the id of both objects isn't the same.");
				else return false;
			}
		//end: check id
		return true;
	}
	
	/**
	 * Checks the equality of this object and a given one basing on the id-value
	 * of both objects. The objects are only equal, if the String- comparisons for the id-value
	 * returns true. In case of String-comparison, the method is case-sensitive.
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
	 * Returns the LabelableElement object containing this object.
	 * @return the container of this object
	 * @generated
	 */
	public IdentifiableElement getIdentifiableElement() 
	{
        IdentifiableElement identifiableElement = basicGetIdentifiableElement();
        return identifiableElement != null && identifiableElement.eIsProxy() ? (IdentifiableElement)eResolveProxy((InternalEObject)identifiableElement) : identifiableElement;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public IdentifiableElement basicGetIdentifiableElement() 
	{
		IdentifiableElement retVal= null;
		if (this.getLabelableElement()!= null)
		{
			if (this.getLabelableElement() instanceof IdentifiableElement)
				retVal= (IdentifiableElement) this.getLabelableElement();
			else
				throw new GraphException("The container of this identifier object '"+this.getId()+"' is not of type '"+IdentifiableElement.class.getName()+"'.");
		}
		return(retVal);	 
	}

	/**
	 * Sets the container of this object to the given one. This method calls 
	 * setLabelableElement(newIdentifiableElement).
	 * @param newIdentifiableElement the container object being set as container for this object
	 */
	public void setIdentifiableElement(IdentifiableElement newIdentifiableElement) 
	{
		this.setLabelableElement(newIdentifiableElement);
	}
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID)
        {
            case GraphPackage.IDENTIFIER__IDENTIFIABLE_ELEMENT:
                if (resolve) return getIdentifiableElement();
                return basicGetIdentifiableElement();
            case GraphPackage.IDENTIFIER__ID:
                return getId();
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
        switch (featureID)
        {
            case GraphPackage.IDENTIFIER__IDENTIFIABLE_ELEMENT:
                setIdentifiableElement((IdentifiableElement)newValue);
                return;
            case GraphPackage.IDENTIFIER__ID:
                setId((String)newValue);
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
        switch (featureID)
        {
            case GraphPackage.IDENTIFIER__IDENTIFIABLE_ELEMENT:
                setIdentifiableElement((IdentifiableElement)null);
                return;
            case GraphPackage.IDENTIFIER__ID:
                setId(ID_EDEFAULT);
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
        switch (featureID)
        {
            case GraphPackage.IDENTIFIER__IDENTIFIABLE_ELEMENT:
                return basicGetIdentifiableElement() != null;
            case GraphPackage.IDENTIFIER__ID:
                return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
        }
        return super.eIsSet(featureID);
    }

} //IdentifierImpl
