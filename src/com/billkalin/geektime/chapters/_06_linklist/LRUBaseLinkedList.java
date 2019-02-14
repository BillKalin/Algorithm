package com.billkalin.geektime.chapters._06_linklist;

/**
 * 基于单链表LRU算法（java）
 */
public class LRUBaseLinkedList<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	private Node<T> head;
	private int capacity;
	private int size;
	
	public LRUBaseLinkedList() {
		head = new Node<>();
		capacity = 10;
		size = 0;
	}
	
	public void add(T data) {
		Node<T> preNode = findPre(data);
		if (null != preNode) {
			delete(preNode);
			addAtBegin(data);
		} else {
			if (size >= capacity) {
				deleteAtEnd();
			}
			addAtBegin(data);
		}
	}
	
	//头部插节点
	public void addAtBegin(T data) {
		Node<T> newNode = new Node<T>(data);
		Node<T> next = head.next;
		newNode.next = next;
		head.next = newNode;
		size ++;
	}
	
	public void delete(Node<T> preNode) {
		Node<T> temp = preNode.next;
		preNode.next = temp.next;
		temp = null;
		size --;
	}
	
	//删除尾部节点
	public void deleteAtEnd() {
		Node<T> node = head;
		if (node.next == null) {
			return;
		}
		//倒数第二个结点
		while(node.next.next != null) {
			node = node.next;	
		}
		
		Node<T> next = node.next;
		node.next = null;
		next = null;
		
		size --;
	}
	
	//查找指定元素的前一个结点
	public Node<T> findPre(T data) {
		Node<T> pre = head;
		while(pre.next != null) {
			if (data.equals(pre.next.data))
				return pre;
			pre = pre.next;
		}
		return null;
	}
	
	private static class Node<T> {
		T data;
		Node<T> next;
		public Node(T t) {
			data = t;
		}
		public Node() {}
	}
}
