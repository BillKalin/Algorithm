package com.billkalin.leetcode;

public class LeetCode31 {
    //第一种解法：暴力解决，先得出nums的全部排列进行排序，然后找到下一个大的数字，
    //时间复杂为n！，空间复杂为n

    //第二种解法
    //
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i) {
        int start = i, end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
