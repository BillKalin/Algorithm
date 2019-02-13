package com.billkalin.leetcode;

import java.util.Stack;

public class LeetCode32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//use dp
	public int longestValidParentheses3(String s) {
		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1;i<s.length();i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i-1) == '(') {
					dp[i] = (i >= 2 ? dp[i-2]:0)+2;
				} else if (i-dp[i-1]>0 && dp[i - dp[i-1] -1] == '(') {
					dp[i] = dp[i-1] + ((i-dp[i-1] >= 2 ? dp[i-dp[i-1] - 2]:0))+2;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
	
	//use stack, time = O(n), space = O(n)
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max  = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
	
	//use two pointer, time = O(n), space = O(1)
	public int longestValidParentheses2(String s) {
        int max  = 0;
        //scan left to right, left track the ( count, right track the ) count,
        //if right > left , right = left = 0,
        //if left == right, max = Math.max(max, left*2);
        int left = 0, right = 0;
        for (int i=0;i<s.length();i++) {
        	if ('(' == s.charAt(i)) {
        		left ++;
        	}
        	
        	if (')' == s.charAt(i)) {
        		right ++;
        	}
        	
        	if (left == right) {
        		max = Math.max(max, 2 * left);
        	} else if (right > left) {
        		left = right = 0;
        	}
        }
        
        left = right = 0;
        
        for(int i=s.length()-1;i>=0;i--) {
        	if ('(' == s.charAt(i)) {
        		left ++;
        	}
        	
        	if (')' == s.charAt(i)) {
        		right ++;
        	}
        	
        	if (left == right) {
        		max = Math.max(max, 2 * left);
        	} else if (right > left) {
        		left = right = 0;
        	}
        }
        return max;
    }
}
