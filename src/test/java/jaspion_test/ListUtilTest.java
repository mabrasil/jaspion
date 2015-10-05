package jaspion_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static jaspion.ListUtil.*;
import static org.junit.Assert.*;

public class ListUtilTest {
	
	@Test
	public void testShouldCreateListOfIntegers() {
		List<Integer> list = Arrays.asList(2, 3, 4);
		
		List<Integer> nlist = map(x -> x * 2, list);
		
		assertEquals(Integer.valueOf(4), nlist.get(0));
		assertEquals(Integer.valueOf(6), nlist.get(1));
		assertEquals(Integer.valueOf(8), nlist.get(2));
	}
	
	@Test
	public void testShouldCreateListOfStrings() {
		List<Integer> list = Arrays.asList(2, 3, 4);
		
		List<String> nlist = map(x -> x.toString(), list, String.class);
		
		assertEquals("2", nlist.get(0));
		assertEquals("3", nlist.get(1));
		assertEquals("4", nlist.get(2));
	}
	
	@Test
	public void testShouldCreateArrayListOfIntegers() {
		List<Integer> list = new LinkedList<>();
		
		list.add(1); 
		list.add(2); 
		list.add(3);
		
		List<Integer> nlist = map(x -> x + 2, list, ArrayList::new);
		
		assertTrue(nlist instanceof ArrayList);
	}
	
	@Test
	public void testShouldCreateLinkedListOfStrings() {
		List<Integer> list = new ArrayList<>();
		
		list.add(2);
		list.add(3);
		list.add(4);
		
		List<String> nlist = map(x -> x.toString(), list, String.class, LinkedList::new);
		
		assertEquals("2", nlist.get(0));
		assertEquals("3", nlist.get(1));
		assertEquals("4", nlist.get(2));
		
		assertTrue(nlist instanceof LinkedList);
	}
	
	@Test
	public void testShouldFilterEvenValues() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		List<Integer> evenList = filter(x -> x % 2 == 0, list);
		
		assertEquals(Integer.valueOf(2), evenList.get(0));
		assertEquals(Integer.valueOf(4), evenList.get(1));
		assertEquals(Integer.valueOf(6), evenList.get(2));
	}
	
	@Test
	public void testShouldFilterStringValues() {
	    List<Object> list = Arrays.asList(1, "2", "three", 4);
	    
	    List<String> strList = filter(x -> x instanceof String, list, String.class);
		
	    assertEquals("2", strList.get(0));
	    assertEquals("three", strList.get(1));
	}
	
	@Test
	public void testShouldFilterOddValuesToArrayList() {
	    List<Integer> list = new LinkedList<>();
	    
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.add(5);
	    list.add(6);
	    
	    List<Integer> nlist = filter(x -> !(x % 2 == 0), list, ArrayList::new);
	    
	    assertTrue(nlist instanceof ArrayList);
	}
	
	@Test
	public void testShouldFilterStringValuesToLinkedList() {
	    List<Object> list = new ArrayList<>();
	    
	    list.add(2);
	    list.add("3");
	    list.add(true);
	    list.add("five");
	    
	    List<String> nlist = filter(x -> x instanceof String, list, String.class, LinkedList::new);
	    
	    assertEquals("3", nlist.get(0));
	    assertEquals("five", nlist.get(1));
	    
	    assertTrue(nlist instanceof LinkedList);
	}
}
