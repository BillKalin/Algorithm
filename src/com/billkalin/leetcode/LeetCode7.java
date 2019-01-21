package com.billkalin.leetcode;

public class LeetCode7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        
        int num = 0;
        int next = x;
        while(next > 0) {
            int currCarry = next % 10;
             if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && next % 10 > 7
               || num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && next % 10 < -8)             {
                return 0;
            }
            num = num * 10 + currCarry;
            next = next /10;
        }
        
        return sign * num;
    }
}
