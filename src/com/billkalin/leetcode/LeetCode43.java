package com.billkalin.leetcode;

public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0)
            return num2;
        if (num2 == null || num2.length() == 0)
            return num2;

        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + ans[p2];
                ans[p1] += sum / 10;
                ans[p2] = sum % 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : ans) {
            if (!(stringBuilder.length() == 0 && num == 1)) {
                stringBuilder.append(num);
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
