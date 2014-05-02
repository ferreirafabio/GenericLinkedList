package de.hska.iwii.i2.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitList {
	
	LinkedList<String> list = new LinkedList<>();
	
	@Before
	public void init() {
		list = new LinkedList<>();
	}
	
	
	@Test(expected = AssertionError.class)
	public void removeFirstEmpty() {
		list.removeFirst();
	}

	@Test(expected = AssertionError.class)
	public void removeLastEmpty() {
		list.removeLast();
	}

	@Test(expected = AssertionError.class)
	public void removeFromEmpty() {
		list.remove(5);
	}

	@Test
	public void readAtStart() {
		list.addFirst("1");
		list.addFirst("2");
		assertEquals(list.get(0), "2");
	}

	@Test(expected = AssertionError.class)
	public void get1() {
		list.addFirst("1");
		list.addFirst("2");
		list.get(3);
	}

	@Test(expected = AssertionError.class)
	public void get2() {
		list.addFirst("1");
		list.addFirst("2");
		list.get(-1);
	}

	@Test
	public void add1() {
		list.addFirst("1");
		list.addFirst("2");
		list.add(2, "3");
		assertEquals("3", list.get(2));
	}

	@Test(expected = AssertionError.class)
	public void add2() {
		list.addFirst("1");
		list.addFirst("2");
		list.add(3, "4");
	}

	@Test
	public void listEmpty() {
		list.addFirst("1");
		list.addFirst("2");
		list.remove(0);
		list.remove(0);
		assertTrue(list.listEmpty());
	}

	@Test
	public void emptyList1() {
		list.addFirst("1");
		list.addFirst("2");
		list.removeFirst();
		list.removeLast();
		assertTrue(list.listEmpty());
	}

	@Test
	public void emptyList2() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.removeLast();
		list.removeFirst();
		assertFalse(list.listEmpty());
	}

	@Test
	public void emptyList3() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.removeLast();
		list.removeFirst();
		assertEquals("2", list.get(0));
	}

	@Test //list of 5 elements
	public void emptyList4() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		list.addFirst("5");
		assertEquals("3", list.get(2));
	}

	@Test //list of 5 elements
	public void emptyList5() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		list.addFirst("5");
		assertEquals("2", list.get(3));
	}
	
	@Test //list of 4 elemens
	public void emptyList6() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		assertEquals("3", list.get(1));
	}
	
	@Test //list of 4 elemens
	public void emptyList7() {
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addFirst("4");
		assertEquals("1", list.get(3));
	}

}
