package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                 map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
         Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
	
	public int majorityElement2(int[] nums) {
		if (null == nums || nums.length == 0)
			return -1;
		int major = nums[0];
		int count = 0;
		for (int i=0;i<nums.length;i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (nums[i] == major) {
				count++;
			} else {
				count --;
			}
		}
		return major;
	}
}
