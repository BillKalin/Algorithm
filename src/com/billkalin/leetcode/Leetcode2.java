package com.billkalin.leetcode;

public class Leetcode2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ret = new ListNode(0);
        ListNode pre = ret;
        
        int num = 0;
        while(c1 != null || c2 != null || num > 0) {
            int curr = (num + ((c1 == null)?0:c1.val) + ((c2 == null)?0:c2.val));
            int s = curr%10;
            num = curr/10;    
            ListNode node = new ListNode(s);
            pre.next = node;
            pre = node;
            c1 = (null == c1) ? null : c1.next;
            c2 = (null == c2) ? null : c2.next;
        }
        
        //先计算，然后翻转链表
        // ret = reverseNode(ret);
        
        return ret.next;
    }
    
    private ListNode reverseNode(ListNode node) {
        if (node.next == null) {
            return node;    
        }
        
        ListNode root = reverseNode(node.next);
        node.next.next = node;
        node.next = null;
        return root;
    }
}
