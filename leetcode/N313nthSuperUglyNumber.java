package leetcode;

import java.util.Arrays;

/**
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，
 * 前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 */

public class N313nthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index= new int[primes.length];

        for (int i = 1; i < n; i++){
            int smallestUglyNum = primes[0] * dp[index[0]];

            for (int j = 1; j < primes.length; j++){
                if (primes[j] * dp[index[j]] < smallestUglyNum){
                    smallestUglyNum = primes[j] * dp[index[j]];
                }
            }
            for (int j = 0; j < primes.length; j++){
                if (smallestUglyNum == primes[j] * dp[index[j]]){
                    index[j]++;
                }
            }
            dp[i] = smallestUglyNum;
        }
        return dp[n - 1];
    }

    public static void main(String[] args){
        N313nthSuperUglyNumber s= new N313nthSuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
