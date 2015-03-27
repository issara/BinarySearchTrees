import java.util.*;

/**
 * @author Pong and Greg
 *
 *The following class is the BST class which is the main code for finding, inserting, 
 *deleting and traversing the tree.  There is also a displayTree and getMin, getMax method.
 *
 *The class also contains the variables and constructor method for the root node, 
 *and the size of the BST.
 */
public class BST {
	public BSTNode root;		//initializes root of tree
	private int size;			//initializes size of tree
	
	/**
	    * This is the constructor method for the BST class.
	    */
	public BST(){
		root = null;			//root starts off as empty
		size = 0;				//size is 0
	}
	
	 /**
	    * The find method goes through the BST recursively and finds the targeted value key.
	    * 
	    * @param: k
	    * @param: v
	    * @return:BSTNode of the found value
	    */
	public BSTNode find(int k, BSTNode v){
		if(v==null){
			return null;
		}
		else if(v.key==k){
			return v;
		}
		else if(k<v.key){
			return find(k,v.left);
		}
		else{
			return find(k,v.right);
		}
	}
	
	 /**
	    * The recursive insert method is the actual insert method
	    * which is kept private in order to maintain order and control
	    * to the BST
	    * 
	    * @param: k
	    * @param: v
	    */
	private void recInsert(int k,BSTNode v){
		if(k>v.key){
			if(v.right!=null){
				recInsert(k,v.right);
			}
			else{
				v.right = new BSTNode(k,null,null,v);
			}
		}
		else{
			if(v.left!=null){
				recInsert(k,v.left);
			}
			else{
				v.left = new BSTNode(k,null,null,v);
			}
		}
	}
	
	 /**
	    * This insert method is public so people can actually
	    * use this to insert values, which actually calls on the 
	    * recInsert method which starts at the root by default in this method.
	    * 
	    * @param: k
	    */
	public void insert(int k){
		if(root==null){
			root = new BSTNode(k,null,null,null);
		}
		else{
			recInsert(k,root);
		}
	}
	
	 /**
	    * The getMin method goes through the (sub)tree recursively to find the 
	    * minimum value depending on the node it starts at.
	    * 
	    * @param: v
	    * @return: BSTNode of the minimum value
	    */
	public BSTNode getMin(BSTNode v){
		if(v.left==null){
			return v;
		}
		else{
			return getMin(v.left);
		}
	}
	
	 /**
	    * The getMax method goes through the (sub)tree recursively to find the 
	    * maximum value depending on the node it starts at.
	    * 
	    * @param: v
	    * @return: BSTNode of the maximum value
	    */
	public BSTNode getMax(BSTNode v){
		if(v.right==null){
			return v;
		}
		else{
			return getMax(v.right);
		}
	}
	
	 /**
	    * The display tree methods creates a visual tree for the user to see
	    * and adds a new line every time there is an added level to the tree
	    * 
	    */
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = (BSTNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
		
	}  // end displayTree()
	
	 /**
	    *This is the general traverse method which calls on the three other traversal
	    *methods depending on what the user wants between PreOrder, inOrder and PostOrder.
	    *
	    *@param: traverseType
	    */
	public void traverse(char traverseType)
	{
		switch(traverseType)
		{
			case 'p': System.out.print("\nPreorder traversal: ");
				System.out.println("Root is " + root.key);
				preOrder(root);
				break;
			case 'i': System.out.print("\nInorder traversal:  ");
				System.out.println("Root is " + root.key);
				inOrder(root);
				break;
			case 't': System.out.print("\nPostorder traversal: ");
				System.out.println("Root is " + root.key);
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	 /**
	    * This is the preOrder traversal method which traverses the tree in
	    * the preOrder path and prints out each value it traverses.
	    * 
	    * @param: v
	    */
	public void preOrder(BSTNode v){
		if (v!=null){
			System.out.println(v.key);
				preOrder(v.left);
				preOrder(v.right);
		}
		
	}
	
	 /**
	    * This is the postOrder traversal method which traverses the tree in
	    * the preOrder path and prints out each value it traverses.
	    * 
	    * @param: v
	    */
	public void postOrder(BSTNode v){
		if(v!=null){
			postOrder(v.left);
			postOrder(v.right);
			System.out.println(v.key);
		}
	}
	
	 /**
	    * This is the inOrder traversal method which traverses the tree in
	    * the preOrder path and prints out each value it traverses.
	    * 
	    * @param: v
	    */
	public void inOrder(BSTNode v){
		if(v!=null){
			inOrder(v.left);
			System.out.println(v.key);
			inOrder(v.right);
		}
	}
	
	 /**
	    * This is the delete method which goes through 4 different cases of deletion:
	    * If there is only the root, if the value has 2 or more children, if value
	    * has a single child or if value is a leaf.  After it deletes the node with the
	    * targeted value, it reorganizes the tree to make sure it is still a BST.
	    * 
	    * @param: k
	    * @return: BSTNode
	    */
	public BSTNode delete(int k){
		BSTNode v = find(k,root);
		System.out.println("Found" + v.key);
		
		//Root deletion
		if(k==root.key && root.left==null && root.right==null){
			root = null;
		}
		
		//More than 2 children deletion
		else if(v.right!=null && v.left!=null){
			double mat;
			mat = Math.random();
			if(mat>1){
//				System.out.println("Two child deletion with successor"+ mat);
				BSTNode succ= getMin(v.right);
//				System.out.println("succ is" + succ.key);
//				System.out.println("succ parent is " + succ.parent.key);
				if(v.right == succ){
					if(succ.right != null){
						succ.parent.right = succ.right;
					}
					else{ 
						succ.parent.right = null; 
						succ.parent = null;
					}
				}
				else{ //normal getMin
					if(succ.right != null){
						succ.parent.left = succ.right;
						succ.right.parent = succ.parent;
					}
					else{
						succ.parent.left = null;
						succ.parent = null; 
					}
				}
				v.key = succ.key;
//				System.out.println("parent of succ key again" + succ.parent.key);
			}
			else{
//				System.out.println("Two child deletion with predecessor "+ mat);
				BSTNode pred = getMax(v.left);
//				System.out.println("pred is" + pred.key);
//				System.out.println("pred parent is " + pred.parent.key);
				if(v.left == pred){
					if(pred.left != null){
						pred.parent.left = pred.left;
					}
					else{ 
						pred.parent.left = null; 
						pred.parent = null;
					}
				}
				else{ //normal getMax
					if(pred.left != null){
						pred.parent.right = pred.left;
						pred.left.parent = pred.parent;
					}
					else{
						pred.parent.right = null;
						pred.parent = null; 
					}
				}
				v.key = pred.key;
//				System.out.println("parent of succ key again" + succ.parent.key);
			}
			
		
		}
	
		//leaf deletion
		else if(v.right==null && v.left==null){
			System.out.println("Leaf deletion ");
			if(v.parent.left == v){
				v.parent.left = null;
				v.parent = null;	
			}
			else if(v.parent.right == v){
				v.parent.right = null;
				v.parent = null;	
			}
		}
		
		//Single child /
		else{ //if(v.left!=null||v.right!=null){
//			System.out.println("Single child deletion ");
			BSTNode temp = v.parent;
			
			if(v.parent.left == v){
				if(v.left!=null){ 
					v.left.parent = v.parent;
					v.parent.left = v.left;
//					System.out.println("Left Left The parent's child is " + temp.left.key);
//					System.out.println("The parent's child's par is " + temp.left.parent.key);
				}
				else{
					v.right.parent = v.parent;
					v.parent.left = v.right;
//					System.out.println("Left Right The parent's child is " + temp.left.key);
//					System.out.println("The parent's child's par is " + temp.left.parent.key);
				}
			}
			else if(v.parent.right == v){
				if(v.left!=null){
					v.left.parent = v.parent;
					v.parent.right = v.left;
//					System.out.println("Right Left The parent's child is " + temp.right.key);
//					System.out.println("The parent's child's par is " + temp.right.parent.key);
				}
				else{
					v.right.parent = v.parent;
					v.parent.right = v.right;
//					System.out.println("Right Right The parent's child is " + temp.right.key);
//					System.out.println("The parent's child's par is " + temp.right.parent.key);
				}
			}
			
		}
	
		return v;
		
	}
}
