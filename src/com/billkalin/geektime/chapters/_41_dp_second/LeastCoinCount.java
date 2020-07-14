package com.billkalin.geektime.chapters._41_dp_second;

public class LeastCoinCount {

    public static void main(String[] args) {
        int money = 9;
//        MoneyCoinCount(0, 0, money);
        mCurrMinCount = MoneyCoinCount2(money);

        int[] coins = new int[]{2, 3, 5};
        int count = MoneyCoinCount2(money, coins);

        System.out.println("main: money = " + money + " & count = " + mCurrMinCount + " & count = " + count);
    }

    private static int mCurrMinCount = Integer.MAX_VALUE;
    private static boolean[][] mem = new boolean[9 + 1][9 + 1];

    //回溯法
    private static void MoneyCoinCount(int cMoney, int cCount, int money) {
        if (cMoney == money) {
            if (mCurrMinCount > cCount) {
                mCurrMinCount = cCount;
            }
            System.out.println("MoneyCoinCount: money = " + money + " & count = " + cCount);
            return;
        }

        if (mem[cMoney][cCount]) {
            System.out.println("MoneyCoinCount: money = " + money + " & count = " + cCount + " & cache");
            return;
        }
        mem[cMoney][cCount] = true;

        if (cMoney + 1 <= money) {
            MoneyCoinCount(cMoney + 1, cCount + 1, money);
        }
        if (cMoney + 3 <= money) {
            MoneyCoinCount(cMoney + 3, cCount + 1, money);
        }
        if (cMoney + 5 <= money) {
            MoneyCoinCount(cMoney + 5, cCount + 1, money);
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
            dp[i] = money + 1;//初始化
        }

        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > money) {
                continue;
            }
            for (int j = coins[i]; j <= money; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[money];
    }
}
