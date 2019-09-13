package leetcode.ainterview.sf;



/**
 * 圈格子
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 我们现在需要在一个二维网格上画一个封闭图形，你有两种操作：
 *
 * 1. 连接一个1*1格子的对角线。
 *
 * 2. 连接一个1*1格子的一条边。
 *
 * 已知你每分钟只能选择一个操作，现在要求你画出一个面积至少为m的多边形，请问你至少需要多长时间？
 *
 * 输入
 * 输入第一行是一个数据组数T。(1<=T<=300)
 *
 * 接下来有T行，每行一个正整数q，表示多边形至少要涵盖的面积（1<=q<=10^9）。
 *
 * 输出
 * 对于每一个q，输出一行，表示至少需要多少分钟。
 *
 *
 * 样例输入
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 * 样例输出
 * 4
 * 4
 * 6
 * 6
 * 7
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[] dp(int n){

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 4;
        dp[2] = 4;
        dp[3] = 6;
        dp[4] = 6;
        for (int i = 5; i <= n; i++){
            for (int j = 1; j < i / 2; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j] - 2);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Main s= new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            int a;
            int Max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++){
                a = sc.nextInt();
                Max = Math.max(Max, a);
                nums[i] = a;
            }
            int[] dpArray = s.dp(Max);

            for (int num: nums){
                System.out.println(dpArray[num]);
            }
        }
    }
}
