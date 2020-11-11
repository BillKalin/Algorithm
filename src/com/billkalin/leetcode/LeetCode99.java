package com.billkalin.leetcode;

public class LeetCode99 {

    private LeetCode94.TreeNode first, second;
    private LeetCode94.TreeNode preNode;

    //使用中序遍历的特点，从小到大，如果存在比之前的大，那就记录下来，最后交换结点的值即可
    public void recoverTree(LeetCode94.TreeNode root) {
        if (root == null)
            return;
        interOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void interOrder(LeetCode94.TreeNode root) {
        if (root == null)
            return;
        interOrder(root.left);
        if (preNode != null) {
            if (first == null && preNode.val >= root.val) {
                first = preNode;
            }

            if (first != null && preNode.val >= root.val) {
                second = root;
            }
        }
        preNode = root;
        interOrder(root.right);
    }
}
