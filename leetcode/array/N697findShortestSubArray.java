package leetcode.array;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N697findShortestSubArray {
    public int findShortestSubArray(int[] nums) {

        int freqMax = 0;
        int[][] helper = new int[50001][3];

        for (int i = 0; i < nums.length; i++){
            if (helper[nums[i] + 1][0] == 0){
                helper[nums[i] + 1][0] = i + 1;
            }
            helper[nums[i] + 1][1] = i + 1;
            helper[nums[i] + 1][2]++;

            if (helper[nums[i] + 1][2] > freqMax){
                freqMax = helper[nums[i] + 1][2];
            }
        }

        int ans = 50000;

        for (int i = 1; i < helper.length; i++){
            if (helper[i][2] == freqMax){
                ans = Math.min(ans, helper[i][1] - helper[i][0]);
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        N697findShortestSubArray s = new N697findShortestSubArray();

        System.out.println(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
