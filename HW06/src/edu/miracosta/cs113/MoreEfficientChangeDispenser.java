/**
 * MoreEfficientChangeDispenser.java : This program gives you possiblity of changes with better efficiency
 * 
 * 
 * @author Sina Dalir
 * @version 1.0
 *
 */

/**
 * ALGORITHM:
 * DECLARE & INITIALIZE Scanner keyboard
 * DECLARE & INITIALIZE ArrayList<int[]> uniqueCombinations
 * DECLARE num, changeAmount
 * DECLARE quarters, dimes, nickels, pennies
 * PRINT "Please enter change amount : $ "
 * ASSIGN num = keyboard.nextDouble()
 * ASSIGN changeAmount = (int) (num *100)
 * CALL keyboard.close();
 * CALL change(0, 0, 0, changeAmount, changeAmount)
 * PRINT num
 * FOR EACH 
 * 		PRINT item[0] , item[1], item[2], item[3]
 * PRINT uniqueCombinations.size()
 **/
package edu.miracosta.cs113;
import java.util.Scanner;
import java.util.ArrayList;

public class MoreEfficientChangeDispenser {

	public static void main(String[] args) 
	{
		Scanner keyboard  = new Scanner(System.in);
		double num ;
		int changeAmount;
		ArrayList<int[]> uniqueCombinations = new ArrayList<int[]>();
		System.out.print("Please enter change amount : $ ");
		num = keyboard.nextDouble();
		changeAmount = (int) (num *100);
		keyboard.close();
		change(0, 0 , 0 , changeAmount, changeAmount, uniqueCombinations);
		
		System.out.println("These are all the unique combinations for $ " + num  );
		
		for (int[] items : uniqueCombinations) {
			 System.out.println(" Quarters = " +   items[0] + "   Dimes = " + items[1] + "    Nickels = " + items[2] + "    Pennies = " + items[3] + " P");
        }
        System.out.println("It took " + uniqueCombinations.size() + " combinations");
		
	}
	
	
	//This method is much more efficient than the other recursive methods in the changeDispenser
	/**
	 * The Recursive method that creates combinations of coins possible some might be duplicats
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
	public static void change(int quarters, int dimes, int nickels, int pennies, int total, ArrayList<int[]> uniqueCombinations)
	{
		if((quarters * 25) + (dimes * 10) + (nickels * 5) + pennies != total)
		{
			return;
		}
		
		int[] combinations = {quarters, dimes, nickels, pennies};
		save(combinations, uniqueCombinations);

		if(pennies >= 25)
		{
			change(quarters + 1, dimes, nickels, pennies - 25, total,uniqueCombinations );
		}
		if(pennies >= 10)
		{
			change(quarters, dimes + 1, nickels, pennies - 10, total, uniqueCombinations  );
		}
		
		if(pennies >= 5)
		{	
			change(quarters, dimes, nickels + 1, pennies - 5, total , uniqueCombinations);
		}
		
	}
	
	
	/**
	 * Helper method which sepreates duplicats and leaves only unique combinations in the arrayList
	 * 
	 * @param combination
	 * 			int[] array of int or one set of combinations
	 */
	public static void save(int[] combinations, ArrayList<int[]> uniqueCombinations) 
	{
		boolean repeated = false;
		int i = 0;
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
