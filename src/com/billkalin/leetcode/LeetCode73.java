package com.billkalin.leetcode;

public class LeetCode73 {
    //Time: O(m*n), space:O(m+n)
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (matrix[i][j] == 0) {//记录为0的行和列
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //time:O(m*n), space:O(1)
    public void setZeroes2(int[][] matrix) {
        boolean isFirstCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstCol = true;//第一列是否为0
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {//当前行和列的第一个标记为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {//当前行和列的第一个为0，则该元素也为0
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {//如果第一个元素也为0，那么第一行全设置为0
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (isFirstCol) {//如果第一列为0，那么第一列所有都设置为0
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
