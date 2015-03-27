/** 
 * @author Pong and Greg
 * 
 * Class definition for an array based stack of characters.
 * The Stack class consists of arrays that will be used in the Calc class.
 * It uses the LIFO method.
 */

public class CStack{ 

	private char[] calcA;
	private int size;	
	
	/**
	 * Constructor: creates a head and sets it to null, also sets the starting size of the stack at 0 
	 */
	public CStack(){ //constructor	
		 calcA = new char[100];
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
	public char peek(){
		return calcA[size-1];
	}
	
	 /**
	    * Pushes the number into the stack in order to be used when the checker hits an operand
	    *
	    * @param s
	    */
	public void push(char s){
		calcA[size]= s;
		size++;
	}
	
	 /**
	    * Pops the string when the checker hits and operand and runs one of the four operand methods
	    *
	    * @return String
	    */
	public char pop(){	
		if (isEmpty()) return ' ';	
		char top = calcA[size-1];
		calcA[size-1]=' ';
		size--;
		return top;
		
	}

	

}
