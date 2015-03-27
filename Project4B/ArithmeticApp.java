import java.util.Scanner;

/**
 * @author Pong and Greg
 *
 * Input: (((3+1)*3)/((9-5)+2))-(((3*(7-4))+6))
 *_______________________________________________________________________________
 * PostOrder Traversal of Figure 8.6:  3 3 1 + * 2 9 5 - + / 3 7 4 - * 6 + - END|
 * ______________________________________________________________________________
 *
 *This class is the main app for Part B and Part C of the project
 *It will input a string of arithmetic expression and convert it into a character array
 *Note that the expression should not have any spaces and should be fully parenthesized.
 *
 *The methods in this class include the main() and the buildExpression which builds the
 *arithmetic tree.
 *
 */

public class ArithmeticApp {
	private char[] a = {'0','1','2','3','4','5','6','7','8','9','+','-','/','*'};
	private char[] list = new char[100];
	private Stack nStack = new Stack();
	BTree op1 = null;
	
	 /**
	    * This method will input the arithmetic string and build an arithmetic tree out of the input.
	    * 
	    * @param: s
	    * @return: BTree which is the final arithmetic tree
	    */
	public BTree buildExpression(String s){ //converting a string of arithmetic expression to an arithmetic binary tree
		char c =' ';
		for (int i=0; i<s.length(); i++){	//loop goes though whole string to check 
			c = s.charAt(i);
			list[i] = c;
			//System.out.println(list[i]);
		}
		for (int j=0; j<s.length(); j++){
			for (int k=0; k<a.length; k++){
				if (list[j]==(a[k])){ 			//if the character is a number, has to check as a loop between all
				BTree newB = new BTree();
				newB.addRoot(list[j]);  	
				nStack.push(newB);
				}
			}
			if(list[j]==')'){					//if the character is a close parentheses 
				BTree t1 = nStack.pop(); 
				op1 = nStack.pop();
				BTree t2 = nStack.pop();					
				op1.attach(op1, t2, t1);  		
				nStack.push(op1);
			}				
		}
//		System.out.println("Size of stack is" + nStack.size());
		return op1;
	}	
	
	/**
	 * This is the main method which gets the user input through the scanner method and then uses
	 * buildexpression to convert it into a binary arithmetic tree.  Then it uses a postorder
	 * traversal in order to get the postfix expression of the infix input.
	 * 
	 * Finally it uses the Calc method to calculate the postfix expression.
	 * Note that this only works with single digit numbers as we are using characters
	 * 
	 * @param args
	 */
	
	public static void main(String[] args){		
//		String s = "(((3+1)*3)/((9-5)+2))-(((3*(7-4))+6))";
		Scanner p= new Scanner(System.in);
		Scanner t= new Scanner(System.in);
		System.out.println("If you'd like to quit, type \"quit\"\nOtherwise type \"go\"");
		String temp = t.nextLine();
		while (!temp.equals("quit") && !temp.equals("Quit")){
			System.out.println("Enter the infix calculation you'd like to perform,\nwith each entity separated by a space: ");
			String s = p.nextLine();
		
			ArithmeticApp newone = new ArithmeticApp();
			BTree ns = new BTree();
			ns= newone.buildExpression(s);

			TNode first = ns.getRoot();
			System.out.println("The root of the tree is" + first.key);
			System.out.println("PostOrder :");
			ns.postOrder(first);				
			
			char[] l = ns.getlArith();			
			int su = ns.getSize();
			
//			System.out.println("The l array contains");
//			for (int i=0; i<su; i++){			
//				System.out.print(l[i]+ " ");
//			}
			
			Calc lets = new Calc();
			System.out.println("\nThe sum is " + lets.checkCalc(l, su));		
			System.out.println("If you'd like to quit, type \"quit\"\nOtherwise type \"go\"");
			temp = t.nextLine();
		}
		System.out.println("You quit");	
	}
	
}
