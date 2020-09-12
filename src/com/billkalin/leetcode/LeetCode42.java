package com.billkalin.leetcode;

import java.util.Stack;

public class LeetCode42 {

    //动态规划
    public int trap(int[] height) {
        int ret = 0;
        if (height == null || height.length == 0)
            return ret;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 1; i < size; i++) {
            ret += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ret;
    }

    //双指针
    public int trap2(int[] height) {
        int ret = 0;
        if (height == null || height.length == 0)
            return ret;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ret += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ret += rightMax - height[right];
                right--;
            }
        }
        return ret;
    }

    //使用栈
    public int trap3(int[] height) {
        int ret = 0;
        if (height == null || height.length == 0)
            return ret;
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        while (curr < height.length) {
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = curr - stack.peek() - 1;
                int bheight = Math.min(height[curr], height[stack.peek()]) - height[top];
                ret += (distance * bheight);
            }
            stack.push(curr++);
        }
        return ret;
    }
}
