package com.billkalin.leetcode;

public class LeetCode28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i=0;i<haystack.length();i++) {
           for (int j=0;;j++) {
                
               if (j == needle.length()) {
                   return i;
               }
               
               if (i+j == haystack.length()) {
                   return -1;
               }
               if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }
        
        return -1;
    }
}
