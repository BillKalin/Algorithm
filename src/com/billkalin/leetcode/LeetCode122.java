package com.billkalin.leetcode;

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int currMax = 0;
        int totalMax = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > prices[i - 1]) {//如果前一个是波峰，加上上一个最大的收益，同时更新实时波谷的值
                totalMax += currMax;
                currMax = 0;
                min = price;
            } else {
                if (price < min) {//找到最低谷
                    min = price;
                } else if (price - min > currMax) {//尝试计算当前收益值
                    currMax = price - min;
                }
            }
        }
        if (currMax > 0) {//这里需要注意，有可能一直涨...
            totalMax += currMax;
        }
        return totalMax;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxNum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxNum += prices[i] - prices[i - 1];
            }
        }
        return maxNum;
    }
}
