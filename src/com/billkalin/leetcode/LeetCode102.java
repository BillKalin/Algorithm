package com.billkalin.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.billkalin.leetcode.LeetCode94.TreeNode;

public class LeetCode102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> retList = new LinkedList<List<Integer>>();
	        if(root == null)
	            return retList;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            List<Integer> subList = new LinkedList<>();
	            for(int i=0;i<size;i++) {
	                if(queue.peek().left != null) {
	                    queue.add(queue.peek().left);
	                }
	                 if(queue.peek().right != null) {
	                    queue.add(queue.peek().right);
	                }
	                
	                subList.add(queue.poll().val);
	                
	            }
	            retList.add(subList);
	        }
	        return retList;
	    }
	 
	 public List<List<Integer>> levelOrder2(TreeNode root) {
	        List<List<Integer>> retList = new LinkedList<List<Integer>>();
	        levelScan(retList, root, 0);
	        return retList;
	 }
	 
	 private void levelScan(List<List<Integer>> retList, TreeNode root, int level) {
		 if(null == root)
			 return;
		 if(level >= retList.size()) {
			 retList.add(new LinkedList<Integer>());
		 }
		 retList.get(level).add(root.val); 
		 levelScan(retList, root.left, level+1);
		 levelScan(retList, root.right, level+1);
	 }
}
