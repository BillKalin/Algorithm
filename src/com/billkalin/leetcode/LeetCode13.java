package com.billkalin.leetcode;

public class LeetCode13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 常规解法
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int i = 0;
        int num = 0;
        while(i<s.length()) {
            char ch = s.charAt(i);
            if ('C' == ch) {
                if (i+1 < s.length() && 'M' == s.charAt(i+1)) {
                    num += 900;
                    i++;
                } else if (i+1 < s.length() && 'D' == s.charAt(i+1)) {
                    num += 400;
                    i++;
                } else {
                    num += 100;
                }
            } else if ('X' == ch) {
                if (i+1 < s.length() && 'L' == s.charAt(i+1)) {
                    num += 40;
                    i++;
                } else if (i+1 < s.length() && 'C' == s.charAt(i+1)) {
                    num += 90;
                    i++;
                } else {
                     num += 10;
                }
            } else if ('I' == ch) {
                if (i+1 < s.length() && 'V' == s.charAt(i+1)) {
                    num += 4;
                    i++;
                } else if (i+1 < s.length() && 'X' == s.charAt(i+1)) {
                    num +=9;
                    i++;
                } else {
                     num += 1;
                }
            } else if ('M' == ch) {
                num += 1000;
            } else if ('D' == ch) {
                num += 500;
            } else if ('C' == ch) {
                num += 100;
            } else if ('L' == ch) {
                num += 50;
            } else if ('X' == ch) {
                num += 10;
            } else if ('V' == ch) {
                num += 5;
            } else if ('I' == ch) {
                num += 1;
            }
            i++;
        }
        return num;
    }
	
	/**
	 * 先减去特殊组合，I+V = 6，IV = 4，其实是多加了2，
	 * 然后，再挨个字符遍历加对应的数值
	 * @param s
	 * @return
	 */
	public int romanToInt2(String s) {
	     int sum=0;
	    if(s.indexOf("IV")!=-1){sum-=2;}
	    if(s.indexOf("IX")!=-1){sum-=2;}
	    if(s.indexOf("XL")!=-1){sum-=20;}
	    if(s.indexOf("XC")!=-1){sum-=20;}
	    if(s.indexOf("CD")!=-1){sum-=200;}
	    if(s.indexOf("CM")!=-1){sum-=200;}
	    
	    char c[]=s.toCharArray();
	    int count=0;
	    
	   for(;count<=s.length()-1;count++){
	       if(c[count]=='M') sum+=1000;
	       if(c[count]=='D') sum+=500;
	       if(c[count]=='C') sum+=100;
	       if(c[count]=='L') sum+=50;
	       if(c[count]=='X') sum+=10;
	       if(c[count]=='V') sum+=5;
	       if(c[count]=='I') sum+=1;
	       
	   }
	   
	   return sum;
	    
	}
}
