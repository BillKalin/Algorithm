package com.billkalin.leetcode;

public class LeetCode67 {
    public String addBinary(String a, String b) {
        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }

            sum += carry;
            carry = sum / 2;
            stringBuilder.append(sum % 2);
            i--;
            j--;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }
}
