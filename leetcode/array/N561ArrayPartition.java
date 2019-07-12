package leetcode.array;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N561ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i< nums.length/2; i++){
            result += nums[2*i];
        }
        return result;
    }

    private void quickSort(int[] nums, int s, int t){
        int i = s, j = t;
        int temp;
        if (s < t){
            temp = nums[s];
            while(i != j){
                while (j > i && nums[j] >= temp)
                    j--;
                nums[i] = nums[j];

                while(i < j && nums[i] <= temp)
                    i++;
                nums[j] = nums[i];
            }
            nums[i] = temp;

            quickSort(nums, s, i-1);
            quickSort(nums, i+1, t);
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 4, 3, 2};

        N561ArrayPartition s = new N561ArrayPartition();
        System.out.println(s.arrayPairSum(nums));
    }
}
