package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)
            return head;
       ListNode curr = head, pre = null;
        while(m > 1) {
            pre = curr;
            curr = curr.next;
            m--;
            n--;
        }
     
        ListNode con = pre, tail = curr;
        ListNode next;
        while(n>0) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            n--;
        }
        
        if(null != con) {
            con.next = pre;
        } else {
            head = pre;
        }
        
        tail.next = curr;
        
        return head;
    }
}
