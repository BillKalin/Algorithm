package com.billkalin.geektime.chapters._39_huisu;

public class HuisuMain {

    public static void main(String[] args) {
        HuisuMain test = new HuisuMain();
        test.EightQueue(0);
//        test.EightQueue2();
    }

    private static final int N = 8;
    private int[] result = new int[N];

    private void EightQueue(int row) {
        if (row == 8) {
            printQueue();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isOk(row, col)) {
                result[row] = col;
                EightQueue(row + 1);
            }
        }
        System.out.println();
    }

    private boolean isOk(int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        for (int r = row - 1; r >= 0; r--) {
            if (result[r] == col)
                return false;
            if (leftUp >= 0) {
                if (result[r] == leftUp)
                    return false;
            }

            if (rightUp < 8) {
                if (result[r] == rightUp)
                    return false;
            }

            leftUp--;
            rightUp++;
        }

        return true;
    }

    private void printQueue() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (result[row] == col) {
                    System.out.print("O");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private void EightQueue2() {
        int[][] results = new int[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                results[row][col] = 0;
            }
        }

        int row = 0;
        int col = 0;
        boolean isOk;
        while (row < 8) {
            isOk = false;
            while (col < 8) {
                if (isOk(results, row, col)) {
                    results[row][col] = 1;
                    isOk = true;
                    col = 0;
                    break;
                }
                col++;
            }

            if (isOk) {
                if (row == 7) {
                    print(results);
                    System.out.println("=======================");
                    for (int i = 0; i < 8; i++) {
                        if (results[row][i] == 1) {
                            results[row][i] = 0;
                            col = i + 1;
                            break;
                        }
                    }
                    continue;
                }
                row++;
            } else {
                if (row == 0)
                    break;
                row--;
                for (int i = 0; i < 8; i++) {
                    if (results[row][i] == 1) {
                        results[row][i] = 0;
                        col = i + 1;
                        break;
                    }
                }
            }
        }
    }

    private void print(int[][] s) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (s[row][col] == 1) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    private boolean isOk(int[][] result, int row, int col) {
        int left = col - 1;
        int right = col + 1;
        for (int r = row - 1; r >= 0; r--) {
            if (result[r][col] == 1)
                return false;
            if (left >= 0) {
                if (result[r][left] == 1)
                    return false;
            }
            if (right < 8) {
                if (result[r][right] == 1)
                    return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
