package com.billkalin.geektime;

/**
 * 字符串匹配算法
 * @author Administrator
 *
 */
public class StringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mainStr = "abcacabdc";
		String subStr = "cabdc";
		char[] main = mainStr.toCharArray();
		char[] sub = subStr.toCharArray();
		boolean isBfMath = bfMatch(main, main.length, sub, sub.length);
		boolean rkMatch = rkMatch(main, main.length, sub, sub.length);
		boolean isBmMatch = bmMatch(main, main.length, sub, sub.length);
		boolean isKpmMatch = isKMPMatch(main, main.length, sub, sub.length);
	}

	// 暴力算法(BF)
	private static boolean bfMatch(char[] main, int n, char[] sub, int m) {
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (main[i] == sub[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		if (j == m) {
			return true;
		}
		return false;
	}

	//RK算法
	private static boolean rkMatch(char[] main, int n, char[] sub, int m) {
		int[] hashArray = new int[n - m + 1];
		int subHash = 0;
		//计算模式串的hash值
		for (int j=0;j<m;j++) {
			subHash += (sub[j]-'a') * (int) Math.pow(26, (m - 1 - j));
		}
		//计算主串的子串hash值
		for (int i=0;i<n-m+1;i++) {
			if (i == 0) {
				int ret = 0;
				for (int j=0;j<m;j++) {
					ret += (main[j]-'a') * (int) Math.pow(26, (m - 1 - j));
				}
				hashArray[i] =  ret;
			} else {
				hashArray[i] = (hashArray[i-1] - (int) Math.pow(26, (m - 1))*(main[i-1]-'a'))*26 + (main[i+m-1] - 'a');
			}
		}
		//比较hash值
		for (int i=0;i<hashArray.length;i++) {
			if (subHash == hashArray[i]) {
				return true;
			}
		}
		return false;
	}
	
	// BM算法
	private static boolean bmMatch(char[] main, int n, char[] sub, int m) {
		// 坏字符
		int[] bc = new int[256];
		initBadChar(sub, m, bc);
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		// 好后缀
		initGoodSuffix(sub, m, suffix, prefix);
		int i = 0;
		while (i < n - m) {
			int j;
			for (j = m - 1; j >= 0; j--) {
				if (main[i + j] != sub[j]) {
					break;
				}
			}
			if (j < 0) {
				return true;
			}
			int nextStart = i + j - bc[main[i + j]];
			int nextGoodStart = 0;
			if (j < m - 1)
				nextGoodStart = moveGoodSuffix(j, m, suffix, prefix);
			i = Math.max(nextStart, nextGoodStart);
		}
		return false;
	}

	private static void initBadChar(char[] sub, int m, int[] bc) {
		for (int i = 0; i < m; i++) {
			char ch = sub[i];
			bc[ch] = i;
		}
	}

	private static void initGoodSuffix(char[] sub, int m, int[] suffix, boolean[] prefix) {
		for (int i = 0; i < m; i++) {
			suffix[i] = -1;
			prefix[i] = false;
		}

		for (int i = 0; i < m - 1; i++) {
			int k = 0;
			int j = i;
			while (j >= 0 && sub[j] == sub[m - k - 1]) {
				j--;
				k++;
				suffix[k] = j + 1;
			}
			if (j == -1) {
				prefix[k] = true;
			}
		}
	}

	private static int moveGoodSuffix(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j;
		if (suffix[k] != -1) {
			return suffix[k];
		}
		for (int r = j + 2; r < m; r++) {
			if (prefix[m - r]) {
				return r;
			}
		}
		return m;
	}

	// KMP算法
	public static boolean isKMPMatch(char[] main, int n, char[] sub, int m) {
		int i = 0;
		int j = 0;
		int[] nextArray = getNextArray(sub, m);
		for (i = 0; i < n; i++) {
			while (j > 0 && main[i] != sub[j]) {
				j = nextArray[j - 1] + 1;
			}

			if (main[i] == sub[j]) {
				j++;
			}

			if (j == m) {
				return true;
			}
		}
		return false;
	}

	private static int[] getNextArray(char[] sub, int m) {
		int[] next = new int[m];
		int k = -1;
		next[0] = -1;
		for (int i = 1; i < m; i++) {
			while (k != -1 && sub[k + 1] != sub[i]) {
				k = next[k];
			}

			if (sub[k + 1] == sub[i]) {
				k++;
			}
			next[i] = k;
		}
		return next;
	}
}
