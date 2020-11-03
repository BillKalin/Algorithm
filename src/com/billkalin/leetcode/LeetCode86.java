package com.billkalin.leetcode;

public class LeetCode86 {
    public Leetcode2.ListNode partition(Leetcode2.ListNode head, int x) {
        //哨兵模式
        Leetcode2.ListNode beforeHead = new Leetcode2.ListNode(0), afterHeader = new Leetcode2.ListNode(0);
        Leetcode2.ListNode before = beforeHead;
        Leetcode2.ListNode after = afterHeader;
        while (head != null) {
            if (head.val < x) {
                before.next = head;//尾插法
                before = head;
            } else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }
        after.next = null;//这里需要断开，否则会出现环
        before.next = afterHeader.next;
        return beforeHead.next;
    }
}
