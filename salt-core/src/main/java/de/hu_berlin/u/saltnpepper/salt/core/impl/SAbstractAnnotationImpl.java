package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.lang.annotation.Inherited;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SAbstractAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class SAbstractAnnotationImpl extends LabelImpl implements SAbstractAnnotation {

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

		Label label = super.getLabel(SaltUtil.KW_SVAL_TYPE);
		if (label != null) {
			if ((label.getValue() == null) && (this.getValue() != null)) {
				label.setValue(computeSValueType());
			}
			retVal = SDATATYPE.valueOf(label.getValue().toString());
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
		Label label = super.getLabel(SaltUtil.KW_SVAL_TYPE);
		if (label == null) {
			label = GraphFactory.createLabel();
			label.setQName(SaltUtil.KW_SVAL_TYPE);
			this.addLabel(label);
		}
		if (newSValueType == null){
			label.setValue(null);
		}else{
			label.setValue(newSValueType.toString());
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
}
