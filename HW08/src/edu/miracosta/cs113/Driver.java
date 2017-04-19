package edu.miracosta.cs113;

public class Driver {

	public static void main(String[] args) 
	{
		MaxHeap<Integer> items = new MaxHeap<Integer>();
		
		items.insert(10);
		items.insert(14);
		items.insert(3);
		items.insert(6);
		items.insert(12);
		items.insert(13);
		items.insert(7);
		items.insert(4);
		items.insert(1);
		items.insert(2);
		
		items.remove();
		
		items.printHeap();
	
	}

}
