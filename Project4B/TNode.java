
/** 
 * @author Pong and Greg
 * 
 * Class definition for a TNode of a binary search tree 
 */
public class TNode {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public char key;	//the high score entry 
	public TNode left;		//refers to the left node in the tree
	public TNode right;		//refers to the right node in the tree

	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public TNode(char k, TNode l, TNode r) {	
		key = k;								
		left = l;
		right = r;
	}
	

	
	public void displayNode(TNode v){
		System.out.println(v.key);
	}
}
