package com.billkalin.leetcode;

public class LeetCode136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int singleNumber(int[] nums) {
	        if(null == nums || nums.length == 0)
	        	return -1;
	        int ret = 0;
	        
	        for(int i=0;i<nums.length;i++) {
	        	ret ^= nums[i];
	        }
	        
	        return ret;
	    }
}
