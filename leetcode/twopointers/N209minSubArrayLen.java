package leetcode.twopointers;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N209minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
//        int k = 0;
        int ans = 0;
//        int sum = 0;

        for (int i=0; i< nums.length; i++){
            int sum = 0;
//            System.out.println(i);
            int k = i;
            while(k < nums.length && sum < s) {
//                System.out.println("    "+k);
                sum += nums[k];
                k++;
            }
            int tmp = k - i;
//            System.out.println("size of tmp:" + tmp);
            if (tmp < ans && ans != 0 && sum >= s){
                ans = tmp;
            } else if(ans == 0 && tmp> ans && sum >= s){
                ans = tmp;
            }
//            System.out.println("        ans"+ans);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 1, 2, 4, 3};

        N209minSubArrayLen s = new N209minSubArrayLen();
        System.out.println(s.minSubArrayLen(7, nums));
    }
}
