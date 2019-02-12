package com.billkalin.leetcode;

import java.util.Arrays;

public class LeetCode268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//XOR
	  public int missingNumber(int[] nums) {
	       if (null == nums || nums.length == 0)
	    	   return -1;
	       int ret = nums.length;
	       for (int i=0;i<nums.length;i++) {
	    	   ret ^= (i^nums[i]);
	       }
	       return ret;
	    }
	  
	  //sum
	  //0~n sum = n*(n-1)/2, missing = sum - realSum;
	  public int missingNumber2(int[] nums) {
	       if (null == nums || nums.length == 0)
	    	   return -1;
	       int realSum = 0;
	       int sum = nums.length * (nums.length -1)/2;
	       for (int s: nums) {
	    	   realSum += s;
	       }
	       return sum - realSum;
	    }
	  
	  //binary search
	  public int missingNumber3(int[] nums) {
	       if (null == nums || nums.length == 0)
	    	   return -1;
	       Arrays.sort(nums);
	       int left = 0, right = nums.length, mid = (left + right)/2;
	       while(left < right) {
	    	   mid = (left + right)/2;
	    	   if (nums[mid] > mid) {
	    		   right = mid;
	    	   } else {
	    		   left = mid + 1;
	    	   }
	       }
	       return left;
	    }
	  
}
