package edu.miracosta.cs113;
import java.lang.Comparable;

/**
 * This class includes static method for QuickSort
 * @author w7249749
 *
 */
public class QuickSort 
{
	/** Sort the table using the Quicksort algorithm
	 * pre : table contains Comparable objects
	 * post : table is sorted
	 * @param table The array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] table)
	{
		quickSort(table, 0 , table.length - 1);
	}
	
	/** A part of the table using the quicksort algorithm
	 * post : the part of table from first through last is sorted
	 * 
	 * @param table the array to be sorted
	 * @param first the index of the low bound
	 * @param last the index of the high bound
	 */
	private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last)
	{
		if(first < last)
		{
			int pivIndex = partition(table, first, last);
			quickSort(table, first, pivIndex - 1);
			quickSort(table, pivIndex + 1, last);
			
		}
	}
	
	/** Partition the table so that values from first to pivIndex
	 *   are less than or equal to the pivot value, and values from 
	 *   pivIndex to last are greater than the pivot value
	 * 
	 * @param table the table to be partitioned
	 * @param first the index of the low bound
	 * @param last the index of the high bound
	 * @return the location of the pivot value
	 */
	private static <T extends Comparable<T>> int partition(T[] table, int first, int last)
	{
		T pivValue = table[first] ;
		int up = first;
		int down = last;
		do
		{
			//Getting the first up index where it's bigger than piv point
			while(pivValue.compareTo(table[up]) >= 0 && (up < last))
			{
					up++;
			}
			
			while(pivValue.compareTo(table[down]) < 0)
			{
				down--;
			}
			if(up < down)
			{
				swap(table , up , down);
			}
		}while(up < down);
		swap(table, first, down);
		return down;
	}
	
	private static <T extends Comparable<T>> void swap(T[] table, int first , int last)
	{
		T temp = table[first];
		table[first] = table[last];
		table[last] = temp;
		
	}

}
