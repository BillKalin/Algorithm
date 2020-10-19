package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};
        List<int[]> ret = new ArrayList<>();
        for (int[] item : intervals) {
            if (newInterval == null || item[1] < newInterval[0]) {
                ret.add(item);
            } else if (item[0] > newInterval[1]) {
                ret.add(newInterval);
                ret.add(item);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(item[0], newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
        }

        if (newInterval != null) {
            ret.add(newInterval);
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
