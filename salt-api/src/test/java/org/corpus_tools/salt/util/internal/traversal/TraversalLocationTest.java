package org.corpus_tools.salt.util.internal.traversal;

import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TraversalLocationTest {

	@Test
	public void verifyEqualsAndHashCode() {
		EqualsVerifier.forClass(TraversalLocation.class).suppress(Warning.STRICT_INHERITANCE).verify();
	}
}
