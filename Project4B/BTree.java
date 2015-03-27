/**
 * @author Pong and Greg
 *
 *The following class is the Binary Tree that will be used in the ArithmeticApp method,
 *in order to construct an arithmetic tree.  This class contains general methods for Trees
 *such as getRoot, postOrder traversal, addRoot, getSize, displayNode and attach which attaches 
 *two trees together.
 *
 *It also has the instance variables and constructors for root, size (of lArith array), and an
 *lArith array which will be used to maintain the postOrder traversal values in order to be used
 *for the Calc method.
 */
public class BTree {
	private TNode root;			//initialize the root node
	public char[] lArith;		//initialize the lArith array
	public int size;			//initialize the size of lArith

	/**
	    * This is the constructor method for the BTree class including root, lArith array and size.
	    */
	public BTree(){
		root = null;
		lArith = new char[100];
		size = 0;
	}
	
	 /**
	    * The getRoot method gets the root and returns it, this will be used in the other classes.
	    * 
	    * @return:TNode which is the root of the tree
	    */
	public TNode getRoot(){
		return root;
	}
	
	 /**
	    * This is the postOrder traversal method which traverses the tree in
	    * the preOrder path and prints out each value it traverses.
	    * 
	    * @param: v
	    */
	public void postOrder(TNode v){
		if(v!=null){
			postOrder(v.left);
			postOrder(v.right);
			System.out.print(v.key + " "); 
			lArith[size]= v.key;
			size++;							//When this increments it should maintain size for lArith[]
		}
		
	}
	
	 /**
	    * The getlArith method gets the lArith array and returns it, 
	    * this will be used in the other classes.
	    * 
	    * String[] which is the array taht contains the postOrder traversals
	    */
	public char[] getlArith(){
		return lArith;
	}
	
	 /**
	    * The getSize method gets the size and returns it, this will be used in the other classes.
	    * 
	    * @return:int which is the size of the lArith array
	    */
	public int getSize(){
		return size;
	}
	
	 /**
	    * The addRoot method adds the node to a tree as a root node.
	    * 
	    * @param: v
	    */
	public void addRoot(char v){
		root = new TNode(v,null,null);
	}
	
	 /**
	    * The attach method attaches the three trees together with the p tree being the root 
	    * of the tree and the other two trees will expand on that.
	    * 
	    * @param: p
	    * @param: t1
	    * @param: t2
	    */
	public void attach(BTree p, BTree t1, BTree t2){
		root = p.root;
		root.left = t1.root;
		root.right = t2.root;
		System.out.println(root.key);
		System.out.println(root.right.key);
		System.out.println(root.left.key);
	}
}
	
