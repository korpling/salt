package de.hu_berlin.german.korpling.saltnpepper.salt.graph.util.tests;

import java.util.Collection;
import java.util.Vector;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.util.UnmodifiableEList;
import junit.framework.TestCase;

public class UnmodifiableEListTest extends TestCase {	
	/**
	 * Tests if method {@link UnmodifiableEList#indexOf(Object)} works correctly.
	 * @param o
	 */
	public void testIndexOf() {
		Collection<String> data= new Vector<String>();
		data.add("no6");
		data.add("no4");
		data.add("no7");
		data.add("no3");
		data.add("no1");
		data.add("no5");
		data.add("no2");
		
		UnmodifiableEList<String> fixture= new UnmodifiableEList<String>(data);
		assertEquals(4, fixture.indexOf("no1"));
		assertEquals(6, fixture.indexOf("no2"));
		assertEquals(3, fixture.indexOf("no3"));
		assertEquals(1, fixture.indexOf("no4"));
		assertEquals(5, fixture.indexOf("no5"));
		assertEquals(0, fixture.indexOf("no6"));
		assertEquals(2, fixture.indexOf("no7"));
	}

	/**
	 * Tests if method {@link UnmodifiableEList#lastIndexOf(Object)} works correctly.
	 * @param o
	 */
	public void testLastIndexOf() {
		Collection<String> data= new Vector<String>();
		data.add("no3");
		data.add("no2");
		data.add("no1");
		data.add("no3");
		data.add("no1");
		data.add("no5");
		data.add("no2");
		
		UnmodifiableEList<String> fixture= new UnmodifiableEList<String>(data);
		assertEquals(4, fixture.lastIndexOf("no1"));
		assertEquals(6, fixture.lastIndexOf("no2"));
		assertEquals(3, fixture.lastIndexOf("no3"));
	}
}
