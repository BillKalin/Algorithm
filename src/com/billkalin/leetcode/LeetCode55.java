package com.billkalin.leetcode;

public class LeetCode55 {

    //贪心算法
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxStep)//最大步数都无法到达该位置，肯定是不能到的
                return false;
            maxStep = Math.max(i + nums[i], maxStep);
        }
        return true;
    }

    //从后往前遍历
    public boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    //回溯法
    public boolean canJump3(int[] nums) {
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int position) {
        if (nums.length == position)
            return true;
        int furtherJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPos = 0; nextPos <= furtherJump; nextPos++) {
            if (canJump(nums, nextPos))
                return true;
        }
        return false;
    }

    //动态规划
    enum Index {
        Good, BAD, UNKNOWN
    }
    //动态规划
    public boolean canJump4(int[] nums) {
        Index[] dp = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Index.UNKNOWN;
        }
        dp[nums.length - 1] = Index.Good;
        for (int i = nums.length - 2; i >= 0; i++) {
            int further = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= further; j++) {
                if (dp[j] == Index.Good) {
                    dp[i] = Index.Good;
                    break;
                }
            }
        }

        return dp[0] == Index.Good;
    }
}
