package com.billkalin.leetcode;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i] = new int[n];
        }
        int i = 1;
        int rStart = 0;
        int rEnd = n - 1;
        int cStart = 0;
        int cEnd = n - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int j = cStart; j <= rEnd; j++) {
                array[rStart][j] = i++;
            }
            rStart++;
            for (int j = rStart; j <= rEnd; j++) {
                array[j][cEnd] = i++;
            }
            cEnd--;

            for (int j = cEnd; j >= cStart; j--) {
                array[rEnd][j] = i++;
            }
            rEnd--;

            for (int j = rEnd; j >= rStart; j--) {
                array[j][cStart] = i++;
            }
            cStart++;
        }
        return array;
    }
}
