package leetcode.dfsbfs;

import java.util.*;

/**
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 *
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 *
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，
 * 或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 *
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，
 * 并返回最终的网格 grid 。
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 * */

public class N1034colorBorder {

    private int[][] direct = new int[][]{{0, 1}, {0, -1},{1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int[][] res = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                res[i][j] = grid[i][j];
            }
        }

        queue.add(r0 * 50 + c0);
        visited[r0][c0] = true;


        while(!queue.isEmpty()){
            int top = queue.poll();
            boolean flag= false;

            for (int i = 0; i < direct.length; i++){
                int rr = (top / 50)  + direct[i][0];
                int cc = (top % 50) + direct[i][1];
                if (rr >= 0 && rr < grid.length && cc >= 0 && cc < grid[0].length
                        && grid[rr][cc] == grid[r0][c0] && !visited[rr][cc]){
                    queue.add(rr * 50 + cc);
                    visited[rr][cc] = true;
                }
                if (!(rr >= 0 && rr < grid.length && cc >= 0 && cc < grid[0].length
                        && grid[rr][cc] == grid[r0][c0] )){
                    flag = true;
                }
            }
            if (flag)
                res[top / 50][top % 50] = color;
        }

        return res;
    }


    public static void main(String [] args){
        N1034colorBorder s = new N1034colorBorder();

        int[][] grid = new int[][]{{1, 1},{1, 2}};
        int[][] grid1 = new int[][]{{1, 2, 2},{2, 3, 2}};
        int[][] grid2 = new int[][]{{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        int[][] grid3 = new int[][]{{1, 2, 1, 2, 1, 2},{2, 2, 2, 2, 1, 2},{1, 2, 2, 2, 1, 2}};
        int[][] grid4 = new int[][]{{1, 2, 1},{1, 2, 2},{2, 2, 1}};

//        System.out.println(Arrays.deepToString(s.colorBorder(grid, 0, 0, 3)));
//        System.out.println(Arrays.deepToString(s.colorBorder(grid1, 0, 1, 3)));
//        System.out.println(Arrays.deepToString(s.colorBorder(grid2, 1, 1, 2)));
        System.out.println(Arrays.deepToString(s.colorBorder(grid3, 1, 3, 1)));
//        System.out.println(Arrays.deepToString(s.colorBorder(grid4, 1, 1, 2)));

    }
}
