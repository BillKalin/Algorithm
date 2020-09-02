package com.billkalin.leetcode;

import java.util.HashMap;

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        HashMap<Integer, Integer>[] rows = new HashMap[row];
        HashMap<Integer, Integer>[] cols = new HashMap[col];
        HashMap<Integer, Integer>[] cubes = new HashMap[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            cubes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') continue;
                int ch = (int) board[i][j];
                int boxIndex = 3 * (i / 3) + j / 3;
                rows[i].put(ch, rows[i].getOrDefault(ch, 0) + 1);
                cols[j].put(ch, cols[j].getOrDefault(ch, 0) + 1);
                cubes[boxIndex].put(ch, cubes[boxIndex].getOrDefault(ch, 0) + 1);
                if (rows[i].getOrDefault(ch, 0) > 1
                        || cols[j].getOrDefault(ch, 0) > 1
                        || cubes[boxIndex].getOrDefault(ch, 0) > 1)
                    return false;
            }
        }

        return true;
    }
}
