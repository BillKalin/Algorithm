package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public ListNode removeElements(ListNode head, int val) {
	        if (null == head)
	            return null;
	        ListNode fakeHead = new ListNode(0);
	        fakeHead.next = head;
	        ListNode pre = fakeHead;
	        while(pre.next != null) {
	            if (pre.next.val == val) {
	                pre.next = pre.next.next;
	            } else {
	                pre = pre.next;
	            }
	        }
	        
	        return fakeHead.next;
	    }
	 
	 public ListNode removeElements2(ListNode head, int val) {
	        if (head == null) return null;
	        head.next = removeElements2(head.next, val);
	        return head.val == val ? head.next : head;
	}
}
