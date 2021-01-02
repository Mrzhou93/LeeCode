package leetcode.dp;

import java.util.Arrays;

/**
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，
 * 每个子数组的中的值都会变为该子数组中的最大值。
 *
 * 返回给定数组完成分隔后的最大和。 
 *
 * 示例：
 *
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 *  
 * 提示：
 *
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-for-maximum-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N1043maxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        dp[0] = A[0];

        for (int i = 0; i < A.length; i++){
            int max = A[i];
            for (int j = 1; i - j + 1 >= 0 && j <= K; j++) {
                max = Math.max(max, A[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                } else {
                    dp[i] = Math.max(dp[j], j * max);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[A.length - 1];
    }

    public static void main(String[] args) {
        N1043maxSumAfterPartitioning s = new N1043maxSumAfterPartitioning();

        System.out.println(s.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
