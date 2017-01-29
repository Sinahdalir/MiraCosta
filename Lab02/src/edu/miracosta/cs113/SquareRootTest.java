/*
 * SquareRootTest.java : A tester to see if a number is squared
 * 
 * Class Invariant :Tester for a square root test, The number shouldn't be negative
 * 
 *  @author Sina Dalir
 *  @version 1.0      
 */

/*
 * ALGORITHM:
 * 
 * IMPORT Scanner & Math
 * DECLARE & INITIALIZE keyboard
 * DECLARE num, answer
 * PRINT "Please enter the number to see if it is a square number :"
 * ASSIGN num = keyboard.nextInt()
 * CALL keyboard.close();
 * ASSIGN & CALL answer = Math.pow();
 * IF
 * 		PRINT num
 * ELSE
 * 		PRINT num
 */
package edu.miracosta.cs113;
import java.util.Scanner;
import java.lang.Math;
public class SquareRootTest {
	/**
	 * Tester for the square root test
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double num, answer;
		
		System.out.print("Please enter the number to see if it is a square number :");
		num = keyboard.nextInt();
		keyboard.close();
		answer = Math.pow(num, 0.5);
		if((answer - (int) answer) == 0)
		{
			System.out.println("The number " +  num + " is a square number");
		}
		else
		{
			System.out.println("The number " +  num + " is NOT a square number");
		}
	}

}
