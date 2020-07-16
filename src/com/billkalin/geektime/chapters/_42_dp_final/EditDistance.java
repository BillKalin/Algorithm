package com.billkalin.geektime.chapters._42_dp_final;

public class EditDistance {

    public static void main(String[] args) {
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();

        EditDistance instance = new EditDistance();
        instance.editDist(a, b, 0, 0, a.length, b.length, 0);
        int dist = instance.mMinDst;
        System.out.println("最小编辑字符数为：" + dist);
    }

    private int mMinDst = Integer.MAX_VALUE;

    //回溯法
    private void editDist(char[] a, char[] b, int i, int j, int m, int n, int dist) {
        if (i == m || j == n) {
            if (i < m) dist += (m - i);
            if (j < n) dist += (n - j);
            if (mMinDst > dist) {
                mMinDst = dist;
            }
            return;
        }

        if (a[i] == b[j]) {//如果字符相等，则比较下一个字符
            editDist(a, b, i + 1, j + 1, m, n, dist);
        } else {
            //b 删除一个字符就相等
            editDist(a, b, i + 1, j, m, n, dist + 1);
            //a 删除一个字符就相等
            editDist(a, b, i, j + 1, m, n, dist + 1);
            //a, b都替换相同字符
            editDist(a, b, i + 1, j + 1, m, n, dist + 1);
        }
    }
}
