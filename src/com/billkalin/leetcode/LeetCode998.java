package com.billkalin.leetcode;

public class LeetCode998 {
    public LeetCode94.TreeNode insertIntoMaxTree(LeetCode94.TreeNode root, int val) {
        if (root != null && root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        LeetCode94.TreeNode node = new LeetCode94.TreeNode(val);
        node.left = root;
        return node;
    }

    public LeetCode94.TreeNode insertIntoMaxTree2(LeetCode94.TreeNode root, int val) {
        LeetCode94.TreeNode node = new LeetCode94.TreeNode(val);
        //大于根结点，直接创建新结点，左节点为当前根结点
        if (root.val < val) {
            node.left = root;
            return node;
        }

        LeetCode94.TreeNode curr = root;
        //查找第一个比预定值小的结点
        while (curr.right != null && curr.right.val > val) {
            curr = curr.right;
        }
        //新结点的左孩子为当前结点右孩子
        node.left = curr.right;
        //当前结点的右孩子为新结点
        curr.right = node;

        return root;
    }

}
