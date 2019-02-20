package com.billkalin.leetcode;

import java.util.HashSet;
import java.util.Set;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int numComponents(ListNode head, int[] G) {
	        Set<Integer> set = new HashSet<>();
	        for(int i: G) {
	            set.add(i);
	        }
	        int ans = 0;
	        ListNode curr = head;
	        while(curr != null) {
	            if(set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))) {
	                  ans++;
	            }
	         
	            curr = curr.next;
	        }
	        return ans;
	    }
}
