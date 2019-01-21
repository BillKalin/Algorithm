package com.billkalin.leetcode;

public class LeetCode8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int myAtoi(String str) {
	       if (null == str || str.length() == 0) {
			            return 0;
			        }
			    
			        int i = 0;
			        int num = 0;
			        int sign = 1;
		            while(i < str.length()) {
		              if (str.charAt(i) == ' ')
			            {
			            	i++;
			                continue;
			            } else {
	                      break;
	                    }
		            }
		        
	                if (i < str.length()) {
	                    if (str.charAt(i) == '-') {
	                        sign = -1;
	                         i++;
	                    } else if (str.charAt(i) == '+'){
	                        sign = 1;
	                         i++;
	                    }
	                }
		        
			        while(i < str.length()) {
			            char ch = str.charAt(i);	            
			            if (ch < '0' || ch > '9') {
			                break;
			            }
			            if (num >  Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && ch - '0' > 7)) {
			                if (sign == 1) 
			                    return Integer.MAX_VALUE;
			                else  
			                    return Integer.MIN_VALUE;
			            }
			            num = num*10 + (ch-'0');
			            i++;
			        }
			        
			        return sign * num;
	    }
}
