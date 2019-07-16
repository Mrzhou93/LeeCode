package leetcode.array;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N643findMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        int i = 0;

        while (i < k){
            sum += nums[i++];
        }

        max = sum;

        while (i < nums.length){
            sum = sum + nums[i] - nums[i - k];
            if (sum > max){
                max = sum;
            }
            i++;
        }
        return (double) max / k;
    }

    public static void main(String[] args) {
        N643findMaxAverage s = new N643findMaxAverage();

        System.out.println(s.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(s.findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
    }
}
