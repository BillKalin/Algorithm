package com.billkalin.leetcode;

public class LeetCode10 {
    public static void main(String[] args) {
        LeetCode10 instance = new LeetCode10();
        boolean isMatch = instance.isMatch2("aa", ".*");
        System.out.println("isMatch= " + isMatch);
    }

    //backpacking 算法
    private boolean isMatch(String string, String pattern) {
        if (pattern.isEmpty())
            return string.isEmpty();

        boolean firstMatch = !string.isEmpty() && (string.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(string, pattern.substring(2))
                    || (firstMatch && isMatch(string.substring(1), pattern));
        } else {
            return firstMatch && isMatch(string.substring(1), pattern.substring(1));
        }
    }

    private int[][] mem;

    //备忘录DP
    private boolean isMatch2(String string, String pattern, int si, int pi) {
        if (mem == null) {
            mem = new int[string.length() + 1][pattern.length() + 1];
        }
        if (mem[si][pi] != 0)
            return mem[si][pi] == 1;

        boolean isMatch;
        if (pi == pattern.length()) {
            isMatch = si == string.length();
        } else {
            boolean firstMatch = si < string.length() && (string.charAt(si) == pattern.charAt(pi) || pattern.charAt(pi) == '.');
            if (pi + 1 < pattern.length() && pattern.charAt(pi + 1) == '*') {
                isMatch = isMatch2(string, pattern, si, pi + 2) || (firstMatch && isMatch2(string, pattern, si + 1, pi));
            } else {
                isMatch = firstMatch && isMatch2(string, pattern, si + 1, pi + 1);
            }
        }

        if (isMatch) {
            mem[si][pi] = 1;
        } else {
            mem[si][pi] = 2;
        }
        return isMatch;
    }

    // 表格法
    private boolean isMatch2(String string, String pattern) {
        boolean[][] dp = new boolean[string.length() + 1][pattern.length() + 1];
        int strLength = string.length();
        int pLength = pattern.length();
        dp[strLength][pLength] = true;
        for (int i = strLength; i >= 0; i--) {
            for (int j = pLength - 1; j >= 0; j--) {
                boolean first = i < strLength && (string.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if (j + 1 < pLength && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first && dp[i + 1][j];
                } else {
                    dp[i][j] = first && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
