package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		findDuplicates(nums);
		
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
	    
	    public static List<Integer> findDuplicates(int[] nums) {
	        List<Integer> ret = new ArrayList<Integer>();
	        if(nums == null || nums.length == 1)
	            return ret;
	         int result = nums[0];
	         for(int i=1;i<nums.length;i++) {
	             result = (result ^ nums[i]);
	         }
	        
	        for(int i=0;i<nums.length;i++) {
	            if((result & nums[i]) == nums[i]) {
	                continue;
	            }
	           ret.add(nums[i]);
	         }
	         return ret;   
	    }
}
