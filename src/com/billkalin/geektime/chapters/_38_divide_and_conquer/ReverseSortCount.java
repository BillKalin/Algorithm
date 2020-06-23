package com.billkalin.geektime.chapters._38_divide_and_conquer;

import java.util.Arrays;

/**
 * 利用分治算法计算数组的逆序对数
 */
public class ReverseSortCount {

    public static void main(String[] args) {
        ReverseSortCount sortCount = new ReverseSortCount();
        int[] a = new int[]{1,5,6,2,3,4};
        int count = sortCount.countReverseNumber(a, 0, a.length - 1);
        System.out.println("数组：" + Arrays.toString(a) + " 逆序对数为：" + count);
    }

    private int num = 0;

    private int countReverseNumber(int[] a, int start, int end) {
        num = 0;
        mergeSort(a, start, end);
        return num;
    }

    private void mergeSort(int[] a, int start, int end) {
        if (a == null || a.length == 0 || start >= end)
            return;
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    private void merge(int[] a, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = middle + 1;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                num += (middle - i + 1);//这里从i到middle，都是小于a[j]，个数为(middle - i + )
                temp[k++] = a[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

        for (i = 0; i < temp.length; i++) {
            a[start + i] = temp[i];
        }
    }
}
