package leetcode.string;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回true，否则请返回false。
 *
 * 示例 1：
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */

public class N1232checkStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int a = 0;
        int b = 0;
        if (coordinates[1][0] - coordinates[0][0] != 0) {
            a = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            b = coordinates[1][1] - a * coordinates[1][0];
        } else {
            b = coordinates[1][0];
        }
        for (int i = 1; i < coordinates.length; i++) {
                if (a * coordinates[i][0] + b != coordinates[i][1]) {
                    return false;
                }
            }

        return true;
    }

    public static void main(String[] args) {
        N1232checkStraightLine s = new N1232checkStraightLine();
        System.out.println(s.checkStraightLine(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(s.checkStraightLine(
                new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(s.checkStraightLine(
                new int[][]{{-7, -3}, {-7, -1}, {-2, -2}, {0, -8}, {2, -2}, {5, -6}, {5, -5}, {1, 7}}));
    }
}
