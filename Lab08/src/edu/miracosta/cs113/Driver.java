/**
 * Driver.java : This driver checks number susing queue and stacks from API
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM
 * 
 * DECLARE & INSTANTIATE Stack<Integer> stack1
 * DECLARE & INSTANTIATE Stack<Integer> stack2
 * DECLARE & INSTANTIATE Queue<Integer> queue
 * PRINT "True = " + stack.empty()
 * CALL stack.push(-1);
 * CALL stack.push(15);
 * CALL stack.push(23);
 * CALL stack.push(44);
 * CALL stack.push(4);
 * CALL stack.push(99);
 * PRINT "The top of stack1 is " + stack1.peek()
 * WHILE 
 * 		ASSIGN & CALL Integer num = stack1.pop()
 * 		CALL queue.offer(num)
 * 		PRINT "The top of stack2 is " + stack2.push(num)
 * END WHILE
 * WHILE
 * 		PRINT "The Stack variable is " + stack2.pop() + " The Queue variable is " + queue.poll()
 * END WHILE
 */

package edu.miracosta.cs113;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		
		System.out.println("The top of stack1 is " + stack1.peek());
		
		
		while(!stack1.empty())
		{
			Integer num = stack1.pop();
			queue.offer(num);
			System.out.println("The top of stack2 is " + stack2.push(num));
		}
		
		while(!stack2.empty() || !queue.isEmpty())
		{
			System.out.println("The Stack variable is " + stack2.pop() + " The Queue variable is " + queue.poll());
		}
	}

}
