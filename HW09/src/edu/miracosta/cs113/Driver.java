package edu.miracosta.cs113;

//This driver is only used for testing output real testing is in JUnit tests
public class Driver {

	public static void main(String[] args) {
		HashtableChain<Integer, String> table = new HashtableChain<Integer, String>(5);
		table.put(1, "one" );
		table.put(2, "two");
		table.put(3, "three");
		table.put(4, "four");
		table.put(5, "five");
		table.put(6, "six");
		table.put(7, "seven");
		
		System.out.println(table);
		
		System.out.println(table.toStringWithIterator());
		
		System.out.println();
		
		System.out.print(table.entrySet());
		
		

	}

}
