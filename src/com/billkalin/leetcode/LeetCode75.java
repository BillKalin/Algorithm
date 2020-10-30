package com.billkalin.leetcode;

public class LeetCode75 {

    //方法1：排序，最快排序时间复杂度也为O(nlongn)

    //方法2：分别统计0，1，2的个数，然后在改写数组元素
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int num0 = 0, num1 = 0, num2 = 0;
        for (int num : nums) {
            if (num == 0) num0++;
            if (num == 1) num1++;
            if (num == 2) num2++;
        }
        for (int i = 0; i < num0; i++) nums[i] = 0;
        for (int i = 0; i < num1; i++) nums[num0 + i] = 1;
        for (int i = 0; i < num2; i++) nums[num0 + num1 + i] = 2;
    }

    //方法3，双指针，分别指向0，2的位移
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        int num0 = 0, num2 = n - 1;
        for (int i = 0; i <= num2; i++) {
            if (nums[i] == 0) {
                swap(nums, i, num0++);
            } else if (nums[i] == 2) {
                swap(nums, i--, num2--);
            }
        }
    }

    //方法4：
    public void sortColors3(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        int num0 = 0, num2 = n - 1;
        for (int i = 0; i <= num2; i++) {
            while (nums[i] == 2 && i < num2) {
                swap(nums, i, num2--);
            }
            while (nums[i] == 0 && i > num0) {
                swap(nums, i, num0++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
