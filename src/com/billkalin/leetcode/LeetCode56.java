package com.billkalin.leetcode;

import java.util.*;

public class LeetCode56 {

    //先按start排序，然后以end判断是否在区间内
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] item : intervals) {
            if (item[0] > end) {
                ret.add(new int[]{start, end});
                start = item[0];
                end = item[1];
            } else {
                end = Math.max(end, item[1]);
            }
        }

        ret.add(new int[]{start, end});

        return ret.toArray(new int[0][]);
    }

}
