package leetcode;

import java.util.HashMap;
import java.util.Map;

/***
 * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。
 * 翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
 * 返回经过一些翻转后，行上所有值都相等的最大行数。
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 *
 * 输入：[[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *
 *
 * 提示：
 *
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * 所有 matrix[i].length 都相等
 * matrix[i][j] 为 0 或 1
 */

public class N1072maxEqualRowsAfterFlips {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            if (matrix[i][0] == 1){
                for (int j = 0; j < m; j++){
                    matrix[i][j] ^= 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++){
                sb.append(matrix[i][j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int ans = 0;
        for (String k: map.keySet()){
            ans = Math.max(ans, map.get(k));
        }

        return ans;
    }

    public static void main(String[] args){
        N1072maxEqualRowsAfterFlips s = new N1072maxEqualRowsAfterFlips();

//        System.out.println(s.maxEqualRowsAfterFlips(new  int[][]{{0, 1}, {1, 1}}));
//        System.out.println(s.maxEqualRowsAfterFlips(new  int[][]{{0, 1}, {1, 0}}));
        System.out.println(s.maxEqualRowsAfterFlips(new  int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {1, 1, 0}}));
    }
}
