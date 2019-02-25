package com.billkalin.leetcode;

public class LeetCode704 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] nums, int target) {
        if(nums == null|| nums.length == 0)
            return -1;
        
        int low = 0;
        int high = nums.length-1;
        int mid = -1;
        while(low <= high) {
            mid = low + ((high - low)>>>1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
	
	public int search(int[] nums, int target, int low, int high) {
        if(low > high)
            return -1;
        
        int mid = low +((high - low )>>>1);
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target) {
            return search(nums, target, low, mid - 1);
        } else {
            return search(nums, target, mid + 1, high);
        }
    }
}
