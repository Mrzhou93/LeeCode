package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * */

public class N39combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, target, res, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> partResult, int index){
        if (target == 0){
            res.add(partResult);
            return;
        }

        if (target < candidates[index])
            return;

        for (int i = index; i < candidates.length; i++){
            List<Integer> list = new ArrayList<>(partResult);
            list.add(candidates[i]);
            dfs(candidates, target- candidates[i], res, list, i);
        }
    }

    public static void main(String[] args){
        N39combinationSum s = new N39combinationSum();

        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
