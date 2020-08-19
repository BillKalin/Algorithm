package com.billkalin.leetcode;

import java.util.Arrays;

public class LeetCode322 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        int amount = 100;
        int count = coinChange2(nums, amount);
        System.out.println(Arrays.toString(nums) + " amount " + amount + " & count = " + count);
    }

    //回溯法，这个超时了
    public static int coinChange(int[] coins, int amount) {
        coinChange(coins, amount, 0);
        if (mMinCount == Integer.MAX_VALUE)
            return -1;
        return mMinCount;
    }

    private static int mMinCount = Integer.MAX_VALUE;

    public static void coinChange(int[] coins, int amount, int currAmount) {
        if (amount < 0)
            return;
        if (0 == amount) {
            mMinCount = Math.min(mMinCount, currAmount);
            return;
        }
        for (int coin : coins) {
            coinChange(coins, amount - coin, currAmount + 1);
        }
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    //备忘录方法
    public static int coinChange(int[] coins, int amount, int[] mem) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem[amount - 1] != 0) return mem[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChange(coins, amount - coin, mem);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        mem[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount - 1];
    }

    //动态规划
    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int coin : coins) {
            if (coin <= amount) {//这里需要注意可能金币的额度比要amount都大
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= amount - i) {//这里不能写coin+i<=amount,因为有coin+i就溢出
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
