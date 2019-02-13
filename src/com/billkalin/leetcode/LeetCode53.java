package com.billkalin.leetcode;

public class LeetCode53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maxSubArray(int[] nums) {
	        if (null == nums || nums.length == 0)
	            return Integer.MIN_VALUE;
	        
	        // int curr = 0;
	        // int max = Integer.MIN_VALUE;
	        // for (int i=0;i<nums.length;i++) {
	        //     if (curr <= 0) {
	        //         curr = nums[i];
	        //     } else {
	        //         curr += nums[i];
	        //     }
	        //      max = Math.max(max, curr);
	        // }
	        
	        int max = nums[0];
	        int curr = max;
	        for (int i=1;i<nums.length;i++) {
	            curr = Math.max(curr+nums[i], nums[i]);
	            max = Math.max(curr, max);
	        }
	        
	        return max;
	    }
}
