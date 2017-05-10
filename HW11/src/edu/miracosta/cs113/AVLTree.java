package edu.miracosta.cs113;



@SuppressWarnings("serial")
public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> 
{
	private boolean increase;
	
	/** add starter method 
	 * pre: the item to insert implements the Comparable interface
	 * @param item the item being inserted
	 * @return true if the object is inserted; false if the
	 * 								object already exists in the tree
	 * @throws ClassCastException if item is not Comparable
	 */
	public boolean add(E item)
	{
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	
	/** Recursive add method. Inserts the given object into the tree
	 * post: addReturn is set true if the item is inserted,
	 * 			false if the item is already in the tree
	 * @param localRoot The local root of the subtree
	 * @param item The obejct to be inserted
	 * @return the new local root of the subtree with the item inserted
	 */
	private AVLNode<E> add(AVLNode<E> localRoot, E item)
	{
		if(localRoot == null)
		{
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		}
		if(item.compareTo(localRoot.data) == 0)
		{
			increase = false;
			addReturn = false;
			return localRoot;
		}
		else if(item.compareTo(localRoot.data) < 0 )
		{
			localRoot.left = add((AVLNode<E>) localRoot.left , item);
			if(increase)
			{
				decrementBalance(localRoot);
				if(localRoot.balance < AVLNode.LEFT_HEAVY)
				{
					increase = false;
					return rebalanceLeft(localRoot);
				}
			}
			return localRoot;
		}
		else
		{
			localRoot.right = add((AVLNode<E>) localRoot.right , item);
			if(increase)
			{
				incrementBalance(localRoot);
				if(localRoot.balance > AVLNode.RIGHT_HEAVY)
				{
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
			return localRoot;
		}
		
		
	}
	
	/** Method to rebalance right.
	 * pre : localRoot is the root of an AVL subtree that is
	 * 		critically RIGHT-HEAVY
	 * post: Balance is restored.
	 * @param localRoot Root of AVL subtree that needs rebalancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
	{
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		//Right- left
		if(rightChild.balance < AVLNode.BALANCED)
		{
			AVLNode<E> rightLeftChild =  (AVLNode<E>) rightChild.left;
			
			if(rightLeftChild.balance > AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.BALANCED;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			}
			else
			{
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				rightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			
			localRoot.right = rotateRight(rightChild);
		}//RIGHT-RIGHT
		else
		{
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateLeft(localRoot);
	}
	
	/** Method to rebalance left.
	 * pre: localRoot is the root of an AVL subtree that is
	 * 		critically left-heavy
	 * post: Balance is restored.
	 * @param localRoot Root of AVL subtree that needs rebalancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot)
	{
		AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
		if(leftChild.balance > AVLNode.BALANCED)
		{
			AVLNode<E> leftRightChild =  (AVLNode<E>) leftChild.right;
			
			if(leftRightChild.balance < AVLNode.BALANCED)
			{
				leftChild.balance = AVLNode.BALANCED;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.RIGHT_HEAVY;
			}
			else
			{
				leftChild.balance = AVLNode.LEFT_HEAVY;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;

			}
			
			localRoot.left = rotateLeft(leftChild);
		}
		else
		{
			leftChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateRight(localRoot);
	}
	
	private void decrementBalance(AVLNode<E> node)
	{
		node.balance --;
		if(node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	private void incrementBalance(AVLNode<E> node)
	{
		node.balance ++;
		if(node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	/**
	 * toString representing the objects in the tree
	 * 
	 * @return formatted string of variables from the tree
	 */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, 1, sb);
		return sb.toString(); 
	}
	
	
	
	private static class AVLNode<E> extends Node<E>
	{
		public static final int LEFT_HEAVY = -1;
		public static final int RIGHT_HEAVY = 1;
		public static final int BALANCED = 0;
		private int balance;
		
		/** Construct a node with the given item as a the data field
		 * 
		 * @param item
		 */
		public AVLNode(E item)
		{
			super(item);
			balance = BALANCED;
		}
		
		@Override
		public String toString()
		{
			return balance + ": " + super.toString();
		}
	}
}
