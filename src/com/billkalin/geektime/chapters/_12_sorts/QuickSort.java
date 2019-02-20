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
		int i = sort.topKNumber(array, 7);
		System.out.println("i = " + i);
		sort.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private int topKNumber(int[] array, int k) {
		if(null == array || array.length == 0 || k > array.length)
			return -1;
		int start = 0;
		int end = array.length-1;
		int pation = 0;
		while(start <= end) {
			pation = patiation(array, start, end);
			if(pation + 1 == k) {
				return array[pation];
			} else if (pation + 1 > k) {
				end = pation-1;
			} else {
				start = pation+1;
			}
		}
		return -1;
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
		while (true) {
			while (i < j && array[i] < priot) {
				i++;
			}

			while (j>=0 && array[j] >= priot) {
				j--;
			}
			if (i >= j) {
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
