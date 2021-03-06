package leetcode.array;

import java.util.Arrays;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */

public class N1109corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking: bookings){
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int num = booking[2];
            ans[start] += num;

            if (end + 1 < n){
                ans[end + 1] -= num;
            }

//            System.out.println(Arrays.toString(ans));
        }

        for (int i = 1; i < n; i++){
            ans[i] += ans[i - 1];
        }

        return ans;
    }

//    public int[] corpFlightBookings(int[][] bookings, int n) {  // 超时
//        int[] ans = new int[n];
//
//        for (int[] booking: bookings){
//            int from = booking[0];
//            int to = booking[1];
//            int num = booking[2];
//            for (int i = from - 1; i < to; i++){
//                ans[i] += num;
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        N1109corpFlightBookings s = new N1109corpFlightBookings();

        System.out.println(Arrays.toString(s.corpFlightBookings(
                new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
}
