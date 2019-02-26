package com.billkalin.leetcode;

public class LeetCode367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPerfectSquare(int num) {
        int low=1,high=num;
        while(low <= high) {
            long mid =(high + low)>>>1;//这里为啥是long？ 防止溢出
            if(num == mid * mid)
                return true;
            else if(mid * mid > num) {
                high = (int)mid-1;
            } else {
                low = (int)mid+1;
            }
        }
        
        return false;
    }
}
