package leetcode.unionfind;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 * 示例 2：
 *
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 注意:
 *
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N684findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = null;
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i <= edges.length; i++){
            parent[i] = i;
        }

        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];

            while (parent[x] != x){
                x = parent[x];
            }

            while (parent[y] != y){
                y = parent[y];
            }

            if (x == y){
                ans = edge;
            } else {
                parent[x] = y;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        N684findRedundantConnection s = new N684findRedundantConnection();

        System.out.println(Arrays.toString(s.findRedundantConnection(
                new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}})));
    }
}
