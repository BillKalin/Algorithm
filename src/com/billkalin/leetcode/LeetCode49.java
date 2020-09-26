package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {

    //字符串字母相同，只是字母的位置不同，那就对每个排序，
    // 得到字符串相同的作为一组,用Map来存储
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            String keyStr = String.valueOf(chars);
            List<String> list = map.getOrDefault(keyStr, new ArrayList<String>());
            list.add(str);
            map.put(keyStr, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    //使用计数，因为是由字母组成，那么可以计算每个字符串的出现次数，然后作为key进行存储
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = new char[26];
            for (char c : str.toCharArray()) {
                ch[c - 'a']++;
            }
            String key = String.valueOf(ch);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
