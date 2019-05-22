package leetcode;

import org.omg.CORBA.ARG_IN;

import java.util.*;

/**
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。
 * 花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 *
 * 示例 1：
 *
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 */

public class N1042gardenNoAdj {
    public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N + 1);
        int[] res = new int[N + 1];

        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] path: paths){
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

//        System.out.println(Arrays.deepToString(graph.toArray()));

        for (int i = 0; i <= N; i++){
            boolean[] tmp = new boolean[5];

            for (int x: graph.get(i)){
                tmp[res[x]] = true;
            }
            for (int j = 1; j <= 4; j++)
                if (!tmp[j]) {
                    res[i] = j;
                    break;
                }
        }

        return Arrays.copyOfRange(res, 1, N + 1);
    }


    public static void main(String[] args){
        N1042gardenNoAdj s = new N1042gardenNoAdj();

        System.out.println(Arrays.toString(
                s.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})));

        System.out.println(Arrays.toString(
                s.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})));

        System.out.println(Arrays.toString(
                s.gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}})));

       System.out.println(Arrays.toString(
                s.gardenNoAdj(5, new int[][]{{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}})));
    }
}
