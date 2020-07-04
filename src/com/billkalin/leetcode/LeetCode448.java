package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4,3,2,7,8,2,3,1};
		List<Integer> rt = findDisappearedNumbers2(nums);
		System.out.print("" + rt);
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
//		[4,3,2,7,8,2,3,1]
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			while (nums[temp - 1] != temp) {
				int j = nums[temp - 1];
				nums[temp - 1] = temp;
				temp = j;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				ret.add(i + 1);
			}
		}

		return ret;
	}

	public static List<Integer> findDisappearedNumbers2(int[] nums) {
//		[4,3,2,7,8,2,3,1]
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0)
				nums[index] = -nums[index];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				ret.add(i + 1);
		}
		return ret;
	}
}
