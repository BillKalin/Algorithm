package com.billkalin.leetcode;

import java.util.Stack;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       Stack<Integer> s1 = new Stack<>();
	        Stack<Integer> s2 = new Stack<>();
	        ListNode curr = l1;
	        while(curr != null) {
	            s1.push(curr.val);
	            curr = curr.next;
	        }
	        curr = l2;
	        while(curr != null) {
	            s2.push(curr.val);
	            curr = curr.next;
	        }
	        int carry = 0;
	        ListNode head = null;
	        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
	            int n1 = s1.isEmpty() ? 0: s1.pop();
	            int n2 = s2.isEmpty() ? 0: s2.pop();
	            int sum = n1 + n2 + carry;
	            carry = sum/10;
	            ListNode newNode = new ListNode(sum%10);
	            newNode.next = head;
	            head = newNode;
	        }
	        
	        return head;
	    }
}
