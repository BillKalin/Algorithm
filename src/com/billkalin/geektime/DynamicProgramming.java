package com.billkalin.geektime;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/***
	 *  0-1背包问题 回溯法
	 *  @param weight 物品重量集合
	 *  @param curr 当前物品索引
	 *  @param  n 物品总数
	 *  @param cw 当前总重量
	 *  @param w 限定总重量
	 *  备忘录法
	 */
	private int mMaxNum = Integer.MIN_VALUE;
	private boolean[][] mem = new boolean[5][10];
	void precessBackpack(int[] weight, int curr, int n, int cw, int w) {
		if (curr == n || cw == w) {//物品全放进去了，或者已经达到重量限制
			if (cw > mMaxNum) {
				mMaxNum = curr;
			}
			return;
		}
		if (mem[curr][cw]) return;
		mem[curr][cw] = true;
		precessBackpack(weight, curr+1, n, cw, w);//没放进背包
		if (cw + weight[curr] <= w) {//放进背包
			precessBackpack(weight, curr+1, n, cw+weight[curr], w);
		}
	}
	
	/**
	 * 表格法
	 * @param weight
	 * @param curr
	 * @param n
	 * @param cw
	 * @param w
	 * @return
	 */
	int precessBackpack2(int[] weight, int curr, int n, int cw, int w) {
		boolean[][] states = new boolean[n][w+1];
		states[0][0] = true;
		states[0][weight[0]] = true;
		for (int i=1;i<n;i++) {
			//不放进背包
			for (int j=0;j<=w;j++) {
				if (states[i-1][j]) {
					states[i][j] = states[i-1][j];
				}
			}
			//放进背包
			for (int j=0;j<=w-weight[i];j++) {
				if (states[i-1][j]) {
					states[i][j+weight[i]] = true;
				}
			}
		}
		
		for (int i=w;i>=0;i--) {
			if(states[n-1][i]) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * 利用一个数组实现
	 * @param weight
	 * @param curr
	 * @param n
	 * @param cw
	 * @param w
	 * @return
	 */
	int precessBackpack3(int[] weight, int curr, int n, int cw, int w) {
		boolean[] states = new boolean[w+1];
		states[0] = true;
		states[weight[0]] = true;
		for (int i=1;i<n;i++) {
			for (int j=w-weight[i];j>=0;j--) {
				if (states[j]) {
					states[j + weight[i]] = true;
				}
			}
		}
		
		for (int i=w;i>=0;i--) {
			if(states[i]) {
				return i;
			}
		}
		return 0;
	}
	
	
	/***
	 * 背包问题，限制最大重量最大的价值，回溯法
	 */
	private int mMaxValue = 0;
	void precessBackpack4(int[] weight, int[] values, int curr, int n, int cw, int w, int cv) {
		if (curr == n || cw == w) {
			if (mMaxValue < cv) {
				mMaxValue = cv;
			}
			return;
		}
		
		precessBackpack4(weight, values, curr+1, n, cw, w, cv);
		if (weight[curr] + cw <= w) {
			precessBackpack4(weight, values, curr+1, n, cw+weight[curr], w, cv+values[curr]);
		}
	}
	/**
	 * 动态规划算法
	 * @param weight
	 * @param values
	 * @param curr
	 * @param n
	 * @param cw
	 * @param w
	 * @param cv
	 */
	void precessBackpack5(int[] weight, int[] values, int curr, int n, int cw, int w, int cv) {
		int[][] ws = new int[n][w+1];
		for (int i=0;i<n;i++) {
			for (int j=0;j<w+1;j++) {
				ws[i][j] = -1;
			}
		}
		ws[0][0] = 0;
		ws[0][weight[0]] = values[0];
		
		for (int i=1;i<n;i++) {
			for (int j=0;j<=w;j++) {
				if (ws[i-1][j]>=0) {
					ws[i][j] =  ws[i-1][j];
				}
			}
			
			for (int j=0;j<=w-weight[i];j++) {
				if (ws[i-1][j]>=0) {
					int v = ws[i-1][j] + values[i];
					if (v > ws[i-1][j+weight[j]] + values[i]) {
						ws[i][j+weight[j]] = v;
					}
				}
			}
		}
		
		int maxValues = -1;
		for (int i=w;i>=0;i--) {
			if (ws[n-1][i] >= maxValues) {
				maxValues = ws[n-1][i];
			}
		}
	}
}
