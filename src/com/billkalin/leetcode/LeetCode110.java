package com.billkalin.leetcode;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
        if (null == root)
           return true;
       int left = getTreeDepth(root.left);
       int right = getTreeDepth(root.right);
       if (Math.abs(left - right) > 1)
           return false;
       return isBalanced(root.left) && isBalanced(root.right);
   }
   
   private int getTreeDepth(TreeNode root) {
       if (null == root)
           return 0;
       int left = getTreeDepth(root.left);
       int right = getTreeDepth(root.right);
       return left > right ? left+1:right+1;
   }
   
   public int isBalanced2(TreeNode root) {
	   if (root == null)
		   return 0;
	   
	   int left = isBalanced2(root.left);
	   int right = -1;
	   if (left != -1 && root.right != null) {
		   right = isBalanced2(root.right);
	   }
	   
	   if (-1 != left && right != -1) {
		   if (Math.abs(left -right) < 1) {
			   return left > right ? left + 1 :right + 1;
		   }
	   }
	   return -1;
   }
}
