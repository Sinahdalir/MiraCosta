package edu.miracosta.cs113;

public abstract class Heap<E> 
{
	
	abstract boolean insert(E item);
	
	abstract E remove();
	
	abstract int size();
	
	abstract boolean isEmpty();
	
	abstract E peek();
	
	abstract protected int compare(E left, E right);
	
	abstract protected void swap(int i, int j);
	
}
