package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	   public ListNode sortList(ListNode head) {
	        if (null == head || head.next == null)
	            return head;
	        //使用快慢指针进行分割两半
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode pre = null;
	        while(fast != null && fast.next != null) {
	            pre = slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        pre.next = null;
	        
	        ListNode left = sortList(head);
	        ListNode right = sortList(slow);
	        
	        //合并两个子链表
	        return mergeListNode(left, right);
	    }
	    
	    private ListNode mergeListNode(ListNode left, ListNode right) {
	        ListNode ret = new ListNode(0);
	        ListNode curr = ret;
	        while(null != left && null != right) {
	            if (left.val < right.val) {
	                curr.next = left;                
	                left = left.next;
	            } else {
	                 curr.next = right;
	                right = right.next;
	            }
	            curr = curr.next;
	        }
	        
	        if (null != left) {
	            curr.next = left;
	        }
	        
	        if (null != right) {
	            curr.next = right;
	        }
	        
	        return ret.next;
	    }
}
