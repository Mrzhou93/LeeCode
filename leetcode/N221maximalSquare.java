package leetcode;

import java.util.logging.Logger;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 *
 * 示例:
 *
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 * */

class N221maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;

        if (row == 0)
            return 0;

        int col = matrix[0].length;
        int max = 0;

        int[][] dp = new int[row + 1][col + 1];     // 以i, j为右下角的正方形的边长

        for (int i = 1; i <= row; ++i){
            for (int j = 1; j <= col; ++j){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String [] args){
        N221maximalSquare s = new N221maximalSquare();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(s.maximalSquare(matrix));
    }
}
