package com.billkalin.leetcode;

public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length <= 2)
            return nums.length;
        int m = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > j) {
                if (nums[i] == nums[j]) {
                    m++;
                    if (m < 2) {
                        j++;
                        nums[j] = nums[i];
                    }
                } else {
                    m = 0;
                    j++;
                    nums[j] = nums[i];
                }
            }
        }

        return j + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length <= 2)
            return nums.length;

        int j = 0;
        for (int n : nums) {
            if (j < 2 || nums[j - 2] < n) {
                nums[j++] = n;
            }
        }

        return j + 1;
    }
}
