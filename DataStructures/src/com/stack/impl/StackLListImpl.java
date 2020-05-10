package com.stack.impl;

/**
 * 
 * @author viditsharma01 This class implements stacks by using linked list
 */

public class StackLListImpl {

	StackNode root;

	static class StackNode {

		int data;
		StackNode next;

		public StackNode(int d) {
			data = d;
			next = null;
		}

	}

	// to check stack is empty or not -- start

	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	// to check stack is empty or not -- end

	// to add element -- end
	public void push(int data) {

		// create new node
		StackNode newNode = new StackNode(data);

		// check size
		if (root == null) {
			root = newNode;
		} else {
			StackNode temp = root;
			root = newNode;
			root.next = temp;
		}
		System.out.println(data + " pushed to stack");
	}

	// to add element -- end

	// to remove and get element from stack -- start

	public int pop() {

		int popped = Integer.MIN_VALUE;

		if (root == null) {
			System.out.println("Stack is empty.");
			return popped;
		} else {
			popped = root.data;
			root = root.next;
		}

		return popped;
	}

	// to remove and get element from stack -- start

	// peep or top only to get value -- start

	public int peek() {

		if (root == null) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}

		return root.data;
	}

	// peep or top only to get value -- end

	public static void main(String[] args) {

		StackLListImpl sll = new StackLListImpl();

		sll.push(10);
		sll.push(20);
		sll.push(30);

		System.out.println(sll.pop() + " popped from stack");

		System.out.println("Top element is " + sll.peek());

	}

}
