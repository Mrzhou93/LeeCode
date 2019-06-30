package leetcode.unionfind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 *
 * 我们最多能执行多少次 move 操作？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N947removeStones {

    private int[] parents;

    public int removeStones(int[][] stones) {
        int length = stones.length;

        parents = new int[length];

        for (int i = 0; i < length; i++){
            parents[i] = i;
        }

        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    int firstRoot = find(i);
                    int secondRoot = find(j);
                    if (firstRoot != secondRoot){
                        parents[secondRoot] = firstRoot;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < length; i++){
            if (i == parents[i])
                ans++;
        }

        return stones.length - ans;
    }

    public int find(int x){
        int r = x;
        while (r != parents[r]){
            r = parents[r];
        }

        return r;
    }

    public static void main(String[] args){
        N947removeStones s = new N947removeStones();

        System.out.println(s.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(s.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        System.out.println(s.removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}}));
    }
}
