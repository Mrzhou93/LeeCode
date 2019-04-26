package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * */

public class N77combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), n, k, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> partRes,int n, int k, int index){
        if (partRes.size() == k){
            res.add(partRes);
            return;
        }

        for (int i = index + 1; i <= n; i++){
            List<Integer> list = new ArrayList<>(partRes);

            if (!list.contains(i)){
                list.add(i);
                dfs(res, list, n, k, i);
            }
        }
    }

    public static void main(String[] args){
        N77combine s= new N77combine();

        System.out.println(s.combine(4, 2));
    }
}
