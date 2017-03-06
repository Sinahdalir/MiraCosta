package edu.miracosta.cs113;

public interface StackInterface<E> {

	    /**
	     * Adds item to the top of the stack.
	     */
	    E push(E item);

	    /**
	     * Removes the top item from the stack and returns it.
	     * @exception java.util.NoSuchElementException if the stack is empty.
	     * @return E or the data on top of stack
	     */
	    E pop();

	    /**
	     * Returns the top item from the stack without popping it.
	     * @exception java.util.NoSuchElementException if the stack is empty.
	     * @return E or the data on top of stack
	     */
	    E peek();

	    /**
	     * Returns the number of items currently in the stack.
	     * @return int size of stack
	     */
	    int size();

	    /**
	     * Returns whether the stack is empty or not.
	     * @return true if stack is empty, false otherwise
	     */
	    boolean empty();

}
