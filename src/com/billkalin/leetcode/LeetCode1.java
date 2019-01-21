package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;
        int[] ret = new int[2];
        if(nums.length == 2) {
            if (target == nums[0]+nums[1]) {
                ret[0] = 0;
                ret[1] = 1;
                return ret;
            }
        }
        
        //solution1
        // for(int i=0;i<nums.length-1;i++) {
        //     for(int j=i+1;j<nums.length;j++) {
        //         if (nums[i]+nums[j] == target) {
        //             ret[0] = i;
        //             ret[1] = j;
        //             break;
        //         }
        //     }
        // }
        // solution2
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ret;
    }
}
