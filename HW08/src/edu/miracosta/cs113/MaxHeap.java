package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Comparable;

public class MaxHeap<E extends Comparable<E>> extends Heap<E> 
{
	private ArrayList<E> theData;
	
	Comparator<E> comparator = null;
	
	public MaxHeap()
	{
		 theData = new ArrayList<E>();
	}
	
	public MaxHeap(Comparator<E> comp)
	{
		theData = new ArrayList<E>();     
		comparator = comp;
		 
	}
	
	public boolean insert(E item)
	{
		theData.add(item);
		
		int child = theData.size() - 1;     
		int parent = (child - 1) / 2;
		
		while(parent >= 0 && compare(theData.get(parent), theData.get(child)) < 0) 
		{
			swap(parent, child);       
			child = parent;        
			parent = (child - 1) / 2;  
		}
		return true;
	}
	
	public E remove()
	{
		boolean repeat = true;
		 if(isEmpty())
		 {
			 return null;  
		 }     
		 
		 E result = theData.get(0);
		 
		 if(theData.size() == 1) 
		 {
			 theData.remove(0);      
			 return result;  
		 }
		 
		 theData.set(0, theData.remove(theData.size() - 1));
		 
		 int parent = 0;
		 while(repeat) 
		 {
			 int leftChild = 2 * parent + 1; 
			 if (leftChild >= theData.size())
			 {
				leftChild = 0;
				repeat = false;
				
	         }         
			 int rightChild = leftChild + 1; 
			 int maxChild = leftChild; 
	         if(rightChild < theData.size() && compare(theData.get(leftChild), theData.get(rightChild)) < 0 && leftChild != 0) 
	         {     
	        	 maxChild = rightChild;
	         }        
	         
	         if(compare(theData.get(parent), theData.get(maxChild)) < 0 && leftChild != 0) 
	         {
	        	 swap(parent, maxChild);    
	        	 parent = maxChild;         
	         }
	         
	         else 
	         { 
	        	 repeat = false;
	         }     
	     }
		 return result;
	}
	
	public int size()
	{
		return theData.size();
	}
	
	public boolean isEmpty()
	{
		return theData.size() == 0;
	}
	
	public E peek()
	{
		return theData.get(0);
	}
	
	
	protected int compare(E left, E right)
	{
		if(comparator != null) 
		{ 
			  return comparator.compare(left, right);
	    } 
		else
		{          
			  return ((Comparable<E>) left).compareTo(right);     
		}
	}
	
	protected void swap(int i, int j)
	{
		E temp = theData.get(i);
		theData.set(i, theData.get(j));
		theData.set(j, temp);
	}
	
	public void printHeap()
	{
		for(E item: theData)
		{
			System.out.print(item +  " ");
		}
	}
	

}
