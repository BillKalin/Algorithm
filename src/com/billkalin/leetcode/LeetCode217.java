package com.billkalin.leetcode;

import java.util.Arrays;

public class LeetCode217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean containsDuplicate(int[] nums) {
	        if(null == nums || nums.length < 2) {
	            return false;
	        }
	        // Set<Integer> sets = new HashSet<Integer>();
	        // for (int i :nums)  {
	        //     if (sets.contains(i))
	        //         return true;
	        //     sets.add(i);
	        // }
	        
	        Arrays.sort(nums);
	        for (int i=0;i<nums.length-1;i++) {
	            if(nums[i] == nums[i+1])
	                return true;
	        }
	        return false;
	    }
}
