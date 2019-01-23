package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode94 {

	  public static class TreeNode {
		  public int val;
		  public TreeNode left;
		  public TreeNode right;
		  public TreeNode(int x) { val = x; }
	  }
	
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> retList = new ArrayList<Integer>();
	        if (root == null) {
	            return retList;
	        }
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode curr = root;
	        while(curr != null || !stack.isEmpty()) {
	            while(curr != null) {
	                 stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();
	            retList.add(curr.val);
	            curr = curr.right;
	        }
	        return retList;
	  }
	 
	 
	 public List<Integer> inorderTraversal2(TreeNode root) {
	        List<Integer> retList = new ArrayList<Integer>();
	        if (root == null) {
	            return retList;
	        }
	        inorderHelper(root, retList);
	        return retList;
	  }
	 
	 private void inorderHelper(TreeNode root, List<Integer> retList) {
		 if (null == root)
			 return;
		 inorderHelper(root.left, retList);
		 retList.add(root.val);
		 inorderHelper(root.right, retList);
	 }
}
