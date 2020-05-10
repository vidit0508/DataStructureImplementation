package com.stack.impl;

import java.util.Stack;

import com.stack.impl.StackLListImpl.StackNode;

public class StackReversal {

	/* Link list node */
	static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node head = null;

	static void push(int data) {
		// create new node
		Node newNode = new Node(data);

		// check size
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			head = newNode;
			head.next = temp;
		}
	}

	// to reverse linked list -- start
	static Node reverseList(Node head) {
		// Stack to store elements of list
		Stack<Node> stk = new Stack<Node>();

		// Push the elements of list to stack
		Node ptr = head;
		while (ptr.next != null) {
			stk.push(ptr);
			ptr = ptr.next;
		}

		// Pop from stack and replace
		// current nodes value'
		head = ptr;
		while (!stk.isEmpty()) {
			ptr.next = stk.peek();
			ptr = ptr.next;
			stk.pop();
		}
		ptr.next = null;

		return head;
	}

	// to reverse linked list -- start

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		// Node head = null;

		/*
		 * Use push() to construct below list 1->2->3->4->5
		 */
		push(5);
		push(4);
		push(3);
		push(2);
		push(1);

		printList(head);
		System.out.println();

		head = reverseList(head);

		printList(head);
	}
}
