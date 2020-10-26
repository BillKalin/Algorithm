package com.billkalin.leetcode;

import java.util.Stack;

public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String str : path.split("/")) {
            if (str.isEmpty() || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
