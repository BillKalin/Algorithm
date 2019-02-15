package com.billkalin.geektime.chapters._08_stack;

/**
 * 模拟浏览器前进和后退
 *
 */
public class SimpleBrowse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleBrowse browse = new SimpleBrowse();
		browse.forwardNew("a");
		browse.forwardNew("b");
		browse.forwardNew("c");
		browse.print();
		browse.back();
		browse.print();
		browse.forward();
		browse.print();
		browse.back();
		browse.back();
		browse.print();
	}

	private LinkStack<String> mCurr;
	private LinkStack<String> mHistory;
	
	public SimpleBrowse() {
		mCurr = new LinkStack<>();
		mHistory = new LinkStack<>();
	}
	
	public String forwardNew(String page) {
		mCurr.push(page);
		mHistory.clear();
		return mCurr.peek();
	}
	
	public String back() {
		String curr = mCurr.pop();
		mHistory.push(curr);
		return curr;
	}
	
	public String forward() {
		String curr = mHistory.pop();
		if(curr != null) {
			mCurr.push(curr);
		}
		return curr;
	}
	
	public boolean canBack() {
		return mCurr.size()>0;
	}
	
	public boolean canForward() {
		return mHistory.size()>0;
	}
	
	
	public void print() {
		System.out.println("当前还有的页面：");
		mCurr.print();
	}
}
