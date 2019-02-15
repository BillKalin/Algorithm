package com.billkalin.geektime.chapters._07_linklist;


/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 */
public class LinkListAlgorithm {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = new Node<Integer>();
		head.data = 0;
		Node<Integer> node1 = new Node<Integer>();
		node1.data = 1;
		Node<Integer> node2 = new Node<Integer>();
		node2.data = 2;
		
		head.next = node1;
		node1.next = node2;
		
		LinkListAlgorithm lla = new LinkListAlgorithm();
		lla.printNode(head);
		
		Node<Integer> reverseHead = lla.reverseLinkList(head);
		System.out.print("翻转链表：");
		lla.printNode(reverseHead);
		
//		node2.next = head;
//		boolean isCycle = lla.checkCycle(head);
//		System.out.print("是否有环：" + isCycle);
		
//		Node<Integer> head1 = new Node<Integer>();
//		head1.data = 0;
//		Node<Integer> node11 = new Node<Integer>();
//		node11.data = 1;
//		Node<Integer> node21 = new Node<Integer>();
//		node21.data = 2;
//		
//		head1.next = node11;
//		node11.next = node21;
//		
//		lla.printNode(head1);
		
//		Node<Integer> mergedNode = lla.mergeLinkList(head, head1);
//		System.out.print("合并后的链表:");
//		lla.printNode(mergedNode);
		
//		Node<Integer> node = lla.getMiddleNode(head);
//		System.out.println("中间节点：" + node.data);
		
//		int k = 3;
//		System.out.print("删除倒数第:" + k + "个结点：");
//		head = lla.removeKNode(head, k);
//		lla.printNode(head);
	}
	
	//单链表翻转
	private <T> Node<T> reverseLinkList(Node<T> head) {
		if (head == null)
			return head;
//		//递归方法翻转
//		if (head == null || head.next == null)
//			return head;
//		Node<T> ret = reverseLinkList(head.next);
//		head.next.next = head;
//		head.next = null;
//		return ret;
		
		//不带头结点的翻转
//		Node<T> curr = head;
//		Node<T> pre = null;
//		Node<T> next = null;
//		
//		while(curr != null) {
//			next = curr.next;
//			curr.next = pre;
//			pre = curr;
//			curr = next;
//		}
//		return pre;
		
		//带头结点的翻转
		Node<T> fakeHead = new Node<T>();
		fakeHead.next = head;
		
		Node<T> curr = head.next;
		head.next = null;
		Node<T> next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = fakeHead.next;
			fakeHead.next = curr;
			curr = next;
		}
		
		return fakeHead.next;
	}
	
	//链表中环的检测
	private <T> boolean checkCycle(Node<T> head) {
		if (head == null)
			return false;
		Node<T> slow = head;
		Node<T> fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	//两个有序的链表合并
	private <T extends Comparable<T>> Node<T> mergeLinkList(Node<T> left, Node<T> right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		Node<T> head = null;
		Node<T> lh = left;
		Node<T> rh = right;
		if (lh.data.compareTo(rh.data) < 0) {
			head = lh;
			lh = lh.next;
		} else {
			head = rh;
			rh = rh.next;
		}
		
		Node<T> r = head;
		
		while(lh != null && rh != null) {
			if (lh.data.compareTo(rh.data) < 0) {
				r.next = lh;
				lh = lh.next;
			} else {
				r.next = rh;
				rh = rh.next;
			}
			r = r.next;
		}
		
		if (lh != null) {
			r.next = lh;
		}
		
		if (rh != null) {
			r.next = rh;
		}
		
		return head;
	}
	
	//删除链表倒数第n个结点
	private <T> Node<T> removeKNode(Node<T> head, int k) {
		if (head == null)
			return head;
		Node<T> fast = head;
		int i = 1;
		while(fast != null && i < k) {
			fast = fast.next;
			i++;
		}
		
		if (null == fast)
			return head;
		
		Node<T> slow = head;
		Node<T> pre = null;
		while(fast.next != null) {
			fast = fast.next;
			pre = slow;//保存要删除结点的前一个结点
			slow = slow.next;
		}
		
		if (pre == null) {//删除头结点
			head = head.next;
		} else {//删除指定结点
			pre.next = pre.next.next;
		}
		return head;
	}
	
	//求链表的中间结点
	private <T> Node<T> getMiddleNode(Node<T> head) {
		if (head == null)
			return null;
		Node<T> slow = head;
		Node<T> fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static class Node<T> {
		T data;
		Node<T> next;
	}
	
	 <T> void printNode(Node<T> head) {
		if (head == null) {
			System.out.println("linklist is empty");
			return;
		}
		
		Node<T> curr = head;
		while(curr != null) {
			System.out.print(curr.data + ",");
			curr = curr.next;
		}
		
		System.out.println("");
	}
}
