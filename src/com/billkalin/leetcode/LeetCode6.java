package com.billkalin.leetcode;

public class LeetCode6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int n  = s.length();
        int gap = 2 * numRows - 2;
        for (int i=0;i<numRows;i++) {
            for (int j=0;j+i<n;j+=gap) {
                sb.append(s.charAt(i+j));
                if (i!=0&&i!=numRows-1&&j+gap-i<n) {
                      sb.append(s.charAt(j+gap-i));
                }
            }
        }
        return sb.toString();
    }
}
