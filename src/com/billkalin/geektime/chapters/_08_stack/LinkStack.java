package com.billkalin.geektime.chapters._08_stack;

/**
 * 链式栈 - 基于链表
 * @author Administrator
 *
 * @param <T>
 */
public class LinkStack<T> implements IStack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStack<Integer> stack = new LinkStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.print();
		stack.pop();
		stack.print();
	}

	
	private Node<T> top;
	private int count;
	private int capacity;
	
	public LinkStack() {
		this(10);
	}
	
	public LinkStack(int capacity) {
		this.capacity = capacity;
		this.count = 0;
	}
	
	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}
	
	@Override
	public void push(T t) {
		if(isFull()) 
			return;
		Node<T> data = new Node<T>();
		data.data = t;
		
		data.next = top;
		top = data;
		
		count ++;
	}
	
	@Override
	public T pop() {
		if (isEmpty())
			return null;
		count --;
		T t = top.data;
		top = top.next;
		return t;
	}
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	@Override
	public boolean isFull() {
		return count == capacity;
	}
	
	@Override
	public void print() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		Node<T> data = top;
		while(data != null) {
			System.out.print(data.data + ",");
			data = data.next;
		}
		System.out.println();
	}
	
	private static class Node<T> {
		T data;
		Node<T> next;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public void clear() {
		top = null;
		count = 0;
	}
}
