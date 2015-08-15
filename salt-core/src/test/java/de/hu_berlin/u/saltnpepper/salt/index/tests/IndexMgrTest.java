package de.hu_berlin.u.saltnpepper.salt.index.tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.index.IndexMgr;
import de.hu_berlin.u.saltnpepper.salt.index.IndexMgrImpl;

public class IndexMgrTest {

	protected IndexMgr fixture=null;
	
	public IndexMgr getFixture() {
		return fixture;
	}

	public void setFixture(IndexMgr fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new IndexMgrImpl());
	}

	/**
	 * Creates an index an checks if the index was created successfully.
	 */
	@Test
	public void testCreateIndex() {
		String index1= "index01";
		String index2= "index02";
		
		getFixture().createIndex(index1, String.class, String.class);
		assertTrue(getFixture().containsIndex(index1));
		getFixture().createIndex(index2, Object.class, Object.class);
		assertTrue(getFixture().containsIndex(index1));
		assertTrue(getFixture().containsIndex(index2));
	}
	
	/**
	 * Tests that only values can be added matching to the class type of value.
	 */
	@Test
	public void testAddValues(){
		String indexId= "index";
		getFixture().createIndex(indexId, String.class, String.class);
		
		try{
			getFixture().put(indexId, "wrongObject", new Integer(4));
			fail();
		}catch (ClassCastException e){}
		
		getFixture().put(indexId, "key", "val1");
		assertEquals("val1", getFixture().get(indexId, "key"));
		
		getFixture().put(indexId, "key", "val2");
		assertTrue(getFixture().getAll(indexId, "key").contains("val1"));
		assertTrue(getFixture().getAll(indexId, "key").contains("val2"));
	}
	
	/**
	 * Tests that a value is removed from all indexes at once.
	 */
	@Test
	public void testRemoveValue(){
		String index1= "index1";
		String index2= "index2";
		String index3= "index3";
		String key="key";
		Object value= new Object();		
		
		getFixture().createIndex(index1, String.class, Object.class);
		getFixture().createIndex(index2, String.class, Object.class);
		getFixture().createIndex(index3, String.class, Object.class);
		
		getFixture().put(index1, "key1", "val1");
		getFixture().put(index1, key, value);
		getFixture().put(index1, key, "val2");
		
		getFixture().put(index2, "key1", "val1");
		getFixture().put(index2, key, value);
		getFixture().put(index2, key, "val2");
		
		getFixture().put(index3, "key1", "val1");
		getFixture().put(index3, key, value);
		getFixture().put(index3, key, "val2");
	
		assertTrue(getFixture().getAll(index1, key).contains(value));
		assertTrue(getFixture().getAll(index2, key).contains(value));
		assertTrue(getFixture().getAll(index3, key).contains(value));
		
		getFixture().removeValue(value);
		
		assertFalse(getFixture().getAll(index1, key).contains(value));
		assertFalse(getFixture().getAll(index2, key).contains(value));
		assertFalse(getFixture().getAll(index3, key).contains(value));
	}
}
