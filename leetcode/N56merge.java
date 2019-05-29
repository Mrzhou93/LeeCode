package leetcode;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

public class N56merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int[] interval: intervals){
            if (res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            }else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }

    public static void main(String[] args){
        N56merge s= new N56merge();

        System.out.println(Arrays.deepToString(
                s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
