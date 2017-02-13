package edu.miracosta.cs113;


public class MySingleLinkedList<E>
{
	private Node<E> head = null;
	private int size = 0;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public MySingleLinkedList()
	{
		size = 0;
		head = null;
	}
	/**
	 * get() gets the data from the given index Node
	 * @param index
	 * @return data in Node
	 */
	public E get(int index) 
	{
		if (index < 0 || index >= size) 
		{
			throw new
				IndexOutOfBoundsException(Integer.toString(index));
		}   
		Node<E> node = getNode(index);   
		return node.data; 
	}
	
	/**
	 * set() sets the data in the given index Node
	 * 
	 * @param index
	 * @param anEntry
	 * @return data from node
	 */
	public E set(int index, E anEntry) 
	{
		if (index < 0 || index >= size) 
		{
			throw new                                                    
				IndexOutOfBoundsException(Integer.toString(index));
		}   
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = anEntry;
		return result; 
	}
	
	/**
	 * add() adds after the given index or if not to the beginning
	 * 
	 * @param index
	 * @param item
	 */
	public void add(int index, E item) 
	{
		if (index < 0 || index > size) 
		{
			throw new                                         
			IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) 
		{
			addFirst(item);
		} 
		else
		{
			Node<E> node = getNode(index-1);
			addAfter(node, item);  
		}
	}
	/**
	 * add() adds to the end of the list
	 * 
	 * @param item
	 * @return true always
	 */
	public boolean add(E item)
	{
		add(size, item);
		return true;
	}
	/**
	 * adds to the beginning of the list using addFirst()
	 * 
	 * @param item
	 */
	public void addToBeginning(E item)
	{
		addFirst(item);
	}
	/**
	 * returns size variable
	 * 
	 * @return int variables of size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * addFirst() adds to the beginning of the list
	 * 
	 * @param item
	 */
	private void addFirst(E item) 
	{   
		head = new Node<E>(item, head);   
		size++;
	}
	
	/**
	 * addAfter() adds after the given index to the list
	 * 
	 * @param node
	 * @param item
	 */
	private void addAfter(Node<E> node, E item) 
	{
		node.next = new Node<E>(item, node.next);  
		size++;
	}
	/**
	 * removeAfter() removes the node after the given Node
	 * 
	 * @param node
	 * @return data from node
	 */
	private E removeAfter(Node<E> node) 
	{
		Node<E> temp = node.next;
		if (temp != null) 
		{
			node.next = temp.next;
			size--;
			return temp.data;
		} 
		else 
		{     
			return null;
		} 
	}
	/**
	 * removeStudent() this method is specific for the MySingleLinkedList<String>
	 * 	the list has to have String and removes the Node with the name given in paramateres
	 * 
	 * @
	 * 
	 * @param name
	 * @return
	 */
	public Node<E> removeStudent(String name)
	{
		Node<E> node = head;
		Node<E> beforeNode = null;
		boolean found = false;
		while(!found && node != null) 
		{   
			Student student = (Student) node.data;
			
			if(student.getName().equals(name))
			{
				found = true;
			}
			else
			{
				beforeNode = node;
			}
			node = node.next;
		}
		removeAfter(beforeNode);
		return node; 
	}
	/**
	 * Removes first Node
	 * @return the data deleted
	 */
	public E removeFirst() 
	{  
		if (head == null) 
		{
			return null;  
		} 
		else
		{   
			Node<E> temp = head;
			head = head.next;
			size--;   
			return temp.data;  
		}
	}
	/**
	 * @return String with all variables
	 */
	@Override
	public String toString() 
	{
		Node<String> nodeRef =(Node<String>) head;
		String result = "";
		while (nodeRef != null) 
		{     
			result += nodeRef.data;
			if (nodeRef.next != null) 
			{
				result += " ==> "; 
			}     
			nodeRef = nodeRef.next;   
		}   
		return result; 
	}
	/**
	 * returns the node in the given index
	 * 
	 * @param index
	 * @return Node<E> 
	 */
	private Node<E> getNode(int index)
	{   
		Node<E> node = head;
		int i = 0;
		while(i < index && node != null) 
		{     
			node = node.next;
			i++;
		}
		return node; 
	}
	
	
	
	
	/**
	 * This is a Node inner class needed for the LinkedList
	 * @author w7249749
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;
		/** Creates a new node with a null next field
		 * 
		 *  @param data  The data stored
		 *           
		 **/
		private Node(E data) 
		{
			this.data = data;     this.next = null;   
		}  
		/** Creates a new node that references another node
		 * @param data  The data stored       
		 * @param nodeRef  
		 * 			The node referenced by new node   
		 **/   
		private Node(E data, Node<E> nodeRef) 
		{
			this.data = data;
			this.next = nodeRef;   
		}
	}

}
