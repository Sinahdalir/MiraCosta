package edu.miracosta.cs113;
import java.util.Scanner;


public class ComputeAreaAndPerimeter {
	
	public static void main(String[] args)
	{
		Shape myShape;
		double perimeter;
		double area;
		myShape = getShape();
		myShape.readShapeData();
		perimeter = myShape.computePerimeter();
		area = myShape.computeArea();
		displayResult(myShape, area, perimeter);
		System.exit(0);
	}
	public static Shape getShape()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter S for Square");
		System.out.println("Enter R for Rectangle");
		System.out.println("Enter T for Right Triangle");
		String figType = in.next();
		in.close();
		if(figType.equalsIgnoreCase("C"))
		{
			return new Square();
		}
		else if(figType.equalsIgnoreCase("T"))
		{
			return new EquilateralTriangle();
		}
		else if(figType.equalsIgnoreCase("R"))
		{
			return new Rectangle();
		}
		else 
		{
			return null;
		}
		
		
	}
	
	private static void displayResult(Shape myShape, double area, double perim)
	{
		System.out.println(myShape);
		System.out.printf("This area is %.2f%n The perimeter is %.2f%n" , area, perim);
	}

}
