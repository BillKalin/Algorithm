package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {

    public List<Integer> postorderTraversal(LeetCode94.TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        postorderTraversal(root, ret);
        return ret;
    }

    //方法一：递归
    public void postorderTraversal(LeetCode94.TreeNode root, List<Integer> ret) {
        if (root == null)
            return;
        postorderTraversal(root.left, ret);
        postorderTraversal(root.right, ret);
        ret.add(root.val);
    }

    //方法二：利用双栈(和前序遍历相反)
    public List<Integer> postorderTraversal2(LeetCode94.TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (root == null)
            return ret;
        Stack<LeetCode94.TreeNode> stack = new Stack<>();

        LeetCode94.TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                ret.addFirst(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return ret;
    }

    //方法三：使用标记来标示访问过的节点
    public List<Integer> postorderTraversal3(LeetCode94.TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        LeetCode94.TreeNode curr = root;
        LeetCode94.TreeNode pre = null;
        Stack<LeetCode94.TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            //如果没有右孩子，或者右孩子已经访问过，那就访问该节点
            if (curr.right == null || curr.right == pre) {
                ret.add(curr.val);
                stack.pop();
                pre = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }

        return ret;
    }
}
