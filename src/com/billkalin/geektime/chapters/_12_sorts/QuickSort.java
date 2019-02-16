package com.billkalin.geektime.chapters._12_sorts;

import java.util.Arrays;

/**
 * 
 * 快速排序 时间复杂度：o(nlogn) 空间复杂度：o(1) 不稳定
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 3, 2, 1, 8, 5, 4, 2 };
		System.out.println(Arrays.toString(array));
		QuickSort sort = new QuickSort();
		sort.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private void quickSort(int[] array, int start, int end) {
		if (null == array || array.length <= 1)
			return;
		if (start >= end)
			return;
		int q = patiation(array, start, end);
		quickSort(array, start, q - 1);
		quickSort(array, q + 1, end);
	}

	private int patiation(int[] array, int start, int end) {
		int priot = array[end];
		int i = start;
		int j = end;
		while (i <= j) {
			while (i < j && array[i] < priot) {
				i++;
			}

			while (i < j && array[j] >= priot) {
				j--;
			}
			if (i == j) {
				break;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
//		for(int j=start;j<end;j++) {
//			if(array[j] < priot) {
//				if(i != j) {
//					int temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//				}
//				i++;
//			}
//		}
//		
//		int temp = array[i];
//		array[i] = array[end];
//		array[end] = temp;
		array[end] = array[i];
		array[i] = priot;
		return i;
	}
}
