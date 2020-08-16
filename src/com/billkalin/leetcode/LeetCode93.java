package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {

    /**
     * BF
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses1(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return list;
        int length = s.length();
        for (int i = 0; i < 4 && i < length - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    String num1 = s.substring(0, i);
                    String num2 = s.substring(i, j);
                    String num3 = s.substring(j, k);
                    String num4 = s.substring(k, length);
                    if (isValidIp(num1) && isValidIp(num2) && isValidIp(num3) && isValidIp(num4)) {
                        list.add(num1 + "." + num2 + "." + num3 + "." + num4);
                    }
                }
            }
        }
        return list;
    }

    private static boolean isValidIp(String str) {
        if (str.length() == 0 || str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0') || Integer.valueOf(str) > 255)
            return false;
        return true;
    }

    /**
     * 回溯法
     */
    public static List<String> restoreIpAddresses2(String s) {
        if (s == null || s.length() < 4 || s.length() > 12)
            return new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
        restore(s, 0, 0, new StringBuilder(), list);
        return list;
    }

    private static void restore(String string, int dotIndex, int index, StringBuilder path, ArrayList<String> result) {
        if (dotIndex > 4 || index > string.length())
            return;
        if (dotIndex == 4 && index == string.length()) {
            result.add(path.toString());
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > string.length())
                break;
            int num = Integer.valueOf(string.substring(index, index + i));
            if (i == 1 || i == 2 && num >= 10 && num <= 99 || i == 3 && num >= 100 && num <= 255) {
                path.append(num);
                if (dotIndex < 3) {
                    path.append(".");
                }
                restore(string, dotIndex + 1, index + i, path, result);
                if (dotIndex < 3) {
                    path.deleteCharAt(path.length() - 1);
                }
                path.delete(path.length() - i, path.length());
            }
        }
    }


}
