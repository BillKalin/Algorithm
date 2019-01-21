package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0)
            return 0;
        
        int ret = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                j = Math.max(j, map.get(c)+1);
            }
            ret = Math.max(ret ,i-j+1);
            map.put(c, i);
        }
        return ret;
    }
}
