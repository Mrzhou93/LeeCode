package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N216combinationSum3 {

    private List<List<Integer>> ans;
    private boolean[] visited;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        visited = new boolean[9];

        backTrace(k, n, new ArrayList<>(), 0);

        return ans;
    }

    public void backTrace(int k, int n, List<Integer> tmp, int index){
        if (k < 0)
            return;

        if (k == 0 && n == 0){
            ans.add(tmp);
            return;
        }

        for (int i = index; i < 9; i++){
            if (!visited[i]){
                visited[i] = true;
                List<Integer> tmpRes = new ArrayList<>(tmp);
                tmpRes.add(i + 1);
                backTrace(k - 1, n - (i + 1), tmpRes, i + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        N216combinationSum3 s = new N216combinationSum3();

        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9));
    }
}
