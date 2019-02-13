package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean containsNearbyDuplicate(int[] nums, int k) {
	        if (null == nums || nums.length == 0)
	            return false;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i=0;i<nums.length;i++) {
	            if (map.containsKey(nums[i])) {
	                if (i - map.get(nums[i]) <= k) {
	                    return true;
	                }
	            } 
	            map.put(nums[i], i);
	        }
	        return false;
	    }
	 
	 public boolean containsNearbyDuplicate2(int[] nums, int k) {
	        if (null == nums || nums.length == 0)
	            return false;
	        Set<Integer> sets = new HashSet<Integer>();
	        for (int i=0;i<nums.length;i++) {
	           if (i > k) {
	        	   sets.remove(nums[i-k-1]);
	           }
	           if (!sets.add(nums[i])) {
	        	   return true;
	           }
	        }
	        return false;
	    }
}
