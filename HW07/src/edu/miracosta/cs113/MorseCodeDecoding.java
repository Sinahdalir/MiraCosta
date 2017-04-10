/**
 * MorseCodeDecoding.java : this program decodes Morse Code to English
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE & INITIALIZE Scanner input to null
 * DECLARE & INITIALIZE Scanner code to null
 * DECLARE & INITIALIZE Scanner keyboard
 * DECLARE & INITIALIZE String temp
 * DECLARE command
 * TRY
 * 		INITIALIZE input = new Scanner(new FileInputStream(fileName))
 * CATCH
 * 		PRINT "File codes.txt was not found"
 * 		PRINT "or could not be opened"
 * 		CALL System.exit(0)
 * DECLARE & INITIALIZE morseCodes = CALL BinaryTree.readBinaryTreeTextFile(input)
 * CALL input.close()
 * CALL printOptions()
 * PRINT "Please enter your command : "
 * ASSIGN temp = keyboard.nextLine()
 * ASSIGN command = Integer.parseInt(temp)
 * WHILE
 * 		IF
 * 			PRINT format  decodeLetter(morseCodes, String code) for the whole alphabet
 * 		END IF
 * 		IF
 * 			PRINT "Please enter file name : "
 * 			ASSIGN temp =  CALL keyboard.nextLine()
 * 			TRY
 * 				INITIALIZE input = new Scanner(new FileInputStream(fileName))
 * 			CATCH
 * 				PRINT "File codes.txt was not found"
 * 				PRINT "or could not be opened"
 * 				CALL System.exit(0)
 * 			PRINT "The Translation of the file is : "
 * 			WHILE 
 * 					ASSIGN code = new Scanner(input.nextLine())
 * 					PRINT & CALL decodeLine(morseCodes, code)
 * 					CALL code.close()
 * 			END WHILE
 * 		END IF
 * 		IF
 * 			PRINT "Please enter morse code for translation(only use *, - and spaces) : "
 * 			ASSIGN temp = CALL keyboard.nextLine()
 * 			PRINT "The translation is : " + CALL decodeLine(morseCodes, code)
 * 			CALL code.close();
 * 		END IF
 * CALL printOptions()
 * PRINT "Please enter your command : "
 * ASSIGN temp = keyboard.nextLine()
 * ASSIGN command = Integer.parseInt(temp)
 * END WHILE
 * CALL keyboard.close()
 * PRINT "Thank you for using out morse code decoding program!!!"
 **/
package edu.miracosta.cs113;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MorseCodeDecoding {

	public static void main(String[] args) 
	{
		Scanner input = null;
		Scanner code = null;
		Scanner keyboard = new Scanner(System.in);
		String temp;
		int command;
		try
	    {
			input = new Scanner(new FileInputStream("codes3.txt"));
	    } 
	    catch(FileNotFoundException e)
	    {
	    	System.out.println("File codes.txt was not found");
	    	System.out.println("or could not be opened");
	    	System.exit(0);
	    }
		
		BinaryTree<String> morseCodes = BinaryTree.readBinaryTreeTextFile(input);
		input.close();
		
		
		printOptions();
		System.out.print("Please enter your command : ");
		temp = keyboard.nextLine();
		command = Integer.parseInt(temp);
		while(command < 4)
		{
			if(command == 1)
			{
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*-") + " : ", " *-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-***")  + " : ", " -***", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-*-*")  + " : ", " -*-*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-**")  + " : ", " -**", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*")  + " : ", " *", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "**-*")  + " : ", " **-*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "--*")  + " : ", " --*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "****")  + " : ", " ****", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "**")  + " : ", " **", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*---")  + " : ", " *---", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-*-")  + " : ", " -*-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*-**")  + " : ", " *-**", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "--")  + " : ", " --", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-*")  + " : ", " -*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "---")  + " : ", " ---", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*--*")  + " : ", " *--*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "--*-")  + " : ", " --*-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*-*")  + " : ", " *-*", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "***")  + " : ", " ***", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-")  + " : ", " -", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "**-")  + " : ", " **-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "***-")  + " : ", " ***-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "*--")  + " : ", " *--", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-**-")  + " : ", " -**-", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "-*--")  + " : ", " -*--", " |");
				System.out.printf("%s %s %5s %s" , "\n| ", decodeLetter(morseCodes, "--**")  + " : ", " --**", " |");
			}
			else if(command == 2)
			{
				System.out.print("Please enter file name : ");
				temp = keyboard.nextLine();
				try
			    {
					input = new Scanner(new FileInputStream(temp));
			    } 
			    catch(FileNotFoundException e)
			    {
			    	System.out.println("File  was not found");
			    	System.out.println("or could not be opened");
			    	System.exit(0);
			    }
				System.out.println("The Translation of the file is : ");
				while(input.hasNextLine())
				{
					code = new Scanner(input.nextLine());
					System.out.println(decodeLine(morseCodes, code));
					code.close();
				}
			}
			else if(command == 3)
			{
				System.out.println("Please enter morse code for translation(only use *, - and spaces) : ");
				temp = keyboard.nextLine();
				
				code = new Scanner(temp);
				System.out.println("The translation is : " + decodeLine(morseCodes, code));
				code.close();
			}
			
			printOptions();
			System.out.print("Please enter your command : ");
			temp = keyboard.nextLine();
			command = Integer.parseInt(temp);
		}
		keyboard.close();
		System.out.println("Thank you for using out morse code decoding program!!!");

	}
	
	/**
	 * Print options for the user
	 * 
	 */
	public static void printOptions()
	{
		System.out.println("\n\n1. Translation table");
		System.out.println("2. Decode text file ");
		System.out.println("3. Decode line");
		System.out.println("4. End Program\n");
	}
	
	/**
	 * Decodes a code to an English letter 
	 * 
	 * @param codes
	 *           BinaryTree<String> representing codes
	 * @param code
	 *            String representing code
	 *            
	 * @return String , representing the English translation
	 */
	public static String decodeLetter(BinaryTree<String> codes, String code)
	{
		if(codes == null )
		{
			return "Not a correct morse code, please try again!";
		}
		else if(code.length() == 0)
		{
			if(codes.printRoot().equals("0"))
			{
				return "Not a correct morse code, please try again!";
			}
			else
			{
				return "" + codes.printRoot();
			}
			
		}
		else if(code.charAt(0) == '*')
		{
			return "" + decodeLetter(codes.getLeftSubtree(), code.substring(1));
		}
		else if(code.charAt(0) == '-')
		{
			return "" + decodeLetter(codes.getRightSubtree(), code.substring(1));
		}
		else
		{
			return decodeLetter(codes, code.substring(1));
		}
	}
	
	/**
	 * Decodes a line to English  
	 * 
	 * @param codes
	 *           BinaryTree<String> representing codes
	 * @param code
	 *            Scanner representing code
	 *            
	 * @return String , representing the English translation
	 */
	public static String decodeLine(BinaryTree<String> codes , Scanner code)
	{
		String line;
		code.useDelimiter(" ");
		if(!code.hasNext())
		{
			return "";
		}
		else 
		{
			line = code.next();
			return decodeLetter(codes, line) + decodeLine(codes, code);
			
			
		}
	}
	

	
	

}
