package leetcode;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 *
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 *
 * 输出：4
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */

public class N1091shortestPathBinaryMatrix {

    int[][] move = {{-1, -1}, {0, -1}, {1, -1},
                    {-1, 0},           {1, 0},
                    {-1, 1},  {0, 1},  {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;

        int[][] visited = new int[grid.length][grid[0].length];

        return shortestPathBinaryMatrix(grid, 0, 0, 1, visited);
    }

    public int shortestPathBinaryMatrix(int[][] grid, int i, int j, int length, int[][] visited){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)  // 越界
            return -1;

        if (grid[i][j] == 1 || visited[i][j] == 1)   // 值不对，或者已经访问过了
            return -1;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return length;

        visited[i][j] = 1;

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 8; k++){
            int cur = shortestPathBinaryMatrix(
                    grid, i + move[k][0], j + move[k][1], length + 1, visited);
            if (cur > 0 && min > cur){
                min = cur;
            }
        }

        visited[i][j] = 0;

        return min == Integer.MAX_VALUE? -1: min;
    }

    public static void main(String[] args){
        N1091shortestPathBinaryMatrix s = new N1091shortestPathBinaryMatrix();
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0, 1},{1, 0}}));
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0, 0, 0},{1, 1, 0}, {1, 1, 0}}));
        System.out.println(s.shortestPathBinaryMatrix(
                new int[][]{
                        {0,0,1,0,1,1},
                        {1,0,0,1,0,0},
                        {0,1,0,1,0,0},
                        {1,0,1,0,0,0},
                        {0,1,0,1,0,0},
                        {0,0,0,0,0,0}}));
    }
}
