package com.billkalin.geektime.chapters._15_bsearch;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,4,1,3,7,6,9,0};
		int k = 6;
		int index = search(a, k);
		System.out.println("index = " + index);
		index = search2(a, k, 0, a.length-1);
		System.out.println("index = " + index);
		
		double s = sqrt(0.04, 0.00001);
		System.out.println("s = " + s);

	}

	//非递归
	private static int search(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		int low=0, high=a.length-1,mid=0;
		while(low<=high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] == k)
				return mid;
			else if(a[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//递归
	private static int search2(int[] a, int k, int low, int high) {
		if(a == null || a.length == 0)
			return -1;
		if(low > high)
			return -1;
		int mid = low + ((high - low)>>>1);
		if(a[mid] == k) {
			return mid;
		} else if (a[mid] > k) {
			return search2(a, k, low, mid-1);
		} else {
			return search2(a, k, mid+1, high);
		}
	}
	
	private static double sqrt(double num, double pre) {
		if(num < 0)
			return Double.NaN;
		double low = 1;
		double high = num;
		double mid;
		double temp;
		if (num>1){
	        low = 1;
	        high = num;
	    }else{
	        low = num;
	        high = 1;
	    }
		while(low <= high) {
			mid = low + (high - low)/2.00;
			temp = mid * mid;
			if(temp - num <= pre && temp - num >= pre*-1) {
				return mid;
			} else if (temp>num) {
				high = mid;
			} else {
				low = mid;
			}
		}
		
		return -1;
	}
}
