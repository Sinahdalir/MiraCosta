package edu.miracosta.cs113;

import java.util.ArrayList;

public class TheDirectory {
	private ArrayList<DirectoryEntry> directory = new ArrayList<DirectoryEntry>() ;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public TheDirectory()
	{
		directory = new ArrayList<DirectoryEntry>() ;
	}
	/**
	 * Accessor for directory value
	 * 
	 * @return directory ArrayList value
	 */
	public ArrayList<DirectoryEntry> getDirectory()
	{
		return directory;
	}
	/**Add an entry to theDirectory or change an existing entry
	 * 
	 * @param aName
	 * @param newNumber
	 * @return the old number, or if a new entry, null
	 */
	public String addOrChangeEntry(String aName, String newNumber)
	{
		String oldNumber = null; 
		boolean found = false;
		for(int i = 0; i < directory.size(); i++)
		{
			if(directory.get(i).getName().equals(aName))
			{
				oldNumber = directory.get(i).getNumber();
				directory.get(i).setNumber(newNumber);
				found = true;
			}
		}
		if(found == false)
		{
			directory.add(new DirectoryEntry(aName, newNumber));
		}
		return oldNumber;
	}
	/**Remove an entry
	 * 
	 * @param aName
	 * @return the entry removed, or null if there is no entry for aName
	 */
	public DirectoryEntry removeEntry(String aName)
	{
		DirectoryEntry old = null;
		for(int i = 0; i < directory.size(); i++)
		{
			if(directory.get(i).getName().equals(aName))
			{
				old = directory.get(i);
				directory.remove(i);
			}
		}
		
		return old;
	}

}
