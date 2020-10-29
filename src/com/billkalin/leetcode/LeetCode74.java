package com.billkalin.leetcode;

public class LeetCode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int start = 0, end = matrix.length - 1;
        int mid;
        //先定位所在行
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = end;
        //如果所在行的第一个元素比target大，那就在上一行
        if (start >= 0 && matrix[start][0] > target) {
            start -= 1;
        }

        //在指定行中进行查找
        if (start >= 0) {
            int row = start;
            start = 0;
            end = matrix[0].length - 1;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (matrix[row][mid] == target)
                    return true;
                else if (matrix[row][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            int value = matrix[mid / cols][mid % cols];
            if (value == target)
                return true;
            else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
