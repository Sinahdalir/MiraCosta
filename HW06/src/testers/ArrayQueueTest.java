package testers;
import edu.miracosta.cs113.ArrayQueue;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayQueueTest {

	private ArrayQueue<String> queue = new ArrayQueue<String>();
	
	public void makeQueue()
	{
		queue.offer("Hello");
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		
	}
	
	@Test
	public void testOffer() {
		makeQueue();
		assertFalse(queue.isEmpty());
		assertEquals(queue.peek(), queue.poll());
	}

	@Test
	public void testPoll() {
		makeQueue();
		queue.poll();
		assertEquals(queue.peek(),"A");
		queue.poll();
		assertEquals(queue.peek(),"B");
		queue.poll();
		assertEquals(queue.peek(),"C");
		queue.poll();
		assertEquals(queue.peek(),"D");
		queue.poll();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testPeek() {
		makeQueue();
		assertEquals(queue.peek(),"Hello");
	}

	@Test
	public void testAdd() {
		makeQueue();
		queue.offer("Hello");
		assertFalse(queue.isEmpty());
		assertEquals(queue.peek(), queue.poll());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testClear() {
		queue.clear();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testSize() {
		makeQueue();
		assertEquals(queue.size(), 5 );
	}

}
