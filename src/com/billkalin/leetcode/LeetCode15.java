package com.billkalin.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public List<List<Integer>> threeSum(int[] nums) {
	        if(nums == null || nums.length < 3) {
	            return Collections.emptyList();
	        }
	        //先排序
	        Arrays.sort(nums);
	        int i=0;
	        int j=0;
	        int k = 0;
	        List<List<Integer>> res = new LinkedList<List<Integer>>();
	        //然后固定一个数字
	        for (i=0;i < nums.length-2;i++) {
	            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
	                j = i+1;
	                k = nums.length - 1;
	                while(j < k) {
	                    int sum = nums[i] + nums[j] + nums[k];
	                    if (sum == 0) {
	                        List<Integer> list =new LinkedList<Integer>();
	                        list.add(nums[i]);
	                        list.add(nums[j]);
	                        list.add(nums[k]);
	                        res.add(list);
	                        while(j < k && nums[j] == nums[j+1]) {
	                            j++;
	                        }

	                        while(j < k && nums[k] == nums[k-1]) {
	                            k--;
	                        }
	                        j++;
	                        k--;
	                    } else if (sum > 0) {
	                        k--;
	                    } else {
	                        j++;
	                    }
	                }
	            }
	        }
	        
	        return res;
	    }
}
