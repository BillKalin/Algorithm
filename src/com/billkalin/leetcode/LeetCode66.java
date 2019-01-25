package com.billkalin.leetcode;

public class LeetCode66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[]{1};
//         int carry=(digits[digits.length-1]+1)/10;
//         if (carry==0) {
//             digits[digits.length-1] = digits[digits.length-1]+1;
//             return digits;
//         }
//         digits[digits.length-1] = (digits[digits.length-1]+1)%10;
//         for(int i=digits.length-2;i>=0;i--) {
//             carry = digits[i]+carry;
//              digits[i] = carry % 10;
          
//             if (carry / 10 == 0) {
//                    carry = carry / 10;
//                 break;
//             }
//                carry = carry / 10;
//         }
        
//         if (carry > 0) {
//             int[] newNum = new int[digits.length+1];
//             newNum[0] = 1;
//             digits = newNum;
//         }
        int n = digits.length;
        for (int i=n-1;i>=0;i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[n+1];
        newNum[0] = 1;
        return newNum;
    }
}
