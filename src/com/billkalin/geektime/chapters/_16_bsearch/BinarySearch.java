package com.billkalin.geektime.chapters._16_bsearch;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,6,1,2,3};
		int i = searchCircle(a, 4);
	}

	//查找第一个值等于给定值的元素
	private static int searchFirst(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		
		int low=0, high=a.length-1,mid;
		while(low <= high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] == k) {
				if(mid == 0 || a[mid-1] != a[mid])
					return mid;
				else {
					high = mid - 1;
				}
			} else if (a[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//查找最后一个值等于给定值的元素
	private static int searchLast(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		
		int low=0, high=a.length-1,mid;
		while(low <= high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] == k) {
				if(mid == a.length-1 || a[mid] != a[mid+1])
					return mid;
				else {
					low = mid + 1;
				}
			} else if(a[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//查找第一个大于等于给定值的元素
	private static int searchFirstAbove(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		int low=0, high=a.length-1,mid;
		while(low <= high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] >= k) {
				if(mid == 0 || a[mid-1] < k)
					return mid;
				else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	//查找最后一个小于等于给定值的元素
	private static int searchLastBelow(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		int low=0, high=a.length-1,mid;
		while(low <= high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] <= k) {
				if(mid == a.length-1 || a[mid+1] > k)
					return mid;
				else {
					low = mid + 1;
				}
			} else if(a[mid] > k) {
				high = mid - 1;
			} 
		}
		return -1;
	}
	
//	4，5，6，1，2，3。针对这种情况，如何实现一个求“值等于给定值”的二分查找算法呢？
	private static int searchCircle(int[] a, int k) {
		if(a == null || a.length == 0)
			return -1;
		int low=0, high=a.length-1,mid;
		while(low <= high) {
			mid = low + ((high - low)>>>1);
			if(a[mid] == k)
				return mid;
			else if (a[mid] > a[high]) {
				if(a[mid] > k && k >= a[low]) {//左半部分查找
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if(a[high] >= k && k > a[mid]) {//右半部分查找
					low = mid + 1;
				} else {
					high = mid -1;
				}
			}
		}
		return -1;
	}
}
