package edu.miracosta.cs113;

public class DirectoryEntry {
	private String name;
	private String number;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public DirectoryEntry()
	{
		this.name = "";
		this.number = "";
	}
	/**
	 *  Full constructor, specifying each part of DirectoryEntry
	 * @param name
	 * @param number
	 */
	public DirectoryEntry(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	/**
	 * Accessor for name value
	 * 
	 * @return name String value
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * Mutator for name value
	 * 
	 * @param name
	 *            String value representing name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * Accessor for number value
	 * 
	 * @return number String value
	 */
	public String getNumber() 
	{
		return number;
	}
	/**
	 * Mutator for number value
	 * 
	 * @param name
	 *            String value representing number
	 */
	public void setNumber(String number) 
	{
		this.number = number;
	}
	/**
	 * toString representing objects values
	 * 
	 * @return formatted string of DirectoryEntry variables 
	 */
	@Override
	public String toString() {
		return "DirectoryEntry [name=" + name + ", number=" + number + "]";
	}
	
	/**
	 * Equals method checks ALL instance variables are equal
	 * 
	 * @return boolean value for equality
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectoryEntry other = (DirectoryEntry) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
}
