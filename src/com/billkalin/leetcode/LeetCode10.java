package com.billkalin.leetcode;

public class LeetCode10 {
    public static void main(String[] args) {
        LeetCode10 instance = new LeetCode10();
        boolean isMatch = instance.isMatch("aab", "c*a*b");
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


}
