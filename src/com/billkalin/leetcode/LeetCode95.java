package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {
    public List<LeetCode94.TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<LeetCode94.TreeNode>();
        return generateTrees(1, n);
    }

    //递归
    //参考：https://leetcode.wang/leetCode-95-Unique-Binary-Search-TreesII.html
    public List<LeetCode94.TreeNode> generateTrees(int start, int end) {
        List<LeetCode94.TreeNode> list = new ArrayList<LeetCode94.TreeNode>();
        if (start > end) {//没有数字，则添加null
            list.add(null);
            return list;
        }
        if (start == end) {//只有一个数字时，只需要添加一个节点
            list.add(new LeetCode94.TreeNode(start));
            return list;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到左子树节点
            List<LeetCode94.TreeNode> leftList = generateTrees(start, i - 1);
            //得到右子树节点
            List<LeetCode94.TreeNode> rightList = generateTrees(i + 1, end);
            //左右子树的两两组合
            for (LeetCode94.TreeNode left : leftList) {
                for (LeetCode94.TreeNode right : rightList) {
                    LeetCode94.TreeNode root = new LeetCode94.TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    //动态规划
    public List<LeetCode94.TreeNode> generateTrees2(int n) {
        if (n == 0)
            return new ArrayList<LeetCode94.TreeNode>();
        ArrayList<LeetCode94.TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<LeetCode94.TreeNode>();
        dp[0].add(null);
        //长度从1到n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<LeetCode94.TreeNode>();
            //不同的数字作为根节点，考虑1->len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;//左子树长度
                int right = len - root;//右子树长度
                for (LeetCode94.TreeNode leftTree : dp[left]) {
                    for (LeetCode94.TreeNode rightTree : dp[right]) {
                        LeetCode94.TreeNode node = new LeetCode94.TreeNode(root);
                        node.left = leftTree;
                        //克隆右子树加上偏移
                        node.right = clone(rightTree, root);
                        dp[len].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    //克隆子树并加上offset的值
    private LeetCode94.TreeNode clone(LeetCode94.TreeNode node, int offset) {
        if (node == null)
            return null;
        LeetCode94.TreeNode root = new LeetCode94.TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
}
