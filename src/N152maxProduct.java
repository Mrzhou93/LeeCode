package src;

/**
 *给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * */

class N152maxProduct {
    public int maxProduct(int[] nums) {
        int maxValue = 1;               // 以第i个数字结尾的最大的乘积
        int minValue = 1;               // 以第i个数字结尾的最小的乘积
        int dp = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                int temp = maxValue;
                maxValue = Math.max(minValue * nums[i], nums[i]);
                minValue = Math.min(temp * nums[i], nums[i]);
            } else {
                maxValue = Math.max(maxValue * nums[i], nums[i]);
                minValue = Math.min(minValue * nums[i], nums[i]);
            }
            dp = Math.max(maxValue, dp);
        }
        return dp;
    }

    public static void main(String[] args){
        N152maxProduct s= new N152maxProduct();

        int[] num = {2, 3, -2, 4};
        int[] num1 = {-2, 0, -1};
        int[] num2 = {0, 2};
        int[] num3 = {-2,3,-4};

        System.out.println(s.maxProduct(num));  // 6
        System.out.println(s.maxProduct(num1)); // 0
        System.out.println(s.maxProduct(num2)); // 2
        System.out.println(s.maxProduct(num3)); // 24
    }
}
