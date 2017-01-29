/*
 * NumberFizzBuzz.java : A program that print all numbers from 1- 100 but replaces multiples of
 * 3 by fizz and 5 by buzz and both by fizzbuzz
 * 
 * Class Invariant : Only print 1- 100
 * 
 *  @author Sina Dalir
 *  @version 1.0      
 */
/*
 * ALGORITHM:
 * 	
 * DECLARE int num
 * DECLARE boolean fizz
 * DECLARE boolean buzz
 * ASSIGN num 
 * WHILE 
 * 		ASSIGN num = num + 1
 * 		ASSIGN fizz
 * 		ASSIGN buzz
 * 		IF
 * 			ASSIGN fizz = true
 * 		IF
 * 			ASSIGN buzz = true
 * 		IF
 * 			PRINT Fizzbuzz
 * 		IF 	
 * 			PRINT Fizz
 * 		IF 
 * 			PRINT Buzz
 * 		ELSE 
 * 			PRINT num
 */
package edu.miracost.cs113;
public class NumberFizzBuzz {
	/**
	 * Main for printing the numbers
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		int num;
		boolean fizz;
		boolean buzz;
		num = 0;
		
		while(num != 101)
		{
			num += 1;
			fizz = false;
			buzz = false;
			if(num % 3 == 0)
			{
				fizz = true;
			}
			if(num % 5 == 0 )
			{
				buzz = true;
			}
			
			if(buzz && fizz)
			{
				System.out.println("Fizzbuzz");
			}
			else if(fizz)
			{
				System.out.println("Fizz");
			}
			else if(buzz)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(num);
			}
		}

	}

}
