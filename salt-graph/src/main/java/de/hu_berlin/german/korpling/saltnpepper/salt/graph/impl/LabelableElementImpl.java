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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Labelable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl#getLabels <em>Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabelableElementImpl extends EObjectImpl implements LabelableElement {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> labels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.LABELABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentWithInverseEList<Label>(Label.class, this, GraphPackage.LABELABLE_ELEMENT__LABELS, GraphPackage.LABEL__LABELABLE_ELEMENT);
		}
		return labels;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addLabel(Label label) 
	{
		if (label== null)
			throw new GraphException("Cannot add an empty label object.");
		if ((label.getName()== null) || (label.getName().isEmpty()))
			throw new GraphException("Cannot add a label object without a name.");
		//checking if QName already exists
		boolean exists= false;
		for (Label searchLabel: this.getLabels())
		{
			if (searchLabel.getQName().equalsIgnoreCase(label.getQName()))
			{
				exists= true;
				break;
			}
		}
		if (exists)
		{
			if (this instanceof IdentifiableElement)	
				throw new GraphException("Cannot add the given label '"+label+"' object to LabelableElement '"+((IdentifiableElement)this).getId()+"', because a label with this QName already exists: "+ label.getQName());
			else
				throw new GraphException("Cannot add the given label object, because a label with this QName already exists: "+ label.getQName());
		}
		this.getLabels().add(label);
	}

	/**
	 * Returns a QName created of namespace, seperator and name.
	 * @param namespace 
	 * @param name
	 */
	private String getQName(String namespace, String name)
	{
		String retVal= null;
		if ((namespace!= null) && (!namespace.isEmpty()))
			retVal= namespace + LabelImpl.GET_NS_SEPERATOR();
		retVal= retVal + name;
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Label getLabel(String ns, String name) 
	{
		return(this.getLabel(this.getQName(ns, name)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Label getLabel(String QName) 
	{
		if ((QName== null) || (QName.isEmpty()))
				return(null);
		Label retLabel= null;
		for (Label label: this.getLabels())
		{
			if (label.getQName().equalsIgnoreCase(QName))
			{
				retLabel= label;
				break;
			}
				
		}
		return(retLabel);	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeLabel(String QName) 
	{
		boolean retVal= false;
		Integer i= null;
		for (Label label: this.getLabels())
		{
			if (label.getQName().equalsIgnoreCase(QName))
			{ 
				i= this.getLabels().indexOf(label);
				break;
			}
		}
		if (i== null)
			return(false);
		else
		{
			this.getLabels().remove(i.intValue());
			retVal= true;
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int getNumOfLabels() 
	{
		return(this.getLabels().size());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeAll() 
	{
		this.getLabels().clear();
		return(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Label> getLabelsByNamespace(String ns) 
	{
		EList<Label> labels= new BasicEList<Label>();
		
		for (Label label: this.getLabels())
		{
			if (	(label.getNamespace()!= null) && 
					(label.getNamespace().equalsIgnoreCase(ns)))
			{
				labels.add(label);
			}
			else if ((ns== null) && (label.getNamespace()== null))
			{
				labels.add(label);
			}
		}
		return(labels);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean hasLabel(String QName) 
	{
		boolean retVal= false;
		if ((QName== null) || (QName.isEmpty()))
			retVal= false;
		else
		{
			for (Label label: this.getLabels())
			{
				if (label.getQName().equalsIgnoreCase(QName))
				{
					retVal= true;
					break;
				}
			}
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeLabel(String namespace, String name) 
	{
		StringBuffer QName= new StringBuffer();
		QName.append(namespace);
		QName.append(Label.NS_SEPERATOR);
		QName.append(name);
		return(this.removeLabel(QName.toString()));
	}

	/**
	 * Returns a hashcode, created  out of the labels-object.
	 * 
	 * @return hashcode for this object 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		return result;
	}

	/**
	 * Returns all the differences between this object and the given one as a list of strings. This method uses the same
	 * comparisons as the equals method. 
	 * @param obj object to compare with
	 * @return a list of differences, null if both objects are equal
	 * @model
	 */
	@Override
	public EList<String> differences(Object obj)
	{
		EList<String> retVal= new BasicEList<String>();
		boolean equals= this.equals(retVal, obj);
		if (retVal.size()== 0)
		{
			if (!equals)
			{
				retVal.add("An unknown difference was found.");
			}
			else 
			{
				retVal= null;
			}
		}
		return(retVal);
	}
	
	/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	public boolean equals(EList<String> differences, Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
		{
			if (differences!= null)
				differences.add(this.getClass().getSimpleName()+": The given object is null.");
			else return false;
		}
		if (!(obj instanceof LabelableElement))
		{
			if (differences!= null)
			{
				differences.add(this.getClass().getSimpleName()+": The given object is not of type '"+getClass()+"', it is of type '"+obj.getClass()+"'.");
			}
			return false;
		}
		LabelableElementImpl other = (LabelableElementImpl) obj;
		if (this.getLabels() == null) 
		{
			if (other.getLabels() != null)
			{
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": This object contains no labels, but the given one does.");
				else return false;
			}
		} 
		else 
		{
			if (this.getLabels().size()!= other.getLabels().size())
			{
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The number of labels for both objects is not the same, this object has '"+this.getLabels().size()+"' labels, whereas the other object contains '"+other.getLabels().size()+"'.");
				else return false;
			}
			System.out.println("---------------------------> HELLO");
			// TODO: remove this when hashEList is part of labelableElementImpl
			HashSet<Label> thisLabels = new HashSet<Label>(this.getLabels());
			for (Label label : other.getLabels())
			{
			// for label l in this.getLabels: get equivalent label in hashedEList
				// if not existent: >> Differences
				if (! thisLabels.contains(label))
				{
					System.out.println("label "+label+" is not contained.");
					if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The label object '"+label.getQName()+"' in "+this+" has no equivalent in "+other+".");
					else return false;
				}
			}
		}
		return true;
	}
	 
	/**
	 * Checks the equality of this object and a given one basing on the id-value
	 * of both objects. The objects are only equal, if the String- comparisons for the id-value
	 * returns true. In case of String-comparison, the method is case-sensitive.
	 * TODO take care, that the flag differences does not allow to get the differences by two separate threads at one time
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		boolean retVal= this.equals(null, obj);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabels()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				return ((InternalEList<?>)getLabels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				return getLabels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				getLabels().clear();
				getLabels().addAll((Collection<? extends Label>)newValue);
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
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				getLabels().clear();
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
			case GraphPackage.LABELABLE_ELEMENT__LABELS:
				return labels != null && !labels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LabelableElementImpl
