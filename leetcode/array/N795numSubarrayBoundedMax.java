package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N795numSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int left = -1;
        int right = -1;
        int count = 0;

        for (int i=0; i<A.length; i++) {
            if (A[i] > R) {
                left = i;
            } else if (A[i] >= L) {
                right = i;
            }

            if (right > left) {
                count += right - left;
            }
        }
        return count;
    }

    public int numSubarrayBoundedMax(int[] A, int max){
        int ans = 0;
        int sub = 0;

        for (int num: A){
            if (num <= max){
                sub++;
                ans += sub;
            } else {
                sub = 0;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        N795numSubarrayBoundedMax s = new N795numSubarrayBoundedMax();

        System.out.println(s.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}
