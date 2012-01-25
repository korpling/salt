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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SNamed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl#getSName <em>SName</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SNamedElementImpl extends SFeaturableElementImpl implements SNamedElement 
{
	
	/**
	 * This is a static version of the method:
	 * {@inheritDoc SNamedElement#getSName()}
	 * 
	 * This static method is necessary for multiple inheritance, to not rewrite the code in each class 
	 * extending this class.
	 */
	public static String getSName(SNamedElement sNamedElement) {
		SFeature sNameFeature= sNamedElement.getSFeature(SaltCoreFactory.SALT_CORE_NAMESPACE, SaltCoreFactory.SALT_CORE_SFEATURES.SNAME.toString());
		if (sNameFeature!= null)
		{
			return(sNameFeature.getSValue().toString());
		}
		else return(null);
	}

	/**
	 * This is a static version of the method:
	 * {@inheritDoc SNamedElement#setSName(String)}
	 * 
	 * This static method is necessary for multiple inheritance, to not rewrite the code in each class 
	 * extending this class. 
	 */
	public static void setSName(SNamedElement sNamedElement, String newSName) 
	{
		SFeature sNameFeature= sNamedElement.getSFeature(SaltCoreFactory.SALT_CORE_NAMESPACE, SaltCoreFactory.SALT_CORE_SFEATURES.SNAME.toString());
		if (sNameFeature== null)
			sNameFeature= sNamedElement.createSFeature(SaltCoreFactory.SALT_CORE_NAMESPACE, SaltCoreFactory.SALT_CORE_SFEATURES.SNAME.toString(), newSName);
		else
			sNameFeature.setSValue(newSName);
	}
	
	/**
	 * Takes notifications important concerning the SName handling.
	 * Checks if a label equal to sName is contained twice in the list of labels (this occurs, when the model is loaded from XML file), 
	 * in such a case, the first found label having the namespace salt and the name SNAME is the real one. In such a case copy the value of the
	 * new given feature to the already existing label and remove the new given feature
	 * 
	 * @param notifiedElement the {@link SNamedElement} object delegating the method
	 * @param notification the notification to be handled
	 */
	public static void eNotify(SNamedElement notifiedElement, Notification notification)
	{
		if(GraphPackage.Literals.LABELABLE_ELEMENT__LABELS.equals(notification.getFeature())) 
		{//if change happens in LabelableElement.getLabels()
			switch (notification.getEventType()) 
			{
				case Notification.ADD:
				{//if Label is added
					if (notification.getNewValue() instanceof SFeature)
					{//if added Label is Identifier
						SFeature sFeature= (SFeature) notification.getNewValue();
						if (	(SaltCoreFactory.SALT_CORE_SFEATURES.SNAME.toString().equals(sFeature.getSName()))&&
								(SaltCoreFactory.SALT_CORE_NAMESPACE.equals(sFeature.getSNS())))
						{
							//start: check if sName is contained twice
								//check if a label equal to sName is contained twice in list, in such a case, the first found label
								//having the namespace salt and the name SNAME is the real one. In such a case copy the value of the
								//new given feature to the already existing label and remove the new given feature
								boolean toRemove=false;
								for (Label label: notifiedElement.getLabels())
								{
									if (	(SaltCoreFactory.SALT_CORE_SFEATURES.SNAME.toString().equals(label.getName()))&&
											(SaltCoreFactory.SALT_CORE_NAMESPACE.equals(label.getNamespace())))
									{
										if (label!= sFeature)
										{
											label.setValue(sFeature.getSValue());
											toRemove= true;
										}
									}
								}
								if (toRemove)
									notifiedElement.getLabels().remove(sFeature);
							//end: check if sName is contained twice
						}
					}//if added Label is Identifier
				}//if Label is added
			}
		}//if change happens in LabelableElement.getLabels()
	}
	
	/**
	 * The default value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SNAMED_ELEMENT;
	}

	/**
	 * {@inheritDoc SNamedElement#getSName()}
	 */
	public String getSName() {
		return(SNamedElementImpl.getSName(this));
	}

	/**
	 * {@inheritDoc SNamedElement#setSName(String)}
	 */
	public void setSName(String newSName) 
	{
		SNamedElementImpl.setSName(this, newSName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SNAMED_ELEMENT__SNAME:
				return getSName();
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
			case SaltCorePackage.SNAMED_ELEMENT__SNAME:
				setSName((String)newValue);
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
			case SaltCorePackage.SNAMED_ELEMENT__SNAME:
				setSName(SNAME_EDEFAULT);
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
			case SaltCorePackage.SNAMED_ELEMENT__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
		}
		return super.eIsSet(featureID);
	}

} //SNamedElementImpl
