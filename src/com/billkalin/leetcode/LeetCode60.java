package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode60 {
    //https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factors = new int[n + 1];
        factors[0] = 1;
        for (int i = 1; i <= n; i++) {
            factors[i] = i * factors[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factors[n - i];
            stringBuilder.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factors[n - i];
        }

        return String.valueOf(stringBuilder);
    }
}
