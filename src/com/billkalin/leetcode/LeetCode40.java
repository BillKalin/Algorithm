package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        resolve(candidates, target, 0, retList, path);
        return retList;
    }

    private void resolve(int[] candidates, int target, int start, List<List<Integer>> retList, List<Integer> path) {
        if (target < 0)
            return;
        if (target == 0) {//正好相等，则添加到结果里面　
            retList.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])//跳过重复的数字计算
                continue;
            path.add(candidates[i]);//添加到这个路径，回溯
            resolve(candidates, target - candidates[i], i + 1, retList, path);
            path.remove(path.size() - 1);
        }
    }
}
