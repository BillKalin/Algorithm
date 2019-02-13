package com.billkalin.leetcode;

public class LeetCode509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int fib(int N) {
        if(N == 0 || N == 1)
            return N;
        int first = 0;
        int second = 1;
        int sum = 0;
        for(int i=2;i<=N;i++) {
            sum = first+second;
            first = second;
            second = sum;
        }
        return sum;//fib(N-1) + fib(N-2);
    }
}
