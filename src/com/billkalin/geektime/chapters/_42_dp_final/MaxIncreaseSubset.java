package com.billkalin.geektime.chapters._42_dp_final;

import java.util.Arrays;

public class MaxIncreaseSubset {

    public static void main(String[] args) {
        int[] a = new int[]{2, 9, 3, 6, 5, 1, 7};
        MaxIncreaseSubset instance = new MaxIncreaseSubset();
        int maxLength = instance.maxIncreaseSubset(a, a.length);
        System.out.println(Arrays.toString(a) + " maxIncreaseSubsetLength = " + maxLength);
    }

    //一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？比如 2, 9, 3, 6, 5, 1, 7
    // 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
    private int maxIncreaseSubset(int[] a, int length) {
        int[] dp = new int[a.length];
//        dp[i] = Math.max(dp[0]....dp[i - 1])+1;
        for (int i = 0; i < a.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(dp[i], max);
        }

        return dp[length - 1];
    }
}
