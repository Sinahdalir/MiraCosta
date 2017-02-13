package edu.miracosta.cs113;

public class Term implements Comparable<Term> {
	
	private int exponent;
	private int coefficient;
	/**
	 * Default constructor, setting all int variables to zero
	 * 
	 */
	public Term()
	{
		exponent = 0;
		coefficient = 0;
	}
	/**
	 * Full constructor, specifying each part of Term
	 * 
	 * @param exponent
	 *            integer representing exponent
	 * @param coefficient
	 *            integer representing coefficient
	 * 
	 */
	public Term(int exponent,  int coefficient)
	{
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	/**
	 * Mutator for exponent value
	 * 
	 * @param exponent
	 *            integer value representing exponent
	 */
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	/**
	 * Mutator for coefficient value
	 * 
	 * @param coefficient
	 *            integer value representing coefficient
	 */
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	/**
	 * Accessor for exponent value
	 * 
	 * @return exponent integer value
	 */
	public int getExponent()
	{
		return exponent;
	}
	/**
	 * Accessor for coefficient value
	 * 
	 * @return coefficient integer value
	 */
	public int getCoefficient()
	{
		return coefficient;
	}
	/**
	 * toString representing objects values
	 * 
	 * @return formatted string of coefficient with X and exponent
	 */
	@Override
	public String toString()
	{
		if(coefficient < 0)
		{
			return "(" +coefficient + ")X^" + exponent + " + ";
		}
		if(exponent == 0)
		{
			return "" + coefficient ;
		}
		else if(exponent == 1)
		{
			return coefficient + "X + ";
		}
		return coefficient + "X^" + exponent + " + ";
	}
	/**
	 * Equals method checks ALL instance variables are equal
	 * 
	 * @return boolean value for equality
	 */
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
		{
			return false;
		}
		else if(other.getClass() == getClass())
		{
			Term newOther = (Term) other;
			return this.exponent == newOther.getExponent() &&
					this.coefficient == newOther.getCoefficient();
			
		}
		else
		{
			return false;
		}

	}
	/**
	 * compareTo method defined for this class from implementing Comaprable
	 * 
	 * @return a compared int value between two objects exponents 
	 */
	@Override
	public int compareTo(Term other)
	{
		return this.exponent - other.getExponent();
	}
	
	
	
	

}
