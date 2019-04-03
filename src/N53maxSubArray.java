package src;

/***
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

class N53maxSubArray {
    public int maxSubArray2(int[] nums) {       // 动态规划
        int max = 0;
        int res = 0;
        for(int i=0; i < nums.length; i++){
            res = Math.max(nums[i], res+nums[i]);
            max = Math.max(res, max);
        }
        return max;
    }

    public int maxSubArray1(int[] nums){
        int sum = 0;
        int max = nums[0];
        for (int num: nums){
            if (sum>=0)    // !!!!
                sum += num;
            else
                sum = num;
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray(int[] nums){         // 分治法
        return findSubAarray(nums, 0, nums.length-1);
    }

    private int findSubAarray(int[] nums, int s, int t){
        if (s == t)
            return nums[s];
        else {
            int mid = s + (t - s) / 2;
            int leftSum = findSubAarray(nums, s, mid);
            int rightSum = findSubAarray(nums, mid+1, t);
            int crossSum = findCrossSum(nums, s, mid, t);

            if (leftSum >= rightSum && leftSum >= crossSum)
                return leftSum;
            else if (rightSum >= leftSum && rightSum >= crossSum)
                return rightSum;
            else
                return crossSum;
        }
    }

    private int findCrossSum(int[] nums, int s, int mid, int t){
        int leftSum = Integer.MIN_VALUE;
        int lsum = 0;
        for (int i=mid; i >= s; i--){
            lsum += nums[i];
            if (lsum > leftSum){
                leftSum = lsum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int rsum = 0;
        for (int i = mid + 1; i <= t; i++){
            rsum += nums[i];
            if (rsum > rightSum){
                rightSum = rsum;
            }
        }
        return leftSum+rightSum;
    }

    public static void main(String[] args){
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        N53maxSubArray s = new N53maxSubArray();
        System.out.println(s.maxSubArray(num));
        System.out.println(s.maxSubArray1(num));
    }
}
