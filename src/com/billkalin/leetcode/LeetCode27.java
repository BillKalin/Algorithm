package com.billkalin.leetcode;

public class LeetCode27 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int removeElement(int[] nums, int val) {
	        if (nums == null || nums.length == 0)
	            return 0;
	        int len = nums.length;
	        int j = 0;
	        for(int i=0;i<nums.length;i++) {
	            if(nums[i] == val) {
	                len -= 1;
	            }else {
	                nums[j] = nums[i];
	                j++;
	            }    
	        }
	        return len;
	    }
}
