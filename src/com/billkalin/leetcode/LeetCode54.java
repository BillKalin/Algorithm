package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return ret;
        int rStart = 0, rEnd = matrix.length - 1;
        int cStart = 0, cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            //从左到右
            for (int i = cStart; i <= cEnd; i++) {
                ret.add(matrix[rStart][i]);
            }
            rStart++;
            //从上到下
            for (int i = rStart; i <= rEnd; i++) {
                ret.add(matrix[i][cEnd]);
            }
            cEnd--;
            //从右到左
            if (rStart <= rEnd) {
                for (int i = cEnd; i >= cStart; i--) {
                    ret.add(matrix[rEnd][i]);
                }
            }
            rEnd--;
            //从下到上
            if (cStart <= cEnd) {
                for (int i = rEnd; i >= rStart; i--) {
                    ret.add(matrix[i][cStart]);
                }
            }
            cStart++;
        }
        return ret;
    }
}
