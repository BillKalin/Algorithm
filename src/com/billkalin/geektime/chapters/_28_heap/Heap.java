package com.billkalin.geektime.chapters._28_heap;

import java.util.Arrays;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap();
		int[] array = {1,3,5,2,8,7,6};
		System.out.println(Arrays.toString(array));
		heap.heapSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private void heapSort(int[] array) {
		buildHeap(array, array.length);
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			heap(array, 0, i);
		}
	}

	private void buildHeap(int[] array, int n) {
		for (int i = n / 2; i >= 0; i--) {
			heap(array, i, n);
		}
	}

	private void heap(int[] array, int i, int n) {
		while (true) {
			int max = i;
			if (2 * i < n && array[2 * i] > array[max]) {
				max = 2 * i;
			}

			if (2 * i + 1 < n && array[2 * i + 1] > array[max]) {
				max = 2 * i + 1;
			}

			if (max == i) {
				break;
			}

			swap(array, i, max);
			i = max;
		}
	}
}
