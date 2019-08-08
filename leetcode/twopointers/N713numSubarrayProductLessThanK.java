package leetcode.twopointers;

/**
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 *
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N713numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1)
            return 0;

        int ans = 0;
        int l = 0;
        int res = 1;

        for (int r = 0; r < nums.length; r++){
            res *= nums[r];
            while (res >= k){
                res /= nums[l];
                l++;
            }
            ans += (r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        N713numSubarrayProductLessThanK s = new N713numSubarrayProductLessThanK();

        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
