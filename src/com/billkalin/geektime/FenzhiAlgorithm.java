package com.billkalin.geektime;

/**
 * 分治算法
 * @author Administrator
 *
 */
public class FenzhiAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenzhiAlgorithm instance = new FenzhiAlgorithm();
		int[] a = {1, 5, 6, 2,4,3};
		int num = instance.count(a, a.length);
		System.out.println(num);
	}

	private int num = 0;
	
	int count(int[] a, int n) {
		mergeSortCounting(a, 0, n-1);
		return num;
	}
	
	private void mergeSortCounting(int[] a, int start, int end) {
		if(start >= end)
			return;
		int mid = (start + end)/2;
		mergeSortCounting(a, start, mid);
		mergeSortCounting(a, mid+1, end);
		merge(a, start, mid, end);
	}
	
	private void merge(int[] a,int start, int mid, int end) {
		int i=start, j = mid+1, k = 0;
		int[] temp = new int[end - start + 1];
		while(i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++]; 
			} else {
				temp[k++] = a[j++];
				num += mid - i + 1;
			}
		}
		
		while(i <= mid) {
			temp[k++] = a[i++]; 
		}
		
		while(j <= end) {
			temp[k++] = a[j++]; 
		}
		
		for(i=0;i<end-start+1;i++) {
			a[start + i] = temp[i];
		}
	}
}
