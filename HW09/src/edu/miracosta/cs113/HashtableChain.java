package edu.miracosta.cs113;
import java.util.AbstractMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.NoSuchElementException;

public class HashtableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V> 
{
	private static final int CAPACITY = 101;
	private double LOAD_THRESHOLD = 3.0;
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	
	
	/** Constructor for HashtableChain
	 * 
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain()
	{
		table = new LinkedList[CAPACITY];
	}
	
	/** Method get for class HashtableChain
	 * @param key the key being sought
	 * @return the value associated with this key if found, otherwise , null
	 */
	@Override
	public V get(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			return null;
		}
		for(Entry<K, V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
			{
				return nextItem.value;
			}
		}
		return null;
	}
	
	/** Method put for class HashtableChain
	 * @param key the key of item being inserted
	 * @param value the value for this key
	 * @return the old value associated with this key if,
	 * 				found, otherwise,  null
	 */
	@Override
	public V put(K key, V value)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			table[index] = new LinkedList<Entry<K, V>>();
		}
		for(Entry<K,V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
			{
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}
		
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if(numKeys > (LOAD_THRESHOLD * table.length))
		{
			rehash();
		}
		return null;
	}
	
	/** Removes item associated to the key from map and returns it, if not there return null
	 * 
	 * @param key the Key to the value
	 * @return  value of the key
	 */
	@Override    
	public V remove(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			return null;
		}
		for(Entry<K,V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
			{
				V oldVal = nextItem.value;
				table[index].remove(nextItem);
				numKeys--;
				if(table[index].isEmpty())
				{
					table[index] = null;
				}
				return oldVal;
			}
		}
		return null;
		
	}
	
	
   /**     
    * Expands table size when loadFactor exceeds LOAD_THRESHOLD     
    * @post the size of table is doubled and is an     
    *       odd integer. Each entry from the original     
    *       table is reinserted into the expanded table.     
    */
	// If you use the rehash of the HashtableOpen the difference is    
	@SuppressWarnings("unchecked")
	public void rehash()
	{
		LinkedList<Entry<K,V>>[] oldTable = table;
		table = new LinkedList[table.length * 2 + 1];
		numKeys = 0;
		for(LinkedList<Entry<K, V>> linkedList : oldTable)
		{
			if (linkedList != null) 
			{
                for (Entry<K,V> nextItem : linkedList) 
                {
                    put(nextItem.key, nextItem.value);
                }
            }
		}
	}
	
	/** Method that returns size of map
	 * 
	 * @return int size
	 */
	public int size()
	{
		return numKeys;
	}
	
	/** Method returns if map is empty
	 * 
	 * @return boolean true if empty, false otherwise
	 */
	 public boolean isEmpty() 
	 {
		 return numKeys == 0;
	 }
	
	 /** Method Returns a String representation of all the datas
	  * 
	  * @return String of all the data
	  */
	 public String toString()
	 {
		 String all = "";
		 for(LinkedList<Entry<K,V>> items : table)
		 {
			 if(items != null)
			 {
				 for(Entry<K,V> item : items)
				 {
					 all = all + "\n" + item; 
				 }
			 }
		 }
		 return all;
	 }
	 
	 /** Method Returns a String representation of all the datas
	  * 
	  * @return String of all the data
	  */
	 public String toStringWithLoop()
	 {
		 String all = "";
		Iterator <Map.Entry<K,V>> iter = entrySet().iterator();
		while(iter.hasNext())
		{
			all = all + "\n" + iter.next();
		}
		return all;
	 }
	 
	 /** Method that returns the Set of the entries
	  * 
	  * @return Set of all the entries
	  */
	public Set<Map.Entry<K, V>> entrySet() 
	{
		return new EntrySet();   
	}
	
	
	private static class Entry<K, V> implements KWHashMap.Entry<K, V>
	{
		private K key;
		private V value;
		
		/** Creates a new key-value pair
		 * @param key The key
		 * @param value The value
		 */
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		/**Retrieves the key
		 * @return the key
		 */
		public K getKey()
		{
			return key;
		}
		
		/**Retrieves the value
		 * @return the value
		 */
		public V getValue()
		{
			return value;
		}
		
		/** Sets the value
		 * 
		 * @param val the new value
		 * @return the old value
		 */
		public V setValue(V val)
		{
			V oldVal = value;
			value = val;
			return oldVal;
		}
		
		/** Returns the string representation of all the data
		 * 
		 * @return String
		 */
		public String toString()
		{
			return key + "=" + value;
		}
	}
	
	 private class EntrySet extends AbstractSet<Map.Entry<K, V>> 
	 {        
		 /** Return the size of the set. */        
		 @Override        
		 public int size() 
		 {
			 return numKeys;        
		 }        
		 
		 
		 /** Return an iterator over the set. */
		 @Override
		 public Iterator<Map.Entry<K, V>> iterator() 
		 {
			 return new SetIterator();        
		 }    
	 }
	 
	 private class SetIterator implements Iterator<Map.Entry<K, V>> 
	 {
		 int index = 0;  
		 
		 Entry<K,V> lastItemReturned = null;
		 
		 Iterator<Entry<K, V>> localIterator = null;       
		 
		 @Override        
		 public boolean hasNext() 
		 {            
			 if(localIterator != null) 
			 {
				 if (localIterator.hasNext())
				 {
					 return true;                
				 } 
				 else 
				 {                    
					 localIterator = null;
					 index++;
				 }            
			 }           
			 while(index < table.length && table[index] == null) 
			 {               
				 index++;
			 }            
			 if(index == table.length) 
			 {
				 return false;            
			 }            
			 localIterator = table[index].iterator();
			 return localIterator.hasNext();        
		}        
		@SuppressWarnings("unchecked")
		@Override        
		public Map.Entry<K, V> next() 
		{
			if(localIterator.hasNext())
			{
				lastItemReturned = localIterator.next();
				return (Map.Entry<K,V>) lastItemReturned;	
			}
			else
			{
				throw new NoSuchElementException();
			}
		}       

		@Override        
		public void remove()
		{
			
			if (lastItemReturned == null) 
			{
                throw new IllegalStateException(); 
                //This means next() has to be called before calling remove(), so can't call remove() twice in a row
            } 
			else
			{
                localIterator.remove();
                lastItemReturned = null;
            }
		}    
	}
}
