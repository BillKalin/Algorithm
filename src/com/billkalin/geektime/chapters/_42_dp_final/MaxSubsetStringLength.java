package com.billkalin.geektime.chapters._42_dp_final;

public class MaxSubsetStringLength {
    public static void main(String[] args) {
        char[] a = "abc782".toCharArray();
        char[] b = "acb821".toCharArray();
        MaxSubsetStringLength instance = new MaxSubsetStringLength();
        int length = instance.maxSubStringLength(a, b);
        System.out.println("最长公共子序列长度：" + length);
    }

    private int maxSubStringLength(char[] a, char[] b) {
        int m = a.length, n = b.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (a[0] == b[i]) {
                dp[0][i] = 1;
            } else if (i != 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            if (b[0] == a[i]) {
                dp[i][0] = 1;
            } else if (i != 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
