package com.billkalin.leetcode;

import java.util.LinkedList;

public class LeetCode654 {
    public LeetCode94.TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    //time: O(n2), space: O(1)
    private LeetCode94.TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left >= right)
            return null;
        //找到最大值
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        LeetCode94.TreeNode node = new LeetCode94.TreeNode(nums[maxIndex]);
        //左边区间最大值为左孩子结点
        node.left = constructMaximumBinaryTree(nums, left, maxIndex);
        //右边区间最大值为右孩子结点
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);
        return node;
    }

    public LeetCode94.TreeNode constructMaximumBinaryTree2(int[] nums) {
        LinkedList<LeetCode94.TreeNode> linkedList = new LinkedList<>();
        for (int num : nums) {
            LeetCode94.TreeNode node = new LeetCode94.TreeNode(num);
            while (!linkedList.isEmpty() && linkedList.peekFirst().val < num) {
                node.left = linkedList.pop();
            }
            if (!linkedList.isEmpty()) {
                linkedList.peekFirst().right = node;
            }
            linkedList.push(node);
        }
        return linkedList.peekLast();
    }
}
