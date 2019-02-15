package com.billkalin.geektime.chapters._09_queue;

public interface IQueue<T> {
	boolean enqueue(T t);
	T dequeue();
	void print();
}
