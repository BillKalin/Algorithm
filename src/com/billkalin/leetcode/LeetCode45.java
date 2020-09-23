package com.billkalin.leetcode;

public class LeetCode45 {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int end = 0;
        //贪心算法，找到i ~ maxpos最大的一个i+nums[i],接着从这个位置继续找
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }

    //从后往前找，从0～postion中找到第一个可以到达的下标，也就是离末尾最远的下标
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }
}
