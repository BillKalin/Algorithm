package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
        if (null == head || head.next == null)
            return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode slow = fakeHead;//记录重复结点的前一个
        ListNode fast = slow.next;
        
        while(fast != null) {
        	//查找最后一个重复结点
            while(fast.next != null && fast.val == fast.next.val)    
            {
                fast = fast.next;
            }
            
            if (slow.next != fast) {//重复结点的前一个指向最后一个重复结点的后一个结点
                slow.next = fast.next;
                fast = slow.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        
        return fakeHead.next;
    }
	
	public ListNode deleteDuplicates2(ListNode head) {
        if (null == head || head.next == null)
            return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;//记录重复结点的前一个
        ListNode curr = head;
        
        while(curr != null) {
        	//查找最后一个重复结点
            while(curr.next != null && curr.val == curr.next.val)    
            {
                curr = curr.next;
            }
            
            if (pre.next != curr) {//重复结点的前一个指向最后一个重复结点的后一个结点
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            
            curr = curr.next;
        }
        
        return fakeHead.next;
    }
}
