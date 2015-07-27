package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

public class SNodeTest extends SAnnotatableElementTest{

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSNode());
	}

}
