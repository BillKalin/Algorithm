package com.billkalin.leetcode;

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int num = matrix.length;
        int start = 0, end = num - 1;
        //先把上下对折
        while (start < end) {
            int[] tmp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmp;
            start++;
            end--;
        }
        //对角线对折
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    //自内而外交换
    public void rotate2(int[][] matrix) {
        int num = matrix.length;
        for (int x = 0, y = num - 1; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                int tmp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = tmp;
            }
        }
    }
}
