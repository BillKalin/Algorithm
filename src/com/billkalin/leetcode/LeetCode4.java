package com.billkalin.leetcode;

public class LeetCode4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int n1 = nums1.length;
	        int n2 = nums2.length;
	        int total = n1 + n2;
	        int[] num = new int[total];
	        int i=0, j = 0, k=0;
	        while(i<n1 && j<n2) {
	            if (nums1[i] < nums2[j]) {
	                num[k++] = nums1[i];
	                i++;
	            } else {
	                num[k++] = nums2[j];
	                j++;
	            }
	        }
	        
	        while(i<n1) {
	            num[k++] = nums1[i];
	            i++;
	        }
	        
	         while(j<n2) {
	            num[k++] = nums2[j];
	            j++;
	        }
	        
	        if (total < 2) {
	            return num[0];
	        } else if (total == 2) {
	             return (num[0]+num[1])/2.0;
	        }
	        
	        if (total> 2 && total % 2 == 0) {
	             return ((num[total/2 - 1] + num[total/2]))/2.0;
	        }
	        return num[total/2];
	    }
	
}
