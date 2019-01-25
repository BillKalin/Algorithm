package com.billkalin.leetcode;

public class LeetCode415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addStrings(String num1, String num2) {
        if(null == num1 || num1.length() == 0)
            return num2;
         if(null == num2 || num2.length() == 0)
            return num1;
        int n1 = num1.length();
        int n2 = num2.length();
        int i=n1-1;
        int j = n2-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0|| carry>0) {
             n1 = i>=0 ? num1.charAt(i) - '0':0;
             n2 = j>=0 ? num2.charAt(j) - '0':0;
            carry += n1+n2;
            sb.append(carry%10);
            carry = carry/10;;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
