package com.billkalin.leetcode;

public class LeetCode61 {

    public Leetcode2.ListNode rotateRight(Leetcode2.ListNode head, int k) {
        if (head == null)
            return head;
        Leetcode2.ListNode cHead = head;
        int length = 1;
        while (cHead.next != null) {
            cHead = cHead.next;
            length++;
        }
        //收尾相连，形成单循环链
        cHead.next = head;
        //从头开始遍历
        //如果length > k, 那就需要遍历i=length - k个节点
        //如果length < k, 那就需要遍历i = length - k%length个节点
        for (int i = length - k % length; i > 1; i--) {
            head = head.next;
        }
        //断开尾部
        cHead = head.next;
        head.next = null;
        return cHead;
    }
}
