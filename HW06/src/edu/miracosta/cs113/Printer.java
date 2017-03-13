package edu.miracosta.cs113;


public class Printer 
{
	private String name;
	private ArrayQueue<PrintJob> jobs;
	private int lower;
	private int upper;
	private static int  currentTime;

	/**
	 * Default constructor, setting all int variables to zero or Strings to ""
	 * 
	 */
	public Printer() 
	{
		this.name = "";
		this.jobs = null;
		this.lower = 0;
		this.upper = 0;
		currentTime = 0;
	}
	
	/**
	 * Full constructor, specifying each part of PRinter
	 * 
	 * @param name
	 *            String representing name of printer
	 * @param jobs
	 *            Queue<PrintJob> representing jobs
	 * @param lower
	 *            int representing lower bound
	 * @param upper
	 *            int representing upper bound           
	 * 
	 */
	public Printer(String name, ArrayQueue<PrintJob> jobs, int lower, int upper) 
	{
		this.name = name;
		this.jobs = jobs;
		this.lower = lower;
		this.upper = upper;
		currentTime = 0;
	}
	
	/**
	 * Custom constructor, specifying needed parts of PRinter
	 * 
	 * @param name
	 *            String representing name of printer
	 * @param lower
	 *            int representing lower bound
	 * @param upper
	 *            int representing upper bound           
	 * 
	 */
	public Printer(String name, int lower, int upper) 
	{
		this.name = name;
		this.jobs = new ArrayQueue<PrintJob>(100);
		this.lower = lower;
		this.upper = upper;
		currentTime = 0;
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
	 * Accessor for jobs reference
	 * 
	 * @return jobs Queue reference
	 */
	public ArrayQueue<PrintJob> getJobs() 
	{
		return jobs;
	}
	/**
	 * Mutator for jobs value
	 * 
	 * @param jobs
	 *            Queue<PrintJob> value representing jobs
	 */
	public void setJobs(ArrayQueue<PrintJob> jobs) 
	{
		this.jobs = jobs;
	}
	
	/**
	 * Accessor for lower value
	 * 
	 * @return lower int value
	 */
	public int getLower() 
	{
		return lower;
	}
	
	/**
	 * Mutator for lower value
	 * 
	 * @param lower
	 *            int value representing lower
	 */
	public void setLower(int lower) 
	{
		this.lower = lower;
	}
	/**
	 * Accessor for upper value
	 * 
	 * @return upper int value
	 */
	public int getUpper() 
	{
		return upper;
	}
	/**
	 * Mutator for upper value
	 * 
	 * @param upper
	 *            int value representing upper
	 */
	public void setUpper(int upper) 
	{
		this.upper = upper;
	}
	
	/**
	 * Helper which adds PrintJob object to jobs 
	 * 
	 * @param job
	 *            PrintJob value representing job
	 */
	public void addJob(PrintJob job)
	{
		jobs.offer(job);
	}
	
	/**
	 * Helper which check to see if printJob fnished then polls from queue
	 * 
	 */
	public void tick()
	{
		if(!jobs.isEmpty())
		{
			PrintJob job = this.jobs.peek();
			if(currentTime == job.getTimeToPrint()  )
			{
				System.out.println("DONE : The print job with " + jobs.peek().getNumberPapers() +
						" pages comepletd on " + this.name + " at minute " + currentTime ); 
				jobs.poll();
				if(!jobs.isEmpty())
				{
					jobs.peek().setStartTime(currentTime);
				}
			}
		}
		
	}
	
	/**
	 * updateTime increments the static variable curretnTime
	 * 
	 */
	public static void updateTime()
	{
		currentTime++;
	}
	/**
	 * getCurrentTime gets the static variable curretnTime
	 * 
	 * @return int
	 *            int value representing currentTime
	 */
	public static int getCurrentTime() 
	{
		return currentTime;
	}
	
	/**
	 * toString representing objects values
	 * 
	 * @return formatted string of Student variables 
	 */
	@Override
	public String toString() {
		return "Printer [name=" + name + ", jobs=" + jobs + ", lower=" + lower + ", upper=" + upper + "]";
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
		Printer other = (Printer) obj;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (lower != other.lower)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (upper != other.upper)
			return false;
		return true;
	}


}
