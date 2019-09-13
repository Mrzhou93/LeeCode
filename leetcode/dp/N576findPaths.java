package leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
 * 或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。
 * 答案可能非常大，返回 结果 mod 109 + 7 的值。
 *
 * 示例 1：
 *
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 * 解释:
 *
 * 示例 2：
 *
 * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
 * 输出: 12
 * 解释:
 *
 * 说明:
 *
 * 球一旦出界，就不能再被移动回网格内。
 * 网格的长度和高度在 [1,50] 的范围内。
 * N 在 [0,50] 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N576findPaths {

    private int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0)
            return 0;

        int[][][] dp = new int[N][m + 2][n + 2];
        int ans = 0;

        dp[0][i + 1][j + 1] = 1;

        if (i == 0) ans++;
        if (i == m - 1) ans++;
        if (j == 0) ans++;
        if (j == n - 1) ans++;

        for (int kk = 1; kk < N; kk++) {
            for (int jj = 1; jj <= n; jj++) {
                for (int ii = 1; ii <= m; ii++) {
                    dp[kk][ii][jj] = dp[kk - 1][ii - 1][jj] + dp[kk - 1][ii][jj - 1] +
                            dp[kk - 1][ii + 1][jj] + dp[kk - 1][ii][jj + 1];
                    dp[kk][ii][jj] %= MOD;
                    if (ii == 1) ans += dp[kk][ii][jj];
                    if (ii == m) ans += dp[kk][ii][jj];
                    if (jj == 1) ans += dp[kk][ii][jj];
                    if (jj == m) ans += dp[kk][ii][jj];
                    ans %= MOD;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        N576findPaths s = new N576findPaths();

        System.out.println(s.findPaths(2, 2, 2, 0, 0));
        System.out.println(s.findPaths(1, 3, 3, 0, 1));
        System.out.println(s.findPaths(1, 2, 50, 0, 0));
    }
}
