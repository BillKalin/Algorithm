package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> retList = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        List<Integer> list = new ArrayList<>();
	        subsets(nums, retList, list, 0);
	        return retList;
	    }
	    
	    private void subsets(int[] nums, List<List<Integer>> retList, List<Integer> list, int start) {
	        retList.add(new ArrayList<>(list));
	        for(int i=start;i<nums.length;i++) {
	            list.add(nums[i]);
	            subsets(nums, retList, list, i+1);
	            list.remove(list.size() - 1);
	        }
	    }
}
