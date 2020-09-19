package com.billkalin.leetcode;

public class LeetCode44 {

    //双指针回溯
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = p.length();
        int startJ = -1;
        int lastMatch = 0;
        while (i < m) {
            //如果当前字符和表达式字符相等或者表达式字符为？，则两个指针都往后移动
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                //如果当前表达式字符为*，则要记录当前指针的状态，
                // 以便下一次回溯，同时表达式继续往后匹配
                startJ = j;
                j++;
                lastMatch = i;
            } else if (startJ != -1) {
                //从上一次表达式的匹配下标开始进行回溯比较
                j = startJ + 1;
                lastMatch++;
                i = lastMatch;
            } else {
                return false;
            }
        }

        //表达式指针未到末尾且后面是*，
        // 则可以继续后移，直到表达式的下标直到末尾才匹配成功
        while (j < n && p.charAt(j) == '*') j++;

        return j == n;
    }

    //动态规划
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;//p，s都是空字符串，是匹配的
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {//如果是*开头的话，是匹配的
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果当前字符相等或者p的字符为？，则当前匹配取决于前一个字符的匹配状况
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //如果p的当前字符是*，要么是用*匹配，要么不需要*
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
