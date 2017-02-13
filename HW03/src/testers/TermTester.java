package testers;

import edu.miracosta.cs113.Term;

public class TermTester {

	public static void main(String[] args) {
		Term term = new Term();
		term.setCoefficient(4);
		term.setExponent(3);
		
		System.out.println(term.getCoefficient() + "= 4");
		System.out.println(term.getExponent() + "= 3");
		
		Term term2 = new Term(3, 4);
		System.out.println(term.equals(term2) + " = true");
		
		term2.setExponent(10);

		System.out.println(term2.compareTo(term) + "= positive");
	}

}
