package com.billkalin.leetcode;

public class LeetCode62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int pathCount = uniquePaths(m, n);
        System.out.println(m + "x" + n + " = " + pathCount);
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    private static int[][] mem;

    public static int uniquePaths2(int m, int n) {
        mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }
        return uniquePathsMem(m - 1, n - 1, mem);
    }

    private static int uniquePathsMem(int m, int n, int[][] mem) {
        if (m == 0 || n == 0)
            return 1;
        if (mem[m - 1][n] == -1) {
            mem[m - 1][n] = uniquePathsMem(m - 1, n, mem);
        }
        if (mem[m][n - 1] == -1) {
            mem[m][n - 1] = uniquePathsMem(m, n - 1, mem);
        }
        return mem[m - 1][n] + mem[m][n - 1];
    }

    public static int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths4(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}
