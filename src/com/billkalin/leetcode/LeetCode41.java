package com.billkalin.leetcode;

public class LeetCode41 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        int num = firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {
        //把对应的数字放到正确位置上，即i+1 = nums[i], 如果是负数或者大于n的数则跳过
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > n)
                i++;
            else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < n && nums[i] == i + 1) i++;
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
