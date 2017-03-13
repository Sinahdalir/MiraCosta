package edu.miracosta.cs113;

public class PrintJob {
	
	private int numberPapers;
	private int startTime;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public PrintJob() 
	{
		this.numberPapers = 0;
		this.startTime = 0;
	}
	/**
	 * Full constructor, specifying each part of PrintJon
	 * 
	 * @param numberPapers
	 *            int representing number of papers
	 * @param startTime
	 *            int representing start time
	 * 
	 */
	public PrintJob(int numberPapers, int startTime) 
	{
		this.numberPapers = numberPapers;
		this.startTime = startTime;
	}
	
	/**
	 * Accessor for number papers value
	 * 
	 * @return number papers int value
	 */
	public int getNumberPapers() 
	{
		return numberPapers;
	}
	
	/**
	 * Mutator for numberPapers value
	 * 
	 * @param numberPapers
	 *            int value representing numberPapers
	 */
	public void setNumberPapers(int numberPapers) 
	{
		this.numberPapers = numberPapers;
	}
	
	/**
	 * Accessor for startTime value
	 * 
	 * @return startTime int value
	 */
	public int getStartTime() 
	{
		return startTime;
	}
	
	/**
	 * Mutator for startTime value
	 * 
	 * @param startTime
	 *            int value representing startTime
	 */
	public void setStartTime(int startTime) 
	{
		this.startTime = startTime;
	}
	
	/**
	 * MEthod that gets the time to print the printJob
	 * 
	 * @return int 
	 *            time to print the print job
	 */
	public int getTimeToPrint()
	{
		if(numberPapers % 10 > 0)
		{
			return (numberPapers / 10)  + 1 + startTime ;
		}
		else
		{
			return (numberPapers / 10) + startTime ;
		}
		
	}
	
	/**
	 * toString representing objects values
	 * 
	 * @return formatted string of PrintJob variables 
	 */
	@Override
	public String toString() {
		return "PrintJob  with numberPapers = " + numberPapers + ", startTime=" + startTime ;
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
		PrintJob other = (PrintJob) obj;
		if (numberPapers != other.numberPapers)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}
	
	
	
	
	

}
