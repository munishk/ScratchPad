import java.util.Stack;

public class InfixToPostfix {
	
	public static void main(String[] args) {
		String infix = "((2+4)*7)+3*(9-5)";
		String postfix = convertInfixToPostfix(infix);
		System.out.println("Direct infix evaluation:" + evaluateInfix(infix));
		System.out.println("Infix to postfix:" + postfix);
		System.out.println("Postfix evaluation:" + evaluatePostfix(postfix));
	}
	
	
	private static int evaluatePostfix(final String postfixStr) {
		Stack<Integer> operandStack = new Stack<Integer>();
		for(int i=0; i < postfixStr.length(); i++) {
			char c = postfixStr.charAt(i);
			switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
				evaluate(c, operandStack);
				break;

			default:
				operandStack.push(c - '0');
			}
		}
		return operandStack.pop();
	}
	
	private static int  evaluateInfix(final String infixStr) {
		Stack<Integer> operandStack = new Stack<Integer>();
		
		Stack<Character> operatorStack = new Stack<Character>();
		for(int i=0; i< infixStr.length();i++) {
			char c = infixStr.charAt(i);
			
			switch(c){
			case '+':
			case '-':
			case '*':
			case '/':insertOperator(c, operatorStack, operandStack); 
			         break;
			case '(': 
			          operatorStack.push(c);
			           break;
			case ')':   while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
				evaluate(operatorStack.pop(), operandStack);
			            }
			            operatorStack.pop();
			             break;
				     
				default:
					operandStack.push( c - '0');
			}

		}
		while(!operatorStack.isEmpty()) {
			evaluate(operatorStack.pop(), operandStack);
			
		}
		return operandStack.pop();
		
	}
	
	private static String convertInfixToPostfix(final String infixStr) {
		final StringBuilder postfix = new StringBuilder(infixStr.length());
		Stack<Character> operatorStack = new Stack<Character>();
		for(int i=0; i< infixStr.length();i++) {
			char c = infixStr.charAt(i);
			
			switch(c){
			case '+':
			case '-':
			case '*':
			case '/':insertOperator(c, operatorStack, postfix); 
			         break;
			case '(': 
			          operatorStack.push(c);
			           break;
			case ')':   while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
				           postfix.append(operatorStack.pop());
			            }
			            operatorStack.pop();
			             break;
				     
				default:
					postfix.append(c);
			}

		}
		while(!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
			
		}
		return postfix.toString();
		
	}
	
	private static void insertOperator(char operator, Stack<Character> operatorStack, StringBuilder postfix) {
		int currentPrecedence = getPrecedence(operator);
		while(!operatorStack.isEmpty() && currentPrecedence <= getPrecedence(operatorStack.peek())) {
			postfix.append(operatorStack.pop());
		}
		operatorStack.push(operator);
	}
	
	private static void insertOperator(char operator, Stack<Character> operatorStack, Stack<Integer> operandStack) {
		int currentPrecedence = getPrecedence(operator);
		while(!operatorStack.isEmpty() && currentPrecedence <= getPrecedence(operatorStack.peek())) {
			evaluate(operatorStack.pop(), operandStack);
		}
		operatorStack.push(operator);
	}
	
	private static void evaluate(char operator, Stack<Integer> operandStack) {
		int second = operandStack.pop();
		int first = operandStack.pop();
		 operandStack.push(compute(first, second, operator));

	}
	
	private static int compute(int first, int second, char operator) {
		switch (operator) {
		case '+':
			        return first + second;

		case '-':
	        return first - second;
		case '*':
	        return first * second;
		case '/':
	        return first / second;

		default:
			throw new IllegalArgumentException();
		}
	}
	
	private static void insertOpeningParen(char operator, Stack<Character> operatorStack, StringBuilder postfix) {
		int currentPrecedence = getPrecedence(operator);
		while(!operatorStack.isEmpty() && currentPrecedence <= getPrecedence(operatorStack.peek())) {
			postfix.append(operatorStack.pop());
		}
		operatorStack.push(operator);
	}
	
	private static int getPrecedence(final char operator) {
		switch (operator) {
		case '+':
		case '-': return 1;			

		case '*':
		case '/': return 2;
		
		case '(': return 0;

		default:
			throw new IllegalArgumentException();
		}
	}

}
