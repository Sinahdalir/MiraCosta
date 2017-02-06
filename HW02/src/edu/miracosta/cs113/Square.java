package edu.miracosta.cs113;

import java.util.Scanner;

public class Square extends Shape {
	
	private double length;

	
	public Square()
	{
		super("Square");
	}
	
	public Square(double length)
	{
		super("Square");
		this.length = length;
	}

	public double getLength()
	{
		return length;
	}
	
	
	@Override
	public double computeArea() {
		return length * length;
	}

	@Override
	public double computePerimeter() {
		return 4 * length;
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
