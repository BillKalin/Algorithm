package com.billkalin.leetcode;

public class LeetCode70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        
        int first = 1;
        int second = 2;
        int sum = 0;
        int i = 3;
        while(i<=n) {
            sum = first+second;
            first = second;
            second = sum;
            i++;
        }
        
        return sum;//climbStairs(n-1) + climbStairs(n-2);
    }
}
