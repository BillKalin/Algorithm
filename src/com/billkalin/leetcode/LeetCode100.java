package com.billkalin.leetcode;

import java.util.Stack;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if(p != null && q != null) {
            if (p.val != q.val)
                return false;
        } else
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if((p == null && q != null) || (p != null && q == null)) {
           return false;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(p);
        s2.push(q);
        while(!s1.isEmpty() && !s2.isEmpty()) {
        	TreeNode node1 = s1.pop();
        	TreeNode node2 = s2.pop();
        	
        	if(node1.val != node2.val)
        		return false;
        	
        	if(node1.left != null && node2.left != null) {
        		s1.push(node1.left);
        		s2.push(node2.left);
        	} else if (node1.left == null && node2.left == null) {
        		
        	} else {
        		return false;
        	}
        	
        	if(node1.right != null && node2.right != null) {
        		s1.push(node1.right);
        		s2.push(node2.right);
        	} else if (node1.right == null && node2.right == null) {
        		
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
}
