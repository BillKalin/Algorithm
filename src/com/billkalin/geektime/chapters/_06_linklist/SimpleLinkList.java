package com.billkalin.geektime.chapters._06_linklist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 */
public class SimpleLinkList {

	public static void main(String[] args) {
		SimpleLinkList link = new SimpleLinkList(); 
	        //int data[] = {1};
	        //int data[] = {1,2};
	        //int data[] = {1,2,3,1};
	        //int data[] = {1,2,5};
	        //int data[] = {1,2,2,1};
	       // int data[] = {1,2,5,2,1};
	        int data[] = {1,2,5,3,1};

	        for(int i =0; i < data.length; i++){
	            //link.insertToHead(data[i]);
	            link.insertTail(data[i]);
	        }
	       // link.printAll();
	       // Node p = link.inverseLinkList_head(link.head);
	       // while(p != null){
	       //     System.out.println("aa"+p.data);
	       //     p = p.next;
	       // }

	        System.out.println("打印原始:");
	        link.printAll();
	        if (link.palindrome()){
	            System.out.println("回文");
	        } else {
	            System.out.println("不是回文");
	        }
	}

	/**
	 * 判断是否是回文字符串
	 * @return
	 */
	public boolean palindrome() {
		if (null == head)
			return false;
		if (head.next == null)
			return true;
		//使用快慢指针
		Node slow = head;
		Node fast = head;
		Node pre = null;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			//翻转前半部分
			Node next = slow.next;
			slow.next = pre;
			pre = slow;
			
			slow = next;
		}
		
		
		if (fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if (slow.data != pre.data) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}
		
		return true;
	}
	
	private Node reverseNode(Node node) {
		Node pre = null;
		Node curr = head;
		Node next = null;
		
		while(curr != node) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		curr.next = pre;
		
		return curr;
	}
	
	private Node reverseNodeWithHead(Node node) {
		Node hhead = new Node();
		hhead.next = node;
		
		Node curr = node.next;
		node.next = null;
		
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = hhead.next;
			hhead.next = curr;
			curr = next;
		}
		
		return hhead;
	}
	
	 public void printAll() {
	    Node p = head;
	    while (p != null) {
	       System.out.print(p.data + " ");
	       p = p.next;
	    }
	    System.out.println();
	 }
	
	private Node head;
	
	public Node find(int value) {
		if (null == head)
			return null;
		Node node = head;
		while(node != null) {
			if (node.data == value)
				return node;
			node = node.next;
		}
		return null;
	}
	
	public void insertToHead(int value) {
		Node newNode = new Node(value);
		insertToHead(newNode);
	}
	
	public void insertToHead(Node newNode) {
		if (null == head) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	 //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }
	
	public void deleteByValue(int value) {
		if (null == head)
			return;
		Node curr = head;
		Node pre = null;
		while(curr != null && curr.data != value) {
			pre = curr;
			curr = curr.next;
		}
		
		if(null == curr)
			return;
		
		if (pre == null) {
			head = head.next;
		} else {
			pre.next = pre.next.next;
		}
	}
	
	public void insertBefore(Node p, int value) {
		Node newNode = new Node(value);
		insertBefore(p, newNode);
	}
	
	public void insertBefore(Node p, Node newNode) {
		if (p == null)
			return;
		if (p == head) {
			insertToHead(newNode);
			return;
		}
		
		Node curr = head;
		while(curr != null && curr.next != p) {
			curr = curr.next;
		}
		
		if (curr == null)
			return;
		
		newNode.next = p;
		curr.next = newNode;
	}
	
	public void insertAfter(Node p, int value) {
		Node newNode = new Node(value);
		insertAfter(p, newNode);
	}
	
	public void insertAfter(Node p, Node newNode) {
		if (null == p)
			return;
		newNode.next = p.next;
		p.next = newNode;
	}
	
	public void deleteByNode(Node node) {
		if (null == head || node == null)
			return;
		if (node == head) {
			head = head.next;
			return;
		}
		Node curr = head;
		while(curr != null && curr.next != node) {
			curr = curr.next;
		}
		
		if (null == curr)
			return;
		
		curr.next = curr.next.next;
	}
	
	private static class Node {
		int data;
		Node next;
		
		public Node(){}
		public Node(int value) {
			data = value;
		}
	}
	
}
