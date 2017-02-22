package edu.miracosta.cs113;

import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import java.lang.IllegalStateException;
import java.util.Collection;


public class DoubleLinkedList<E> implements List<E> {
	
	
	 private Node <E> head = null;
	 private Node <E> tail = null;
	 private int size = 0;
	 
 	/**
	 * Default constructor, setting all int variables to zero or Nodes to null
	 * 
	 */
	public DoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	/** Add an item at the specified index.     
	 * @param index  The index at which the object is to be inserted     
	 * @param obj   The object to be inserted     
	 * @throws IndexOutOfBoundsException  
	 * if the index is out of range (i < 0 || i > size()) */
	public void add(int index, E obj) 
	{
		listIterator(index).add(obj); 
	}
	
	/** Get the element at position index.
	 *@param index  Position of item to be retrieved
	 *@return The item at index 
	 **/ 
	public E get(int index) 
	{
		return listIterator(index).next(); 
	}
	
	/** Add an item to the end of the list    
	 * @param obj   The object to be inserted     
	**/
	public boolean add(E obj)
	{
		addLast(obj);
		return true;
	}
	
	/** Add an item to the beginning of the list    
	 * @param obj   The object to be inserted     
	 **/
	public void addFirst(E item) 
	{
		add(0, item); 
	}
	
	/** Add an item to the end of the list    
	 * @param obj   The object to be inserted     
	**/
	public void addLast(E item) 
	{
		add(size, item); 
	}
	
	/** Get the first element in the list
	 * 
	 *@return The item at beginning of list 
	 **/ 
	public E getFirst() 
	{
		return head.data; 
	}
	/** Get the last element in the list
	 * 
	 *@return The item at beginning of list 
	 **/ 
	public E getLast() 
	{
		return tail.data;
	}
	
	/** Initializes the iterator
	 * 
	 *@return DoubleListIterator at index 0
	 **/ 
	public DoubleListIterator listIterator()
	{
		return new DoubleListIterator(0);
	}
	
	/** Initializes the iterator at index given 
	 * 
	 * @param int index 
	 *@return DoubleListIterator at index given in param
	 **/ 
	public DoubleListIterator listIterator(int index)
	{
		return new DoubleListIterator(index);
	}
	
	/** Get the size of list
	 * 
	 *@return int , size of list
	 **/ 
	public int size()
	{
		return size;
	}
	
	/** Removes the item if found in list
	 * 
	 * @param E the object to remove
	 *@return boolean if found and removed returns true, if not false
	 **/ 
	public boolean remove(Object obj)
	{
		boolean found = false;
		DoubleListIterator itr = listIterator();
		for(int i = 0; i < size; i++)
		{
			if(itr.next().equals(obj))
			{
				itr.remove();
				found =  true;
			}
		}
		return found;
	}
	
	/** Removes the item at index given if found in list
	 * 
	 * @param int the index of the item to remove
	 *@return E, the data that was removed
	 **/ 
	public E remove(int index)
	{
		if (index < 0 || index > size) 
		  {
			  throw new IndexOutOfBoundsException("Invalid index " + index);   
		  }
		else
		{
			
			DoubleListIterator itr = listIterator(index);
			E removedItem = itr.next();
			itr.remove();
			return removedItem;
		}
	}
	
	/** 
	 * Removes the first item in the list
	 * 
	 **/ 
	public void removeFirst()
	{
		DoubleListIterator itr = listIterator();
		itr.next();
		itr.remove();
	}
	/** Removes the first item in the list
	 * 
	 **/ 
	public void removeLast()
	{
		DoubleListIterator itr = listIterator(size - 1);
		itr.next();
		itr.remove();
	}
	
	/** Changes the data at the given index
	 * 
	 * @param int the index of the item to change
	 * @param E the new data
	 *@return E, the old data
	 *@throws IndexOutOfBoundsException  
	 * if the index is out of range (i < 0 || i > size())
	 **/
	public E set(int index,E obj)
	{
		DoubleListIterator itr = listIterator(index - 1);
		itr.next();
		E removedItem = itr.next();
		itr.set(obj);
		return removedItem;
	}
	
	/** Clears the whole list
	 * 
	 **/ 
	public void clear()
	{
		DoubleListIterator itr = listIterator();
		for(int i = 0 ; i < size; i++)
		{
			itr.next();
			itr.remove();
		}
	}
	/** Checks to see if the list is empty
	 * 
	 * @return true if empty, otherwise false
	 **/
	public boolean isEmpty()
	{
		if(head ==  null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/** Get the index of the given data
	 * 
	 * @param Object tthe data to find in list
	 *@return int , index of the given item
	 **/
	public int indexOf(Object obj)
	{
		boolean found = false;
		DoubleListIterator itr = listIterator();
		while(!found && itr.index != size)
		{
			if(itr.next().equals(obj))
			{
				found =  true;
			}
		}
		
		if(found == true)
		{
			return itr.index - 1;
		}
		else
		{
			return -1;
		}
		
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
	private class DoubleListIterator implements ListIterator<E> {
		
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index = 0;
		
		/**
		 * Full constructor, specifying each part of DoubleListIterator
		 * 
		 * @param int
		 *           index of the DoubleListIterator 
		 * 
		 */
		public DoubleListIterator(int i) {
			  // error check index
			  if (i < 0 || i > size) 
			  {
				  throw new IndexOutOfBoundsException("Invalid index " + i);   
			  }
			  lastItemReturned = null; 
			  // No item returned yet   
			  // Special case of last item (why not let loop do this?)
			  if (i == size) 
			  {
				  index = size;     nextItem = null;   
			  }
			  else 
			  {
				  // Start at the beginning
			    nextItem = head;
			    for (index = 0; index < i; index++) 
			    {       
			    	nextItem = nextItem.next;    
			    }
			   } 
		} 
		
		/** Check to see if the end of the list is reached
		 * 
		 *@return boolean , true if their is another item , false if end of list reached
		 **/
		public boolean hasNext() 
		{
			return nextItem != null; 
		}
		
		/** iterate the iterator forward
		 * 
		 *@return E , return the next item in the list and iterate the list and increment index
		 *@throws IndexOutOfBoundsException  
		 * if the list has next
		 **/
		public E next() 
		{
			if (!hasNext()) 
			{
				throw new NoSuchElementException();   
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data; 
		}
		/** Check to see if the iterator has a previous
		 * 
		 *@return boolean , true if their is a previous item , 	
		 *						false if the iterator is at the beginning of the list
		 **/
		public boolean hasPrevious() 
		{
			  return (nextItem == null && size != 0) || nextItem.prev != null;
		}
		
		/** iterate the iterator backward
		 * 
		 *@return E , return the previous item in the list and iterate the list and decrement index
		 *@throws IndexOutOfBoundsException  
		 * if the list has previous item
		 **/
		public E previous() 
		{
			if (!hasPrevious()) 
			{
				throw new NoSuchElementException();   
			}  
			if (nextItem == null) 
			{
				// Iterator past the last element
				nextItem = tail;
			}   
			else 
			{
				nextItem = nextItem.prev;   
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
		
		/** Add an item before the iterator
		 *      
		 * @param E, the object to add     
		 **/
		public void add(E obj)
		{
			if(head == null) 
			{ 
				head = new Node<E>(obj); 
				tail = head; 
			}
			else if(nextItem == head) 
			{
				Node<E> newNode = new Node<E>(obj); 
				newNode.next = nextItem; 
				nextItem.prev = newNode;  
				head = newNode; 
			}
			else if(nextItem == null) 
			{
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			else 
			{
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode; 
			}
			size++;
			index++;
			lastItemReturned = null;
		}
		
		/** Get the index of the next item
		 * 
		 *@return int, the index of next item
		 **/
		public int nextIndex()
		{
			return index + 1;
		}
		
		/** Get the index of the previous item
		 * 
		 *@return int, the index of previous item
		 **/
		public int previousIndex()
		{
			return index - 1;
		}
		
		/** remove the item last returned
		 * 
		 *@throws IllegalStateException  
		 * if no item was returned with iterator or next() or previous() hasn't been called
		 **/
		public void remove()
		{
			if(lastItemReturned == null)
			{
				throw new IllegalStateException();
			}
			if(nextItem == null && lastItemReturned.prev == null)
			{
				head = null;
				tail = null;
			}
			else if(nextItem == null)
			{
				lastItemReturned.prev.next = lastItemReturned.next;
				tail = lastItemReturned.prev;
				
			}
			else if(lastItemReturned.prev == null)
			{
				lastItemReturned.next.prev = lastItemReturned.prev;
				head = lastItemReturned.next;
			}
			else
			{
				lastItemReturned.prev.next = lastItemReturned.next;
				lastItemReturned.next.prev = lastItemReturned.prev;
			}
			size--;
			index--;
			lastItemReturned = null;
		}
		/** change the data of the last item returned
		 * 
		 *@throws IllegalStateException  
		 * if no item was returned with iterator or next() or previous() hasn't been called
		 **/
		public void set(E obj)
		{
			if(lastItemReturned == null)
			{
				throw new IllegalStateException();
			}
			lastItemReturned.data = obj;
		}
	}

	private static class Node<E> 
	{
		private E data;
		private Node<E> next = null; 
		private Node<E> prev = null; 
		
		/** Creates a new node with a null next field
		 * 
		 *  @param data  The data stored
		 *           
		 **/
		private Node(E dataItem) 
		{
			data = dataItem;   
		}
		
		/** Creates a new node that references another node
		 * @param data  The data stored       
		 * @param nodeRef  
		 * 			The node referenced by new node   
		 **/   
		private Node(E data, Node<E> nodeRef, Node<E> nodeRefPrev) 
		{
			this.data = data;
			this.next = nodeRef;   
			this.prev = nodeRefPrev;
		}
	}

}
		
	
	
		


	
	
	
	

