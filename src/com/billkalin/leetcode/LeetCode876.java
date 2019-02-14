package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode876 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public ListNode middleNode(ListNode head) {
	        if (null == head || head.next == null)
	            return head;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;        
	        }
	    
	        // if (fast != null) {
	        //     slow = slow.next;
	        // }
	        
	        return slow;
	    }
}
