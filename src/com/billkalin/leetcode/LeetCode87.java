package com.billkalin.leetcode;

public class LeetCode87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        //如果字符出现的次数不一致，那肯定是不符合要求的
        for (int i : letters) {
            if (i != 0)
                return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            //考察0~i 和 i~length，是否符合要求
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            //考察 s1 0~i ，和 s2 s2.length - i, s2.length是否符合要求
            // s1: i~s1.length 和 s2: 0~s2.length - i
            if (isScramble(s1.substring(i), s2.substring(0, s2.length()-i)) &&
                    isScramble(s1.substring(0, i), s2.substring(s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
