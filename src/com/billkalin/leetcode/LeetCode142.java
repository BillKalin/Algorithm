package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
        if (null == head || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {//找到环了
                ListNode temp = head;
                while(temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        
//         if (slow == null || fast.next == null)
//             return null;
        
//         ListNode p = head;
//         ListNode s = slow;
//         while(p != s) {
//             p = p.next;
//             s = s.next;
//         }
        return null;
    }
}
