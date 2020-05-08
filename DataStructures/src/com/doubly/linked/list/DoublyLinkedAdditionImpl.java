package com.doubly.linked.list;

public class DoublyLinkedAdditionImpl {

	Node head;

	class Node {

		int data;
		Node prev;
		Node next;

		public Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	// adding node at the front -- start

	public void push(int data) {

		// create new node
		Node newNode = new Node(data);

		// make next of new node as head and previous as null
		newNode.next = head;
		newNode.prev = null;

		// if head is not null
		if (null != head) {
			head.prev = newNode;
		}

		head = newNode;

	}

	// adding node at front -- end

	// adding node after a given node -- start

	public void insertAfter(Node prevNode, int data) {

		// check if previous node is null or not
		if (null == prevNode) {
			System.out.println("The system can not find a node.");
			return;
		}

		// create new node
		Node newNode = new Node(data);

		// previous -- previous -- next -- previous of new -- new -- next of next
		// assign next of previous to next of new
		newNode.next = prevNode.next;

		// next of previous is new node now
		prevNode.next = newNode;

		// previous node new node is prevNode
		newNode.prev = prevNode;

		// if new node next is not null
		if (newNode.next != null) {
			// change previous of new node's next node as new node
			newNode.next.prev = newNode;
		}

	}

	// adding node after a given node -- end

	// adding node at end -- start

	public void append(int data) {

		// create new node
		Node newNode = new Node(data);

		// as it is going to be the last node so its next would be null
		newNode.next = null;

		// check if head is null
		if (head == null) {
			// assign new node to head
			newNode.prev = null;
			head = newNode;
			return;
		}

		// find last node
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;

		newNode.prev = temp;

	}

	// adding node at end -- end

	// adding node before a given node -- start

	public void insertBefore(Node nextNode, int data) {

		if (nextNode == null) {
			System.out.println("could not find a node.");
			return;
		}

		// creating a new node
		Node newNode = new Node(data);

		// scenario - nextNodeprev == newNodePrev -- newNodenext == nextNode -- next
		// assign new node of previous as previous of next node
		newNode.prev = nextNode.prev;

		// new node next is next node
		nextNode.prev = newNode;

		// next of new node is next node
		newNode.next = nextNode;

		// if new node's previous is not null
		if (newNode.prev != null) {
			// assign next of previous node's next as new node
			newNode.prev.next = newNode;
		}

	}

	// adding node before a given node -- start

	// This function prints contents of linked list starting from the given node
	public void printlist(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	public static void main(String[] args) {

		DoublyLinkedAdditionImpl dll = new DoublyLinkedAdditionImpl();

		dll.append(6);
		
		dll.push(7);
		
		dll.push(1);
		
		dll.append(4);
		
		dll.insertAfter(dll.head.next, 8);

		System.out.println("created doubly linked list.");
		dll.printlist(dll.head);

	}

}
