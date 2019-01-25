package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public List<String> letterCombinations(String digits) {
	        List<String> retList = new ArrayList<String>();
	        if (null == digits || digits.length() == 0) {
	            return retList;
	        }
	        String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        solution("", keys, digits, 0, retList);
	        return retList;
	    }
	    
	    private void solution(String prefix, String[] keys, String digits, int offset, List<String> ret)     {
	        if (offset >= digits.length()) {
	            ret.add(prefix);
	            return;
	        }    
	        String ch = keys[(digits.charAt(offset) - '0')] ;
	        for (int i=0;i<ch.length();i++) {
	            solution(prefix+ch.charAt(i), keys, digits, offset+1, ret);
	        }
	    }
}
