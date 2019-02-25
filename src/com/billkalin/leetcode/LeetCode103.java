package com.billkalin.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> retList = new LinkedList<List<Integer>>();
		if(root == null)
			return retList;
		
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		boolean left = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new LinkedList<>();
			for(int i=0;i<size;i++) {
				TreeNode node = null;
				if(left) {
					node = queue.pollFirst();
					if(node.left != null) {
						queue.addLast(node.left);
					}
					if(node.right != null) {
						queue.addLast(node.right);
					}
				} else {
					node = queue.pollLast();
					if(node.left != null) {
						queue.addFirst(node.left);
					}
					if(node.right != null) {
						queue.addFirst(node.right);
					}
				}
				subList.add(node.val);
			}
			retList.add(subList);
			left = !left;
		}
		return retList;
	}
}
