package com.billkalin.leetcode;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
