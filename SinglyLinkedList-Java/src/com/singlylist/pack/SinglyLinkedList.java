package com.singlylist.pack;

public class SinglyLinkedList {
	private Node head = null;

	// Function to Append an element into the linkedlist
	public void append(int val) {
		Node lastNode = getLastNode();
		if (lastNode == null) {
			head = new Node(val);
		} else {
			lastNode.next = new Node(val);
		}
	}

	// Function to Remove the tail element from a linkedlist
	private Node deleteTailElement() {
		if (head == null) {
			return null;
		}
		Node tmpNode = head;
		Node prevNode = null;
		while (tmpNode.next != null) {
			prevNode = tmpNode;
			tmpNode = tmpNode.next;
		}
		prevNode.next = null;
		return tmpNode;
	}

	// Function to Remove all element in the linkedlist that is great than a target value
	public void deleteAllGreaterElements(int val) {
		if (head == null) {
			return;
		}

		Node current = head;
		Node prev = null;

	    while(current != null && current.num > val) {
	        head = current.next;
	        current = head;
	    }

	    while(current !=null) {
	        if(current.num > val) {
	            prev.next = current.next;
	        } else {
	            prev = current;
	        }
	        current = current.next;
	    }
	}

	// Get last node
	private Node getLastNode() {
		if (head == null) {
			return null;
		}
		Node tmpNode = head;
		while (tmpNode.next != null) {
			tmpNode = tmpNode.next;
		}
		return tmpNode;
	}

	// Print singly linked list
	public void print() {
		System.out.println("");
		if (head == null) {
			System.out.print("EMPTY");
			return;
		}
		Node tmpNode = head;
		while (tmpNode != null) {
			System.out.print(tmpNode.num + " -> ");
			tmpNode = tmpNode.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.print();
		myList.append(35);
		myList.append(33);
		myList.append(3);
		myList.append(50);
		myList.print();
		myList.deleteTailElement();
		myList.print();
		myList.deleteAllGreaterElements(33);
		myList.print();
	}
}
