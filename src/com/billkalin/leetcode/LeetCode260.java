package com.billkalin.leetcode;

public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int diff = 0;
        //先计算所有的数字异或值
        for (int num : nums) {
            diff ^= num;
        }
        //得到相应位不同的位置，然后区分开这两个数字，同时计算异或值
        diff &= (-diff);
        for (int num : nums) {
            if ((num & diff) == 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }

        return ret;
    }
}
