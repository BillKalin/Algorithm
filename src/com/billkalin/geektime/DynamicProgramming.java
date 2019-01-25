package com.billkalin.geektime;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicProgramming instance = new DynamicProgramming();
		int[] coins = {1,3,5};
		int money = 9;
		instance.initCoin(coins, money);
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
	
	 /**
	   * 求出杨晖三角的最短路径
	   *
	   * @param triangles
	   */
	void processTriangle(int[][] triangles) {
		int[][] states = new int[triangles.length][triangles[triangles.length - 1].length];
		int startPoint = triangles.length - 1;
		int maxpoint = triangles[triangles.length - 1].length;
		    
		for (int i=0;i<=startPoint;i++) {
			for (int j=0;j<maxpoint;j++) {
				states[i][j] = -1;
			}
		}
		
		states[0][startPoint] = triangles[0][startPoint];
		for (int i=1;i<=startPoint;i++) {
			int currIndex = 0;
			while(currIndex < maxpoint) {
				if (states[i-1][currIndex] >= 0) {
					int leftValue = states[i-1][currIndex]+triangles[i][currIndex - 1];
					if (states[i][currIndex-1] == -1) {
						states[i][currIndex-1] = leftValue;
					} else if (states[i][currIndex-1] > leftValue) {
						states[i][currIndex-1] = leftValue;
					}
					
					int rightValue = states[i-1][currIndex]+triangles[i][currIndex + 1];
					if (states[i][currIndex + 1] == -1) {
						states[i][currIndex + 1] = rightValue;
					}
					currIndex ++;
				}
				currIndex ++;
			}
		}
		
		int minValue = -1;
		for (int i=0;i<maxpoint;i++) {
			if (minValue > states[startPoint][i] && states[startPoint][i] != -1) {
				minValue = states[startPoint][i];
			}
		}
		
		int outValue = minValue;
		for (int i=startPoint;i>=0;i--) {
			int currIndex = 0;
			while(currIndex < maxpoint) {
				if (states[i][currIndex] == outValue) {
					outValue = outValue - triangles[i][currIndex];
				}
				
				currIndex ++;
			}
		}
	}
	
	void initCoin(int[] coins, int money) {
		int[][] cc = new int[coins.length][money+1];
		for(int i=0;i<coins.length;i++) {
			for (int j=1;j<money+1;j++) {
				if (coins[i] <= j) {
					int col = j - coins[i];
					cc[i][j] = cc[i][col] + 1;
				} else {
					cc[i][j] = cc[i-1][j];
				}
			}
		}
		
		int coin = cc[coins.length-1][money];
	}
}
