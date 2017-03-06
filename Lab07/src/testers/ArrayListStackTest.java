package testers;

import static org.junit.Assert.*;
import edu.miracosta.cs113.ArrayListStack;
import org.junit.Test;

public class ArrayListStackTest {
	
	private ArrayListStack<String> stack = new ArrayListStack<String>();

	public void makeStack()
	{
		stack.push("Hello");
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
	}
	@Test
	public void testArrayListStack() {
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
	}

	@Test
	public void testPush() {
		makeStack();
		stack.push("E");
		assertEquals(stack.peek(),"E");
	}

}
