package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

import java.util.List;

public class LeetCode92 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        int m = 2;
        int n = 4;

        ListNode node = reverseBetween(head, m, n);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;
        ListNode curr = head, pre = null;
        while (m > 1) {
            pre = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = pre, tail = curr;
        ListNode next;
        while (n > 0) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            n--;
        }

        if (null != con) {
            con.next = pre;
        } else {
            head = pre;
        }

        tail.next = curr;

        return head;
    }
}
