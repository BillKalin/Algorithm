package com.billkalin.leetcode;

public class LeetCode287 {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 4, 2 };// { 1, 3, 4, 2, 2 };
		int ret = findDuplicate(nums);
		System.out.println(ret);
	}

	/**
	 * 这里利用2个指针的办法，参考链表查找是否有环的做法，一个走一步，一个走2步
	 * 
	 * @param nums
	 * @return
	 */
	public static int findDuplicate(int[] nums) {
		int i = nums[0];
		int j = nums[0];
		do {
			i = nums[i];
			j = nums[nums[j]];
		} while (i != j);
		// 找到环的入口
		int p1 = nums[0];
		int p2 = j;
		while (p1 != p2) {
			p1 = nums[p1];
			p2 = nums[p2];
		}
		return p1;
	}
}
