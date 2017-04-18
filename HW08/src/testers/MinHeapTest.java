package testers;

import static org.junit.Assert.*;
import edu.miracosta.cs113.MinHeap;
import org.junit.Test;

public class MinHeapTest 
{

	private MinHeap<Person> theData = new MinHeap<Person>();
	
	public void addItems()
	{
		
		Date firstDate = new Date(1, 1, 1990);
		Date secondDate = new Date(2,2,1990);
		Date thirdDate = new Date(10, 10, 1980);
		Date fourthDate = new Date(5, 6, 1985);
		Date fifthDate = new Date(1, 2, 1999);
		Date sixthDate = new Date(12, 5, 2000);
		Date seventhDate = new Date(4, 9, 1970);
		
		Person first = new Person("John" ,firstDate, null);
		Person second = new Person("Sina" ,secondDate, null);
		Person third = new Person("Jack" ,thirdDate, null);
		Person fourth = new Person("Marry" ,fourthDate, null);
		Person fifth = new Person("Ann" ,fifthDate, null);
		Person sixth = new Person("Maddy" ,sixthDate, null);
		Person seventh = new Person("Ali" ,seventhDate, null);
		
		theData.insert(first);
		theData.insert(second);
		theData.insert(third);
		theData.insert(fourth);
		theData.insert(fifth);
		theData.insert(sixth);
		theData.insert(seventh);
	}

	@Test
	public void testInsert() 
	{
		theData = new MinHeap<Person>(new ComparePerson());
		addItems();
		Person sam = new Person("Sam", new Date(1,1, 2012), null );
		theData.insert(sam);
		assertEquals(sam, theData.peek() );
		
	}

	@Test
	public void testRemove() {
		theData = new MinHeap<Person>(new ComparePerson());
		addItems();
		theData.remove();
		assertEquals("Ann", theData.peek().getName() );
		
	}

	@Test
	public void testSize() {
		addItems();
		assertEquals(7 , theData.size() );
	}

	@Test
	public void testIsEmpty() {
		addItems();
		assertFalse(theData.isEmpty());
	}

	@Test
	public void testPeek() {
		
		theData = new MinHeap<Person>(new ComparePerson());
		addItems();
		assertEquals("Maddy", theData.peek().getName() );
	}
	
	@Test
	public void testMinHeap() 
	{
		addItems();
		
		assertEquals("Ali", theData.peek().getName() );
		
	}

	@Test
	public void testMinHeapComparatorOfE() {
		theData = new MinHeap<Person>(new ComparePerson());
		addItems();
		assertEquals("Maddy", theData.peek().getName() );
	}

}
