package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        subsetsWithDup(nums, 0, new ArrayList<Integer>(), list);
        return list;
    }

    private void subsetsWithDup(int[] nums, int index, List<Integer> path, List<List<Integer>> list) {
        list.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDup(nums, i + 1, path, list);
            path.remove(path.size() - 1);
        }
    }
}
