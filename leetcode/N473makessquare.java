package leetcode;

import java.util.Arrays;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
 * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N473makessquare {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;

        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        if (sum % 4 != 0)
            return false;

        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        int i = nums.length - 1;

        for (int j = 0; j < 4; j++){
            while (visited[i] == 1)
                i--;

            if (!dfs(nums, visited, i, sum / 4, 0))
                return false;
        }

        return true;
    }

    public boolean dfs(int[] nums, int[] visited, int i, int a, int cur){
        visited[i] = 1;
        cur += nums[i];
        if (cur == a)
            return true;

        for (int j = i - 1; j >= 0; j--){
            if (visited[j]==0 && nums[j] + cur <= a){
                if (dfs(nums, visited, j, a, cur))
                    return true;

                visited[j] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args){
        N473makessquare s = new N473makessquare();
        System.out.println(s.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(s.makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}
