package edu.miracosta.cs113;

public class Tester {
	public static void main(String[] args) 
	{
		Integer[] list = new Integer[10];
		list[0] = 15;
		list[1] = 10;
		list[2] = 430;
		list[3] = 6;
		list[4] = 1;
		list[5] = 35;
		list[6] = 2;
		list[7] = 866;
		list[8] = 8;
		list[9] = 9;
		RadixSort.sort(list);
		for(Integer item : list)
		{
			System.out.println(item);
		}
	}

}
