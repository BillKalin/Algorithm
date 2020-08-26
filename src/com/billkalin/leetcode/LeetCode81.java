package com.billkalin.leetcode;

public class LeetCode81 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,1};
        int target = 3;
        boolean isExist = search(nums, target);
        System.out.println("isExist = " + isExist);
    }

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target)
                return true;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[start] > nums[mid]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start ++;
            }
        }
        return false;
    }
}
