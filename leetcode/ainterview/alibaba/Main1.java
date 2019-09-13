package leetcode.ainterview.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一只兔子要通过一个n * n （6<= n <= 30)的方格机关区域，兔子每踩一个方格就会触发与之邻边的方格机关,机关触发后会散发迷雾，
 * 机关所在方格的数字对应迷雾散发的时间，数字越小，迷雾散发的时间越短，迷雾散去之后才能继续前进。由于被触发机关的方格是不能行走的，
 * 兔子只能跳着通过该区域。假如兔子每次只能跳过与当前所在方格相邻的一个方格，请为兔子计算出从该正方形区域的最上边中的任意一点出发，
 * 最快时间通过该区域到达最下边所需要的时间。
 * 要求： 兔子只能从左向右或者从上向下走；方格中的数字大于0，小于100；只有机关被触发的方格才能被跳过
 *
 * 输入：
 * 1. 第一行输入一个数字n，表示方格机关的区域大小
 * 2. 随后输入n行，每行有n个使用逗号分隔的数字，分别代表方格机关每一行对应的方格中的数字
 * 输出：
 * 1. 从最上边开始，最快时间通过区域到达对边，所需要的时间
 *
 *
 *
 *
 *
 * 示例：
 * 输入：
 * 6
 * 1,2,3,5,7,6
 * 2,1,4,5,7,4
 * 3,4,5,6,3,6
 * 2,3,1,4,6,8
 * 5,6,1,4,6,2
 * 4,2,4,1,1,6
 *
 * 输出：
 * 6
 *
 * 说明：
 * 兔子有两种方式以最短时间通过该区域（假设方格区域为二维数组 a ）
 * 1. 兔子所踩方格的坐标依次为： a[0][1] -> a[2][1] -> a[4][1] ；
 *     期间跳过机关格子依次为： a[1][1] -> a[3][1] -> a[5][1] ；
 *     对应的通过时间为： 1 + 3 + 2 = 6
 *
 * 2. 兔子所踩方格的坐标依次为； a[0][1] -> a[2][1] -> a[4][1] -> a[4][3] ;
 *     期间跳过的机关格子依次为： a[1][1] -> a[3][1] ->a[4][2] -> a[5][3] ;
 *     对应的通过时间为： 1 + 3 +1 +1 = 6
 */

public class Main1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String line = scanner.nextLine();
//        int n = Integer.parseInt(line);
//        int[][] area = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            line = scanner.nextLine();
//            String[] split = line.split(",");
//            if (split.length != n) {
//                throw new IllegalArgumentException("错误输入");
//            }
//            int j = 0;
//            for (String num : split) {
//                area[i][j++] = Integer.parseInt(num);
//            }
//        }
        int n = 6;
        int[][] area = new int[][]{{1,2,3,5,7,6},{2,1,4,5,7,4},{3,4,5,6,3,6},{2,3,1,4,6,8},{5,6,1,4,6,2},{4,2,4,1,1,6}};

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int[][] dp = new int[n + 1][n + 1];
//        System.out.println(Arrays.deepToString(dp));
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][2] = Integer.MAX_VALUE;
        dp[2][1] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.println(i + " " + j);
                int fromTop =Integer.MAX_VALUE;
                int fromLeft =Integer.MAX_VALUE;
                if (i != 1){
                    fromLeft = dp[i - 2][j] + area[i - 2][j - 1];
                    dp[i][j] = fromLeft;
                    continue;
                }

                if (j != 1){
                    fromTop = dp[i][j - 2] + area[i - 1][j - 2];
                    dp[i][j] = fromTop;
                    continue;
                }

                dp[i][j] = Math.min(fromTop, fromLeft);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++){
            ans = Math.min(ans, dp[n][i]);
        }
        System.out.println(Arrays.deepToString(dp));

        return ans;
    }
}
