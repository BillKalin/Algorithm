package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;
       int lenA = 0;
       int lenB = 0;
       
       ListNode currA = headA;
       ListNode currB = headB;
        
        while(currA != null) {
            lenA++;
            currA = currA.next;
        }
        
        while(currB != null) {
            lenB++;
            currB = currB.next;
        }
        
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            for(int i=0;i<lenA-lenB;i++) {
                currA = currA.next;
            }
        } else if (lenA < lenB) {
            for(int i=0;i<lenB-lenA;i++) {
                currB = currB.next;
            }
        }
        
        while(currA != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
}
