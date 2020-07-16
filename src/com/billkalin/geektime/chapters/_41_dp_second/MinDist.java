package com.billkalin.geektime.chapters._41_dp_second;

public class MinDist {

    public static void main(String[] args) {
        int[][] w = new int[][]{
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3},
        };
        MinDist minDist = new MinDist();
        minDist.minDist(w, 0, 0, w[0][0], 3, 3);
        System.out.println("min dist = " + minDist.getDist());
        int n = minDist.minDist(w, 4);
        System.out.println("min dist = " + n);
    }

    //回溯法
    private int mMinDist = Integer.MAX_VALUE;

    private void minDist(int[][] w, int i, int j, int dist, int m, int n) {
        if (i == m && j == n) {
            if (mMinDist > dist) {
                mMinDist = dist;
            }
            return;
        }

        if (i < m) {
            minDist(w, i + 1, j, dist + w[i + 1][j], m, n);
        }

        if (j < n) {
            minDist(w, i, j + 1, dist + w[i][j + 1], m, n);
        }

    }

    private int getDist() {
        return mMinDist;
    }

    //动态规划
    private int minDist(int[][] w, int n) {
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += w[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += w[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = w[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][n - 1];
    }
}
