package com.billkalin.leetcode;

public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
