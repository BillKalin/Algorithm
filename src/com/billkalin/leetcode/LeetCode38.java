package com.billkalin.leetcode;

public class LeetCode38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {//从1开始计算
            str = getStrForN(str);
        }
        return str;
    }

    private String getStrForN(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char ch = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == ch) {//和当前字符相同则继续计数
                count ++;
            } else {//如果不相等，则加入到字符串序列，count 个 ch，
                // 计数器重新计数，字符重新赋值
                stringBuilder.append(count).append(ch);
                ch = string.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(count).append(ch);
        return stringBuilder.toString();
    }
}
