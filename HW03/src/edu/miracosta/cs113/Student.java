package edu.miracosta.cs113;

public class Student {
	
	private double gpa;
	private String major;
	private String iDNumber;
	private String name;
	
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public Student()
	{
		gpa = 0;
		major = "";
		iDNumber = "";
		name = "";
	}
	/**
	 * Full constructor, specifying each part of Student
	 * 
	 * @param gpa
	 *            double representing gpa
	 * @param major
	 *            String representing major
	 * @param iDNumber
	 *            String representing iDNumber
	 *@param name
	 *            String representing name
	 * 
	 */
	public Student(double gpa, String major, String iDNumber, String name) {
		super();
		this.gpa = gpa;
		this.major = major;
		this.iDNumber = iDNumber;
		this.name = name;
	}
	/**
	 * Accessor for gpa value
	 * 
	 * @return gpa double value
	 */
	public double getGpa() 
	{
		return gpa;
	}
	/**
	 * Mutator for gpa value
	 * 
	 * @param gpa
	 *            double value representing gpa
	 */
	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}
	/**
	 * Accessor for major value
	 * 
	 * @return major String value
	 */
	public String getMajor() 
	{
		return major;
	}
	/**
	 * Mutator for major value
	 * 
	 * @param major
	 *            String value representing major
	 */
	public void setMajor(String major) 
	{
		this.major = major;
	}
	/**
	 * Accessor for iDNumber value
	 * 
	 * @return iDNumber String value
	 */
	public String getIDNumber() 
	{
		return iDNumber;
	}
	/**
	 * Mutator for iDNumber value
	 * 
	 * @param iDNumber
	 *            String value representing iDNumber
	 */
	public void setIDNumber(String iDNumber) 
	{
		this.iDNumber = iDNumber;
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
	 * toString representing objects values
	 * 
	 * @return formatted string of Student variables 
	 */
	@Override
	public String toString() {
		return "Student name: " + name + ", major: " + major + ", iDNumber: " + iDNumber + ", gpa: " + gpa ;
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
		Student other = (Student) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (iDNumber == null) {
			if (other.iDNumber != null)
				return false;
		} else if (!iDNumber.equals(other.iDNumber))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
	

	
}
