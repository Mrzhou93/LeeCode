package src;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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

class NkClosest {
    private int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        find(0, points.length - 1, (points.length) / 2);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void find(int s, int t, int K) {
//        System.out.println("s="+ s + " t=" + t +" k=" + K);
        if (s >= t)
            return;
        int i = s, j = t;
        int kDist = calDist(ThreadLocalRandom.current().nextInt(s, t));

        while (s < t) {
            while (s < t && kDist > calDist(s))
                s++;
            while (s < t && kDist < calDist(t))
                t--;
            swap(s, t);
        }

        if (K <= s - i + 1)
            find(i, s, K);
        else
            find(s + 1, j, K- (s - i + 1));
    }

    private int calDist(int i){       // 计算出距离
        return this.points[i][0] * this.points[i][0] + this.points[i][1] * this.points[i][1];
    }

    private void swap(int i, int j){        // 交换第i和第j个元素的位置
//        System.out.println("In swap"+"i= " + i + " j=" + j);
        int num0 = points[i][0];
        int num1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = num0;
        points[j][1] = num1;
    }

    public static void main(String[] args){
        int[][] num = { {1,3}, {-2, 2}};
        int[][] num1 = { {3,3}, {5,-1}, {-2,4}};

        NkClosest s = new NkClosest();
        System.out.println(s.kClosest(num, 2));
        System.out.println(s.kClosest(num1, 2));
    }
}
