package com.billkalin.leetcode;

import java.util.Arrays;

public class LeetCode16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
           return -1;
       Arrays.sort(nums);
       int i=0, j=0, k=0;
       int ret = -1;
       for (i=0;i<nums.length-2;i++) {
           j = i+1;
           k = nums.length - 1;
           if (i == 0) {
                ret = nums[i] + nums[j] + nums[k];
           }
           while(j<k) {
               int sum = nums[i] + nums[j] + nums[k];
               if (sum == target) {
                   return target;
               } else if (sum > target) {
                   k--;
               } else {                   
                   j++;
               }
                 if (Math.abs((target - ret)) > Math.abs(sum - target)) {
                       ret = sum;
                   }
           }
           
       }
       return ret;
   }    
}
