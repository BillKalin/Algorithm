package com.billkalin.leetcode;

public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
        solveDfs(board, 0);
    }

    private boolean solveDfs(char[][] board, int index) {
        if (index == 81) return true;//到达最后一个位置
        int row = index / 9;//当前所处的行
        int col = index % 9;//当前所处的列
        //如果当前已经放好了，那就放下一个位置
        if (board[row][col] != '.') return solveDfs(board, index + 1);
        //每个位置从1-9，依次尝试放
        for (char ch = '1'; ch <= '9'; ch++) {
            //如果满足条件则尝试放
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                //接着看下一个位置
                if (solveDfs(board, index + 1))
                    return true;
                //这个位置没有放，就回退
                board[row][col] = '.';
            }
        }
        return false;
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
