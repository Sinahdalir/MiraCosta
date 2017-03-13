/**
 * LessEfficientChangeDispenser.java : this program prints printJobs with three different options
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE & INITIALIZE static variable ArrayList<int[]> uniqueCombinations
 * DECLARE & INITIALIZE Scanner keyboard
 * DECLARE num, changeAmount
 * DECLARE quarters, dimes, nickels, pennies
 * PRINT "Please enter change amount : $ "
 * ASSIGN num = keyboard.nextDouble()
 * ASSIGN changeAmount = (int) (num *100)
 * CALL keyboard.close();
 * ASSIGN quarters
 * ASSIGN dimes
 * ASSIGN nickels
 * ASSIGN pennies
 * CALL change(quarters, dimes, nickels, pennies)
 * PRINT num
 * FOR EACH 
 * 		PRINT item[0] , item[1], item[2], item[3]
 * PRINT uniqueCombinations.size()
 **/
package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Scanner;


public class LessEfficientChangeDispenser {

	private static ArrayList<int[]> uniqueCombinations = new ArrayList<int[]>();
	
	public static void main(String[] args) 
	{
		Scanner keyboard  = new Scanner(System.in);
		double num ;
		int changeAmount;
		int quarters;
		int dimes;
		int nickels;
		int pennies;
		System.out.print("Please enter change amount : $ ");
		num = keyboard.nextDouble();
		changeAmount = (int) (num *100);
		
		keyboard.close();
		quarters = changeAmount / 25;
		dimes =  (changeAmount % 25) / 10;
		nickels = ((changeAmount % 25) % 10) / 5;
		pennies = ((changeAmount % 25) % 10) % 5;
		change(quarters, dimes , nickels , pennies, changeAmount);
		
		System.out.println("These are all the unique combinations for $ " + num  );
		
        for (int[] items : uniqueCombinations) {
            System.out.println(" Quarters = " +   items[0] + "   Dimes = " + items[1] + "    Nickels = " + items[2] + "    Pennies = " + items[3] + " P");
        }
        System.out.println("It took " + uniqueCombinations.size() + " combinations");

	}
	
	
	/**
	 * Helper which check to see if printJob fnished then polls from queue
	 * 
	 * @param quarters
	 * 			int value of number of quarters
	 * @param dimes
	 * 			int value of number of dimes
	 * @param	nickels
	 * 			int value of number of nickels
	 * @param pennies
	 * 			int value of pennies
	 * @param total
	 * 			int value of total
	 */
	/**
	public static void change(int quarters, int dimes, int nickels, int pennies, int total)
	{
		if((quarters * 25) + (dimes * 10) + (nickels * 5) + pennies != total)
		{
			
		}
		
		int[] combinations = {quarters, dimes, nickels, pennies};
		save(combinations);
		
	
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels , pennies + 25, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels + 1 , pennies + 20, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels + 2, pennies + 15, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels + 3, pennies + 10, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels  + 4, pennies + 5, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes, nickels + 5 , pennies, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 1, nickels , pennies + 15, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 1, nickels + 1, pennies + 10, total) ;
		}
		if(quarters > 0 )
		{
			 change(quarters - 1, dimes + 1, nickels + 2, pennies  + 5, total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 1, nickels + 3, pennies , total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 2, nickels + 1, pennies , total) ;
		}
		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 2, nickels, pennies + 5, total) ;
		}
		if(dimes > 0)
		{
			 change(quarters, dimes - 1, nickels , pennies + 10, total) ;
		}
		if(dimes > 0)
		{
			 change(quarters, dimes - 1, nickels  + 1, pennies + 5, total) ;
		}
		
		if(dimes > 0)
		{
			 change(quarters, dimes - 1, nickels  + 2, pennies , total) ;
		}
		if(nickels > 0)
		{
			 change(quarters, dimes, nickels - 1, pennies  + 5, total) ;
		}
	}*/
	
	
	//This Method is much more efficient than the one commented out above, but it still doesn't get all the combinations
	/**
	 * Helper which check to see if printJob fnished then polls from queue
	 * 
	 * @param quarters
	 * 			int value of number of quarters
	 * @param dimes
	 * 			int value of number of dimes
	 * @param	nickels
	 * 			int value of number of nickels
	 * @param pennies
	 * 			int value of pennies
	 * @param total
	 * 			int value of total
	 */
	public static void change(int quarters, int dimes, int nickels, int pennies, int total)
	{
		if((quarters * 25) + (dimes * 10) + (nickels * 5) + pennies != total)
		{
			
		}
		
		int[] combinations = {quarters, dimes, nickels, pennies};
		save(combinations);
		
	
		if(nickels > 0)
		{
			 change(quarters, dimes, nickels - 1, pennies  + 5, total) ;
		}
		if(dimes > 0)
		{
			 change(quarters, dimes - 1, nickels  + 2, pennies , total) ;
		}

		if(quarters > 0)
		{
			 change(quarters - 1, dimes + 2, nickels + 1 , pennies, total) ;
		}
	}
	
	
	public static void save(int[] combinations) {
        int i = 0;
        boolean repeated = false;
        while (!repeated && i < uniqueCombinations.size()) 
        {
        	int[] checkCombo = uniqueCombinations.get(i);
            if (checkCombo[0] == combinations[0] &&
            		checkCombo[1] == combinations[1] &&
            		checkCombo[2] == combinations[2] &&
            		checkCombo[3] == combinations[3]) 
            {
                repeated = true;
            }
            i++;
        }
        if(!repeated)
        {
        	uniqueCombinations.add(combinations);
        }
    }
	

}
