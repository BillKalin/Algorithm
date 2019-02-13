package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public ListNode reverseList(ListNode head) {
	        if (null == head || head.next == null)
	            return head;
	        ListNode ret = reverseList(head.next);
	        head.next.next = head;
	        head.next = null;
	        return ret;
	    }
	 
	 public ListNode reverseList2(ListNode head) {
	        if (null == head || head.next == null)
	            return head;
	        ListNode pre = null;
	        ListNode curr = head;
//	        ListNode last = null;
	        while(curr != null) {
	        	 ListNode last = curr.next;
	        	curr.next = pre;
	        	pre = curr;
	        	curr = last;
	        }
//	        head.next = null;
	        return pre;
	    }
}
