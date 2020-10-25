package com.billkalin.leetcode;

public class LeetCode65 {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean hasE = false;//是否有e
        boolean hasNumber = false;//是否有数字
        boolean hasPoint = false;//.标志
        boolean hasNumberAfterE = true;//在e后面要有数字
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                hasNumber = true;
                hasNumberAfterE = true;
            } else if (ch == '.') {
                if (hasPoint || hasE)//不能有多个".",或者有e
                    return false;
                hasPoint = true;
            } else if (ch == 'e') {
                if (!hasNumber || hasE) {//e不能是第一位或者e不能有多个
                    return false;
                }
                hasE = true;
                hasNumberAfterE = false;
            } else if (ch == '-' || ch == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {//-或者+👌不能第一位，只能e后面
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNumber && hasNumberAfterE;
    }
}
