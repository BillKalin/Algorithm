package com.billkalin.geektime.chapters._06_linklist;

public class LruBasedArray<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LruBasedArray<Integer> lru = new LruBasedArray(3);
		lru.offer(1);
		lru.offer(2);
		lru.offer(3);
		lru.printAll();
		lru.offer(2);
	}

	private T[] data;
	private int capacity;
	private int size;
	
	public LruBasedArray(int capacity) {
		this.data = (T[]) new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	
	public void offer(T t) {
		int id = -1;
		for(int i=0;i<size;i++) {
			if (t.equals(data[i])) {
				id = i;
				break;
			}
		}
		
		if (id == -1) {
			if (isFull()) {
				moveRight(0);
				data[0] = t;
			} else {
				moveRight(0);
				data[0] = t;
				size++;
			}
		} else {
			delete(id);
			moveRight(0);
			data[0] = t;
		}
//		size ++;
	}
	
	public void delete(int index) {
		moveLeft(index);
		size --;
	}
	
	public void moveLeft(int index) {
		for(int i=index;i<size-1;i++) {
			data[i] = data[i+1];
		}
	}
	
	public void moveRight(int index) {
		for(int i=size-1;i>index;i--) {
			data[i] = data[i-1];
		}
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void printAll() {
		for(T t: data) {
			System.out.print(t+",");
		}
	}
}
