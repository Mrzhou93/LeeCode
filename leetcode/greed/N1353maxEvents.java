package leetcode.greed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 *
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * 示例 3：
 *
 * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：events = [[1,100000]]
 * 输出：1
 * 示例 5：
 *
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * 输出：7
 *
 *
 * 提示：
 *
 * 1 <= events.length <= 10^5
 * events[i].length == 2
 * 1 <= events[i][0] <= events[i][1] <= 10^5
 */
public class N1353maxEvents {
    public int maxEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        System.out.println(Arrays.deepToString(events));

        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < events.length; i++) {
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (!used.contains(j)){
                    used.add(j);
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        N1353maxEvents s = new N1353maxEvents();
        System.out.println(s.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}})); // 3
        System.out.println(s.maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}})); // 4
        System.out.println(s.maxEvents(new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}}));  //4
        System.out.println(s.maxEvents(new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}})); // 7
        System.out.println(s.maxEvents(new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}}));  // 5
    }
}
