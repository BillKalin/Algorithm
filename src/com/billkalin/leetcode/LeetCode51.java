package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode51 code = new LeetCode51();
		code.solveNQueens(4);
	}

	//https://leetcode.wang/leetCode-51-N-Queens.html
	 public List<List<String>> solveNQueens(int n) {
	        List<List<String>> retList = new ArrayList<>(n);
	        char[][] board = new char[n][n];
	        for(int i=0;i<n;i++) {
	        	for(int j=0;j<n;j++) {
	        		board[i][j] = '.';
	        	}
	        }
	        solveNQueens(board, 0, retList);
	        return retList;
	    }
	    
	 
	 private void solveNQueens(char[][] board, int row, List<List<String>> retList) {
		 if(row == board.length) {
			 retList.add(convert(board));
			 return;
		 }
		 
		 for(int col=0;col<board.length;col++) {
			 if(isOkRow(board, board.length, row, col)) {
				 board[row][col] = 'Q';
				 solveNQueens(board, row+1, retList);
				 board[row][col] = '.';
			 }
		 }
	 }
	 
	 private boolean isOkRow(char[][] board, int n, int row, int col) {
		 int left = col-1, right = col+1;
		 for(int i=row-1;i>=0;i--) {
			 if(board[i][col] == 'Q') {
				 return false;
			 }
			 
			 if(left >= 0 && board[i][left] == 'Q')
				 return false;
			 
			 if(right < n && board[i][right] == 'Q')
				 return false;
			 
			 left --;
			 right ++;
		 }
		 return true;
	 }
	 
	 private List<String> convert(char[][] board) {
		 List<String> rerList = new ArrayList<>();
		 for(int i=0;i<board.length;i++) {
			 String str = new String(board[i]);
			 rerList.add(str);
		 }
		 return rerList;
	 }
}
