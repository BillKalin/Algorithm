package com.billkalin.leetcode;

public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        //最小值溢出
        if (dividend == Integer.MIN_VALUE && dividend == -1)
            return Integer.MAX_VALUE;
        //确定符号
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        int ret = 0;
        if (n == 1) {
            //如果溢出了，需要判断一下符号
            if (m >= Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return sign == 1 ? (int) m : (int) -m;
        }
        while (m >= n) {
            int count = 1;
            long currN = n;
            while (m >= (currN << 1)) {
                count <<= 1;
                currN <<= 1;
            }
            ret += count;
            m -= currN;
        }
        return sign == -1 ? -ret : ret;
    }

    //递归方法
    public int divide2(int dividend, int divisor) {
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        long ret = 0;
        if (m < n)
            return 0;
        long count = 1;
        long currN = n;
        while (m >= (currN << 1)) {
            count <<= 1;
            currN <<= 1;
        }
        ret += count + divide2((int) (dividend - currN), (int) n);
        if ((dividend < 0) ^ (divisor < 0)) {
            ret = -ret;
        }
        return ret > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ret;
    }

    public int divide3(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0) ^ (divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor) return 0;

        long ldivide = ldivide(ldividend, ldivisor);
        if (ldivide > Integer.MAX_VALUE) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sign * ldivide);
    }

    private long ldivide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long ret = 1;
        long ldivisor = divisor;
        while (dividend >= (ldivisor << 1)) {
            ret <<= 1;
            ldivisor <<= 1;
        }
        return ret + ldivide(dividend - ldivisor, divisor);
    }
}
