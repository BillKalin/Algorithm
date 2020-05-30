package com.billkalin.geektime.chapters._32_strings_match;

public class BfStringsMatch {

	public static void main(String[] args) {
		String main = "abcde";
		String sub = "de";

		int isA = bfMatch(main.toCharArray(), main.length(), sub.toCharArray(), sub.length());
		System.out.print("isA = " + isA);
	}

	private static int bfMatch(char[] main, int n, char[] sub, int m) {
		int j;
		for (int i = 0; i <= n - m; i++) {
			j = 0;
			while (j < m && main[i + j] == sub[j]) {
				j++;
			}

			if (j == m) {
				return i;
			}
		}

		return -1;
	}
}
