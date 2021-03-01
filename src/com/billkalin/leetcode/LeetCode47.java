package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(nums, new ArrayList<Integer>(), list, new boolean[nums.length]);
        return list;
    }

    private void permuteUnique(int[] nums, List<Integer> path, List<List<Integer>> list, boolean[] used) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteUnique(nums, path, list, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
