package com.billkalin.leetcode;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(board, i, j, ch)) {
                        board[i][j] = ch;
                        if (solve(board))
                            return true;
                        else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        int rIndex = 3 * (row / 3);
        int cIndex = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch || board[rIndex + i / 3][cIndex + i % 3] == ch)
                return false;
        }
        return true;
    }
}
