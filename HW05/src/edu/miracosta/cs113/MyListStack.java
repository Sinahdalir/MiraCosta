package edu.miracosta.cs113;
import java.util.EmptyStackException;

public class MyListStack<E> implements StackInterface<E> {
	
	private MySingleLinkedList<E> theData;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public MyListStack() 
	{
		theData = new MySingleLinkedList<E>();   
	}
	
	/**
	 * checks to see if the stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	public boolean empty()
	{
		return theData.isEmpty();
	}
	
	/**
	 * Returns the top data in the stack
	 * @return data at the top of the stack
	 */
	public E peek()
	{
		return theData.get(0);
	}

	/**
	 * Removes the data on the top of the stack
	 * @exception java.util.EmptyStackException if the stack is empty.
	 * @return the data removed
	 */
	public E pop()
	{
		if (empty())
		{
			throw new EmptyStackException();
		}
		return theData.removeFirst();
	}
	
	/**
	 * Adds the data on the top of the stack
	 * @exception java.util.EmptyStackException if the stack is empty.
	 * @param the data that will be added to the stack
	 * @return the data added
	 */
	public E push(E obj)
	{
		theData.add(0, obj);
		return obj;
	}
	
	/**
	 * Gets the size of the stack
	 * @return int or number of the size of stack
	 */
	public int size()
	{
		return theData.getSize();
	}
	

}