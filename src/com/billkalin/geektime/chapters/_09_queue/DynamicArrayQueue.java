package com.billkalin.geektime.chapters._09_queue;

/**
 * 动态顺序队列
 * 
 */
public class DynamicArrayQueue<T> implements IQueue<T> {

	private T[] data;
	private int head, tail;
	private int capacity;
	
	public DynamicArrayQueue() {
		this(10);
	}
	
	public DynamicArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	@Override
	public boolean enqueue(T t) {
		// TODO Auto-generated method stub
		if (tail == capacity) {
			if (head == 0)//队列已满
				return false;
			for(int i=head;i<tail;i++) {//如果队尾到达最后，则实现一次数据迁移
				data[i-head] = data[i];
			}
			head = 0;
			tail = tail - head;
		}
		data[tail] = t;
		tail ++;
		return true;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (head == tail)
			return null;
		T t = data[head];
		head ++;
		return t;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(head == tail) {
			System.out.println("队列已满");
			return;
		}
		for(int i=head;i<tail;i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.print();
	}

}
