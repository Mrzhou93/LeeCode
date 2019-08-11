package leetcode.array;

/**
 * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5
 * 输出：true
 * 解释：
 * 数字 5 出现了 5 次，而数组的长度为 9。
 * 所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
 * 示例 2：
 *
 * 输入：nums = [10,100,101,101], target = 101
 * 输出：false
 * 解释：
 * 数字 101 出现了 2 次，而数组的长度是 4。
 * 所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= target <= 10^9
 */

public class N1150isMajorityElememt {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        int major = 0;
        int tar = 0;

        for (int num: nums){
            if (num == target){
                tar++;
            }
            if (major == num){
                count++;
            } else if (count == 0){
                major = num;
                count = 1;
            } else {
                count--;
            }
        }

        return target == major && tar > (nums.length / 2);
    }

    public static void main(String[] args) {
        N1150isMajorityElememt s = new N1150isMajorityElememt();

        System.out.println(s.isMajorityElement(new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6}, 5));
        System.out.println(s.isMajorityElement(new int[]{10, 100, 101, 101}, 101));
    }
}
