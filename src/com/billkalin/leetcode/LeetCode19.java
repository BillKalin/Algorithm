package com.billkalin.leetcode;

public class LeetCode19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	  private static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0)
            return head;
        ListNode voidNode = new ListNode(0);
        voidNode.next = head;
        ListNode slow = voidNode;
        ListNode fast = voidNode;
        int i=0;
        while(fast != null && i<=n) {
            fast = fast.next;
            i++;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (null != slow) {
            slow.next = slow.next.next;
        }
        return voidNode.next;
    }
}
