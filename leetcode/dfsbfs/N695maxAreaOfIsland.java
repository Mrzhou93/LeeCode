package leetcode.dfsbfs;


/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
 * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N695maxAreaOfIsland {

    private int[][] grid;
    private int[][] dir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int row;
    int col;
    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (this.grid[i][j] == 1){
                    bfs(i, j);
                    ans = Math.max(ans, max);
                    max = 0;
                }
            }
        }
        return ans == Integer.MIN_VALUE? 0: ans;
    }

    public void bfs(int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0 || grid[i][j] == -1)
            return;

        grid[i][j] = -1;
        max++;

        for (int k = 0; k < dir.length; k++){
            int ii = i + dir[k][0];
            int jj = j + dir[k][1];

            bfs(ii, jj);
        }
    }

    public static void main(String[] args) {
        N695maxAreaOfIsland s = new N695maxAreaOfIsland();

        System.out.println(s.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }
}
