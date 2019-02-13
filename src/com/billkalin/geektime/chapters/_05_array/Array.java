package com.billkalin.geektime.chapters._05_array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
	private static final int DEFAULT_COUNT = 10;
	private int[] data;
	private int n;
	private int count;
	
	public Array() {
		this(DEFAULT_COUNT);
	}
	
	public Array(int capacity) {
		data = new int[capacity];
		n = capacity;
		count = 0;
	}
	
	//查找
	public int find(int index) {
		if (index < 0 || index >= count)
			return -1;
		return data[index];
	}
	
	//插入
	public boolean insert(int index, int num) {
		//已满
		if (n == count)
			return false;
		//位置错误
		if (index < 0 || index > count) {
			return false;
		}
		
		for(int i = count;i> index;i--) {
			data[i] = data[i-1];
		}
		data[index] = num;
		count ++;
		return true;
	}
	
	
	//删除
	public boolean delete(int index) {
		if (index < 0 || index >= count)
			return false;
		
		for(int i=index+1;i<count;i++) {
			data[i-1] = data[i];
		}
		--count;
		return true;
	}
	
	 public void printAll() {
	        for (int i = 0; i < count; ++i) {
	            System.out.print(data[i] + " ");
	        }
	        System.out.println();
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array array = new Array(5);
	    array.printAll();
	    array.insert(0, 3);
	    array.insert(0, 4);
	    array.insert(1, 5);
	    array.insert(3, 9);
	    array.insert(3, 10);
	        //array.insert(3, 11);
	      array.printAll();
	}

}
