package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean hasCycle(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;
	        while(slow != null && fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	            if (fast == slow)
	                return true;
	        }
	        return false;
	    }
}
