package com.billkalin.leetcode;

public class LeetCode33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int search(int[] nums, int target) {
	   if (null == nums)
	       return -1;
	   int low = 0, high = nums.length-1, mid;
	   while(low <= high) {
		   mid = low + (high - low)/2;
		   if(nums[mid] == target)
			   return mid;
		   else if(nums[mid] > nums[high]) {
			   if(nums[low] <= target && target < nums[mid]) {
				   high = mid - 1;
			   } else {
				   low = mid + 1;
			   }
		   } else {
			   if(nums[mid] < target && target <= nums[high]) {
				   low = mid + 1;
			   } else {
				   high = mid - 1;
			   }
		   }
	   }
	   return -1;
	 }
}
