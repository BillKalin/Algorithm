package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public ListNode swapPairs(ListNode head) {
	        if (null == head)
	            return head;
	        ListNode fakeHead = new ListNode(0);
	        fakeHead.next = head;
	        ListNode slow = head;
	        ListNode fast = head.next;
	        ListNode next = null;
	        ListNode pre = fakeHead;
	        while( fast != null) {
	            next = fast.next;
	            fast.next = slow;
	            slow.next = next;
	            pre.next = fast;
	            pre = slow;
	            slow  = next;
	            if(null == slow)
	                break;
	            fast = slow.next;
	        }
	        return fakeHead.next;
	    }
	 
	 public ListNode swapPairs2(ListNode head) {
	        if (null == head)
	            return head;
	        ListNode fakeHead = new ListNode(0);
	        fakeHead.next = head;
	        ListNode curr = fakeHead;
	        while(curr.next != null && curr.next.next != null) {
	        	ListNode first = curr.next;
	        	ListNode second = curr.next.next;
	        	first.next = second.next;
	        	curr.next = second;
	        	curr.next.next = first;
	        	curr = curr.next.next;
	        }
	        return fakeHead.next;
	    }
	 
	 public ListNode swapPairs3(ListNode head) {
	        if (null == head || head.next == null)
	            return head;
	       ListNode next = head.next;
	       head.next = swapPairs3(head.next.next);
	       next.next = head;
	       return next;
	    }
}
