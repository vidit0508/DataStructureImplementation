package com.linked.list;

/**
 * 
 * @author viditsharma01 This class implements Linked List reversal methods
 */

public class ReversingLinkedList {

	static Node head;

	static class Node {

		int data;
		Node nextNode;

		public Node(int d) {
			data = d;
			nextNode = null;
		}
	}

	// reversing the linked list -- start

	public Node reverseLinkedList(Node node) {

		Node next = null;
		Node current = node;
		Node prev = null;

		while (current != null) {

			// assign next of current as head to next
			next = current.nextNode; // next - 15

			// assign previous value to next of current node
			current.nextNode = prev; // current.nextNode = null

			// assign current as previous
			prev = current; // prev = 85

			// assign next to current
			current = next; // current = 15

		}

		node = prev;

		return node;

	}

	// reversing the linked list -- end

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.nextNode;
		}
	}

	public void printListRecursively(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printListRecursively(node.nextNode);
		}
	}

	public void printReverseListRecursively(Node node) {

		if (node == null)
			return;

		printReverseListRecursively(node.nextNode);

		System.out.print(node.data + " ");

	}

	public static void main(String[] args) {
		ReversingLinkedList list = new ReversingLinkedList();
		list.head = new Node(85);
		list.head.nextNode = new Node(15);
		list.head.nextNode.nextNode = new Node(4);
		list.head.nextNode.nextNode.nextNode = new Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverseLinkedList(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
		System.out.println();
		System.out.println("print linked list recursively.");
		list.printListRecursively(head);

		System.out.println("print reversed linked list recursively.");
		list.printReverseListRecursively(head);
	}
}
