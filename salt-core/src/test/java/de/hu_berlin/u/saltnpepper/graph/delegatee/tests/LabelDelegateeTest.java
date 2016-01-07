package de.hu_berlin.u.saltnpepper.graph.delegatee.tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class LabelDelegateeTest {

	private Label fixture= null;
	
	public Label getFixture() {
		return fixture;
	}

	public void setFixture(Label fixture) {
		this.fixture = fixture;
	}

	TestLabel delegator= null;
	@Before
	public void setUp() throws Exception {
		delegator= new TestLabel();
		setFixture(new LabelImpl(delegator));
	}

	@Test
	public void testDelegateeNamespace() {
		getFixture().setNamespace("myNamespace");
		assertEquals("setNamespace", delegator.lastMethod);
		getFixture().getNamespace();
		assertEquals("getNamespace", delegator.lastMethod);
	}
	@Test
	public void testDelegateeNames() {
		getFixture().setName("myNames");
		assertEquals("setName", delegator.lastMethod);
		getFixture().getName();
		assertEquals("getName", delegator.lastMethod);
	}
	
	@Test
	public void testDelegateeValue() {
		getFixture().setValue("myValue");
		assertEquals("setValue", delegator.lastMethod);
		getFixture().getValue();
		assertEquals("getValue", delegator.lastMethod);
	}
	@Test
	public void testQName() {
		getFixture().setQName(SaltUtil.createQName("myNamespace", "myName"));
		assertEquals("setQName", delegator.lastMethod);
		getFixture().getQName();
		assertEquals("getQName", delegator.lastMethod);
	}
	
	@Test
	public void testDelegateeLabel() {
		Label label= GraphFactory.createLabel();
		label.setName("myName");
		getFixture().addLabel(label);
		assertEquals("addLabel", delegator.lastMethod);
		getFixture().getLabel("myNamespace", "myName");
		assertEquals("getLabel", delegator.lastMethod);
		getFixture().getLabels();
		assertEquals("getLabels", delegator.lastMethod);
		getFixture().getLabel("both");
		assertEquals("getLabel", delegator.lastMethod);
	}
	
	

	private class TestLabel extends LabelImpl implements Label{
		public String lastMethod=null; 
		
		@Override
		public Collection<Label> getLabels() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getLabels());
		}

		@Override
		public void addLabel(Label label) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.addLabel(label);
		}

		@Override
		public Label getLabel(String namespace, String name) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getLabel(namespace, name));
		}

		@Override
		public Label getLabel(String qName) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getLabel(qName));
		}

		@Override
		public void removeLabel(String qName) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.removeLabel(qName);
		}

		@Override
		public void removeLabel(String namespace, String name) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.removeLabel(namespace, name);
		}

		@Override
		public void removeAll() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.removeAll();
			
		}

		@Override
		public Set<Label> getLabelsByNamespace(String namespace) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getLabelsByNamespace(namespace));
		}

		@Override
		public boolean containsLabel(String qName) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.containsLabel(qName));
		}

		@Override
		public Integer sizeLabels() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.sizeLabels());
		}

		@Override
		public void copy(Label surrogate) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.copy(surrogate);
		}

		@Override
		public String getNamespace() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getNamespace());
		}

		@Override
		public void setNamespace(String namespace) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.setNamespace(namespace);
		}

		@Override
		public String getName() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getName());
		}

		@Override
		public void setName(String name) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.setName(name);
		}

		@Override
		public String getQName() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getQName());
		}

		@Override
		public void setQName(String qName) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.setQName(qName);
		}

		@Override
		public Object getValue() {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			return(super.getValue());
		}

		@Override
		public void setValue(Object value) {
			lastMethod= Thread.currentThread().getStackTrace()[2].getMethodName();
			super.setValue(value);
			
		}
	}
}
