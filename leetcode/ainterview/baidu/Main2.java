package leetcode.ainterview.baidu;

/**
 * 公共交通
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 作为一个现代化城市，公共交通是不可缺少的，在A城市中，有n个公共交通站，由于前期缺少规划，所以在部分站点之间已经开通了公交线，但是并不能保证这n个公交站之间的都是可以到达的。
 *
 * 政府通过详细的市场调研，得知了开通某些站点之间的线路所需的代价，因为要节约开支，所以政府希望在保证这n个站点连通的前提下，尽可能的减少总的花费。保证一定有一种方案使得图连通。
 *
 * 请问政府至少需要花费多少代价。
 *
 * 输入
 * 输入第一行包含三个正整数n和m，k，表示有n个站点，编号为1-n，m条已经修建好的线路，k条经过市场调研的线路。(1<=n<=500,1<=m,k<=100000)
 *
 * 接下来m行，每行有两个正整数，a,b，表示a站点和b站点之间的线路已经修好。(1<=a,b<=n)
 *
 * 再接下来有k行，每行三个正整数,a,b,v，表示如果要修建a和b之间的线路，所需的代价是v。(1<=a,b<=n,1<=v<=1000)
 *
 * 输出
 * 输出仅包含一个整数，表示使得站点之间可以通过换乘到达的修建方案的最小代价
 *
 *
 * 样例输入
 * 5 3 3
 * 1 2
 * 1 3
 * 4 5
 * 3 2 10
 * 1 4 6
 * 3 5 2
 * 样例输出
 * 2
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {

    private int[] parent;

    public int getMin(int N, int[][] has, int[][] cost){
        parent = new int[N + 1];
        int ans = 0;
        for (int i = 1; i <= N ; i++){
            parent[i] = i;
        }

        for (int[] path: has){
            if (path[0] < path[1]){
                parent[find(path[1])] = find(path[0]);
            } else {
                parent[find(path[0])] = find(path[1]);
            }
        }
//        System.out.println(Arrays.toString(parent));

        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for (int[] c: cost){
            if (find(c[0]) != find(c[1])){
                ans += c[2];

                if (c[0] < c[1]){
                    parent[find(c[1])] = find(c[0]);
                } else {
                    parent[find(c[0])] = find(c[1]);
                }
            }
        }

        return ans;
    }

    private int find(int x){
        int i = x;
        while(parent[i] != i){
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();

            int[][] has = new int[k][2];
            for (int i = 0; i < k; i++){
                has[i][0] = sc.nextInt();
                has[i][1] = sc.nextInt();
            }

            int[][] cost = new int[l][3];
            for (int i = 0; i < l; i++){
                cost[i][0] = sc.nextInt();
                cost[i][1] = sc.nextInt();
                cost[i][2] = sc.nextInt();
            }
            System.out.println(s.getMin(N, has, cost));
        }
    }
}
