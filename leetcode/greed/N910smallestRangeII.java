package leetcode.greed;

import javax.swing.text.MutableAttributeSet;
import java.util.Arrays;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N910smallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        int len = A.length;

        Arrays.sort(A);

        int ans = A[len - 1] - A[0];

        for (int i = 0; i < len - 1; i++){
            int a = A[i];
            int b = A[i + 1];
            int high = Math.max(A[len - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {
        N910smallestRangeII s = new N910smallestRangeII();

        System.out.println(s.smallestRangeII(new int[]{1}, 0));
        System.out.println(s.smallestRangeII(new int[]{0, 10}, 2));
        System.out.println(s.smallestRangeII(new int[]{1, 3, 6}, 3));
    }
}
