package com.billkalin.geektime.chapters._12_sorts;

import java.util.Arrays;

/**
 *
 * 归并排序
 * 时间复杂度：o(nlogn) 空间复杂度 o(n) 稳定排序算法
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,5,7,8,9,0};
		System.out.println(Arrays.toString(array));
		MergeSort sorts = new MergeSort();
		sorts.merge(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 归并排序
	 * @param array
	 * @param start
	 * @param end
	 */
	private void merge(int[] array, int start, int end) {
		if(null == array)
			return;
		if(start >= end)// 递归终止条件
			return;
		int mid = start + (end - start)/2;// 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
		// 分治递归
		merge(array, start, mid);
		merge(array, mid+1, end);
		merge(array, start, mid, end);
	}
	
	private void merge(int[] array, int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int k = 0;
		int[] temp = new int[end - start + 1];
		while(i<=mid && j<= end) {
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		
		 // 判断哪个子数组中有剩余的数据
		int s = i;
		int e = mid;
		if(j <= end) {
			s = j;
			e = end;
		}
		
		// 将剩余的数据拷贝到临时数组tmp
		while(s <= e) {
			temp[k++] = array[s++];
		}
		
		// 将tmp中的数组拷贝回a[start...end]
		for(i=0;i<temp.length;i++) {
			array[start+i] = temp[i];
		}
	}
}
