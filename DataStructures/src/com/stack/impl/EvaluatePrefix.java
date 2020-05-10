package com.stack.impl;

import java.util.Stack;

public class EvaluatePrefix {

	// method to check if it is operand
	public boolean isOperand(Character ch) {

		if (ch >= 48 && ch <= 57)
			return true;
		else
			return false;
	}

	// method to evaluate prefix format
	public int evaluatePrefix(String in) {

		// check for null
		if (in == null)
			return 0;

		// create stack of integers
		Stack<Integer> operands = new Stack<Integer>();

		// reverse loop through the string
		for (int i = in.length() - 1; i >= 0; i--) {

			Character ch = in.charAt(i);

			// check if it digit then add to stack
			if (isOperand(ch)) {
				operands.push(ch - '0');
			} else {
				// it is operator then perform

				// else it opertor
				int val1 = operands.pop();
				int val2 = operands.pop();

				switch (ch) {

				case '+':
					operands.push(val1 + val2);
					break;

				case '-':
					operands.push(val1 - val2);
					break;

				case '*':
					operands.push(val1 * val2);
					break;

				case '/':
					operands.push(val1 / val2);
					break;

				}
			}

		}

		return operands.pop();
	}

	public static void main(String[] args) {

		EvaluatePrefix evaluatePrefix = new EvaluatePrefix();
		String exprsn = "+9*26";
		System.out.println(evaluatePrefix.evaluatePrefix(exprsn));

	}

}
