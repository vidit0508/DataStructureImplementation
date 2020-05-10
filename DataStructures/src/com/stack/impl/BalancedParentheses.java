package com.stack.impl;

import java.util.Stack;

public class BalancedParentheses {

	/**
	 * 
	 * @param args method to check brackets (, {, [,], }, ) are balanced or not
	 */
	public boolean checkBalanceParentheses(String in) {

		// check for null
		if (in == null)
			return true;

		// create a stack of characters
		Stack<Character> stack = new Stack<Character>();

		// loop through string for parentheses
		for (int i = 0; i < in.length(); i++) {

			Character ch = in.charAt(i);

			// if it opening bracket then add to stack
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			// if it is closing bracket then check for removal
			else if (ch == ')' || ch == '}' || ch == ']') {

				// if stack is empty then it can never be balanced eg : ][
				if (stack.isEmpty())
					return false;

				// now check for match of opening and closing brackets
				if (!isMatchingPair(stack.pop(), ch))
					return false;

			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}

	public boolean isMatchingPair(Character ch1, Character ch2) {

		if (ch1 == '(' && ch2 == ')')
			return true;
		else if (ch1 == '{' && ch2 == '}')
			return true;
		else if (ch1 == '[' && ch2 == ']')
			return true;

		return false;
	}

	public static void main(String[] args) {

		BalancedParentheses balancedParentheses = new BalancedParentheses();

		System.out.println(balancedParentheses.checkBalanceParentheses("{()}[]"));

	}

}
