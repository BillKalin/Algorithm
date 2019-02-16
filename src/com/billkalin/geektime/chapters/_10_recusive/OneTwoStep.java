package com.billkalin.geektime.chapters._10_recusive;

import java.util.HashMap;
import java.util.Map;

public class OneTwoStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneTwoStep instance = new OneTwoStep();
		int ret = instance.climbStaris(10);
		System.out.println("ret = " + ret);
		ret = instance.climbStaris2(10);
		System.out.println("ret = " + ret);
		ret = instance.climbStarisOpt(10);
		System.out.println("ret = " + ret);
	}

	//递归实现爬楼梯问题
	private int climbStaris(int n) {
		if(n == 1 || n == 2)
			return n;
		return climbStaris(n-1) + climbStaris(n-2);
	}
	
	private Map<Integer, Integer> map = new HashMap<>();
	//优化的递归实现爬楼梯问题
	private int climbStarisOpt(int n) {
		if(n == 1 || n == 2)
			return n;
		//已经计算了，就直接返回
		if(map.containsKey(n)) {
			return map.get(n);
		}
		int ret = climbStarisOpt(n-1) + climbStarisOpt(n-2);
		map.put(n, ret);
		return ret;
	}
	
	//非递归方式
	private int climbStaris2(int n) {
		if(n == 1 || n == 2)
			return n;
		int first = 1;
		int second = 2;
		int sum = 0;
		for(int i=3; i<=n; i++) {
			sum = first + second;
			first = second;
			second = sum;
			
		}
		return sum;
	}
}
