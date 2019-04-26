package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * */

public class N47permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(res, new ArrayList<>(), nums, used);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> partRes, int[] nums, boolean[] used){
        if (partRes.size() == nums.length && !res.contains(partRes)){
            res.add(partRes);
            return;
        }

        if (partRes.size() == nums.length)
            return;

        boolean[] partUsed = used.clone();
//        System.out.println(Arrays.toString(partUsed));

        for (int i = 0; i < nums.length; i++){
            if (!partUsed[i]) {
                List<Integer> list = new ArrayList<>(partRes);
                list.add(nums[i]);
                partUsed[i] = true;
                dfs(res, list, nums, partUsed);
                partUsed[i] = false;
            }
        }
    }

    public static void main(String[] args){
        N47permuteUnique s = new N47permuteUnique();

        System.out.println(s.permuteUnique(new int[]{1, 1, 2}));
    }
}
