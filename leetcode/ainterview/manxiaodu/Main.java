package leetcode.ainterview.manxiaodu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 车辆过桥
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 有 N 辆车要陆续通过一座最大承重为 W 的桥，其中第 i 辆车的重量为 w[i]，通过桥的时间为 t[i]。要求： 第 i 辆车上桥的时间不早于第 i - 1 辆车上桥的时间；
 *
 * 任意时刻桥上所有车辆的总重量不超过 W。
 *
 * 那么，所有车辆都通过这座桥所需的最短时间是多少？
 *
 * 输入
 * 第一行输入两个整数 N、W（1 <= N、W <= 100000）。第二行输入 N 个整数 w[1] 到 w[N]（1 <= w[i] <= W）。第三行输入 N 个整数 t[1] 到 t[N]（1 <= t[i] <= 10000）。
 *
 * 输出
 * 输出一个整数，表示所有车辆过桥所需的最短时间。
 *
 *
 * 样例输入
 * 4 2
 * 1 1 1 1
 * 2 1 2 2
 * 样例输出
 * 4
 *
 * 提示
 * 样例解释
 * 不妨设第 1 辆车在 0 时刻上桥，则：
 * 第 2 辆车也可以在 0 时刻上桥；
 * 第 2 辆车在 1 时刻下桥，此时第 3 辆车上桥；
 * 第 1 辆车在 2 时刻下桥，此时第 4 辆车上桥；
 * 第 3 辆车在 3 时刻下桥；
 * 第 4 辆车在 4 时刻下桥，此时所有车辆都通过这座桥。
 */

public class Main {

    public int minTime(int[][] cars, int w, int maxTime){
        Map<Integer, Integer> map = new HashMap<>();
        int t = 0;
        int i = 0;
        int has = 0;

        for (; t < maxTime + 1; t++){

            if (map.containsKey(t)){
                has -= map.get(t);
                map.remove(t);
            }

            while (i < cars.length && has + cars[i][0] <= w){
                has += cars[i][0];
                map.put(t + cars[i][1],
                        map.getOrDefault(t + cars[i][1], 0) + cars[i][0]);
                i++;
            }

            if (i == cars.length && has == 0){
                break;
            }
        }

        return t;
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int w = sc.nextInt();
            int max = 0;
            int[][] cars = new int[n][2];

            for (int i = 0; i < n; i++){
                cars[i][0] = sc.nextInt();
            }

            for (int i = 0; i < n; i++){
                cars[i][1] = sc.nextInt();
                max += cars[i][1];
            }

            System.out.println(s.minTime(cars, w, max));
        }
    }
}
