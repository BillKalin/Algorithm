package com.billkalin.geektime.chapters._09_queue;

/**
 * 链式队列
 * 
 *
 * @param <T>
 */
public class LinkQueue<T> implements IQueue<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<Integer> queue = new LinkQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.print();
		queue.dequeue();
		queue.print();
	}

//	private Node<T> node;
	private Node<T> head, tail;
	private int capacity;
	private int count;
	
	public LinkQueue() {
		this(10);	
	}
	
	public LinkQueue(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public boolean enqueue(T t) {
		// TODO Auto-generated method stub
//		if(count == capacity)
//			return false;
		Node<T> newNode = new Node<T>();
		newNode.data = t;
		
		if(tail == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
		return true;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(head == null)
			return null;
	
		T t = head.data;
		head = head.next;
		if(null == head) {
			tail = null;
		}
		count --;
		return t;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(head == null || head == tail) {
			System.out.println("队列为空");
			return;
		}
		Node<T> curr = head;
		while(curr != null) {
			System.out.print(curr.data + ",");
			curr = curr.next;
		}
		System.out.println();
	}

	private static class Node<T> {
		T data;
		Node<T> next;
	}
}
