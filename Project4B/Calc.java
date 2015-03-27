/**
 * @author Pong and Greg
 *
 *The Calc class is the main class of Part C which has the addIt, subtract, multiply, divide, splitter
 *and checkCalc methods.
 *
 *The class also contains the constructor and common methods for linked lists including size,
 *peek and isEmpty.
 */
public class Calc {
	CStack calcCStack = new CStack();
	
	 /**
	    * Runs the addition operand by popping the 2 top numbers out of the CStack
	    * and by pushing the final total after using the operand right into the CStack
	    */
	public void addIt(){
		double a = Character.getNumericValue(calcCStack.pop());
//		System.out.println("add" + a);
		double b = Character.getNumericValue(calcCStack.pop());
//		System.out.println("add" + b);
		double tot = a + b;
		String stot = String.valueOf(tot);
		char ctot= stot.charAt(0);					//this means it only works with single digits
//		System.out.println("addsum" + tot);
//		System.out.println("addsum char" + ctot);
		calcCStack.push(ctot);
		
	}
	

	 /**
	    * Runs the subtraction operand by popping the 2 top numbers out of the CStack
	    * and by pushing the final total after using the operand right into the CStack
	    */
	public void subtract(){
		double a= Character.getNumericValue(calcCStack.pop());
//		System.out.println("subtract" + a);
		double b= Character.getNumericValue(calcCStack.pop());
//		System.out.println("subtract" + b);
		double tot = a - b;
		String stot = String.valueOf(tot);
		char ctot= stot.charAt(0);	
//		System.out.println("subsum" + tot);
		calcCStack.push(ctot);
	}
	

	 /**
	    * Runs the multiplication operand by popping the 2 top numbers out of the CStack
	    * and by pushing the final total after using the operand right into the CStack
	    */
	public void multiply(){
		double a = Character.getNumericValue(calcCStack.pop());
//		System.out.println("mult" + a);
		double b = Character.getNumericValue(calcCStack.pop());
//		System.out.println("mult" + b);
		double tot = a * b;
		String stot = String.valueOf(tot);
		char ctot= stot.charAt(0);	
//		System.out.println("multsum" + tot);
		calcCStack.push(ctot);
	}
	

	 /**
	    * Runs the division operand by popping the 2 top numbers out of the CStack
	    * and by pushing the final total after using the operand right into the CStack
	    */
	public void divide(){
		double a = Character.getNumericValue(calcCStack.pop());
//		System.out.println("div" + a);
		double b = Character.getNumericValue(calcCStack.pop());
//		System.out.println("div" + b);
		double tot = b / a;	//had to switch b and a because when dividing in post fix the first number should be the divisor
		String stot = String.valueOf(tot);
		char ctot= stot.charAt(0);	
//		System.out.println("divsum" + tot);
		calcCStack.push(ctot);
	}
	
	 /**
	    * Goes through the array from the splitter method and figures out the different methods the program will have to run.
	    * 
	    * @param s
	    * @return char
	    */
	public char checkCalc(char[] s, int nu){
		for (int i=0; i<nu; i++){
			//System.out.println("around and around");
//			if(Character.isDigit(s.charAt(i))){
//				calcCStack.push(s.charAt(i));
//			}
			if (s[i]=='+'){
//				System.out.println("add");
				addIt();
			}
			else if (s[i]=='-'){
//				System.out.println("subtrac");
				subtract();
			}
			else if (s[i]=='*'){
//				System.out.println("multi");
				multiply();
			}
			else if (s[i]=='/'){
//				System.out.println("divid");
				divide();
			}
			else{
//				System.out.println("pushing" + s[i]);
				calcCStack.push(s[i]);
			}
		}
//		System.out.println("hey! look!");
//		System.out.println(calcCStack.peek());
		return calcCStack.pop();	
	}	
	
}



