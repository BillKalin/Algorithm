package com.billkalin.leetcode;

public class LeetCode11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
        if (null == height)
            return 0;
        int left=0,right=height.length-1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea,(Math.min(height[left],  height[right])*(right - left)));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
