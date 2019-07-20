package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N18fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){

                int left = j + 1;
                int right = len - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!ans.contains(tmp)) {
                            ans.add(tmp);
                        }

                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;

                    } else if (sum > target){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N18fourSum s = new N18fourSum();

//        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(s.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }
}
