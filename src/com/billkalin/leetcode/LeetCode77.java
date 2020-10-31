package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(n, k, 1, list, ret);
        return ret;
    }

    private void combine(int n, int k, int start, List<Integer> list, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            combine(n, k - 1, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}
