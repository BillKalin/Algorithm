package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 4 };
		List<Integer> rt = findDuplicates2(nums);
		System.out.print("" + rt);
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1) {
				continue;
			}
			int temp = nums[i];
			nums[i] = -1;// 标记移除
			while (true) {
				if (temp < 0)
					break;
				if (nums[temp - 1] == temp) {
					ret.add(temp);
					break;
				}
				int k = nums[temp - 1];
				nums[temp - 1] = temp;
				temp = k;
			}

		}
		return ret;
	}

	public static List<Integer> findDuplicates2(int[] nums) {
		List<Integer> ret = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return ret;
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				ret.add(Math.abs(index + 1));
			}
			nums[index] = -nums[index];
		}
		return ret;
	}
}
