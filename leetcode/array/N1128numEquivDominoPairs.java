package leetcode.array;

import java.util.*;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */

public class N1128numEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int[] dominoe: dominoes){
            if (dominoe[0] > dominoe[1]){
                int tmp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = tmp;
            }
            List<Integer> tmp = Arrays.asList(dominoe[0], dominoe[1]);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        for (List<Integer> k: map.keySet()){
            int num = map.get(k);
            if (num > 1){
                ans += num * (num - 1) / 2;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        N1128numEquivDominoPairs s = new N1128numEquivDominoPairs();

        System.out.println(s.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(s.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }
}
