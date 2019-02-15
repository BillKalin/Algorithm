package com.billkalin.geektime.chapters._09_queue;

/**
 * 循环队列
 * 关键在于怎么判断队满和队空
 * 1.队满：(tail+1)%length = head
 * 2.对空：head = tail
 * 
 */
public class CircleQueue<T> implements IQueue<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue<Integer> queue = new CircleQueue<>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.print();
		queue.dequeue();
		queue.enqueue(4);
		queue.print();
	}

	private T[] data;
	private int head, tail;
	private int capacity;
	
	public CircleQueue() {
		
	}
	
	public CircleQueue(int capacity) {
		this.capacity = capacity+1;
		data = (T[]) new Object[capacity+1];
	}
	
	@Override
	public boolean enqueue(T t) {
		// TODO Auto-generated method stub
		if ((tail+1)%capacity == head) {
			return false;
		}
		data[tail] = t;
		tail = (tail+1)%capacity;
		return true;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (head == tail)// 队列为空
			return null;
		T t = data[head];
		head = (head + 1)%capacity;
		return t;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(head == tail) {
			System.out.println("队列为空");
			return;
		}
		for(int i=head;i%capacity!=tail;i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

}
