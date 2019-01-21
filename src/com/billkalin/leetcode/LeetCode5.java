package com.billkalin.leetcode;

public class LeetCode5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        if(s.length() == 1) {
            return s;
        }
        int max = 0, currI=0, currJ=0;
        for (int i=0;i<s.length();i++) {
            int maxOdd = isPreStr(s, i, i);
            int maxOver = isPreStr(s, i, i+1);
            int currMax = Math.max(maxOdd, maxOver);
            if (currMax > max) {
                currI = i - (currMax - 1)/2;
                currJ = i + currMax/2;
                max = currMax;
            }
        }
        
        return  s.substring(currI, currJ+1);
    }
    
    private int isPreStr(String s, int left, int right) {
      int i = left;
      int j = right;
        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i --;
            j++;
        }
        
        return j - i - 1;
    }
}
