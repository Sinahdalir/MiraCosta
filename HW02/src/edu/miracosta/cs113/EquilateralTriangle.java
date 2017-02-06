package edu.miracosta.cs113;

import java.util.Scanner;

public class EquilateralTriangle extends Shape {

	
	private double length;

	
	public EquilateralTriangle()
	{
		super("EquilateralTriangle");
	}
	
	public EquilateralTriangle(double length)
	{
		super("EquilateralTriangle");
		this.length = length;
	}

	public double getLength()
	{
		return length;
	}
	
	
	
	@Override
	public double computeArea() {
		return 0.4330127019 * (length * length); //0.4330127019 = root squared of 3 devided by 4
	}

	@Override
	public double computePerimeter() {
		return 3 * length;
	}

	@Override
	public void readShapeData() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the Square");
		length = in.nextDouble();
		in.close();

	}
	
	@Override
	public String toString()
	{
		return super.toString() + " : length is " + length ;
	}


}
