package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> {
	private ArrayList<E> theData;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayListStack() 
	{
		theData = (ArrayList<E>) new ArrayList<Object>();   
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
		return theData.get(theData.size() - 1 );
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
		return theData.remove(theData.size() - 1 );
	}
	
	/**
	 * Adds the data on the top of the stack
	 * @exception java.util.EmptyStackException if the stack is empty.
	 * @param the data that will be added to the stack
	 * @return the data added
	 */
	public E push(E obj)
	{
		theData.add(obj);
		return obj;
	}
	
	/**
	 * Gets the size of the stack
	 * @return int or number of the size of stack
	 */
	public int size()
	{
		return theData.size();
	}
	
}
