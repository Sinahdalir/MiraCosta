package edu.miracosta.cs113;
import java.util.ArrayList;

public class ReplaceAndDeleteMethodDriver {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		
		replace(list, "Two", "Six");
		delete(list, "Four");
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		
	}
	/** 
	 * Replaces each occurrence of oldItem in aList with newItem
	 * @param aList
	 * @param oldItem
	 * @param newItem
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equals(oldItem))
			{
				aList.set(i, newItem);
			}
		}
	}
	/**
	 * Deletes the first occurrence of target in aList
	 * @param aList
	 * @param target
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		int i = 0;
		boolean repeat = true;
		while(i < aList.size() && repeat )
		{
			if(aList.get(i).equals(target))
			{
				aList.remove(i);
				repeat = false;
			}
			i++;
		}
	}

}
