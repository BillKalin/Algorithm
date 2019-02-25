package com.billkalin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public TreeNode invertTree(TreeNode root) {
	        if(root == null)
	            return root;
	        
//	         TreeNode left = invertTree(root.left);
//	         TreeNode right = invertTree(root.right);
	        
//	         root.left = right;
//	         root.right = left;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()) {
	            TreeNode curr = queue.poll();
	            TreeNode temp = curr.left;
	            curr.left = curr.right;
	            curr.right = temp;
	            
	            if(curr.left != null) {
	                queue.add(curr.left);
	            }
	            if(curr.right != null) {
	                queue.add(curr.right);
	            }
	        }
	        return root;
	    }
}
