package leetcode.lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N03findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // nums[i] 应该放在下标为 i 的位置上
            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int findRepeatNumber1(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){
                return nums[i];
            }
        }

        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums){
            if (set.contains(n)){
                return n;
            } else {
                set.add(n);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        N03findRepeatNumber s = new N03findRepeatNumber();
        System.out.println(s.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
