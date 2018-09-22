package com.mousbah.algorithms.linkedlist;

public class App {

	public static void main(String[] args) {

		List<Integer> myLinkedList = new LinkedList<>();

		myLinkedList.insert(10);
		myLinkedList.insert(2);
		myLinkedList.insert(13);
		myLinkedList.insert(5);
		
		myLinkedList.traverseList();
		System.out.println("\n");
		myLinkedList.reverse();
		myLinkedList.traverseList();
	}
}
