package com.linked.list;

import javax.sound.sampled.ReverbType;

public class LinkedListImplememtation {

	Node head;

	class Node {

		int data;
		Node nextNode;

		Node(int d) {
			data = d;
			nextNode = null;
		}
	}

	// for adding node at front -- start
	// O(1)

	public void push(int data) {

		// first create new node
		Node newNode = new Node(data);

		// then assign current head as next of newly created head
		newNode.nextNode = head;

		// then assign new head as newlyy created head
		head = newNode;
	}

	// for adding node at front -- end

	// for adding node after particular node -- start
	// O(1)
	public void insertAfter(Node prevNode, int data) {

		// first previous node should not be null
		if (null == prevNode) {
			System.out.println("The given previous node can not be find.");
			return;
		}

		// first create new node that needs to be created
		Node newNode = new Node(data);

		// first assign the next node of previous node as
		// next of newly created node
		newNode.nextNode = prevNode.nextNode;

		// assign newNode as next node of previous node
		prevNode.nextNode = newNode;

	}

	// for adding node after particular node -- end

	// for adding new node at end -- start
	// O(n)--> as number of iteration to find last node will take place
	public void append(int data) {

		Node newNode = new Node(data);

		// check if head is null
		// if yes then create new node and assign to it
		if (head == null) {
			head = new Node(data);
			return;
		}

		// new node is going to be the last node
		// so make its next as null
		newNode.nextNode = null;

		// if head is not null then look for last node
		// next node is null
		Node last = head;

		while (last.nextNode != null) {
			last = last.nextNode;
		}

		last.nextNode = newNode;

		return;

	}

	// for deleting node at any position -- start

	public void delete(int data) {

		// first assign the head node to temp
		Node temp = head, prev = null;

		// if head node itself contains the node
		if (temp != null && temp.data == data) {
			head = head.nextNode;
			return;
		}

		// keep searching for node whose data is equal
		// to the node that needs to be deleted
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.nextNode;
		}

		// if key is not present linked list then
		if (temp == null)
			return;

		// assign previous next node with temp next node
		prev.nextNode = temp.nextNode;

	}

	// for deleting node at any position -- end

	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.nextNode;
		}
	}
	
	public void printList(Node tnode) {
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.nextNode;
		}
	}

	// for adding new node at end -- end

	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedListImplememtation llist = new LinkedListImplememtation();

		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.nextNode, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();
		System.out.println();
		llist.delete(8);
		System.out.println("after successful deletion");
		llist.printList();
		System.out.println();
	}

}
