package com.billkalin.leetcode;

public class LeetCode96 {

    //可以参考95题得到个数
    //动态规划
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int len = 2; len <= n; len++) {//计算各个长度的数量
            for (int i = 1; i <= len; i++) {
                //左子树 * 右子树的数量 得到第len个长度的树的数量
                dp[len] += dp[i - 1] * dp[len - i];
            }
        }
        return dp[n];
    }
}
