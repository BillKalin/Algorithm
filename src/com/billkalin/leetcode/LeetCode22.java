package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public List<String> generateParenthesis(int n) {
	        List<String>  retList = new ArrayList<String>();
	        helper(retList, "", 0, 0, n);
	        return retList;
	    }
	    
	    private void helper(List<String>  retList, String curr, int open, int close, int max) {
	        if (curr.length() == max * 2) {
	            retList.add(curr);
	            return;
	        }
	        
	        if (open < max) {
	            helper(retList, curr+"(", open+1, close, max);
	        }
	        
	        if (close < open) {
	             helper(retList, curr+")", open, close+1, max);
	        }
	    }
}
