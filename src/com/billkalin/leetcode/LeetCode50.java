package com.billkalin.leetcode;

public class LeetCode50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        //这里要注意溢出的情况，如果这里不处理，那么那n<0,n=-n的时候就溢出了。
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x * x, n / 2);
    }

    //迭代
    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        double res = 1.0;
        for (int i = n; i != 0; i = i / 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? (1 / res) : res;
    }
}
