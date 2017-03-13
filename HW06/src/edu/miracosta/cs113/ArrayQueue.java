package edu.miracosta.cs113;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
	private int capacity;
	private E[] theData;
	private int front ;
	private int rear;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initCapacity) 
	{
		capacity = initCapacity;
		theData = (E[])new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0; 
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() 
	{
		capacity = 10;
		theData = (E[])new Object[10];
		front = 0;
		rear = capacity - 1;
		size = 0; 
	}
	
	public boolean offer(E item) 
	{
		if(size == capacity) 
		{
			reallocate();   
		}
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;
	}
	
	public E poll() 
	{
		if(size == 0)
		{
			return null; 
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;  
		return result; 
	}
	
	public E peek()
	{
		if(size == 0)
		{
			return null; 
		}
		return theData[front];
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void reallocate() 
	{
		int newCapacity = 2 * capacity;
		E[] newData = (E[])new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) 
		{
			newData[i] = theData[j];
			j = (j + 1) % capacity;
		}
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		theData = newData; 
	}
	
	public boolean add(E item) 
	{
		if(size == capacity) 
		{
			throw new   NoSuchElementException();
		}
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;
	}
	
	public E remove() 
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;  
		return result; 
	}
	
	public E element()
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return theData[front];
	}
	
	
	public boolean isEmpty() 
	{
		return (size == 0);
	}
	
	public void clear() 
	{
		theData = null;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean remove(Object object)
	{
		return false;
	}
	
	//Stub Methods
		public boolean addAll(int index, Collection<? extends E> c) 
		{
			return false;
		}
		
		public boolean addAll(Collection<? extends E> c)
		{
			return false;
		}
		
		public boolean contains(Object o)
		{
			return false;
		}
		
		public boolean containsAll(Collection<?> c)
		{
			return false;
		}
		
		public boolean equals(Object o)
		{
			return false;
		}
		
		public int hashCode()
		{
			return 0;
		}
		
		public Iterator<E> iterator()
		{
			return null;
		}
		
		public int lastIndexOf(Object o)
		{
			return 0;
		}
		
		public boolean removeAll(Collection<?> c)
		{
			return false;
		}
		
		public boolean retainAll(Collection<?> c)
		{
			return false;
		}
		
		public List<E> subList(int fromIndex, int toIndex)
		{
			return null;
		}

		public Object[]	toArray()
		{
			return null;
		}
		
		public <T> T[] toArray(T[] a)
		{
			return null;
		}
	
	
	private class QueueIterator implements Iterator<E> 
	{
		  private int index;
		  private int count = 0;
		  
		  public QueueIterator() 
		  {
			  index = front;   
		  }
		  
		  @Override   
		  public boolean hasNext() 
		  {
			  return count < size;   
		  }
		  
		  @Override   
		  public E next() 
		  {
			  if (!hasNext()) 
			  {
				  throw new NoSuchElementException();  
			  }
			  E returnValue = theData[index];
			  index = (index + 1) % capacity;
			  count++; 
			  return returnValue;   
		  }
		  
		  @Override   
		  public void remove() 
		  {     
			  throw new UnsupportedOperationException();   
		  }
	}
	
}
