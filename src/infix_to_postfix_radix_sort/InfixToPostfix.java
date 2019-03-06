package infix_to_postfix_radix_sort;

import java.util.ArrayDeque;
import java.util.HashMap;

public class InfixToPostfix {	

	private HashMap<Character, Integer> operatorMap = new HashMap<>();
	
	private StringBuilder postfixSb;
	private StringBuilder numberMakerSb;
	
	private ArrayDeque<Character> stack;
	private ArrayDeque<Integer> integerStack;
	
	public InfixToPostfix() {	
		operatorMap.put('+', 1);
		operatorMap.put('-', 1);
		operatorMap.put('*', 2);
		operatorMap.put('/', 2);
		operatorMap.put('^', 3);	
	}
	
	public String convert(String input) {	
		//Initialize
		postfixSb = new StringBuilder();
		numberMakerSb = new StringBuilder();		
		stack = new ArrayDeque<Character>();		
		
		//Preprocessing
		for(int i=0; i<input.length(); i++) {
			//Check if it is digit and there are more digits for the number
			if(isDigit(input.charAt(i))) {			
				numberMakerSb.append(input.charAt(i));
				if(i+1 < input.length() && isDigit(input.charAt(i+1))) {
					continue;
				}
				postfixSb.append(numberMakerSb.toString()+" ");		
				numberMakerSb = new StringBuilder();
			}
			
			/* OLD ->
			//Add to postfix if it is not an operator or bracket
			else if(!isOperator(input.charAt(i)) && !isOpeningBracket(input.charAt(i)) && !isEndingBracket(input.charAt(i)) && input.charAt(i) != ' ') {
				postfixSb.append(input.charAt(i)+" ");
			}
			*/
			
			//Check if it is an operator
			else if(isOperator(input.charAt(i))) {
				//check if stack is not null
				//check if last stack element is not an opening bracket
				//check operators level
				//check if operator is left associative
				while(stack.peekLast() != null && !isOpeningBracket(stack.peekLast()) && (operatorMap.get(input.charAt(i)) <= operatorMap.get(stack.peekLast())) && operatorMap.get(input.charAt(i)) < 3) {
					postfixSb.append(stack.removeLast()+" ");
				}
				//Push operator to stack
				stack.addLast(input.charAt(i));
			}
			
			//Check if it is an opening bracket
			else if(isOpeningBracket(input.charAt(i))) {
				stack.addLast(input.charAt(i));
			}
			
			//Check if there is an ending bracket
			else if(isEndingBracket(input.charAt(i))) {				
				while(!stack.isEmpty() && !isOpeningBracket(stack.peekLast())) {					
					postfixSb.append(stack.removeLast()+" ");
				}
				if(stack.isEmpty()) {
					return "Parantezele nu sunt inchise!";
				}
				else {
					//Pop from stack
					stack.removeLast();
				}
			}			
		}	
		
		//Postprocessing
		while(stack.peekLast() != null) {
			if(isOpeningBracket(stack.peekLast()) || isEndingBracket(stack.peekLast())) {
				return "Parantezele nu sunt inchise!";
			}
			postfixSb.append(stack.removeLast()+" ");
		}
		
		if(postfixSb.charAt(postfixSb.length() - 1) == ' ') {
			postfixSb.deleteCharAt(postfixSb.length() - 1);
		}
		//
		return postfixSb.toString();
	}
	
	//
	
	public int evaluatePostfix(String input) {
		//Initialize
		integerStack = new ArrayDeque<Integer>();	
		numberMakerSb = new StringBuilder();	
		int integerNumber;
		int firstPoppedNumber;
		int secondPoppedNumber;
		//
		for(int i=0; i<input.length(); i++) {
			//Negative number check
			if(input.charAt(i) == '-' && i+1 < input.length() && isDigit(input.charAt(i+1))) {
				numberMakerSb.append(input.charAt(i));
				continue;
			}
			//Check if it is a number
			if(isDigit(input.charAt(i))) {			
				numberMakerSb.append(input.charAt(i));
				if(i+1 < input.length() && isDigit(input.charAt(i+1))) {
					continue;
				}
				integerNumber =	Integer.parseInt(numberMakerSb.toString());
				//Push number to stack
				integerStack.addLast(integerNumber);
				//Create an empty string builder
				numberMakerSb = new StringBuilder();
			}
			//Check if it is an operator
			else if(isOperator(input.charAt(i))) {
				firstPoppedNumber = integerStack.removeLast();
				//Return error if integer stack is empty
				if(integerStack.isEmpty()) {
					System.out.println("Incorrect Input! ");
					return -1;
				}				
				secondPoppedNumber = integerStack.removeLast();
				//Operate and push to stack
				integerStack.addLast(operate(firstPoppedNumber, secondPoppedNumber, input.charAt(i)));
			}
		}
		//
		int total = integerStack.removeLast();
		if(integerStack.isEmpty()) {
			return total;
		}
		else {
			System.out.println("Incorrect input!");
			return -1;
		}
	}
	
	public boolean isDigit(char input) {
		return Character.isDigit(input);
	}
	
	private int operate(int firstNumber, int secondNumber, char operator) {
		switch(operator) {
		case '-':	return secondNumber - firstNumber;
		case '+':	return secondNumber + firstNumber;
		case '/':	return secondNumber / firstNumber;
		case '*':	return secondNumber * firstNumber;
		case '^':	return (int) Math.pow(secondNumber, firstNumber);
		}
		return -1;
	}
	
	private boolean isOperator(char chr) {
		if(operatorMap.get(chr) != null) {
			return true;
		}
		return false;
	}	
	
	private boolean isOpeningBracket(char chr) {
		if(chr == '(') {
			return true;
		}
		return false;
	}
	
	private boolean isEndingBracket(char chr) {
		if(chr == ')') {
			return true;
		}
		return false;
	}
	
}
