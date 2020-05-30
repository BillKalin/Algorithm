package com.billkalin.geektime.chapters._32_strings_match;

public class BmStringsMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String main = "abcde";
		String sub = "de";

		int isA = BmMatch(main.toCharArray(), sub.toCharArray());
		System.out.print("isA = " + isA);
	}
         
	/**
	 * BM 匹配字符算法
	 * 
	 * @param main
	 * @param sub
	 * @return
	 */
	public static int BmMatch(char[] main, char[] sub) {
		int m = sub.length;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		int n = main.length;
		int[] badArray = new int[256];
		int[] goodSuffix = new int[m];
		boolean[] prefix = new boolean[m];
		int i = 0;
		int j = 0;
		calBadArray(sub, badArray, m);
		getGoodSuffix(sub, m, goodSuffix, prefix);
		while (i <= n - m) {
			// 从后往前匹配
			j = m - 1;
			while (j >= 0 && sub[j] == main[i + j]) {
				j--;
			}

			if (j < 0)
				return i;

			int badIndex = (j - badArray[(int) main[i + j]]);
			int goodindex = 0;
			if (j < m - 1) {
				goodindex = getGoodSuffixIndex(j, m, goodSuffix, prefix);
			}
			i = i + Math.max(badIndex, goodindex);

		}

		return -1;
	}

	/**
	 * 计算坏字符
	 * 
	 * @param sub
	 * @param badArray
	 */
	private static void calBadArray(char[] sub, int[] badArray, int m) {
		for (int i = 0; i < badArray.length; i++) {
			badArray[i] = -1;
		}

		for (int j = 0; j < m; j++) {
			int ch = (int) sub[j];
			badArray[ch] = j;
		}
	}

	/**
	 * 计算好后缀字符串
	 * 
	 * @param sub
	 * @param m
	 * @param goodSuffix
	 * @param refix
	 */
	private static void getGoodSuffix(char[] sub, int m, int[] goodSuffix, boolean[] prefix) {
		for (int i = 0; i < m; i++) {
			prefix[i] = false;
			goodSuffix[i] = -1;
		}
		for (int i = 0; i < m-1; i++) {
			int k = 0;
			int j = i;
			while (j >= 0 && sub[j] == sub[m - 1 - k]) {
				j--;
				k++;
				goodSuffix[k] = j + 1;
			}

			if (j == -1) {
				prefix[k] = true;
			}
		}
	}

	private static int getGoodSuffixIndex(int j, int m, int[] goodSuffix, boolean[] prefix) {
		int k = m - 1 - j;// 好后缀的长度
		if (goodSuffix[k] != -1)
			return j - goodSuffix[k] + 1;
		for (int r = j + 2; r <= m - 1; r++) {
			if (prefix[m - r]) {
				return r;
			}
		}
		return m;
	}

}
