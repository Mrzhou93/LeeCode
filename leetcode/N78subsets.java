package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * */

public class N78subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> partRes, int[] nums, int index){
        if (partRes.size() <= nums.length){
            res.add(partRes);
        }

        for (int i = index; i < nums.length; i++){
            List<Integer> list = new ArrayList<>(partRes);

            if (!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(res, list, nums, i);
            }
        }
    }

    public static void main(String[] args){
        N78subsets s= new N78subsets();

        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }
}
