package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.lang.annotation.Inherited;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAbstractAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;
import de.hu_berlin.u.saltnpepper.salt.util.internal.SAnnotationContainerHelper;

@SuppressWarnings("serial")
public abstract class SAbstractAnnotationImpl extends LabelImpl implements SAbstractAnnotation, SAnnotationContainer {
	/** Initializes an object of type {@link SAbstractAnnotationImpl}. **/
	public SAbstractAnnotationImpl() {
	}

	/**
	 * Initializes an object of type {@link SAbstractAnnotationImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SAbstractAnnotationImpl(Label delegate) {
		super(delegate);
	}
	// ============================= start: SValueType
	protected SDATATYPE computeSValueType() {
		if (this.getValue() == null)
			return (SDATATYPE.SOBJECT);
		else if (this.getValue() instanceof String)
			return (SDATATYPE.STEXT);
		else if (this.getValue() instanceof Boolean)
			return (SDATATYPE.SBOOLEAN);
		else if (this.getValue() instanceof Integer)
			return (SDATATYPE.SNUMERIC);
		else if (this.getValue() instanceof Long)
			return (SDATATYPE.SNUMERIC);
		else if (this.getValue() instanceof Float)
			return (SDATATYPE.SFLOAT);
		else if (this.getValue() instanceof Double)
			return (SDATATYPE.SFLOAT);
		else if (this.getValue() instanceof URI)
			return (SDATATYPE.SURI);
		else
			return (SDATATYPE.SOBJECT);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_Type()}
	 */
	@Override
	public SDATATYPE getValueType() {
		SDATATYPE retVal = null;

		SFeature feature = getFeature(SaltUtil.FEAT_VALUE_DATATYPE);
		if (feature != null) {
			if ((feature.getValue() == null) && (this.getValue() != null)) {
				feature.setValue(computeSValueType());
			}
			retVal = SDATATYPE.valueOf(feature.getValue().toString());
		} else {// compute value type
			retVal = computeSValueType();

		}// compute value type
		return (retVal);
	}

	/**
	 * {@inheritDoc SAbstractAnnotation#setValueType(SDATATYPE)}
	 */
	@Override
	public void setValueType(SDATATYPE newSValueType) {
		SFeature feature = getFeature(SaltUtil.FEAT_VALUE_DATATYPE);
		if (feature == null) {
			feature = SaltFactory.createSFeature();
			feature.setQName(SaltUtil.FEAT_VALUE_DATATYPE);
			addFeature(feature);
		}
		if (newSValueType == null) {
			feature.setValue(null);
		} else {
			feature.setValue(newSValueType.toString());
		}
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_STEXT()}
	 */
	@Override
	public String getValue_STEXT() {
		String retVal = null;
		if (getValue() != null) {
			if (getValue() instanceof String) {
				retVal = (String) getValue();
			} else {
				retVal = getValue().toString();
			}
		}
		return (retVal);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_SBOOLEAN()}
	 */
	@Override
	public Boolean getValue_SBOOLEAN() {
		Boolean retVal = null;
		if (this.getValueType() == SDATATYPE.SBOOLEAN) {
			if (getValue() instanceof Boolean) {
				retVal = (Boolean) getValue();
			}
		}
		return (retVal);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_SNUMERIC()}
	 */
	@Override
	public Long getValue_SNUMERIC() {
		Long retVal = null;
		if (this.getValueType() == SDATATYPE.SNUMERIC) {
			if (getValue() instanceof Integer) {
				retVal = (Long) ((Integer) getValue()).longValue();
			} else if (getValue() instanceof Long) {
				retVal = (Long) getValue();
			}
		}
		return (retVal);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_SFLOAT()}
	 */
	@Override
	public Double getValue_SFLOAT() {
		Double retVal = null;
		if (this.getValueType() == SDATATYPE.SFLOAT) {
			if (getValue() instanceof Double) {
				retVal = (Double) getValue();
			} else if (getValue() instanceof Float) {
				retVal = ((Float) getValue()).doubleValue();
			}
		}
		return (retVal);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_SURI()}
	 */
	@Override
	public URI getValue_SURI() {
		URI retVal = null;
		if (this.getValueType() == SDATATYPE.SURI) {
			if (getValue() instanceof URI) {
				retVal = (URI) getValue();
			}
		}
		return (retVal);
	}

	/**
	 * {@link Inherited SAbstractAnnotation#getValue_SOBJECT()}
	 */
	@Override
	public Object getValue_SOBJECT() {
		return (getValue());
	}

	// ============================= end: SValueType
	// =======================================> SAnnotation
	/** {@inheritDoc} **/
	@Override
	public SAnnotation createAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SAnnotation> createAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createAnnotations(this, annotationString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addAnnotation(SAnnotation annotation) {
		SAnnotationContainerHelper.addAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		return (SAnnotationContainerHelper.getAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation getAnnotation(String qName) {
		return (SAnnotationContainerHelper.getAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SAnnotation> iterator_SAnnotation() {
		return (SAnnotationContainerHelper.iterator_SAnnotation(this));
	}

	// =======================================< SAnnotation

	// =======================================> SMetaAnnotation
	/** {@inheritDoc} **/
	@Override
	public void addMetaAnnotation(SMetaAnnotation metaAnnotation) {
		SAnnotationContainerHelper.addMetaAnnotation(this, metaAnnotation);
	}

	/** {@inheritDoc} **/
	@Override
	public SMetaAnnotation createMetaAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createMetaAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SMetaAnnotation> createMetaAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createMetaAnnotations(this, annotationString));
	}

	@Override
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations() {
		return (SAnnotationContainerHelper.getMetaAnnotations(this));
	}

	@Override
	public SMetaAnnotation getMetaAnnotation(String qName) {
		return (SAnnotationContainerHelper.getMetaAnnotation(this, qName));
	}

	@Override
	public Iterator<SMetaAnnotation> iterator_SMetaAnnotation() {
		return (SAnnotationContainerHelper.iterator_SMetaAnnotation(this));
	}

	// =======================================< SMetaAnnotation
	// =======================================> SProcessingAnnotation
	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation createProcessingAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createProcessingAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SProcessingAnnotation> createProcessingAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createProcessingAnnotations(this, annotationString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addProcessingAnnotation(SProcessingAnnotation annotation) {
		SAnnotationContainerHelper.addProcessingAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations() {
		return (SAnnotationContainerHelper.getProcessingAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation getProcessingAnnotation(String qName) {
		return (SAnnotationContainerHelper.getProcessingAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation() {
		return (SAnnotationContainerHelper.iterator_SProcessingAnnotation(this));
	}

	// =======================================< SProcessingAnnotation
	// =======================================> SFeature
	/** {@inheritDoc} **/
	@Override
	public SFeature createFeature(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createFeature(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SFeature> createFeatures(String featureString) {
		return (SAnnotationContainerHelper.createFeatures(this, featureString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addFeature(SFeature feature) {
		SAnnotationContainerHelper.addFeature(this, feature);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SFeature> Set<A> getFeatures() {
		return (SAnnotationContainerHelper.getFeatures(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SFeature getFeature(String qName) {
		return (SAnnotationContainerHelper.getFeature(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SFeature> iterator_SFeature() {
		return (SAnnotationContainerHelper.iterator_SFeature(this));
	}
	// =======================================< SFeature
}
