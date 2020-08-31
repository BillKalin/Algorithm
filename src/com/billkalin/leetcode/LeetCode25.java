package com.billkalin.leetcode;

public class LeetCode25 {
    public static void main(String[] args) {
        Leetcode2.ListNode head = new Leetcode2.ListNode(1);
        Leetcode2.ListNode node1 = new Leetcode2.ListNode(2);
        Leetcode2.ListNode node2 = new Leetcode2.ListNode(3);
        Leetcode2.ListNode node3 = new Leetcode2.ListNode(4);
        Leetcode2.ListNode node4 = new Leetcode2.ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Leetcode2.ListNode fake = reverseKGroup2(head, 3);

        while (fake != null) {
            System.out.print(fake.val + ",");
            fake = fake.next;
        }
    }

    public static Leetcode2.ListNode reverseKGroup(Leetcode2.ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        Leetcode2.ListNode fakeHead = new Leetcode2.ListNode(-1);
        fakeHead.next = head;
        Leetcode2.ListNode begin = fakeHead;
        int n = 0;
        while (head != null) {
            n++;
            if (n % k == 0) {//反转begin ，begin+k的链表，返回头节点
                begin = reverseNode(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return fakeHead.next;
    }

    private static Leetcode2.ListNode reverseNode(Leetcode2.ListNode begin, Leetcode2.ListNode end) {
        Leetcode2.ListNode curr = begin.next;
        Leetcode2.ListNode pre = begin, next;
        Leetcode2.ListNode first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        begin.next = pre;
        first.next = curr;
        return first;
    }

    //递归方法
    public static Leetcode2.ListNode reverseKGroup2(Leetcode2.ListNode head, int k) {
        int count = 0;
        Leetcode2.ListNode curr = head;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {//如果满足要翻转的数量
            curr = reverseKGroup2(curr, k);
            while (count-- > 0) {//翻转head 到 curr的节点
                Leetcode2.ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }

        return head;
    }
}
