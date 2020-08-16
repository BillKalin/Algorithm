package com.billkalin.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);
            if (left > 0) {
                map.put(n - left, sum);
            }
            if (right > 0) {
                map.put(n + right, sum);
            }
            map.put(n, sum);
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int max = 0;
        Set<Integer> sets = new HashSet<Integer>();
        for (int n : nums) {
            sets.add(n);
        }
        for (int n : nums) {
            int left = n - 1;
            int right = n + 1;
            while (sets.remove(left)) left--;
            while (sets.remove(right)) right++;
            max = Math.max(max, right - left - 1);
            if (sets.isEmpty())
                return max;
        }
        return max;
    }
}
