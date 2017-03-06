package edu.miracosta.cs113;

/**
 * Driver.java : This driver checks and tests the ArrayListStack
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM
 * 
 * DECLARE & INSTANTIATE ArrayListStack<Integer> stack
 * PRINT "True = " + stack.empty()
 * CALL stack.push(1);
 * CALL stack.push(2);
 * CALL stack.push(3);
 * CALL stack.push(4);
 * CALL stack.push(5);
 * 
 * WHILE 
 * 		PRINT stack.pop()
 * END WHILE
 * PRINT "BOOOM!"
 * CALL stack.push(100)
 * PRINT "100 = " + stack.peek()
 */
public class Driver {

	public static void main(String[] args) {
		ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
		
		System.out.println("True = " + stack.empty());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		while(!stack.empty())
		{
			System.out.println(stack.pop());
		}
		System.out.println("BOOOM!");
		
		stack.push(100);
		
		System.out.println("100 = " + stack.peek());

	}

}
