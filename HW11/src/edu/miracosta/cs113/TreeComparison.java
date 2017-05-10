package edu.miracosta.cs113;

public class TreeComparison {

	public static void main(String[] args) 
	{
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		
		tree1.add(30);
		tree1.add(20);
		tree1.add(10);
		tree1.add(40);
		tree1.add(90);
		tree1.add(50);
		tree1.add(45);
		tree1.add(100);
		
		AVLTree<Integer> tree2 = new AVLTree<Integer>();
		
		tree2.add(30);
		tree2.add(20);
		tree2.add(10);
		tree2.add(40);
		tree2.add(90);
		tree2.add(50);
		tree2.add(45);
		tree2.add(100);

		System.out.println(tree1 + " : BinarySearchTree" + "Height  = 4");
		System.out.println(tree2 + " : AVLTree" + "Height  = 5");
		
	}

}
