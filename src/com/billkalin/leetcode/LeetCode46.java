package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ret;
        permute(nums, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void permute(int[] nums,
                         List<Integer> list,
                         List<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            permute(nums, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
