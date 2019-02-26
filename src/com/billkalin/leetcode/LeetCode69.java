package com.billkalin.leetcode;

public class LeetCode69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public int mySqrt(int x) {
	        if(x <= 0)
	            return 0;
	        int low = 1, high = x, mid = 0, ret = 1;
	        while(low < high) {
	            mid = low +(high - low)/2;
	            if(mid > x/mid) {//防止溢出
	                high = mid;
	            } else {
	                ret = mid;
	                low = mid+1;
	            }
	        }
	        return ret;
	    }
}
