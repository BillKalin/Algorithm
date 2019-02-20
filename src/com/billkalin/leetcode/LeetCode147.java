package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode147 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public ListNode insertionSortList(ListNode head) {
	        ListNode fakeHead = new ListNode(0);
	        // fakeHead.next = head;
	        ListNode pre = fakeHead;
	        ListNode curr = head;
	        ListNode next = null;
	        while(curr != null) {
	            next = curr.next;
	            while(pre.next != null && pre.next.val < curr.val) {
	                pre = pre.next;
	            }
	            
	            curr.next = pre.next;
	            pre.next = curr;
	            pre = fakeHead;
	            curr = next;
	        }
	        return fakeHead.next;
	    }
}
