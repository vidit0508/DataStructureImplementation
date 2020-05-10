package com.stack.impl;

import java.util.Arrays;

/**
 * 
 * @author viditsharma01 This class implements stacks by using arrays
 */

public class StackArrayImpl {

	static int MAX = 3;
	int[] arr = new int[MAX];
	int top;

	public StackArrayImpl() {
		top = -1;
	}

	// to check stack is empty or not -- start

	public boolean isEmpty() {
		if (top < 0)
			return true;
		return false;
	}

	// to check stack is empty or not -- end

	// to add element -- start

	public boolean push(int data) {

		// check size
		if (top >= (MAX - 1)) {
			// place can be used to expand stack
			MAX = 2 * MAX;
			int[] tempArr = new int[MAX];
			tempArr = Arrays.copyOf(arr, MAX);
			arr = new int[MAX];
			arr = tempArr;
		}

		arr[++top] = data;
		return true;
	}

	// to add element -- end

	// to remove and get element from stack -- start

	public int pop() {

		if (top < 0) {
			System.out.println("Stack is empty.");
			return -1;
		}

		return arr[top--];
	}

	// to remove and get element from stack -- end

	// peep or top only to get value -- start

	public int peek() {

		if (top < 0) {
			System.out.println("Stack is empty.");
			return -1;
		}

		return arr[top];
	}

	// peep or top only to get value -- end

	public static void main(String args[]) {
		StackArrayImpl s = new StackArrayImpl();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.peek() + " Peeked from stack");
	}
}
