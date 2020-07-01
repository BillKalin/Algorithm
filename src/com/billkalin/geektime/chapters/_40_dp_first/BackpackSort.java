package com.billkalin.geektime.chapters._40_dp_first;

public class BackpackSort {
    private static final int MAX_NUM = 6;
    private static final int MAX_WEIGHT = 9;
    private int mCurrMaxW = 0;

    public static void main(String[] args) {

    }

    //回溯法
    private void backpack1(int[] weight, int i, int cw) {
        if (i == MAX_NUM || cw == MAX_WEIGHT) {//全部放进包里，或者达到最大重量
            if (mCurrMaxW < cw) mCurrMaxW = cw;
            return;
        }
        backpack1(weight, i + 1, cw);//不放进背包
        if (cw + weight[i] <= MAX_WEIGHT) {//放进背包
            backpack1(weight, i + 1, cw + weight[i]);
        }
    }

    //行-物品数量，列代表物品重量
    private final boolean[][] sWeight = new boolean[MAX_NUM][MAX_WEIGHT + 1];

    //回溯法 - 备忘录
    private void backpack2(int[] weight, int i, int cw) {
        if (i == MAX_NUM || cw == MAX_WEIGHT) {
            if (cw > mCurrMaxW) {
                mCurrMaxW = cw;
            }
            return;
        }
        if (sWeight[i][cw]) {
            return;
        }
        sWeight[i][cw] = true;
        backpack2(weight, i + 1, cw);
        if (cw + weight[i] <= MAX_WEIGHT) {
            backpack2(weight, i + 1, cw + weight[i]);
        }
    }

    //动态规划 - 表格法
    private int backpack3(int[] weight) {
        sWeight[0][0] = true;
        sWeight[0][weight[0]] = true;
        for (int i = 1; i < MAX_NUM; i++) {
            for (int j = 0; j <= MAX_WEIGHT; j++) {
                if (sWeight[i - 1][j]) {//第i个物品不放入包里
                    sWeight[i][j] = sWeight[i - 1][j];
                }
            }
            for (int j = 0; j <= MAX_WEIGHT - weight[i]; j++) {
                if (sWeight[i - 1][j]) {//第i个物品放入包里
                    sWeight[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = MAX_WEIGHT; i >= 0; i--) {
            if (sWeight[MAX_NUM][i])
                return i;
        }
        return 0;
    }

    //动态规划 - 一维数组
    private final boolean[] states = new boolean[MAX_WEIGHT + 1];

    private int backpack4(int[] weight) {
        states[0] = true;
        if (weight[0] <= MAX_WEIGHT) {
            states[weight[0]] = true;
        }

        for (int i = 1; i < MAX_NUM; i++) {
            for (int j = MAX_WEIGHT - weight[i]; j >= 0; j--) {//注意这里，如果从0开始，会影响后面的计算结果，是错误的
                if (states[j]) {//第i个物品放入包里
                    states[j + weight[i]] = true;
                }
            }
        }

        for (int i = MAX_WEIGHT; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }
}
