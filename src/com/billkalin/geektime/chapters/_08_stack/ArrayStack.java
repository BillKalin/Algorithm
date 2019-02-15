package com.billkalin.geektime.chapters._08_stack;

/**
 * 顺序栈  - 基于数组栈
 * 支持动态扩容
 * @author
 *
 */
public class ArrayStack<T> implements IStack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.print();
		int top = stack.peek();
		stack.pop();
		stack.print();
	}

	private T[] data;
	private int capacity;
	private int count;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (T[]) new Object[capacity];
		this.capacity = capacity;
		count = 0;
	}
	
	public ArrayStack() {
		this(10);
	}
	
	@Override
	public T peek() {
		if (isEmpty())
			return null;
		return data[count-1];
	}
	
	@Override
	public T pop() {
		if (isEmpty())
			return null;
		T t = data[count - 1];
		count --;
		if (count == capacity/4 && capacity/2 !=0) {
			resize(capacity/2);
		}
		return t;		
	}
	
	@Override
	public void push(T t) {
		if (isFull()) {
//			return;
			resize(count * 2);
		}
		data[count] = t;
		count ++;
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public boolean isFull() {
		return count == capacity;
	}
	
	@Override
	public void print() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		int size = count-1;
		while(size >= 0) {
			System.out.print(data[size--] + ",");
		}
		System.out.println();
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
		// TODO Auto-generated method stub
		data = (T[]) new Object[capacity];
		count = 0;
	}
	
	private void resize(int size) {
		capacity = size;
		T[] newData = (T[]) new Object[size];
		for(int i=0;i<size;i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}
