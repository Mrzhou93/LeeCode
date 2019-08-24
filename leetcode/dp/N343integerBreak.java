package leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * */


public class N343integerBreak {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(new N343integerBreak().integerBreak(10));
    }
}
