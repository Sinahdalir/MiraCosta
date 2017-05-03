package edu.miracosta.cs113;
import java.io.PrintWriter;
import java.lang.Comparable;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


/**
 * This Class sorts the text file using two other text files
 * Pre : run DataInput.java first before running this method
 * @author w7249749
 *@version 1.0
 *
 * Agorithm :
 * 
 * DECLARE & INSTANTIATE counter & numData as ints
 * DECLARE & INSTANTIATE temp as String
 * DECLARE & INSTANTIATE list, listRight, listLeft as Integer[]
 * DECLARE & INSTANTIATE outputLeft, outputRight, outputOriginal as PrintWriter
 * DECLARE & INSTANTIATE inputLeft, inputRight, inputOriginal as Scanner
 * TRY 
 * 		ASSIGN inputOriginal = new Scanner(new FileInputStream(fileName))
 * 		ASSIGN outputLeft = new PrintWriter(new FileOutputStream(ORIGINAL_LEFT))
 * 		ASSIGN outputRight = new PrintWriter(new FileOutputStream(ORIGINAL_RIGHT))
 * 		WHILE(input.hasNext())
 * 			ASSIGN list = new Integer[10]
 * 			FOR	
 * 				IF hasNextLine()
 * 					ASSIGN temp
 * 				ASSIGN list[i] = CALL Integer.parseInt(temp)
 * 				INCREMENT numData
 * 			CALL QuickSort.sort(list)
 * 			FOR
 * 				IF
 * 					outputLeft.println(num)
 * 				ELSE
 * 					outputRight.println(num)
 * 				INCREMENT count++
 * CATCH
 * 		PRINT "Class not Found"
 * CALL inputOriginal.close()
 * CALL outputLeft.close()
 * CALL outputRight.close()
 * TRY
 * 		ASSIGN outputOriginal = new Scanner(new FileInputStream(ORIGINAL))
 * 		ASSIGN inputLeft = new PrintWriter(new FileOutputStream(ORIGINAL_LEFT))
 * 		ASSIGN inputRight = new PrintWriter(new FileOutputStream(ORIGINAL_RIGHT))
 * 		WHILE
 * 			ASSIGN listRight = new Integer[10]
 *			ASSIGN listLeft = new Integer[10];
 *			ASSIGN list = new Integer[listRight.length + listLeft.length]
 *			FOR
 *				IF
 *					ASSIGN temp = CALL inputLeft.nextLine()
 *					ASSIGN 	listLeft[i] = CALL Integer.parseInt(temp)
 *			FOR
 *				IF
 *					IF
 *					ASSIGN temp = CALL inputRight.nextLine()
 *					ASSIGN 	listRight[i] = CALL Integer.parseInt(temp)
 *			CALL merge(list ,listRight, listLeft)
 *			FOR
 *				IF
 *					CALL outputOriginal.println(num)
 *CATCH
 * 		PRINT "Class not Found"
 * CALL outputOriginal.close();
 * CALL	inputLeft.close();
 * CALL	inputRight.close();
 * ASSIGN int length= 20
 * WHILE
 * 		ASSIGN counter
 * 		TRY
 * 			ASSIGN inputOriginal = new Scanner(new FileInputStream(ORIGINAL))
 *			ASSIGN 	outputLeft = new PrintWriter(new FileOutputStream(ORIGINAL_LEFT))
 *			ASSIGN 	outputRight = new PrintWriter(new FileOutputStream(ORIGINAL_RIGHT))
 *			WHILE 
 *					ASSIGN list = new Integer[length]
 *					FOR
 *						IF
 *							ASSIGN temp = CALL inputOriginal.nextLine()		
 *						ASSIGN list[i] = CALL Integer.parseInt(temp)
 *					FOR 
 *						IF
 *							CALL outputLeft.println(num)
 *						ELSE
 *							CALL outputRight.println(num)
 *					INCREMENT counter
 *		CATCH
 *			PRINT "Class not Found"
 *		 CALL inputOriginal.close()
 * 		CALL outputLeft.close()
 * 		CALL	outputRight.close()
 * 		TRY
 * 				ASSIGN inputRight = new Scanner(new FileInputStream(ORIGINAL_RIGHT))
 * 				ASSIGN inputLeft = new Scanner(new FileInputStream(ORIGINAL_LEFT))
 * 				ASSIGN outputOriginal = new PrintWriter(new FileOutputStream(ORIGINAL))
 * 				WHILE
 * 					listRight = new Integer[length]
 *					listLeft = new Integer[length]
 *					list = new Integer[listRight.length + listLeft.length]
 * 					FOR
 * 						IF
 * 							ASSIGN  temp = CALL inputLeft.nextLine()
 *							ASSIGN listLeft[i] = CALL Integer.parseInt(temp)
 *					FOR
 *						IF
 *							ASSIGN temp = CALL inputRight.nextLine()
 *							ASSIGN listRight[x] = CALL Integer.parseInt(temp)
 *					CALL merge(list ,listRight, listLeft)
 * 					FOR
 * 						IF
 * 							CALL outputOriginal.println(num)
 * 			CATCH
 * 					PRINT "Class not Found"
 * 			CALL outputOriginal.close()
 * 			CALL inputLeft.close()
 *			CALL inputRight.close()
 *			CALL length = length * 2
 *PRINT "Done!"
 */

public class MergeSortDataFile
{
	private static final String ORIGINAL = "Original.txt";
	private static final String ORIGINAL_LEFT = "OriginalLeft.txt";
	private static final String ORIGINAL_RIGHT = "OriginalRight.txt";
	
	public static void main(String[] args) 
	{
		int counter= 0;
		int numData = 0;
		String temp = "";
		Integer[] list = new Integer[10] ;
		Integer[] listRight = null;
		Integer[] listLeft = null;
		PrintWriter outputLeft = null;
		PrintWriter outputRight = null;
		Scanner inputOriginal = null;
		Scanner inputLeft = null;
		Scanner inputRight = null;
		PrintWriter outputOriginal = null;
		
		
		try
		{
			inputOriginal = new Scanner(new FileInputStream(ORIGINAL));
			outputLeft = new PrintWriter(new FileOutputStream(ORIGINAL_LEFT));
			outputRight = new PrintWriter(new FileOutputStream(ORIGINAL_RIGHT));
			
			while(inputOriginal.hasNextLine())
			{
				list = new Integer[10];
				for(int i = 0; i < list.length ; i++)
				{
					if(inputOriginal.hasNextLine())
					{
						temp = inputOriginal.nextLine();
					}
					list[i] = Integer.parseInt(temp);
					numData++;
				}
				
				//Sorting the array
				QuickSort.sort(list);
				
				for(Integer num : list)
				{
					if(counter % 2 == 0)
					{
						outputLeft.println(num);
					}
					else
					{
						outputRight.println(num);
					}
					
				}
				counter++;
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Class not Found");
		}
		
		inputOriginal.close();
		outputLeft.close();
		outputRight.close();
		
		
		
		try
		{
			inputRight = new Scanner(new FileInputStream(ORIGINAL_RIGHT));
			inputLeft = new Scanner(new FileInputStream(ORIGINAL_LEFT));
			outputOriginal = new PrintWriter(new FileOutputStream(ORIGINAL));
			
			while(inputLeft.hasNextLine() || inputRight.hasNextLine())
			{
				listRight = new Integer[10];
				listLeft = new Integer[10];
				list = new Integer[listRight.length + listLeft.length];
				
				
				for(int i = 0; i < listLeft.length  ; i++)
				{
					if(inputLeft.hasNextLine())
					{
						temp = inputLeft.nextLine();
						listLeft[i] = Integer.parseInt(temp);
					}
					
				}
				for(int x = 0; x < listRight.length  ; x++)
				{
					if(inputRight.hasNextLine())
					{
						temp = inputRight.nextLine();
						listRight[x] = Integer.parseInt(temp);
					}
					
				}
				
				merge(list ,listRight, listLeft);
				
				for(Integer num : list)
				{
					if(num != null)
					{
						outputOriginal.println(num);
					}
					
				}
				
				
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Class not Found");
		}
		outputOriginal.close();
		inputLeft.close();
		inputRight.close();
		
		int length= 20;
		while(length <= numData)
		{
			
			counter = 0;
			try
			{
				inputOriginal = new Scanner(new FileInputStream(ORIGINAL));
				outputLeft = new PrintWriter(new FileOutputStream(ORIGINAL_LEFT));
				outputRight = new PrintWriter(new FileOutputStream(ORIGINAL_RIGHT));
				
				while(inputOriginal.hasNextLine())
				{
					
					list = new Integer[length];
					for(int i = 0; i < list.length ; i++)
					{
						if(inputOriginal.hasNextLine())
						{
							temp = inputOriginal.nextLine();
						}
						
						list[i] = Integer.parseInt(temp);
						
					}
							
					for(Integer num : list)
					{
						if(counter % 2 == 0)
						{
							outputLeft.println(num);
						}
						else
						{
							outputRight.println(num);
						}
						
					}
					counter++;
				}
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Class not Found");
			}

			inputOriginal.close();
			outputLeft.close();
			outputRight.close();
			
			
			try
			{
				inputRight = new Scanner(new FileInputStream(ORIGINAL_RIGHT));
				inputLeft = new Scanner(new FileInputStream(ORIGINAL_LEFT));
				outputOriginal = new PrintWriter(new FileOutputStream(ORIGINAL));
				
				while(inputLeft.hasNextLine() || inputRight.hasNextLine())
				{
					listRight = new Integer[length];
					listLeft = new Integer[length];
					list = new Integer[listRight.length + listLeft.length];
					
					
					for(int i = 0; i < listLeft.length ; i++)
					{
						if(inputLeft.hasNextLine())
						{
							temp = inputLeft.nextLine();
							listLeft[i] = Integer.parseInt(temp);
						}
					}
					
					for(int x = 0; x < listRight.length ; x++)
					{
						if(inputRight.hasNextLine())
						{
							temp = inputRight.nextLine();
							listRight[x] = Integer.parseInt(temp);
						}
					}
					
					
					merge(list ,listRight, listLeft);
			
					
					for(Integer num : list)
					{
						if(num != null)
						{
							outputOriginal.println(num);
						}
						
					}
				}
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Class not Found");
			}
			outputOriginal.close();
			inputLeft.close();
			inputRight.close();
	
			length = length * 2;
		}
		
		
	
	System.out.println("Done!");
	
	}
	
	

	/**Merge two sequences
	 * pre : leftSequence and rightSequence are sorted.
	 * post : outputSequence is the merged result and is sorted
	 * @param outputSequence the destination
	 * @param leftSequence the left input
	 * @param rightSequence the right input
	 */
	private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < leftSequence.length && j < rightSequence.length)
		{
			if(leftSequence[i] == null)
			{
				i = leftSequence.length;
				if(rightSequence[j] == null)
				{
					j = rightSequence.length;
				}
			}
			else if(rightSequence[j] == null)
			{
				if(leftSequence[j] == null)
				{
					j = leftSequence.length;
				}
				j = rightSequence.length;
			}
			else if(leftSequence[i].compareTo(rightSequence[j]) < 0)
			{
				outputSequence[k++] = leftSequence[i++];
			}
			else
			{
				outputSequence[k++] = rightSequence[j++];
			}
		}
		
		while(i < leftSequence.length)
		{
			if(leftSequence[i] == null)
			{
				i = leftSequence.length;
			}
			else
			{
				outputSequence[k++] = leftSequence[i++];
			}
			
		}
		while(j < rightSequence.length)
		{
			if(rightSequence[j] == null)
			{
				j = rightSequence.length;
			}
			else
			{
				outputSequence[k++] = rightSequence[j++];
			}
			
		}
	}
	
	

}
