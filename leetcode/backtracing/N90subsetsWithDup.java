package leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * */

public class N90subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        backTrace(res, new ArrayList<>(), nums, visited, 0);

        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> partRes, int[] nums, boolean[] visited, int index){
        if (!res.contains(partRes)){
            res.add(partRes);
        }

        for (int i = index; i < nums.length; i++){
            List<Integer> list = new ArrayList<>(partRes);
            if (!visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                backTrace(res, list, nums, visited, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        N90subsetsWithDup s= new N90subsetsWithDup();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(s.subsetsWithDup(new int[]{1, 1, 2, 2}));
//        System.out.println(s.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
