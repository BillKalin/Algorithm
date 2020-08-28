package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> retList = new ArrayList<>();
        if (s == null || words == null || s.length() == 0 || words.length == 0 || s.length() < words.length)
            return retList;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordsNum = words.length;
        for (int i = 0; i < s.length() - wordLen * wordsNum + 1; i++) {
            Map<String, Integer> subMap = new HashMap<>();
            int j = 0;
            while (j < wordsNum) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordCount.containsKey(word)) {
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    if (subMap.get(word) > wordCount.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == wordsNum) {
                retList.add(i);
            }
        }
        return retList;
    }
}
