package com.billkalin.leetcode;

public class LeetCode34 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode34 instance = new LeetCode34();
		int[] nums = {8,8};
		int target = 8;
		int[] ret = instance.searchRange(nums, target);
		System.out.println(ret);
	}
	
	  public int[] searchRange(int[] nums, int target) {
		  int[] ret = new int[2];
		  ret[0] = -1;
		  ret[1] = -1;
		  if (null == nums || nums.length == 0)
			  return ret;
		  int start = findNum(nums, target, true);
		  if (start != -1) {
			  int end = findNum(nums, target, false);
			  if(end != -1) {
				  ret[0] = start;
				  ret[1] = end;
			  }
		  }
		  return ret;
	    }
	  
	  private int findNum(int[] nums, int target, boolean isStart) {
		  int low=0,high=nums.length-1, mid = 0;
		  while(low <= high) {
			  mid = (low + high)/2;
			  if (target == nums[mid]) {
				  if (isStart) {
					  if (mid == 0 || nums[mid-1] != target) {
						  return mid;
					  }
					  high = mid - 1;
				  } else {
					  if (mid == nums.length - 1 || nums[mid+1] != target) {
						  return mid;
					  }
					  low = mid + 1;
				  }
			  } else if (target > nums[mid]) {
				  low = mid + 1;
			  } else {
				  high = mid - 1;
			  }
		  }
		  return -1;
	  }
}
