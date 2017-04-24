package testers;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import edu.miracosta.cs113.HashtableChain;
import org.junit.Test;

public class HashtableChainTest 
{
	private HashtableChain<Integer, String> table = new HashtableChain<Integer, String>(7);
	
	public void addItems()
	{
		table.put(1, "one" );
		table.put(2, "two");
		table.put(3, "three");
		table.put(4, "four");
		table.put(5, "five");
		table.put(6, "six");
		table.put(7, "seven");
	}

	@Test
	public void testSize() {
		addItems();
		assertEquals(table.size(), 7);
	}

	@Test
	public void testIsEmpty() {
		addItems();
		assertFalse(table.isEmpty());
	}

	@Test
	public void testHashtableChain() {
		HashtableChain<Integer, String> table2 = new HashtableChain<Integer, String>(5);
		table2.put(1, "one");
		assertEquals(table2.size(), 1);
	}

	@Test
	public void testGetObject() {
		addItems();
		assertEquals(table.get(4), "four");
	}

	@Test
	public void testPutKV() {
		addItems();
		table.put(8, "eight");
		assertEquals(table.get(8), "eight");
	}

	@Test
	public void testRemoveObject() {
		addItems();
		table.remove(3);
		assertEquals(table.get(3), null);
		
	}

	@Test
	public void testRehash() {
		addItems();
		HashtableChain<Integer, String> table2 = new HashtableChain<Integer, String>(7);
		table2.put(1, "one" );
		table2.put(2, "two");
		table2.put(3, "three");
		table2.put(4, "four");
		table2.put(5, "five");
		table2.put(6, "six");
		table2.put(7, "seven");
		table2.put(8, "eight");
		assertFalse(table.toString().equals(table2.toString()));
		
		
	}

	@Test
	public void testToString() {
		addItems();
		assertFalse(table.toString().equals(table.toStringWithIterator()));
	}

	@Test
	public void testToStringWithIterator() {
		addItems();
		assertFalse(table.toString().equals(table.toStringWithIterator()));
	}

	@Test
	public void testEntrySet() 
	{
		Set<Map.Entry<Integer, String>> newSet = table.entrySet();
		assertEquals(newSet.size() , table.size());
		
	}

}
