package com.billkalin.geektime.chapters._05_array;

public class GenericArray<T> {
	private T[] data;
    private int size;
	
	public GenericArray(int capicity) {
		data = (T[]) new Object[capicity];
		size = 0;
	}
	
	public GenericArray() {
		this(10);
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean contains(T e) {
		for (T t : data) {
			if (t.equals(e))
				return true;
		}
		return false;
	}
	
	public int find(T e) {
		for (int i=0;i<data.length;i++) {
			if (data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	public void set(int index, T e) {
		checkIndex(index);
		data[index] = e;
	}
	
	public T get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	public void add(int index, T e) {
		checkIndex(index);
		//如果已满，则扩容到2倍大小
		if (size == data.length) {
			resize(data.length * 2);
		}
		
		for (int i=size-1;i>=index;i--) {
			data[i] = data[i-1];
		}
		data[index] = e;
		size++;
	}
	
	public void addFirst(T e) {
		add(0, e);
	}
	
	public void addLast(T e) {
		add(size, e);
	}
	
	public T remove(int index) {
		checkIndexForRemove(index);
		T ret = data[index];
		for (int i = index+1;i<size;i++) {
			data[i-1] = data[i];
		}
		size --;
		data[size] = null;
		
		//缩容
		if (size == data.length/4 && data.length/2 != 0) {
			resize(data.length/2);
		}
		
		return ret;
	}
	
	private void resize(int capacity) {
		T[] newData = (T[]) new Object[capacity];
		for(int i=0;i<size;i++) {
			newData[i] = data[i];
		}
		data = (T[]) newData;
	}
	
	public void checkIndex(int index) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
	}
	
	public void checkIndexForRemove(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
