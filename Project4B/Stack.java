/** 
 * @author Pong and Greg
 * 
 * Class definition for a array based stack of BTrees.
 * The Stack class consists of arrays that will be used in the ArithmeticApp class.
 * It uses the LIFO method.
 */

public class Stack{ 

	private BTree[] bt;
	private int size;	
	
	/**
	 * Constructor: creates a head and sets it to null, also sets the starting size of the stack at 0 
	 */
	public Stack(){ //constructor	
		 bt = new BTree[100];
		 size= 0;		
	}
	
	/**
	 * Returns the size of the stack
	 * 
	 * @return int
	 */
	public int size(){	
		return size;
	}

	 /**
	    * Checks and returns true if the stack is empty
	    *
	    * @return boolean
	    */
	public boolean isEmpty() { 
		return size==0;	
	}
	
	 /**
	    * Returns the top value of the stack
	    *
	    * @return char
	    */
	public BTree peek(){
		return bt[size-1];
	}
	
	 /**
	    * Pushes the number into the stack in order to be used when the checker hits an operand
	    *
	    * @param s
	    */
	public void push(BTree s){
		bt[size]= s;
		size++;
	}
	
	 /**
	    * Pops the string when the checker hits and operand and runs one of the four operand methods
	    *
	    * @return String
	    */
	public BTree pop(){	
		if (isEmpty()) return null;	
		BTree top = bt[size-1];
		bt[size-1]=null;
		size--;
		return top;
	}

	

}
