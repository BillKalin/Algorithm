package com.billkalin.geektime.chapters._11_sorts;

import java.util.Arrays;

/**
 * 
 * 基础排序算法：
 * 排序算法   时间复杂度(最好 最坏 平均)   空间复杂度 是否稳定
 * 冒泡		o(n) o(n*n) o(n*n)		o(1)	     是
 * 选择		o(n*n) o(n*n) o(n*n)	o(1)		 否
 * 插入		o(n) o(n*n) o(n*n)		o(1)		 是
 */
public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,1,2,6,4,9,7,5,8};
		System.out.println(Arrays.toString(array));
		Sorts sorts = new Sorts();
		sorts.shellSort(array);
		System.out.println(Arrays.toString(array));

	}

	/**
	 * 冒泡排序
	 * @param array
	 */
	private void bubbleDown(int[] array) {
		if(null == array || array.length <= 1)
			return;
		int size = array.length;
		for(int i=0;i<size;i++) {
			boolean flag = false;//是否有交换标志，如果没有交换，之后就不需要再比较了
			for(int j=0;j<size - i-1;j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param array
	 */
	private void insertSort(int[] array) {
		if(null == array || array.length <= 1)
			return;
		for(int i=1;i<array.length;i++) {
			int temp = array[i];
			int j = i-1;
			for(;j>=0;j--) {
				if(array[j] > temp) {
					array[j+1] = array[j];
				} else {
					break;
				}
			}
			array[j+1] = temp;
		}
	}
	
	/**
	 * 选择排序
	 * @param array
	 */
	private void selectSort(int[] array) {
		if(null == array || array.length <= 1)
			return;
		for(int i=0;i<array.length-1;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
	
	/**
	 * 希尔排序
	 * @param array
	 */
	private void shellSort(int[] array) {
		if(null == array || array.length <= 1)
			return;
		int gap = 1;
		while(gap <= array.length/3) {
			gap = gap * 3 + 1;
		}
		
		while(gap >= 1) {
			for(int i= gap; i<array.length;i++) {
				int temp = array[i];
				int j = i - gap;
				while(j>=0 && array[j] >= temp) {
					array[j+gap] = array[j];
					j = j - gap;
				}
				array[j+gap] = temp;
			}
			gap = (gap - 1)/3;
		}
	}
}
