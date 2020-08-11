package com.billkalin.leetcode;

public class LeetCode84 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int area = largestRectangleArea(arr);
        System.out.println("area = " + area);
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        //寻找第i个元素，左边的第一个小于heights[i]的元素下标
        //寻找第i个元素，右边的第一个小于heights[i]的元素下标
        //最大矩形面积 = 当前高度 * （右边的第一个小于heights[i]的元素下标 - 左边的第一个小于heights[i]的元素下标 - 1）
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = lessFromLeft[j];
            }
            lessFromLeft[i] = j;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j = lessFromRight[j];
            }
            lessFromRight[i] = j;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }
}
