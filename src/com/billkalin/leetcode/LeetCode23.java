package com.billkalin.leetcode;

import com.billkalin.leetcode.Leetcode2.ListNode;

public class LeetCode23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode mergeKLists(ListNode[] lists) {
		 return patiation(lists, 0, lists.length-1);
   }
   
   private static ListNode patiation(ListNode[] lists, int start, int end) {
       if (start == end) return lists[start];
       if (start < end) {
           int mid = (end + start)/2;
           ListNode left = patiation(lists, start, mid);
           ListNode right = patiation(lists, mid+1, end);
           return mergeTwoListNode(left, right);
       }
       return null;
   }
   
   private  static ListNode mergeTwoListNode(ListNode l1, ListNode l2) {
      if(l1==null) return l2;
   if(l2==null) return l1;
   if(l1.val<l2.val){
       l1.next=mergeTwoListNode(l1.next,l2);
       return l1;
   }else{
       l2.next=mergeTwoListNode(l1,l2.next);
       return l2;
   }
   }
   
	
}
