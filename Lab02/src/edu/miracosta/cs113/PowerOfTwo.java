/**
 * PowerOfTwo.java : A tester to see if a number is squared
 * 
 * Class Invariant :Tester for a power of 2 test, The number shouldn't be negative
 * 
 *  @author Sina Dalir
 *  @version 1.0      
 *  
 */

 /**
 * ALGORITHM:
 * 
 * IMPORT Scanner 
 * DECLARE & INITIALIZE keyboard
 * DECLARE num, answer
 * DECLARE boolean isPower
 * PRINT "Please enter a positive int number to see if it is a power of two :"
 * ASSIGN num = keyboard.nextInt()
 * CALL keyboard.close();
 * ASSIGN asnwer = num;
 * ASSIGN isPower = false
 * IF
 * 		PRINT "YAYYYY!!! The number " + num + " is a power of two!!"
 * ELSE IF
 * 		PRINT "YAYYYY!!! The number " + num + " is a power of two!!"
 * ELSE
 * 		WHILE
 * 				IF
 * 					ASSIGN isPower = true
 * 				ASSIGN answer = answer / 2;
 * 		IF 
 * 			PRINT "YAYYYY!!! The number " + num + " is a power of two!!"
 * 		ELSE 
 * 			PRINT "SORRY!!! The number " + num + " is NOT a power of two!!"
 * 		END WHILE
 * END ELSE
 **/
package edu.miracosta.cs113;
import java.util.Scanner;

public class PowerOfTwo {
	/**
	 * Tester for the square root test
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double num, answer;
		boolean isPower;
		
		System.out.print("Please enter a positive int number to see if it is a power of two :");
		num = keyboard.nextInt();
		keyboard.close();
		isPower = false;
		answer = num;
		if(num == 1)
		{
			System.out.println("YAYYYY!!! The number " + num + " is a power of two!!");
		}
		else if(num == 2)
		{
			System.out.println("YAYYYY!!! The number " + num + " is a power of two!!");
		}
		else
		{
			while(answer >= 2 )
			{
				if(answer == 2.0)
				{
					isPower = true;
				}
				answer = answer / 2;
			}
			
			if(isPower)
			{
				System.out.println("YAYYYY!!! The number " + num + " is a power of two!!");
			}
			else 
			{
				System.out.println("SORRY!!! The number " + num + " is NOT a power of two!!");
			}
		}
		
		
	}

}
