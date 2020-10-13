package com.billkalin.leetcode;

public class LeetCode121 {
    //动态规划
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return dp[prices.length - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minPrices = Integer.MAX_VALUE;
        int maxNum = 0;
        for (int price : prices) {
            if (price < minPrices) {
                minPrices = price;
            } else if (price - minPrices > maxNum) {
                maxNum = price - minPrices;
            }
        }
        return maxNum;
    }
}
