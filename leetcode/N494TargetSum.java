package leetcode;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, 0);
    }

    private int dfs(int[] nums, int index, int S, int sum){
        int result = 0;
        if(index == nums.length){
            return sum == S ? ++result: result;
        }

        result += dfs(nums, index+1, S, sum+nums[index]);
        result += dfs(nums, index+1, S, sum-nums[index]);

        return result;
    }

    public static void main(String[] args){
        int[] num = {1, 1, 1, 1, 1};
        int S = 3;

        N494TargetSum s = new N494TargetSum();
        System.out.println(s.findTargetSumWays(num, S));
    }
}
