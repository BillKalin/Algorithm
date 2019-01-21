package com.billkalin.leetcode;

public class LeetCode14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	   public String longestCommonPrefix(String[] strs) {
	        if (null == strs || strs.length == 0)
	            return "";
	        // StringBuilder sb = new StringBuilder("");
//	         Arrays.sort(strs);
//	         char[] first = strs[0].toCharArray();
//	         char[] last = strs[strs.length - 1].toCharArray();
//	         for(int i=0;i<first.length;i++) {
//	             if(first[i] == last[i]) {
//	                 sb.append(first[i]);
//	             } else {
//	                 break;
//	             }
//	         }
	        String pre = strs[0];
	        for(int i=1;i<strs.length;i++) {
	            while(strs[i].indexOf(pre) != 0) {
	                pre = pre.substring(0, pre.length() - 1);
	                if (pre.isEmpty()) {
	                    return "";
	                }
	            }
	        }
	        return pre;
	    }
}
