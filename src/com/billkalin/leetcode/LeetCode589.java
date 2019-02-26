package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode589 {

	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<Integer> preorder(Node root) {
	        List<Integer> retList = new ArrayList<>();
//	        preorder(root, retList);
	        //非递归方法
	         Stack<Node> stack = new Stack<>();
	         stack.push(root);
	         while(!stack.isEmpty()) {
	             Node curr = stack.pop();
	             retList.add(curr.val);
	             List<Node> children = curr.children;
	             if(null != children && children.size()>0) {
	                for(int i=children.size()-1;i>=0;i--) {
	                    stack.push(children.get(i));
	                }
	             }
	         }
	        return retList;
	    }
	    
	 	//递归方法
	    public void preorder(Node root, List<Integer> retList) {
	        if(root == null)
	            return;
	        retList.add(root.val);
	        for(Node node: root.children) {
	            preorder(node, retList);
	        }
	    }
}
