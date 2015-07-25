/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.core.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelableElementImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotatableElement;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>SAnnotation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl#getSAnnotatableElement
 * <em>SAnnotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class SAnnotationImpl extends LabelImpl implements SAnnotation {

	protected SAnnotationImpl() {
		super();
	}

//	/** {@inheritDoc} */
//	@Override
//	public SAnnotatableElement getSAnnotatableElement() {
//		SAnnotatableElement retVal = null;
//		LabelableElement labelableElement = getLabelableElement();
//		if (labelableElement instanceof SAnnotatableElement){
//			retVal = (SAnnotatableElement) labelableElement;
//		}
//		return (retVal);
//	}
//
//	/** {@inheritDoc} */
//	@Override
//	public void setSAnnotatableElement(SAnnotatableElement newSAnnotatableElement) {
//		super.setLabelableElement(newSAnnotatableElement);
//	}
} // SAnnotationImpl
