package leetcode.map;

import java.util.*;

/**
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，
 * 车只能向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 *
 * 这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location]
 * 包含了你的第 i 次行程信息：
 *
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 *
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务
 * （当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 示例 3：
 *
 * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
 * 输出：true
 * 示例 4：
 *
 * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * 输出：true
 *
 * 提示：
 *
 * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */

public class N1094carPooling {
    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1])); // 以start进行排序

//        Stack<int[]> lastTrip = new Stack<>();

        PriorityQueue<int[]> lastTrip = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

//        System.out.println(Arrays.deepToString(trips));
        int total = 0;

        if (trips[0][0] > capacity)
            return false;

        total += trips[0][0];
        lastTrip.add(trips[0]);

        for (int i = 0; i < trips.length -1; i++){
//            System.out.println(i + " total=" + total);
            if (trips[i + 1][1] < lastTrip.peek()[2]){  // 有交集
                if (total + trips[i + 1][0] > capacity)
                    return false;

                total += trips[i + 1][0];
                lastTrip.add(trips[i + 1]);
            } else {
                while (!lastTrip.isEmpty() && trips[i + 1][1] > lastTrip.peek()[2]){
                    total -= lastTrip.peek()[0];
                    lastTrip.remove();
                }

                lastTrip.add(trips[i + 1]);
                total += trips[i + 1][0];
            }
        }

        return true;
    }

    public boolean carPooling(int[][] trips, int capacity){
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();

        for (int[] trip: trips){
            startMap.put(trip[1], startMap.getOrDefault(trip[1], 0) + trip[0]);
            endMap.put(trip[2], endMap.getOrDefault(trip[2], 0) + trip[0]);
        }

        int cur = 0;
        for (int i = 0; i <= 1000; i++){
            if (startMap.containsKey(i)) {
                cur += startMap.get(i);
            }

            if (endMap.containsKey(i)){
                cur -= endMap.get(i);
            }

            if (cur > capacity){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        N1094carPooling s= new N1094carPooling();

        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int[][] trips1 = new int[][]{{2, 1, 5}, {3, 5, 7}};
        int[][] trips2 = new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        int[][] trips3 = new int[][]{{8, 2, 3}, {4, 1, 3}, {1, 3, 6}, {8, 4, 6}, {4, 4, 8}};
        int[][] trips4 = new int[][]{{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}};
        int[][] trips5 = new int[][]{{3, 6, 9}, {10, 2, 3}, {1, 6, 8}, {2, 1, 6}, {9, 3, 9}};

        System.out.println(!s.carPooling(trips, 4));
        System.out.println(s.carPooling(trips, 5));
        System.out.println(s.carPooling(trips1, 3));
        System.out.println(s.carPooling(trips2, 11));
        System.out.println(!s.carPooling(trips3, 12));
        System.out.println(s.carPooling(trips3, 13));
        System.out.println(s.carPooling(trips4, 23));
        System.out.println(!s.carPooling(trips5, 12));
    }
}
