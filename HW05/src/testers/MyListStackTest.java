package testers;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.miracosta.cs113.MyListStack;

public class MyListStackTest {

	private MyListStack<String> stack = new MyListStack<String>();

	public void makeStack()
	{
		stack.push("Hello");
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
	}
	@Test
	public void testMyListStack() {
		makeStack();
		stack.push("Hello");
		assertFalse(stack.empty());
		assertEquals(stack.peek(), stack.pop());
	}

	@Test
	public void testEmpty() {
		assertTrue(stack.empty());
	}

	@Test
	public void testPeek() {
		makeStack();
		assertEquals(stack.peek(),"D");
	}

	@Test
	public void testPop() {
		makeStack();
		stack.pop();
		assertEquals(stack.peek(),"C");
		stack.pop();
		assertEquals(stack.peek(),"B");
		stack.pop();
		assertEquals(stack.peek(),"A");
		stack.pop();
		assertEquals(stack.peek(),"Hello");
		stack.pop();
		assertTrue(stack.empty());
		
	}

	@Test
	public void testPush() {
		makeStack();
		stack.push("E");
		assertEquals(stack.peek(),"E");
	}


}
