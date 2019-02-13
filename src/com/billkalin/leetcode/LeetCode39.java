package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> retList = new ArrayList<List<Integer>>();
	        List<Integer> path = new ArrayList<Integer>();
	        Arrays.sort(candidates);
	        combinationSum2(candidates, target, 0, retList, path);
	        return retList;
	    }
	    
	    private void combinationSum2(int[] nums, int target, int index, List<List<Integer>> retList, List<Integer> path) {
	        if (target < 0) {
	            return;
	        }
	            
	        if (target == 0) {
	            retList.add(new ArrayList<Integer>(path));
	            return;
	        }
	        
	        for (int i=index;i<nums.length;i++) {
	            path.add(nums[i]);
	            combinationSum2(nums, target-nums[i], i,retList, path);
	            path.remove(path.size() - 1);
	        }
	    }
}
