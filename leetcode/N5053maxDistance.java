package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 */

public class N5053maxDistance {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int maxDistance(int[][] grid) {
        int N = grid.length;
        List<Integer> cur = new LinkedList<>();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (grid[i][j] == 1){
                    cur.add(i * N + j);
                }
            }
        }

        int level = 0;
        int ans = -1;

        while (!cur.isEmpty()){
            level++;
            List<Integer> next = new LinkedList<>();
            for (int i = 0; i < cur.size(); i++){
                for (int j = 0; j < 4; j++){
                    int nx = (cur.get(i) / N) + dx[j];
                    int ny = (cur.get(i) % N) + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 0){
                        grid[nx][ny] = level;
                        ans = level;
                        next.add(nx * N + ny);
                    }
                }
            }
            cur = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        N5053maxDistance s = new N5053maxDistance();

        System.out.println(s.maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }));

        System.out.println(s.maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }
}
