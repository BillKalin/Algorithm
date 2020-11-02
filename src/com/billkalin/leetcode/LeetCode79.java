package com.billkalin.leetcode;

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //以(i,j) 开始字符是否存在
                if (exists(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] boards, char[] words, int r, int c, int index) {
        //如果已达到word的结尾，说明存在
        if (index == words.length)
            return true;
        //处理边界问题
        if (r < 0 || r >= boards.length || c < 0 || c >= boards[0].length)
            return false;
        //如果当前和单词当前字符不等，直接返回
        if (boards[r][c] != words[index]) {
            return false;
        }
        char ch = words[index];
        boards[r][c] = '#';//标记当前字符已使用
        //考察相邻的四个位置是否和word下一个字符相等
        boolean exists = exists(boards, words, r - 1, c, index + 1)
                || exists(boards, words, r + 1, c, index + 1)
                || exists(boards, words, r, c - 1, index + 1)
                || exists(boards, words, r, c + 1, index + 1);
        boards[r][c] = ch;//恢复
        return exists;
    }
}
