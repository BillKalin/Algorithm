package com.billkalin.leetcode;

public class LeetCode143 {
    public void reorderList(Leetcode2.ListNode head) {
        if(head == null)
            return;
        Leetcode2.ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Leetcode2.ListNode head2 = reverseNode(slow.next);
        slow.next = null;

        Leetcode2.ListNode curr1 = head, curr2 = head2;
        while(curr1!= null && curr2 != null) {
            Leetcode2.ListNode next1 = curr1.next;
            Leetcode2.ListNode next2 = curr2.next;
            curr2.next = next1;
            curr1.next = curr2;
            curr1 = next1;
            curr2 = next2;
        }
    }

    private Leetcode2.ListNode reverseNode(Leetcode2.ListNode node) {
        if (node == null || node.next == null)
            return node;
        Leetcode2.ListNode head = reverseNode(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
