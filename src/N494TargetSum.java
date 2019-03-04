package src;

import java.util.Stack;

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
