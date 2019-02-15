package com.billkalin.geektime.chapters._09_queue;

/**
 * 顺序队列
 *
 * @param <T>
 */
public class ArrayQueue<T> implements IQueue<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.print();
		
		queue.dequeue();
		queue.dequeue();
		queue.print();
	}

	private T[] data;
	private int capacity;
	private int head, tail;
	
	public ArrayQueue() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	@Override
	public boolean enqueue(T t) {
		// TODO Auto-generated method stub
		if (tail == capacity)//队列已满
			return false;
		data[tail] = t;
		tail++;
		return true;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(head == tail)//队列是空的
			return null;
		T t = data[head];
		head ++;
		return t;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(head == tail) {
			System.out.println("队列为空!");
			return;
		}
		
		for(int i=head;i<tail;i++) {
			System.out.print(data[i] + ",");
		}
		
		System.out.println();
	}

}
