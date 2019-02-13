package com.billkalin.leetcode;

import java.util.Stack;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(1);
//		ListNode head3 = new ListNode(1);
		head.next = head1;
		head1.next = head2;
//		head2.next = head3;
		
		isPalindrome(head);
	}

	 public static boolean isPalindrome(ListNode head) {
	        if (null == head || head.next == null)
	            return false;
	        ListNode slow = head;
	        ListNode fast = head;
	        Stack<Integer> stack = new Stack<Integer>();
	        while(fast != null && fast.next != null) {
	            stack.push(slow.val);
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        if (fast != null) {
	        	slow = slow.next;
	        }
	        //time = O(n) space = O(1)
	        slow = reverseNode(slow);
	        //time = O(n) space = O(n)
//	        while(!stack.isEmpty() && slow != null)  {
//	            if (null == slow || stack.pop() != slow.val) {
//	                return false;
//	            }
//	            slow = slow.next;
//	        }
	        while(slow != null && head != null) {
	        	if (slow.val != head.val) {
	        		return false;
	        	}
	        	slow = slow.next;
	        	head = head.next;
	        }
	            
	        return true;    
	    }
	 
	 private static ListNode reverseNode(ListNode head) {
		 if(null == head.next) {
			 return head;
		 }
		 
		 ListNode root = reverseNode(head.next);
		 head.next.next = head;
		 head.next = null;
		 return root;
	 }
}
