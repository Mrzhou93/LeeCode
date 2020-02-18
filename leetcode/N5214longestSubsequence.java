package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 */

public class N5214longestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        int ans = 1;

        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i]) && !map.containsKey(arr[i] - difference)){
                map.put(arr[i], i);
                dp[i] = 1;
            } else if (!map.containsKey(arr[i]) && map.containsKey(arr[i] - difference)){
                map.put(arr[i], i);
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            } else if (map.containsKey(arr[i]) && !map.containsKey(arr[i] - difference)){
                dp[i] = dp[map.get(arr[i])];
            } else {
                if (dp[map.get(arr[i] - difference)] >= dp[map.get(arr[i])]){
                    dp[i] = dp[map.get(arr[i] - difference)] + 1;
                    map.put(arr[i], i);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        N5214longestSubsequence s = new N5214longestSubsequence();
        System.out.println(s.longestSubsequence(new int[]{1,2,3,4}, 1));
        System.out.println(s.longestSubsequence(new int[]{1,3,5,7}, 1));
        System.out.println(s.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }
}
