package com.billkalin.geektime.chapters._35_trietree;

public class TrieTest {

	public static void main(String[] args) {
		TrieTest test = new TrieTest();
		String[] testString = {"h", "he", "hel","hell", "hello"};
		for(String item: testString) {
			test.insert(item.toCharArray());
		}
		
		String t = "he";
		String st = "we";
		
		System.out.println(t + " is exist = " + test.isExists(t.toCharArray()));
		System.out.println(st + " is exist = " + test.isExists(st.toCharArray()));
	}

	private TrieNode root = new TrieNode('/');
	
	void insert(char[] chs) {
		TrieNode p = root;
		for(int i=0;i<chs.length;i++) {
			int index = chs[i] - 'a';
			if(p.children[index] == null) {
				TrieNode node = new TrieNode(chs[i]);
				p.children[index] = node; 
			}
			p = p.children[index];
		}
		p.isEnd = true;
	}
	
	boolean isExists(char[] chs) {
		TrieNode p = root;
		for(int i=0;i<chs.length;i++) {
			int index= chs[i] - 'a';
			if(p.children[index] == null)
				return false;
			p = p.children[index];
		}
		
		if(!p.isEnd)
			return false;
		return true;
	}
	
	private static class TrieNode {
		char ch;
		TrieNode[] children = new TrieNode[26];
		boolean isEnd = false;
		
		public TrieNode(char ch) {
			this.ch = ch;
		}
	}
}
