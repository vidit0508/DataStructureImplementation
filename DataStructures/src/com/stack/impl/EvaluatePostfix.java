package com.stack.impl;

import java.util.Stack;

public class EvaluatePostfix {

	public int evaluatePostfix(String in) {

		// check for null
		if (null == in)
			return 0;

		// create stack evaluation
		Stack<Integer> operands = new Stack<Integer>();

		// loop through the strings
		for (int i = 0; i < in.length(); i++) {

			Character ch = in.charAt(i);

			// if digit then add to stack
			if (Character.isDigit(ch)) {
				operands.push(ch - '0');
			} else {
				// else it opertor
				int val1 = operands.pop();
				int val2 = operands.pop();

				// condition to check it is for which condition
				switch (ch) {

				case '+':
					operands.push(val2 + val1);
					break;

				case '-':
					operands.push(val2 - val1);
					break;

				case '*':
					operands.push(val2 * val1);
					break;

				case '/':
					operands.push(val2 / val1);
					break;

				}

			}

		}

		return operands.pop();
	}

	public static void main(String[] args) {

		EvaluatePostfix postfix = new EvaluatePostfix();
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + postfix.evaluatePostfix(exp));

	}

}
