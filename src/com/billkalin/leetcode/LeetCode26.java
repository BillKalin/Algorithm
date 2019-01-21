package com.billkalin.leetcode;

public class LeetCode26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public int removeDuplicates(int[] nums) {
	        if (nums == null || nums.length == 0)
	            return 0;
	        if (nums.length == 1) {
	            return 1;
	        }
	        int j=0;
	        for (int i=1;i<nums.length;i++) {
	            if(nums[j] != nums[i]) {
	                j++;
	                nums[j] = nums[i];
	            }
	        }
	        return j+1;
	    }
}
