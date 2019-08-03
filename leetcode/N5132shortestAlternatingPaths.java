package leetcode;

import java.util.*;

/**
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的最短路径的长度，且路径上红色边和蓝色边交替出现。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 *
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 *
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */

public class N5132shortestAlternatingPaths {
    int n;

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> rGraph = new ArrayList<>();
        this.n = n;
        build(rGraph, red_edges);
        List<List<Integer>> bGraph = new ArrayList<>();
        build(bGraph, blue_edges);

        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;

        dist[0][0] = dist[1][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        queue.add(new int[] {0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] == 0) {
                for (int u: rGraph.get(cur[0])) {
                    if (dist[1][u] == Integer.MAX_VALUE) {
                        dist[1][u] = dist[cur[1]][cur[0]] + 1;
                        queue.add(new int[] {u, 1});
                    }
                }
            } else {
                for (int u: bGraph.get(cur[0])) {
                    if (dist[0][u] == Integer.MAX_VALUE) {
                        dist[0][u] = dist[cur[1]][cur[0]] + 1;
                        queue.add(new int[] {u, 0});
                    }
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[0][i], dist[1][i]);
            if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }

    void build(List<List<Integer>> graph, int[][] edges) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
        }
    }

    public static void main(String[] args) {
        N5132shortestAlternatingPaths s = new N5132shortestAlternatingPaths();

//        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
//                3, new int[][]{{0, 1}, {1, 2}}, new int[][]{})));
//
//        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
//                3, new int[][]{{0, 1}}, new int[][]{{2, 1}})));
//
//        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
//                3, new int[][]{{1, 0}}, new int[][]{{2, 1}})));
//
//        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
//                3, new int[][]{{0, 1}}, new int[][]{{1, 2}})));

        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
                3, new int[][]{{0, 1}, {0, 2}}, new int[][]{{1, 0}})));
    }
}
