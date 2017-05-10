package edu.miracosta.cs113;



public class RebalanceRight
{
	/**
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
	{
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		if(rightChild.balance > AVLNode.BALANCED)
		{
			AVLNode<E> RightLeftChild =  (AVLNode<E>) localRoot.left;
			
			if(RightLeftChild.balance < AVLNode.BALANCED)
			{
				rightChild.balance = AVLNode.BALANCED;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			}
			else
			{
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			
			localRoot.right = rotateLeft(rightChild);
		}
		else
		{
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		return (AVLNode<E>) rotateLeft(localRoot);
	}
**/

}
