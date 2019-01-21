package com.billkalin.leetcode;

public class LeetCode9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean isPalindrome(int x) {
	        if (x < 0 || (x != 0 && x % 10 == 0))
	            return false;
	        //翻转数字，然后相比较
	        int num = 0;
	        int next = x;
	        while (next > 0) {
	            int c = next % 10;
	            num = num * 10 + c;
	            next = next /10;
	        }
	        
	        return num == x;
	    }
}
