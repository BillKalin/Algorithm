package com.billkalin.leetcode;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int minDepth(TreeNode root) {
         return minDepth(root, 0);
 }
 
 public int minDepth(TreeNode root, int sum) {
     if (root == null)
         return 0;
    int left = minDepth(root.left);
     int right = minDepth(root.right);
     // return Math.min(minDepth(root.left), minDepth(root.right))+1;
     return (left == 0 || right == 0)?left+right+1:Math.min(left, right)+1;
 }
}
