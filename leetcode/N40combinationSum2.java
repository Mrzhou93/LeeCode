package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * */

public class N40combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];

        Arrays.sort(candidates);

        dfs(candidates, target, res, new ArrayList<>(), 0, used);

        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> partRes,
                     int index, boolean[] used){
        if (target == 0 && !res.contains(partRes)){
            res.add(partRes);
            return;
        }

        if (target < candidates[index])
            return;

        boolean[] partUsed = used.clone();

        for (int i = index; i < candidates.length; i++){

            List<Integer> list = new ArrayList<>(partRes);

            if (!partUsed[i]) {
                list.add(candidates[i]);
                partUsed[i] = true;
                dfs(candidates, target - candidates[i], res, list, i, partUsed);
            }
        }
    }

    public static void main(String [] args){
        N40combinationSum2 s = new N40combinationSum2();

        System.out.println(s.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
//        System.out.println(s.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }


}
