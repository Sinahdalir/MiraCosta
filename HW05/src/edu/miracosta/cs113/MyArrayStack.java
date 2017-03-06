package edu.miracosta.cs113;
import java.util.EmptyStackException;

public class MyArrayStack<E> implements StackInterface<E> {
	
	 private static final int INITIAL_CAPACITY = 10;
	 private E[] theData;
	 private int topOfStack = -1;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	 @SuppressWarnings("unchecked")
	public MyArrayStack() 
	{
		theData = (E[])new Object[INITIAL_CAPACITY];  
	}
	
	/**
	 * checks to see if the stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	public boolean empty()
	{
		if(topOfStack == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns the top data in the stack
	 * @return data at the top of the stack
	 */
	public E peek()
	{
		return theData[topOfStack];
	}

	/**
	 * Removes the data on the top of the stack
	 * @exception java.util.EmptyStackException if the stack is empty.
	 * @return the data removed
	 */
	public E pop()
	{
		if(empty()) 
		{
			throw new EmptyStackException();
		}
		return theData[topOfStack--]; 
	}
	
	/**
	 * Adds the data on the top of the stack
	 * @exception java.util.EmptyStackException if the stack is empty.
	 * @param the data that will be added to the stack
	 * @return the data added
	 */
	public E push(E obj)
	{
		if (topOfStack == theData.length - 1)
		{
			reallocate();  
		}   
		topOfStack++;
		theData[topOfStack] = obj;
		return obj; 
	}
	
	/**
	 * Gets the size of the stack
	 * @return int or number of the size of stack
	 */
	public int size()
	{
		return topOfStack + 1;
	}
	
	/**
	 * Copies theData into a bigger length array and sets theData to new array
	 */
	 @SuppressWarnings("unchecked")
	private void reallocate()
	{
		E[] theNewData = (E[])new Object[theData.length * 2]; 
		for(int i = 0; i < theData.length ; i++)
		{
			theNewData[i] = theData[i];
		}
		
		theData = theNewData;
	}

}
