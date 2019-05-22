package leetcode;

import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 *
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * */

class N973kClosest {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return dis(o2) - dis(o1);
            }
        });


        for (int i = 0; i < points.length; i++){
            if (pq.size() < K){
                pq.add(points[i]);
            } else if (dis(pq.peek()) > dis(points[i])){
                pq.remove();
                pq.add(points[i]);
            }

//            System.out.println(Arrays.deepToString(pq.toArray()));
        }

        int[][] res = new int[K][2];
        int i = 0;

        while (!pq.isEmpty()){
            res[i][0] = pq.peek()[0];
            res[i][1] = pq.remove()[1];
            i++;
        }

        return res;
    }

    public int dis(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }


    public static void main(String[] args){
        int[][] num = { {1,3}, {-2, 2}};
        int[][] num1 = { {3,3}, {5,-1}, {-2,4}};
        int[][] num2 = { {1,3}, {-2,2}, {2,-2}};

        N973kClosest s = new N973kClosest();

        System.out.println(Arrays.deepToString(s.kClosest(num, 1)));
        System.out.println(Arrays.deepToString(s.kClosest(num1, 2)));
        System.out.println(Arrays.deepToString(s.kClosest(num2, 2)));
    }
}
