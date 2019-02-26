package com.billkalin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode101 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public boolean isSymmetric(TreeNode root) {
		  //非递归方法
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        q.add(root);
	        
	        while(!q.isEmpty()) {
	            TreeNode t1 = q.poll();
	            TreeNode t2 = q.poll();
	            if(t1 == null && t2 == null) 
	                continue;
	            if(t1 == null || t2 == null)
	                return false;
	            if(t1.val != t2.val)
	                return false;
	            q.add(t1.left);
	            q.add(t2.right);
	            q.add(t1.right);
	            q.add(t2.left);
	        }
	        
	        return true;
	        //递归方法
	       // return isMirror(root, root);
	    }
	    
	    public boolean isMirror(TreeNode left, TreeNode right) {
	        if(left == null && right == null)
	            return true;
	        if(left == null || right == null)
	            return false;
	        return (left.val == right.val) && isMirror(left.right, right.left) && isMirror(left.left, right.right);
	    }
}
