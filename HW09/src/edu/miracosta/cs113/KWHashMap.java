package edu.miracosta.cs113;

/** 
 * An interface for HashMap 
 *@author Koffman and Wolfgang 
 **/
public interface KWHashMap<K, V> 
{
	V get(Object key);   
	
	V put(K key, V value); 
	
    V remove(Object key);  
	
    int size();    
	
	boolean isEmpty();
	
	//Just for extra if needed later
	public static interface Entry<K, V> 
	{
		K getKey();
		
		V getValue();
		
		V setValue(V val);
	}
}
