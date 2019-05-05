package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 * */

public class N5051isBoomerang {
    public boolean isBoomerang(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0]? o2[0] - o1[0]: o1[0] - o2[0];
            }
        });

        for (int[] i: points)
            System.out.println("["+i[0]+","+i[1]+"]");

        if (points[0][0] == points[1][0] && points[0][1] == points[1][1]) // 同一点
            return false;

        if (points[2][0] == points[1][0] && points[2][1] == points[1][1]) // 同一点
            return false;

        if (points[1][0] == points[0][0] || points[2][0] == points[1][0]){
            if (points[1][0] != points[0][0] || points[2][0] != points[1][0]){
                return true;
            }else
                return false;
        }

        float k1 = (float) (points[1][1] - points[0][1]) / (points[1][0] - points[0][0]);
        float k2 = (float) (points[2][1] - points[0][1]) / (points[2][0] - points[0][0]);

        System.out.println(k1);
        System.out.println(k2);

//        if (points[1][0] - points[0][0] != 0) {
//            k1 = (points[1][1] - points[0][1]) / (points[1][0] - points[0][0]);
//            k2 = (points[2][1] - points[1][1]) / (points[2][0] - points[1][0]);
//        }

        return k1 != k2;
    }


    public static void main(String[] args){
        N5051isBoomerang s = new N5051isBoomerang();

//        System.out.println(s.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}})); // T
//        System.out.println(s.isBoomerang(new int[][]{{1, 1}, {3, 3}, {2, 2}})); // F
//        System.out.println(s.isBoomerang(new int[][]{{1, 1}, {3, 1}, {2, 1}})); // F
//        System.out.println(s.isBoomerang(new int[][]{{1, 1}, {1, 3}, {1, 2}})); // F
//        System.out.println(s.isBoomerang(new int[][]{{0, 0}, {1, 1}, {1, 1}})); // F
//        System.out.println(s.isBoomerang(new int[][]{{0, 0}, {2, 1}, {2, 2}})); // T
//        System.out.println(s.isBoomerang(new int[][]{{0, 0}, {0, 2}, {2, 1}}));  // T
//        System.out.println(s.isBoomerang(new int[][]{{52, 86}, {12, 65}, {24, 71}}));  // T
        System.out.println(s.isBoomerang(new int[][]{{0, 0}, {1, 2}, {24, 71}}));  // T
    }
}
