package com.billkalin.leetcode;

public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int j = 1; j < row; j++) {
            grid[j][0] += grid[j - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row - 1][col - 1];
    }
}
