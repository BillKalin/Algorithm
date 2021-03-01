package com.billkalin.leetcode;

public class LeetCode137 {
    public int singleNumber(int[] nums) {
        /**
         * 每个数字出现三次，那么在相应的二进制1的次数总和都是3的倍数，
         * 要找出出现一次的数字，那就把相应的二进制位进行或运算得到那个出现1次的数字
         */
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                result |= bit;
            }
        }

        return result;
    }
}
