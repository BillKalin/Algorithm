package com.billkalin.leetcode;

import java.util.Stack;

public class LeetCode98 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        int val = node.val;
        if (min != null && val <= min) return false;
        if (max != null && val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node, node.val, max);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }

        return true;
    }
}
