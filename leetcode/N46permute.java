package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * */

public class N46permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), nums);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> partRes, int[] nums){

        if (partRes.size() == nums.length){
            res.add(partRes);
            return;
        }

        for (int i = 0; i < nums.length; i++){

            List<Integer> list = new ArrayList<>(partRes);

            if (!list.contains(nums[i])){
                list.add(nums[i]);
                dfs(res, list, nums);
            }
        }
    }


    public static void main(String[] args){
        N46permute s = new N46permute();

        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}
