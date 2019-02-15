package com.billkalin.geektime.chapters._08_stack;

public interface IStack<T> {
	T pop();
	void push(T t);
	T peek();
	void print();
	boolean isEmpty();
	boolean isFull();
	int size();
	int capacity();
	void clear();
}
