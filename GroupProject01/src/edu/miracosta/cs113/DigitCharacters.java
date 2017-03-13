package edu.miracosta.cs113;

public class DigitCharacters 
{

	public static void main(String[] args) 
	{
		String test1 = "3ac4";
		String test2 = "123abc";
		String test3 = "xyz";
		
		System.out.println("The sum of the string is: " + toNumber(test1));
		System.out.println("The sum of the string is: " + toNumber(test2));
		System.out.println("The sum of the string is: " + toNumber(test3));
	}

	public static int toNumber(String word)
	{	
		if(word.equals(""))
		{
			return 0;
		}
		else
		{ 
			Character next = word.charAt(0);
			if(Character.isDigit(next))
			{
				return Character.digit(next, 10) +  toNumber(word.substring(1));
			}
			else
			{
				return 0 + toNumber(word.substring(1));
			}
			
		}

	}
}
