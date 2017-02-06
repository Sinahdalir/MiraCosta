package edu.miracosta.cs113;

public class YResults {

	public static void main(String[] args) {
	 int y1;
	 int y2;
	 int n; 
	 n = 99;
	 for(int i = 0; i < n ; i++)
	 {
		 y1 = 100 * i + 10;
		 System.out.printf("%d, " , y1);
	 }
	 System.out.println();
	 for(int i = 0; i < n ; i++)
	 {
		 y2 = 5 * i * i + 2;
		 System.out.printf("%d, " , y2);
	 }

	}

	
	/* 
	 * The Results show that y2 is increasing much faster than y1.
	 * y1 starts with increasing more than y2 but y2 after 1600 starts increasing more 
	 */
}
