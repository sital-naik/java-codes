package com.learning.collection;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	
	class Node{
		private T value;
		private Node next;
		
		Node(T value){
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}
		
	}
	
	private Node head;
	private int size;
	
	public LinkedList(){
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void add(T value) {
		Node new_node = new Node(value);
		size++;
		if(head == null) {
			head = new_node;
			return;
		}
		Node curr;
		for(curr=head; curr.next != null; curr = curr.next) {
		}
		curr.next = new_node;
	}
	
	public void remove(T value) {
		if(head.value.equals(value)) {
			head = head.next;
			size--;
			return;
		}
		Node curr;
		for(curr=head; curr.next != null; curr = curr.next) {
			if(curr.next.value.equals(value)) {
				curr.next = curr.next.next;
				size--;
				return;
			}
		}
	}
	
	public Node getfirst() {
		return head;
	}
	
	public boolean contains(T value) {
		Node curr;
		for(curr=head; curr.next != null; curr = curr.next) {
			if(curr.value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private Node curr = head;

			@Override
			public boolean hasNext() {
				return curr != null;
			}

			@Override
			public T next() {
				T val = curr.value;
				curr = curr.next;
				return val;
			}
		};
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node curr=head; curr != null; curr = curr.next) {
			sb.append(curr.value).append(" --> ");
		}
		sb.append("null");
		return sb.toString();
	}

}
