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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getQName <em>QName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getLabelableElement <em>Labelable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl#getValueString <em>Value String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabelImpl extends LabelableElementImpl implements Label 
{
	//TODO to delete
	public static Long equalTime= 0l;
	
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQName() <em>QName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQName()
	 * @generated
	 * @ordered
	 */
	protected static final String QNAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getValueString() <em>Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueString()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueString() <em>Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueString()
	 * @generated
	 * @ordered
	 */
	protected String valueString = VALUE_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.LABEL;
	}
	
	/**
	 * Returns a hashcode, created  out of the namespace, the name and the value of this object.
	 * 
	 * @return hashcode for this object 
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getName()== null)       ? 0 : this.getName().hashCode());
		result = prime * result	+ ((this.getNamespace() == null) ? 0 : this.getNamespace().hashCode());
		result = prime * result + ((this.getValue() == null)     ? 0 : this.getValue().hashCode());
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
		{//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
//			if (obj.getClass()!= getClass())
			if (!(obj instanceof Label))
				return(false);
		}//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
		Label other = (Label) obj;
		{//namespace
			if (this.getNamespace() == null) 
			{
				if (other.getNamespace()!= null)
				{
					if (differences!= null)
						differences.add("This label does not have a namespace, but the given one does.");
					else return false;
				}
			}
			else if (other.getNamespace()== null)
			{
				if (differences!= null)
					differences.add("This label has a namespace, but the given one does not.");
				else return false;
			}
			else if (this.getNamespace().hashCode()!= other.getNamespace().hashCode())
			{
				if (differences!= null)
					differences.add("The values of both namespaces differs, the namespace of this label is '"+this.getNamespace()+"', whereas the namespace of the given label is '"+other.getNamespace()+"'.");
				else return false;
			}
		}//namespace
		{//name
			if (this.getName() == null) 
			{
				if (other.getName()!= null)
				{
					if (differences!= null)
						differences.add("This label does not have a name, but the given one does.");
					else return false;
				}
			}
			else if (other.getName()== null)
			{
				if (differences!= null)
					differences.add("This label has a name, but the given one does not.");
				else return false;
			}
			else if (this.getName().hashCode()!= other.getName().hashCode())
			{
				if (differences!= null)
					differences.add("The values of both names differs, the name of this label is '"+this.getName()+"', whereas the name of the given label is '"+other.getName()+"'.");
				else return false;
			}
		}//name
		{//value
			if (this.getValue() == null) 
			{
				if (other.getValue()!= null)
				{
					if (differences!= null)
						differences.add("This label does not have a value, but the given one does.");
					else return false;
				}
			}
			else if (other.getValue()== null)
			{
				if (differences!= null)
					differences.add("This label has a value, but the given one does not.");
				else return false;
			}
			else if (this.getValue().hashCode()!= other.getValue().hashCode())
			{
				if (differences!= null)
					differences.add("The values of both values differs, the value of this label is '"+this.getValue()+"', whereas the value of the given label is '"+other.getValue()+"'.");
				else return false;
			}
		}//value
		return true;
	}
	
	/**
	 * Checks the equality of this object and a given one basing on the namespace, the name and
	 * the value of both objects. The objects are only equal, if the String- comparisons for namespace 
	 * and name as well and the equals() method for value returns true. In case of String-comparison,
	 * the method is case-sensitive.
	 * 
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return(this.equals(null, obj));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setName(String newName) 
	{
		if ((newName== null) || (newName.equals("")))
			throw new GraphException("Cannot set the name of this label object, because it is empty.");
		if (newName.contains(GET_NS_SEPERATOR()))
			throw new GraphException("Cannot set the name to the given, because a namespace with namespace seperaor is illegal.");
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getQName() 
	{
		StringBuffer retVal= new StringBuffer();
		
		if ((this.getNamespace()== null) && (this.getName()== null))
			retVal= null;
		else if ((this.getNamespace()== null)  || (this.getNamespace().equals("")))
			retVal.append(this.getName());
		else if ((this.getName()== null) || (this.getName().equals("")))
			retVal.append(this.getNamespace());
		else
		{	
			retVal.append(this.getNamespace());
			retVal.append(Label.NS_SEPERATOR);
			retVal.append(this.getName());
		}
		
		if (retVal!= null)
			return(retVal.toString());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setQName(String newQName) 
	{
		if ((newQName == null) || (newQName.equals("")))
			throw new GraphException("Cannot set new name, because it�s null or empty. ");
		String[] fullName= newQName.split(GET_NS_SEPERATOR());
		StringBuffer ns= new StringBuffer();
		String name= null;
		for (int i= 0; i < fullName.length; i++)
		{
			//last part of fullname reached
			if (i == fullName.length-1)
				name= fullName[i];
			else 
			{					
				if ((ns== null) || (ns.toString().equals("")))
					ns.append(fullName[i]);
				else 
				{
					ns.append(GET_NS_SEPERATOR());
					ns.append(fullName[i]);
				}
			}	
		}
		if (ns.length()!=0)
			this.setNamespace(ns.toString());
		if (name.length()!=0)
			this.setName(name.toString());
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 */
//	public String getFullName() 
//	{
//		StringBuffer retVal= new StringBuffer();
//		
//		if ((this.getNamespace()== null) && (this.getName()== null))
//			retVal= null;
//		else if ((this.getNamespace()== null)  || (this.getNamespace().equals("")))
//			retVal.append(this.getName());
//		else if ((this.getName()== null) || (this.getName().equals("")))
//			retVal.append(this.getNamespace());
//		else
//		{	
//			retVal.append(this.getNamespace());
//			retVal.append(Label.NS_SEPERATOR);
//			retVal.append(this.getName());
//		}
//		
//		if (retVal!= null)
//			return(retVal.toString());
//		else return(null);
//	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 */
//	public void setFullName(String newFullName) 
//	{
//		if ((newFullName == null) || (newFullName.equals("")))
//			throw new GraphException("Cannot set new name, because it�s null or empty. ");
//		String[] fullName= newFullName.split(GET_NS_SEPERATOR());
//		StringBuffer ns= new StringBuffer();
//		String name= null;
//		for (int i= 0; i < fullName.length; i++)
//		{
//			//last part of fullname reached
//			if (i == fullName.length-1)
//				name= fullName[i];
//			else 
//			{					
//				if ((ns== null) || (ns.toString().equals("")))
//					ns.append(fullName[i]);
//				else 
//				{
//					ns.append(GET_NS_SEPERATOR());
//					ns.append(fullName[i]);
//				}
//			}	
//		}
//		if (ns.length()!=0)
//			this.setNamespace(ns.toString());
//		if (name.length()!=0)
//			this.setName(name.toString());
//	}

	private Object value= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getValue() 
	{
		return(this.value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setValue(Object newValue) 
	{
		this.value= newValue;
		
		//synchronize with valueString
		if (value!= null)
			this.valueString= this.value.toString();
		else this.valueString= null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelableElement getLabelableElement() {
		if (eContainerFeatureID() != GraphPackage.LABEL__LABELABLE_ELEMENT) return null;
		return (LabelableElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabelableElement(LabelableElement newLabelableElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLabelableElement, GraphPackage.LABEL__LABELABLE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelableElement(LabelableElement newLabelableElement) {
		if (newLabelableElement != eInternalContainer() || (eContainerFeatureID() != GraphPackage.LABEL__LABELABLE_ELEMENT && newLabelableElement != null)) {
			if (EcoreUtil.isAncestor(this, newLabelableElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLabelableElement != null)
				msgs = ((InternalEObject)newLabelableElement).eInverseAdd(this, GraphPackage.LABELABLE_ELEMENT__LABELS, LabelableElement.class, msgs);
			msgs = basicSetLabelableElement(newLabelableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__LABELABLE_ELEMENT, newLabelableElement, newLabelableElement));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueString() {
		return valueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setValueString(String newValueString) {
		String oldValueString = valueString;
		valueString = newValueString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LABEL__VALUE_STRING, oldValueString, valueString));
		
		//synchronize with value
		this.setValue(newValueString);
	}

	// ------------------------------ start: static ns_seperator
	
	public static String GET_NS_SEPERATOR()
	{
		return(NS_SEPERATOR);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public String getNSSeperator() 
	{
		return(GET_NS_SEPERATOR());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object clone() 
	{
		return(this.clone(GraphFactory.eINSTANCE.createLabel()));
	}

	/**
	 * This method returns the given object. It adds all properties of this to the given object.
	 * @param clone the clone to which all properties of this shall be copied to
	 * @return
	 */
	protected Object clone(Label clone)
	{
		if (clone== null)
			throw new GraphException("Cannot clone label '"+this+"', because the given object is null and its not possible to copy values into a null object.");
		
		clone.setNamespace(this.getNamespace());
		clone.setName(this.getName());
		clone.setValue(this.getValue());
		return(clone);
	}
	
	// ------------------------------ end: static ns_seperator

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLabelableElement((LabelableElement)otherEnd, msgs);
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
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				return basicSetLabelableElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, GraphPackage.LABELABLE_ELEMENT__LABELS, LabelableElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.LABEL__NAMESPACE:
				return getNamespace();
			case GraphPackage.LABEL__NAME:
				return getName();
			case GraphPackage.LABEL__QNAME:
				return getQName();
			case GraphPackage.LABEL__VALUE:
				return getValue();
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				return getLabelableElement();
			case GraphPackage.LABEL__VALUE_STRING:
				return getValueString();
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
			case GraphPackage.LABEL__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case GraphPackage.LABEL__NAME:
				setName((String)newValue);
				return;
			case GraphPackage.LABEL__QNAME:
				setQName((String)newValue);
				return;
			case GraphPackage.LABEL__VALUE:
				setValue(newValue);
				return;
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				setLabelableElement((LabelableElement)newValue);
				return;
			case GraphPackage.LABEL__VALUE_STRING:
				setValueString((String)newValue);
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
			case GraphPackage.LABEL__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case GraphPackage.LABEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphPackage.LABEL__QNAME:
				setQName(QNAME_EDEFAULT);
				return;
			case GraphPackage.LABEL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				setLabelableElement((LabelableElement)null);
				return;
			case GraphPackage.LABEL__VALUE_STRING:
				setValueString(VALUE_STRING_EDEFAULT);
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
			case GraphPackage.LABEL__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case GraphPackage.LABEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphPackage.LABEL__QNAME:
				return QNAME_EDEFAULT == null ? getQName() != null : !QNAME_EDEFAULT.equals(getQName());
			case GraphPackage.LABEL__VALUE:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
			case GraphPackage.LABEL__LABELABLE_ELEMENT:
				return getLabelableElement() != null;
			case GraphPackage.LABEL__VALUE_STRING:
				return VALUE_STRING_EDEFAULT == null ? valueString != null : !VALUE_STRING_EDEFAULT.equals(valueString);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(", name: ");
		result.append(name);
		result.append(", valueString: ");
		result.append(valueString);
		result.append(')');
		return result.toString();
	}

} //LabelImpl