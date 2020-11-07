package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> retList = new ArrayList<Integer>();
        retList.add(0);
        for (int i = 0; i < n; i++) {
            int addNumber = 1 << i;
            for (int j = retList.size() - 1; j >= 0; j--) {
                retList.add(retList.get(i) + addNumber);
            }
        }
        return retList;
    }
}
