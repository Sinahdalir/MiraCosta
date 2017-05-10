package edu.miracosta.cs113;
import java.io.Serializable;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable 
{
	protected Node<E> root;
	
	/**
	 * Default constructor, setting all int variables to zero or Strings to "" & objects to null
	 * 
	 */
	
	public BinaryTree() 
	{
		root = null; 
	}
	
	/**
	 * Full constructor, specifying each part of PRinter
	 * 
	 * @param root
	 *            Node repsresenting root      
	 * 
	 */
	protected BinaryTree(Node<E> root) 
	{
		this.root = root; 
	}
	
	/**
	 * Combinaiton constructor, specifying each part of BinaryTree
	 * 
	 * @param data
	 *            E representing data
	 * @param leftTree
	 *            BinaryTree<E> representing leftTree
	 * @param right
	 *            BinaryTree<E> representing rightTree  
	 * 
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) 
	{
		root = new Node<E>(data);
		if(leftTree != null) 
		{
			root.left = leftTree.root;
		} 
		else
		{
			root.left = null;
		} 
		if(rightTree != null) 
		{
			root.right = rightTree.root;
		} 
		else
		{
			root.right = null; 
		} 
	}
	
	/**
	 * Gets the left subtree of the tree
	 * 
	 * @return BinaryTree<E>
	 */
	public BinaryTree<E> getLeftSubtree() 
	{
		if(root != null && root.left != null) 
		{
			return new BinaryTree<E>(root.left);
		}
		else
		{
			return null;
		}
	}
	/**
	 * Gets the left subtree of the tree
	 * 
	 * @return BinaryTree<E>
	 */
	public BinaryTree<E> getRightSubtree() 
	{
		if(root != null && root.right != null) 
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Checks to see if the root is a leaf
	 * 
	 * @return boolean, flase if not leaf, true if it is a leaf
	 */
	public boolean isLeaf()
	{
		return (root.left == null && root.right == null);
	}
	
	/**
	 * Returns the toString of the root node
	 * 
	 * @return String
	 */
	public String printRoot() 
	{
		return root.toString(); 
	}
	
	/**
	 * toString representing the objects in the tree
	 * 
	 * @return formatted string of variables from the tree
	 */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString(); 
	}
	
	/**
	 * Traverses the tree from the left and preorder
	 * 
	 * @param node
	 *           Node<E> representing node
	 * @param depth
	 *            int representing depth
	 * @param sb
	 *            StringBuilder representing sb  
	 * 
	 */
	protected void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) 
	{
		for(int i = 1; i < depth; i++) 
		{
			sb.append("  ");   
		}   
		if(node == null) 
		{     
			sb.append("null\n");
		}
		else
		{ 
			sb.append(node.toString() + "\n");
		    preOrderTraverse(node.left, depth + 1, sb);
		    preOrderTraverse(node.right, depth + 1, sb);   
		}
	}
	
	//Made for later
	/**
	 * Traverses the tree from the left and in order
	 * 
	 * @param node
	 *           Node<E> representing node
	 * @param depth
	 *            int representing depth
	 * @param sb
	 *            StringBuilder representing sb  
	 * 
	 */

	protected void inOrderTraverse(Node<E> node, int depth, StringBuilder sb) 
	{

		if(node == null) 
		{     
			//So null is not printed
		}
		else
		{ 
			inOrderTraverse(node.left, depth + 1, sb);
			sb.append(node.toString() + "  ");
		    inOrderTraverse(node.right, depth + 1, sb);   
		}
	}
	
	// Made for later
	/**
	 * Traverses the tree from the left and post order
	 * 
	 * @param node
	 *           Node<E> representing node
	 * @param depth
	 *            int representing depth
	 * @param sb
	 *            StringBuilder representing sb  
	 * 
	 */

	protected void postOrderTraverse(Node<E> node, int depth, StringBuilder sb) 
	{
		for(int i = 1; i < depth; i++) 
		{
			sb.append("  ");   
		}   
		if(node == null) 
		{     
			sb.append("null\n");
		}
		else
		{ 
			postOrderTraverse(node.left, depth + 1, sb);
			postOrderTraverse(node.right, depth + 1, sb);   
			sb.append(node.toString() + "\n");
		}
	}
	
	
	
	/**
	 * reads in from a text file and creates a binary tree
	 * 
	 * @param scan
	 *           Scanner representing scan
	 *@return  BinaryTree<String> only string for this method
	 * 
	 */
	public static BinaryTree<String> readBinaryTreeTextFile(Scanner scan) 
	{
		String data = scan.next();
		scan.next();
		if(data.equals("null")) 
		{
			return null;
		}
		else
		{
			BinaryTree<String> leftTree = readBinaryTreeTextFile(scan);
			BinaryTree<String> rightTree = readBinaryTreeTextFile(scan);
			return new BinaryTree<String>(data, leftTree, rightTree); 
		}
	}
	
	/**
	 * writes in from a binary file and creates a binary tree
	 * 
	 * @param fileName
	 *           String representing fileName
	 * @param nameOfObject
	 *           BinaryTree<E> representing nameOfObject   
	 * 
	 */
	public void writeBinaryTreeBinaryfile(String fileName, BinaryTree<E> nameOfObject ) 
	{
		try 
		{
			 ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));  
			 out.writeObject(nameOfObject);
			 out.close();
		} 
		catch (Exception ex) 
		{
			 ex.printStackTrace();  
			 System.exit(1);
		}
	}
	
	/**
	 * read in from a binary file and creates a binary tree
	 * 
	 * @param fileName
	 *           String representing fileName
	 * @return BinaryTree<E> 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryTree<E> readBinaryTreeBinaryfile(String fileName) 
	{
		BinaryTree<E> tree = null;
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			tree = (BinaryTree<E>) in.readObject();
			in.close();
		} 
		catch(Exception ex) 
		{  
			ex.printStackTrace();
			System.exit(1); 
		}
		return tree;
	}
	
	
	protected static class Node<E> implements Serializable 
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		/**
		 * Full constructor, specifying each part of Node
		 * 
		 * @param data
		 *            E repsresenting data      
		 * 
		 */
		public Node(E data) 
		{  
			this.data = data;
			this.left = null;
			this.right = null; 
		} 
		/**
		 * toString representing objects values
		 * 
		 * @return formatted string of Node variables 
		 */
		public String toString()
		{
			return this.data.toString(); 
		}
	}
	
	

}
