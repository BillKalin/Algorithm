package com.billkalin.leetcode;

public class LeetCode72 {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        LeetCode72 leetCode73 = new LeetCode72();
        int editDistance = leetCode73.minDistance2(word1, word2);
        System.out.println("edit distance = " + editDistance);
    }

    //回溯法，超时了。。。
    public int minDistance(String word1, String word2) {
        minDistance(word1, word2, 0, 0, 0);
        return mMinEditLength;
    }

    private int mMinEditLength = Integer.MAX_VALUE;

    public void minDistance(String word1, String word2, int w1, int w2, int editLength) {
        if (w1 == word1.length() || w2 == word2.length()) {
            if (w1 < word1.length()) {
                editLength += word1.length() - w1;
            }
            if (w2 < word2.length()) {
                editLength += word2.length() - w2;
            }
            mMinEditLength = Math.min(editLength, mMinEditLength);
            return;
        }
        if (word1.charAt(w1) == word2.charAt(w2)) {
            minDistance(word1, word2, w1 + 1, w2 + 1, editLength);
        } else {
            minDistance(word1, word2, w1 + 1, w2, editLength + 1);
            minDistance(word1, word2, w1, w2 + 1, editLength + 1);
            minDistance(word1, word2, w1 + 1, w2 + 1, editLength + 1);
        }
    }

    public int minDistance2(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.abs(word1.length() - word2.length());
        }
        int w1length = word1.length();
        int w2Length = word2.length();
        int[][] dp = new int[w1length + 1][w2Length + 1];
        for (int i = 0; i <= w2Length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= w2Length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= w1length; i++) {
            for (int j = 1; j <= w2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[w1length][w2Length];
    }

    public int minDistance3(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.abs(word1.length() - word2.length());
        }
        int wl1 = word1.length();
        int wl2 = word2.length();
        int[][] dp = new int[wl1][wl2];
        for (int i = 0; i < wl2; i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = i;
            } else if (i != 0) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < wl1; i++) {
            if (word2.charAt(0) == word1.charAt(i)) {
                dp[i][0] = i;
            } else if (i != 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < wl1; i++) {
            for (int j = 1; j < wl2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[wl1 - 1][wl2 - 1];
    }
}
