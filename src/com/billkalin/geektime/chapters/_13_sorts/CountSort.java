package com.billkalin.geektime.chapters._13_sorts;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,5,3,0,2,3,0,3};
		System.out.println(Arrays.toString(array));
		array = countSort(array, array.length);
		System.out.println(Arrays.toString(array));
		
		char[] ch = {'1', 'a', 'D', 'c', 'z', '3', 'B', 'A', '2'};
		System.out.println(Arrays.toString(ch));
		test(ch);
		System.out.println(Arrays.toString(ch));
	}

	//计数排序
	public static int[] countSort(int[] array, int n) {
		if(array == null || array.length == 0)
			return array;
		int max = Integer.MIN_VALUE;
		//查找最大值
		for(int i=0;i<n;i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		//初始化计数数组
		int[] countArray = new int[max+1];
		for(int i=0;i<=max;i++) {
			countArray[i] = 0;
		}
		
		//对应的数字计数
		for(int i=0;i<n;i++) {
			countArray[array[i]]++;
		}
		
		//依次累加，得到最后的数组索引
		for(int i=1;i<=max;i++) {
			countArray[i] = countArray[i-1]+countArray[i];
		}
		
		//从后往前遍历计数数组，放到排序后的临时数组
		int[] r = new int[n];
		for(int i=n-1;i>=0;i--) {
			int index = countArray[array[i]]-1;
			r[index] = array[i];
			countArray[array[i]]--;
		}
		
		//复制到原来数组中
		for(int i=0;i<n;i++) {
			array[i] = r[i];
		}
		
		return array;
	}
	
	private static void test(char[] ch) {
		if(ch == null || ch.length == 0)
			return;
		
		int[] count = new int[]{0, 0, 0};//1，小写字母，2，数字，3，大写字母
		for(char c: ch) {
			 if (c>=97 && c<=122) {
				 	count[0]++;
	            }else if (c>=65 && c<=90) {
	            	count[2]++;
	            }else{
	            	count[1]++;
	            }
		}
		
		for(int i=1;i<3;i++) {
			count[i] += count[i-1];
		}
		
		int n = ch.length;
		char[] r = new char[n];
		
		for(int i=n-1;i>=0;i--) {
			char c = ch[i];
			int index = 0;
			if (c>=97 && c<=122) {
			 	index = --count[0];
            }else if (c>=65 && c<=90) {
            	index = --count[2];
            }else{
            	index = --count[1];
            }
			r[index] = c;
		}
		
		for(int i=0;i<n;i++) {
			ch[i] = r[i];
		}
	}
}
