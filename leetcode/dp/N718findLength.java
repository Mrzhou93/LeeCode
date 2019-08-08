package leetcode.dp;

import java.util.Arrays;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N718findLength {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >=0; i--){
            for (int j = B.length - 1; j >= 0; j--){
                if (A[i] == B[j]){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (ans < dp[i][j]){
                        ans = dp[i][j];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return ans;
    }

    public static void main(String[] args) {
        N718findLength s = new N718findLength();

        System.out.println(s.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
