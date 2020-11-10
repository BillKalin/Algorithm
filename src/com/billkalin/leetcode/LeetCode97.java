package com.billkalin.leetcode;

public class LeetCode97 {

    //递归. 超时了。。
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;

        //备忘录方法
        /*int[][] mem = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                mem[i][j] = -1;
            }
        }
        return isInterleave(s1,s2,s3, 0,0,0, mem);*/


        //动态规划
        /*boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && s1.charAt(j- 1) == s3.charAt(i + j - 1))
                            || (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];*/

        //动态规划 二
      /*  boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];*/

        return isInterleave(s1, s2, s3, 0, 0, "");
    }

    private boolean isInterleave(String s1, String s2, String s3, int index1, int index2, String res) {
        if (index1 == s1.length() && index2 == s2.length() && s3.equals(res))
            return true;
        boolean isOk = false;
        if (index1 < s1.length()) {
            isOk |= isInterleave(s1, s2, s3, index1 + 1, index2, res + s1.charAt(index1));
        }
        if (index2 < s2.length()) {
            isOk |= isInterleave(s1, s2, s3, index1, index2 + 1, res + s2.charAt(index2));
        }
        return isOk;
    }

    //备忘录方法
    private boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3, int[][] mem) {
        if (index1 == s1.length()) {
            return s2.substring(index2).equals(s3.substring(index3));
        }
        if (index2 == s2.length()) {
            return s1.substring(index1).equals(s3.substring(index3));
        }

        if (mem[index1][index2] >= 0) {
            return mem[index1][index2] == 1 ? true : false;
        }

        boolean isOk = false;
        if ((s1.charAt(index1) == s3.charAt(index3) && isInterleave(s1, s2, s3, index1 + 1, index2, index3 + 1, mem))
                || (s2.charAt(index2) == s3.charAt(index3) && isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1, mem))) {
            isOk = true;
        }
        mem[index1][index2] = isOk ? 1 : 0;
        return isOk;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
