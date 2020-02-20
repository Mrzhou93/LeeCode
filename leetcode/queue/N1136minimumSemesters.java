package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 已知有 N 门课程，它们以 1 到 N 进行编号。
 *
 * 给你一份课程关系表 relations[i] = [X, Y]，用以表示课程 X 和课程 Y 之间的先修关系：课程 X 必须在课程 Y 之前修完。
 *
 * 假设在一个学期里，你可以学习任何数量的课程，但前提是你已经学习了将要学习的这些课程的所有先修课程。
 *
 * 请你返回学完全部课程所需的最少学期数。
 *
 * 如果没有办法做到学完全部这些课程的话，就返回 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：N = 3, relations = [[1,3],[2,3]]
 * 输出：2
 * 解释：
 * 在第一个学期学习课程 1 和 2，在第二个学期学习课程 3。
 * 示例 2：
 *
 *
 *
 * 输入：N = 3, relations = [[1,2],[2,3],[3,1]]
 * 输出：-1
 * 解释：
 * 没有课程可以学习，因为它们相互依赖。
 *
 *
 * 提示：
 *
 * 1 <= N <= 5000
 * 1 <= relations.length <= 5000
 * relations[i][0] != relations[i][1]
 * 输入中没有重复的关系
 */

public class N1136minimumSemesters {
    public int minimumSemesters(int N, int[][] relations) {
        int[] in = new int[N + 1];

        for (int[] relation: relations){
            in[relation[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N; i++) {
            if (in[i] == 0) {
                ((LinkedList<Integer>) queue).add(i);
            }
        }

//        System.out.println(queue);

        int studyed = 0;
        int times = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                Integer num = queue.remove();
                studyed++;
                for (int[] relation : relations) {
                    if (relation[0] == num) {
                        in[relation[1]]--;
                        if (in[relation[1]] == 0) {
                            ((LinkedList<Integer>) queue).add(relation[1]);
                        }
                    }
                }
                size--;
            }
            times++;
        }

        return studyed == N? times: -1;
    }

    public static void main(String[] args) {
        N1136minimumSemesters s = new N1136minimumSemesters();

        System.out.println(s.minimumSemesters(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(s.minimumSemesters(3,
                new int[][]{{1, 2}, {2, 3},{3, 1}}));
    }
}
