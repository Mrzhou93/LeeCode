package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个整数 k。
 *
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 *
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 *
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 *
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 示例 2：
 *
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */

public class N5191kConcatenationMaxSum {

    private int MOD = 1000000007;


    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int a: arr){
            sum += a;
        }

        long res = 0;
        int length = arr.length;
        int[] dp = new int[length + 1];

        for (int i = 0; i < length; i++){
            dp[i + 1] = Math.max(dp[i] + arr[i], arr[i]);
            res = Math.max(res, dp[i]);
        }

        if (k == 1) {
            return (int) (res % MOD);
        }

        long first = arr[0];
        int cur = 0;
        for (int i = 0; i < length; i++){
            cur += arr[i];
            first = Math.max(first, cur);
        }

        res = Math.max(res, first + dp[length]);
        if (sum > 0){
            long tmp = sum * (k - 2) + dp[length] + first;
            res = Math.max(res, tmp);
        }

        return (int) (res % MOD);
    }

    // 铁定超时
    public int kConcatenationMaxSum1(int[] arr, int k){
        int res = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length; j++) {

                res = Math.max(arr[j], res + arr[j]);
                res %= MOD;
                max = Math.max(max, res);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        N5191kConcatenationMaxSum s = new N5191kConcatenationMaxSum();

        System.out.println(s.kConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println(s.kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println(s.kConcatenationMaxSum(new int[]{-1, -2}, 7));
        System.out.println(s.kConcatenationMaxSum(new int[]{-5,-2,0,0,3,9,-2,-5,4},5));
        // 20
    }
}

/**
 int res = 0;
 int max = 0;
 int arrCondition = 0;

 for (int i = 0; i < k; i++){
 for (int j = 0; j < arr.length; j++){

 if (arr[j] < 0){
 arrCondition++;
 }

 res = Math.max(arr[j], res + arr[j]);
 max = Math.max(max, res);

 }
 }
 */