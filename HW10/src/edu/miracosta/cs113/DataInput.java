package edu.miracosta.cs113;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class outputs a textFile named "Original.txt" with any amount of numbers , 
 * 		the numbers are random
 * @author w7249749
 *@version 1.0
 */
public class DataInput 
{
	private static final String ORIGINAL = "Original.txt";
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		String temp;
		int numData;
		PrintWriter output = null;
		System.out.println("Please enter the number of data you want :");
		temp = keyboard.nextLine();
		numData = Integer.parseInt(temp);
	    try
	    {
	    	output = new PrintWriter(new FileOutputStream(ORIGINAL));
	    }
	    catch(FileNotFoundException e)
	    {
	        System.out.println("Error opening the file dataFile.");
	        System.exit(0);
	    }
		
		for(int i = 0; i < numData; i++)
		{
			int random = (int )(Math.random() * Integer.MAX_VALUE + 1);
			output.println(random);
		}
		
		
		output.close();
		keyboard.close();
		System.out.print("File Ready!");
	}

}
