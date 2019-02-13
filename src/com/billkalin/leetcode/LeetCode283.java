package com.billkalin.leetcode;

public class LeetCode283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void moveZeroes(int[] nums) {
		 int j = 0;
	        for (int i=0;i<nums.length;i++) {
	            if (nums[i] != 0) {
	                // swap(nums, i, j);
	                // j++;
	                nums[j++] = nums[i];
	            }
	        }
	        
	        for (;j<nums.length;j++) {
	            nums[j] = 0;
	        }
	    }
	    
	    private void swap(int[] nums, int i, int j) {
	        int temp = nums[j];
	        nums[j] = nums[i];
	        nums[i] = temp;
	    }
}
