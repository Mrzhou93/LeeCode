package leetcode;

import java.util.*;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N491findSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        backtrace(ans, nums, 0, new LinkedList<>());

        return new ArrayList<>(ans);
    }

    public void backtrace(Set<List<Integer>> ans, int[] nums, int i, List<Integer> list){
        if (list.size() >= 2){
            List<Integer> tmp = new LinkedList<>(list);
            ans.add(tmp);
        }

        for (int j = i; j < nums.length; j++){
//            List<Integer> list = new LinkedList<>(tmp);

            if (list.size() == 0 || ((LinkedList<Integer>) list).getLast() <= nums[j]) {
                list.add(nums[j]);
                backtrace(ans, nums, j + 1, list);
                ((LinkedList<Integer>) list).removeLast();
            }
        }
    }

    public static void main(String[] args){
        N491findSubsequences s = new N491findSubsequences();

        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(s.findSubsequences(new int[]{4, 3, 2, 1}));
    }
}
