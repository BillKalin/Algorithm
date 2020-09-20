package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {

    //利用层序遍历，保留最右边的节点值
    public List<Integer> rightSideView(LeetCode94.TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Queue<LeetCode94.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                LeetCode94.TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i == levelSize - 1) {
                    ret.add(node.val);
                }
            }
        }
        return ret;
    }
}
