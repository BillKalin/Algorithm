package com.billkalin.leetcode;

public class LeetCode35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	   public int searchInsert(int[] nums, int target) {
	        if (null == nums || nums.length == 0)
	            return 0;
	        
	        // int ret = 0;
	        // for(int i=nums.length-1;i>=0;i--) {
	        //     if (nums[i] < target) {
	        //         break;
	        //     }
	        //      ret += 1;
	        // }
	        // return nums.length-ret;
	        int low = 0, high = nums.length-1, mid = 0;
	        while(low <= high) {
	            mid = (low+high)/2;
	            if (nums[mid] == target) {
	                return mid;
	            } else if(nums[mid] > target) {
	                high = mid-1;
	            } else {
	                low = mid+1;
	            }
	        }
	        return low;
	    }
}
