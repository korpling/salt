package org.corpus_tools.salt.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.junit.Before;
import org.junit.Test;

public class AnnotationFinderTest {
	private static final SAnnotation RED = createAnnotation("red");
	private static final SAnnotation GREEN = createAnnotation("green");
	private static final SAnnotation BLUE = createAnnotation("blue");
	private static final String PASTEL = "pastel";
	private static final SAnnotation PASTEL_RED = createAnnotation(PASTEL, "red");
	private static final SAnnotation PASTEL_GREEN = createAnnotation(PASTEL, "green");
	private static final SAnnotation PASTEL_BLUE = createAnnotation(PASTEL, "blue");
	private static final SMetaAnnotation PASTEL_PEN = createMetaAnnotation("gray");
	private SAnnotationContainer container;

	private static SAnnotation createAnnotation(String name) {
		return createAnnotation(null, name);
	}

	private static SAnnotation createAnnotation(String namespace, String name) {
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setNamespace(namespace);
		anno.setName(name);
		return anno;
	}

	private static SMetaAnnotation createMetaAnnotation(String name) {
		SMetaAnnotation anno = SaltFactory.createSMetaAnnotation();
		anno.setName(name);
		return anno;
	}

	@Before
	public void beforeEach() {
		container = SaltFactory.createSAnnotation();
	}

	private void given() {
		container.add(RED);
		container.add(PASTEL_GREEN);
		container.add(BLUE);
		container.add(PASTEL_BLUE);
		container.add(GREEN);
		container.add(PASTEL_RED);
		container.add(PASTEL_PEN);
	}

	@Test
	public void whenFindRedGreenBlue_returnEach() {
		// given
		given();
		// when and then
		assertThat(container.find(SAnnotation.class).withNamespace(PASTEL).withName("blue").go())
				.containsOnly(PASTEL_BLUE);
		assertThat(container.find(SAnnotation.class).withNamespace(PASTEL).withName("green").go())
				.containsOnly(PASTEL_GREEN);
		assertThat(container.find(SAnnotation.class).withNamespace(PASTEL).withName("red").go())
				.containsOnly(PASTEL_RED);
	}

	@Test
	public void whenFindAllBlues_returnBlueAndPastelBlue() {
		// given
		given();
		// when and then
		assertThat(container.find(SAnnotation.class).withName("blue").go()).containsOnly(BLUE, PASTEL_BLUE);
	}

	@Test
	public void whenFindAllPastelColors_returnRedGreenBlue() {
		// given
		given();
		// when and then
		assertThat(container.find(SAnnotation.class).withNamespace(PASTEL).go()).containsOnly(PASTEL_BLUE, PASTEL_GREEN,
				PASTEL_RED);
	}
}
