package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode91 {

    //递归
    public int numDecodings0(String s, int start) {
        if (start == s.length())
            return 1;
        if (s.charAt(start) == '0')
            return 0;
        int a1 = numDecodings0(s, start + 1);
        int a2 = 0;
        if (start < s.length() - 1) {
            int one = s.charAt(start) - '0';
            int two = s.charAt(start + 1) - '0';
            if (one * 10 + two <= 26) {
                a2 = numDecodings0(s, start + 2);
            }
        }
        return a1 + a2;
    }

    //备忘录
    private Map<Integer, Integer> mem = new HashMap<Integer, Integer>();

    public int numDecodings1(String s, int start) {
        if (start == s.length())
            return 1;
        if (s.charAt(start) == '0')
            return 0;
        if (mem.getOrDefault(start, -1) != -1) {
            return mem.get(start);
        }
        int a1 = numDecodings0(s, start + 1);
        int a2 = 0;
        if (start < s.length() - 1) {
            int one = s.charAt(start) - '0';
            int two = s.charAt(start + 1) - '0';
            if (one * 10 + two <= 26) {
                a2 = numDecodings0(s, start + 2);
            }
        }
        mem.put(start, a1 + a2);
        return a1 + a2;
    }

    //dp, time = O(n), space: O(n)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) - '0') != 0 ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }

            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    //dp, time = O(n), space: O(1)
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int curr = 0;
            int f1 = Integer.parseInt(s.substring(i - 1, i));
            int s2 = Integer.parseInt(s.substring(i - 2, i));
            if (f1 >= 1 && f1 <= 9) {
                curr += second;
            }
            if (s2 >= 10 && s2 <= 26) {
                curr += first;
            }

            first = second;
            second = curr;
        }

        return second;
    }
}
