package com.billkalin.geektime;

import java.util.Arrays;

/**
 * 回溯算法
 * @author Administrator
 *
 */
public class HuisuAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuisuAlgorithm instance = new HuisuAlgorithm();
		instance.queues(0);
		
		instance.backpacking(new int[]{1,2,3,4, 10, 15}, 0, 0, 10);
		
		String string = "abc?bc";
		String patternStr = "a*bc";
		
		Pattern pattern = new Pattern(patternStr.toCharArray(), patternStr.length()-1);
		boolean isMatch = pattern.isMatch(string.toCharArray(), string.length()-1);
		System.out.println(string + " 是否匹配正则表达式 " + patternStr + " ? " + isMatch);
	}

	/***
	 * 八皇后问题
	 */
	private int[] result = new int[8];
	public void queues(int row) {
		if (row == 8)//所以行都放置完毕 
		{		
			System.out.println("最后的结果是：" + Arrays.toString(result));
			return;
		}
		for(int col=0;col<8;col++) {
			if (isOkRow(row, col)) {
				result[row] = col;
				queues(row + 1);
			}
		}
	}
	
	//检查左上角，当前列，右上角是否存在棋子
	private boolean isOkRow(int row, int col) {
		int left = col - 1;
		int right = col + 1;
		for (int i=row-1;i>=0;i--) {
			if (result[i] == col) {//上一行的第i列是否存在
				return false;
			}
			//左上角、右上角
			if (left >= 0) {
				if (result[i] == left) {
					return false;
				}
			}
			
			if (right < 8) {
				if (result[i] == right) {
					return false;
				}
			}
			
			left --;
			right ++;
		}
		return true;
	}
	
	/***
	 *  0-1背包问题
	 */
	int mMaxNum = Integer.MIN_VALUE;
	public void backpacking(int[] nums, int m, int curr, int weight) {
		if (m == nums.length || curr == weight) {//所有物品装进去了，或者当前最大值等于书包可装的重量
			if (mMaxNum < curr) {
				mMaxNum = curr;
			}
			System.out.println("背包最后能装下的最大值为：" + mMaxNum);
			return;
		}
		
		backpacking(nums, m + 1, curr, weight);
		if (nums[m] + curr <= weight) {
			backpacking(nums, m+1, curr+nums[m], weight);
		}
	}
	
	/**
	 * 正则表达式匹配
	 * 
	 */
	private static class Pattern {
		private boolean isMatch = false;
		private char[] pattern;
		private int pLen;
		
		public Pattern(char[] pattern, int len) {
			this.pattern = pattern;
			this.pLen = len;
		}
		
		public boolean isMatch(char[] chars, int len){
			isMatch = false;
			match(chars, 0, len, 0, pLen);
			return isMatch;
		}
		
		private void match(char[] chars, int i, int len, int pi, int plen) {
			if (isMatch)
				return;
			if (pi == plen) {//正则表达式遍历完
				if (i == len) {//也正好到文本串结尾，那就是匹配的
					isMatch = true;
				}
				return;
			}
			
			if (pattern[pi] == '*') {//当前字符为*，则试试len-plen每个字符
				for (int k=0;k<=len - i;k++) {
					match(chars, i+k, len, pi+1, plen);
				}
			} else if (pattern[pi] == '?') {//字符为？，匹配0/1个字符
				match(chars, i, len, pi+1, plen);
				match(chars, i+1, len, pi+1, plen);
			} else if (i<len && chars[i] == pattern[pi]){//正常字符，则要精确匹配
				match(chars, i+1, len, pi+1, plen);
			}
		}
	}
}
