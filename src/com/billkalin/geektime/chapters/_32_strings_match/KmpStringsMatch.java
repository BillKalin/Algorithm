package com.billkalin.geektime.chapters._32_strings_match;

public class KmpStringsMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String main = "abcdeabfabcdeabc";
		String sub = "abcdeabc";

		int isA = kmp(main.toCharArray(), main.length(), sub.toCharArray(), sub.length());
		System.out.print("isA = " + isA);
	}

	private static int kmp(char[] main, int n, char[] sub, int m) {
		int[] next = getNext(sub, m);
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j > 0 && main[i] != sub[j]) {
				j = next[j - 1] + 1;
			}

			if (main[i] == sub[j]) {
				j ++;
			}

			if (j == m)
				return i - m + 1;
		}

		return -1;
	}

	private static int[] getNext(char[] sub, int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;

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
