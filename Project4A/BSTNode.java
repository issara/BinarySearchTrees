
/** 
 * @author Pong and Greg
 * 
 * Class definition for a Node of a doubly linked list of Strings for the BST class
 */
public class BSTNode {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public int key;				//the entry
	public BSTNode parent;		//refers to the parent of the node
	public BSTNode left;		//refers to the left node in the tree
	public BSTNode right;		//refers to the right node in the tree

	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public BSTNode(int k, BSTNode l, BSTNode r, BSTNode p) {	
		key = k;								
		parent = p;
		left = l;
		right = r;
	}
	
	/** 
	 * This method displays the entry key of the node
	 * @param: v
	 */
	public void displayNode(BSTNode v){
		System.out.println(v.key);
		System.out.print("Parent is" + v.parent.key);
	}
}
