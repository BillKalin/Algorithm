package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<Integer>();
        preorderHeler(root, retList);
        return retList;
    }
    
    private void preorderHeler(TreeNode root, List<Integer> ret) {
        if (null == root)
            return;
        ret.add(root.val);
        preorderHeler(root.left, ret);
        preorderHeler(root.right, ret);
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> retList = new ArrayList<Integer>();
        if (null != root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while(curr != null || !stack.isEmpty()) {
                if(curr!= null) {
                    stack.push(curr);
                    retList.add(curr.val);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    curr = curr.right;
                }
            }
        }
        return retList;
    }
}
