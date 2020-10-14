package com.billkalin.leetcode;

public class LeetCode52 {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] ds1 = new boolean[2 * n];// 主对角线
        boolean[] ds2 = new boolean[2 * n];// 副对角线
        return totalNQueens(n, 0, cols, ds1, ds2);
    }

    //https://leetcode.wang/leetCode-52-N-QueensII.html
    public int totalNQueens(int n, int row, boolean[] cols, boolean[] ds1, boolean[] ds2) {
        if (row == n) {
            count++;
        }
        for (int col = 0; col < n; col++) {
            int d1 = col - row + n;
            int d2 = col + row;
            if (cols[col] || ds1[d1] || ds2[d2]) continue;
            cols[col] = true;
            ds1[d1] = true;
            ds2[d2] = true;
            totalNQueens(n, row + 1, cols, ds1, ds2);
            cols[col] = false;
            ds1[d1] = false;
            ds2[d2] = false;
        }
        return count;
    }
}
