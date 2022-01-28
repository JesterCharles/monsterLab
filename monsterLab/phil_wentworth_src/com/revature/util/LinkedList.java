package com.revature.util;

public class LinkedList<T> implements List<T> {
	private int size;
	private Node<T> head;
	private Node<T> tail;

	@Override
	public boolean add(T element) {
		if (element == null) {
			return false;
		}
		
		Node<T> newNode = new Node<>(element);
		if (head == null) {
			tail = head = newNode;
		}
		else {
			tail.nextNode = newNode;
			tail = newNode;
		}
		size++;
		return false;
	}

	@Override
	public boolean contains(T element) {
		Node<T> runner = head;
		while (runner != null) {
			if (runner.data.equals(element)) {
				return true;
			}
			
			runner = runner.nextNode;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(T element) {
		Node<T> runner = head;
		
		if (size==0) {
			return false;
		}
		
		if (size==1) {
			if (runner.data.equals(element)) {
				runner.data = null;
				head = null;
				tail = null;
				size = 0;
				return true;
			}
			return false;
		}
		
		// if element is the head
		// set the head to be element.nextNode
		if (head.data.equals(element)) {
			head = head.nextNode;
			return true;
		}
		
		for (int i=0; i<size; i++) {
			if (element.equals(runner.nextNode.data)) {
				if (i<size-1) { //if element is not the tail
					runner.data = runner.nextNode.data;
					runner.nextNode = runner.nextNode.nextNode;
					size--;
					return true;
				}
				//if element is the tail
				runner.nextNode = null;
				tail = runner;
				size--;
				return true;
			} 
			runner = runner.nextNode;
		}
		
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T get(int index) {
		if (index>=size || index<0) {
			throw new IndexOutOfBoundsException(index + " is out of bounds for this list");
		}
		
		Node<T> runner = head;
		
		for (int i=0; i<size; i++) {
			if (i == index) {
				return runner.data;
			}
			runner = runner.nextNode;
		}
		
		return null;
	}

	private static class Node<T> {
		T data;
		Node<T> nextNode;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
}
