/**
 * PolynomialAddition.java : this program adds two polynomials given by the user
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE i, x, coefficient, exponent
 * DECLARE & INITIALIZE Scanner keyboard
 * DECLARE firstTerm & secondTerm
 * CALL getPolynomial(keyboard) & INITIALIZE firstTerm
 * CALL getPolynomial(keyboard) & INITIALIZE secondTerm
 * DECLARE & INITIALIZE finalTerm
 * CALL printArrayList(ArrayList<Term>)
 * PRINT empty line
 * CALL printArrayList(ArrayList<Term>)
 * WHILE
 * 		IF
 * 			ASSIGN coefficient
 * 			ASSIGN exponent
 * 			INCREMENT i
 * 			INCREMENT x
 * 		ELSE IF
 * 			ASSIGN coefficient
 * 			ASSIGN exponent
 * 			INCREMENT i
 * 		ELSE
 * 			ASSIGN coefficient
 * 			ASSIGN exponent
 * 			INCREMENT x
 * END WHILE
 * CALL finalTerm.add(new Term(exponent, coefficient);
 * CALL keyboard.close()
 * PRINT "\nThe addition of these two polynomials equals :"
 * CALL printArrayList(finalTerm)
 * 
 **/
package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Scanner;

public class PolynomialAddition {


	/**
	 * driver for PolynomialAddition
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		
		int i = 0;
		int x = 0;
		int coefficient;
		int exponent;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Term> firstTerm = getPolynomial(keyboard);
		ArrayList<Term> secondTerm = getPolynomial(keyboard);
		ArrayList<Term> finalTerm = new ArrayList<Term>();
		
		printArrayList(firstTerm);
		System.out.println();
		printArrayList(secondTerm);
		
		while(i < firstTerm.size() && x < secondTerm.size())
		{
			if(firstTerm.get(i).compareTo(secondTerm.get(x)) == 0)
			{
				coefficient = firstTerm.get(i).getCoefficient() + secondTerm.get(x).getCoefficient();
				exponent = firstTerm.get(i).getExponent();
				x++;
				i++;
			}
			else if(firstTerm.get(i).compareTo(secondTerm.get(x)) > 0)
			{
				coefficient = firstTerm.get(i).getCoefficient();
				exponent = firstTerm.get(i).getExponent();
				i++;
			}
			else
			{
				coefficient = secondTerm.get(x).getCoefficient();
				exponent = secondTerm.get(x).getExponent();
				x++;
				
			}
			
			finalTerm.add(new Term(exponent, coefficient));
		}
		
		keyboard.close();
		System.out.println("\nThe addition of these two polynomials equals :");
		printArrayList(finalTerm);
		

	}
	/**
	 * getPolynomial gets an ArrayList of Term objects from the user
	 * 
	 * @param keyboard
	 * 				Scanner object for getting user input
	 * 
	 * @return a ArrayList<Term> of type Term filled by the user's input
	 */
	public static ArrayList<Term> getPolynomial(Scanner keyboard)
	{
		String temp;
		int coefficient, exponent;
		Term newTerm = new Term();
		ArrayList<Term> terms = new ArrayList<Term>();
		System.out.println("Please enter your biggest to smalles polynomail term");
		
		do
		{
			System.out.print("Enter the coefficient :");
			temp = keyboard.nextLine();
			coefficient = Integer.parseInt(temp);
			System.out.print("Enter the exponent :");
			temp = keyboard.nextLine();
			exponent = Integer.parseInt(temp);
			newTerm = new Term(exponent, coefficient);
			if(newTerm.getCoefficient() != 0)
			{
				terms.add(newTerm);
			}
			
		}while(newTerm.getExponent() > 0);
		return terms;
	}
	/**
	 * printArrayList prints the arrayList given to the method
	 * 
	 * @param terms
	 * 			ArrayList of type Term
	 * 
	 * @return void
	 */
	public static void printArrayList(ArrayList<Term> terms)
	{
		for(int i = 0; i < terms.size(); i++)
		{
			System.out.print(terms.get(i));
		}
	}
	

}
