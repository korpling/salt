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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IndexFactoryImpl extends EFactoryImpl implements IndexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IndexFactory init() {
		try {
			IndexFactory theIndexFactory = (IndexFactory)EPackage.Registry.INSTANCE.getEFactory("index"); 
			if (theIndexFactory != null) {
				return theIndexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IndexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IndexPackage.SIMPLE_INDEX: return createSimpleIndex();
			case IndexPackage.INDEX_MGR: return createIndexMgr();
			case IndexPackage.COMPLEX_INDEX: return createComplexIndex();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <K, V> SimpleIndex<K, V> createSimpleIndex() {
		SimpleIndexImpl<K, V> simpleIndex = new SimpleIndexImpl<K, V>();
		return simpleIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexMgr createIndexMgr() {
		IndexMgrImpl indexMgr = new IndexMgrImpl();
		return indexMgr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public <K, V> ComplexIndex<K, V> createComplexIndex() {
//		ComplexIndexImpl<K, V> complexIndex = new ComplexIndexImpl<K, V>();
//		return complexIndex;
		SlimComplexIndexImpl<K, V> complexIndex = new SlimComplexIndexImpl<K, V>();
		return complexIndex;
	}
	
	/**
	 * Creates a {@link IdentifiableElementIndex} object which can contain the given value V as value objects.
	 * @return {@link IdentifiableElementIndex} object 
	 */
	@Override
	public <V extends IdentifiableElement> IdentifiableElementIndex<V> createIdentifiableElementIndex()
	{
		IdentifiableElementIndex<V> idIndex = new IdentifiableElementIndex<V>();
		return idIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexPackage getIndexPackage() {
		return (IndexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IndexPackage getPackage() {
		return IndexPackage.eINSTANCE;
	}
} //IndexFactoryImpl
