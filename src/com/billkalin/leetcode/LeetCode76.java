package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {

    public String minWindow(String s, String t) {
        //处理边界情况
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = t.length();
        //保存t字符串的所有字符
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0));
        }

        int left = 0, right = 0;//左右指针
        boolean flag = false;//是否包含t的字串
        int minLength = s.length();//初始最小的字串长度
        int minLeft = 0, minRight = 0;//最小字串的左右边界
        while (right < s.length()) {//
            char c = s.charAt(right);
            if (map.containsKey(c)) {//如果包含，那就数量减1，直到为0，
                // 那就是包含t的字串找到列
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count--;
            }
            while (count == 0 && left <= right) {
                int len = right - left + 1;
                flag = true;
                if (len <= minLength) {
                    minLeft = left;
                    minRight = right;
                    minLength = left;
                }

                char ch = s.charAt(left);//开始所见移动左边指针
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) >= 1) {
                        count += 1;
                    }
                }
                left++;
            }
            right++;
        }

        if (flag) {
            return s.substring(minLeft, minRight + 1);
        }

        return "";
    }

}
