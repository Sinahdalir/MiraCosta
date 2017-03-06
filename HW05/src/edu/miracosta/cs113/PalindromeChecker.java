/**
 * PalindromeChecker.java : Checks to see if the user's input is a palindrome
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * DECLARE & INSTANTIATE Scanner keyboard
 * DECLARE & INSTANTIATE MyListStack<Character> stack1
 * DECLARE & INSTANTIATE MyListStack<Character> stack2
 * DECLARE & INITIALIZE userInputOriginal
 * DECLARE & INITIALIZE userInput
 * DECLARE & INITIALIZE itIsPalindrome
 * DECLARE length
 * PRINT "Welcome to the palindrome checker !"
 * PRINT "Please enter a word to check if it is a palindrome :"
 * ASSIGN & CALL userInputOriginal = keyboard.nextLine()
 * CALL keyboard.close();
 * CALL userInputOriginal.toLowerCase()
 * FOR
 * 		IF
 * 			CALL stack1.push(userInput.charAt(i))
 * 		END IF
 * END FOR
 * ASSIGN length = stack1.size()
 * FOR
 * 		CALL stack2.push(stack1.pop());
 * END FOR
 * IF
 * 		CALL stack1.pop();
 * END IF
 * WHILE
 * 		IF
 * 			ASSIGN itIsPalindrome = false;
 * 		END IF
 * END WHILE
 * IF 	
 * 		PRINT userInputOriginal + " is a Palindrome !!"
 * ELSE 	
 * 		PRINT userInputOriginal + " is NOT a Palindrome !!"
 * END IF
 */
package edu.miracosta.cs113;
import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		//MyArrayStack<Character> stack1 = new MyArrayStack<Character>();
		//MyArrayStack<Character> stack2 = new MyArrayStack<Character>();
		
		//If you want to see this program run with a ArrayStack uncomment two lines above 
		// and comment the two lines below
		
		MyListStack<Character> stack1 = new MyListStack<Character>();
		MyListStack<Character> stack2 = new MyListStack<Character>();
		
		
		String userInputOriginal = "";
		String userInput = "";
		boolean itIsPalindrome = true;
		int length = 0 ;
		
		System.out.println("Welcome to the palindrome checker !");
		System.out.println("Please enter a word to check if it is a palindrome :");
		userInputOriginal = keyboard.nextLine();
		keyboard.close();
		userInput = userInputOriginal.toLowerCase();
		
		for(int i = 0 ; i <userInput.length(); i++)
		{
			if(userInput.charAt(i) != ' ' && userInput.charAt(i) != '\'' &&
					userInput.charAt(i) != '!' && userInput.charAt(i) != '?' &&
					userInput.charAt(i) != ',')
			{
				stack1.push(userInput.charAt(i));
			}
			
		}
		
		length = stack1.size();
		
		for(int i = 0 ; i < (length / 2); i++)
		{
			stack2.push(stack1.pop());
		}
		
		if(stack1.size() != stack2.size())
		{
			stack1.pop();
		}
		
		
		while(!stack1.empty())
		{
			if(!stack1.pop().equals(stack2.pop()))
			{
				itIsPalindrome = false;
			}
		}
		
		if(itIsPalindrome)
		{
			System.out.println(userInputOriginal + " is a Palindrome !!");
		}
		else
		{
			System.out.println(userInputOriginal + " is NOT a Palindrome !!");
		}

	}

}
