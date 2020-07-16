package com.billkalin.geektime.chapters._41_dp_second;

public class LeastCoinCount {

    public static void main(String[] args) {
        int money = 9;
        int[] coins = new int[]{2, 3, 5};
        MoneyCoinCount(0, 0, coins, money);
//        mCurrMinCount = MoneyCoinCount2(money);
        int count = MoneyCoinCount2(money, coins);

        System.out.println("main: money = " + money + " & count = " + mCurrMinCount + " & count = " + count);
    }

    private static int mCurrMinCount = Integer.MAX_VALUE;
    private static boolean[][] mem = new boolean[9 + 1][9 + 1];

    //回溯法
    private static void MoneyCoinCount(int cMoney, int cCount, int[] coins, int money) {
        if (cMoney == money) {
            if (mCurrMinCount > cCount) {
                mCurrMinCount = cCount;
            }
            System.out.println("MoneyCoinCount: money = " + money + " & count = " + cCount);
            return;
        }

        for (int i : coins) {
            if (i + cMoney <= money) {
                MoneyCoinCount(cMoney + i, cCount + 1, coins, money);
            }
        }
    }

    private static int MoneyCoinCount2(int money) {
        int[] dp = new int[money + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 1;
        //状态转移方程：dp[i] = count。i代表钱的数值，count代表这个money使用1、3、5需要最少的金币数量
        for (int i = 6; i <= money; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 3]), dp[i - 5]) + 1;
        }
        return dp[money];
    }

    private static int MoneyCoinCount2(int money, int[] coins) {
        int[] dp = new int[money + 1];
        for (int i = 1; i <= money; i++) {
            dp[i] = money;//初始化
        }

        dp[0] = 0;
        for (int coin : coins) {
            if (coin > money) {
                continue;
            }
            for (int j = coin; j <= money; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[money];
    }
}
