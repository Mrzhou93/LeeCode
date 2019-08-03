package leetcode.dfsbfs;

/**
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即小于 answer <= 2^31 - 1。
 */

public class N1137tribonacci {
    public int tribonacci1(int n) {
        if (n == 0)
            return 0;

        if (n == 1 || n ==2){
            return 1;
        }

        return tribonacci1(n-3) + tribonacci1(n - 2) + tribonacci1(n - 1);
    }

    public int tribonacci(int n){
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        N1137tribonacci s = new N1137tribonacci();

        System.out.println(s.tribonacci(4));
        System.out.println(s.tribonacci(25));
        System.out.println(s.tribonacci(0));
        System.out.println(s.tribonacci(1));
        System.out.println(s.tribonacci(2));
    }
}
