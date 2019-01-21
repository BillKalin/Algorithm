package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode21 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (null == l1 && null == l2)
	            return null;
	        ListNode ret = new ListNode(0);
	        ListNode head = ret;
	        ListNode p = l1, q = l2;
	        while(p != null && q != null) {
	            int val = 0;
	             if (p.val >= q.val) {
	                val = q.val;
	                q = q.next;
	            } else {
	                val = p.val;
	                p = p.next;
	            }
	            ListNode curr = new ListNode(val);
	            head.next = curr;
	            head = curr;
	        }
	    
	        while(p != null) {
	            ListNode curr = new ListNode(p.val);
	                head.next = curr;
	                head = curr;
	                p = p.next;
	        }
	        
	        while(q != null) {
	            ListNode curr = new ListNode(q.val);
	                head.next = curr;
	                head = curr;
	                q = q.next;
	        }
	        
	        return ret.next;
	    }
}
