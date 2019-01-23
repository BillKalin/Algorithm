package com.billkalin.leetcode;

public class LeetCode58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int lengthOfLastWord(String s) {
        int j = 0;
        for(int i=s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                if (j > 0) {
                    return  j;
                }
            } else {
                j ++;
            }
            
        }
        return j;
    }
}
