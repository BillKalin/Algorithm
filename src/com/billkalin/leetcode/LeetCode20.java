package com.billkalin.leetcode;

import java.util.Stack;

public class LeetCode20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public boolean isValid(String s) {
//	 	    if (null == s || s.length()%2 == 1)
//	             return false;
//	         if (s.length() == 0) {
//	             return true;
//	         }
//	         Stack<Character> stack = new Stack<Character>();
//	         for (int i=0;i<s.length();i++) {
//	             char ch = s.charAt(i);
//	             char c = ' ';
//	             switch(ch) {
//	                 case '(':
//	                 case '{':
//	                 case '[':
//	                     stack.push(ch);
//	                     break;
//	                 case ')':
//	                     if (!stack.isEmpty()) {
//	                         c = stack.pop();
//	                         if (c != '(') {
//	                             return false;
//	                         }
//	                     }
//	                     break;
//	                 case '}':
//	                      if (!stack.isEmpty()) {
//	                         c = stack.pop();
//	                          if (c != '{') {
//	                             return false;
//	                         }
//	                      }
//	                     break;     
//	                 case ']':
//	                      if (!stack.isEmpty()) {
//	                         c = stack.pop();
//	                          if (c != '[') {
//	                             return false;
//	                         }
//	                      }
//	                     break;         
//	             }
//	         }
	        
	        
	        Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
	        
	        return stack.isEmpty();
	    }
}
