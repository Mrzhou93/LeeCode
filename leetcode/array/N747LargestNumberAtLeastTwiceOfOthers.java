package leetcode.array;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N747LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        // 找出最大值和次大值
        int max = -1, maxIndex = -1, secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? maxIndex : -1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,2,3};
        int[] nums1 = {0,0,0,1};
        int[] nums2 = {1};
        int[] nums3 = {1, 0};
        int[] nums4 = {0,0,3,2};
        N747LargestNumberAtLeastTwiceOfOthers s = new N747LargestNumberAtLeastTwiceOfOthers();
        System.out.println(s.dominantIndex(nums));  // -1
        System.out.println(s.dominantIndex(nums1)); // 3
        System.out.println(s.dominantIndex(nums2)); // 0
        System.out.println(s.dominantIndex(nums3)); // 0
        System.out.println(s.dominantIndex(nums4)); //-1
    }

}
