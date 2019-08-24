package leetcode.dp;

import java.util.Arrays;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * */

public class N264nthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return -1;

        if (n == 1)
            return 1;

        int dp[] = new int[n];
        dp[0] = 1;
        int index[] = {0, 0, 0};

        for (int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[index[0]] * 2, dp[index[1]] * 3), dp[index[2]] * 5);

            if (dp[i] == dp[index[0]] * 2)
                index[0]++;
            if (dp[i] == dp[index[1]] * 3)
                index[1]++;
            if (dp[i] == dp[index[2]] * 5)
                index[2]++;

            System.out.println("========");
            System.out.println(Arrays.toString(dp));
            System.out.println(Arrays.toString(index));
        }
        return dp[n - 1];
    }


    public static void main(String [] args){
        N264nthUglyNumber s = new N264nthUglyNumber();
        System.out.println(s.nthUglyNumber(10) == 12);        // 12
//        System.out.println(s.nthUglyNumber(11) == 15);        // 15
//        System.out.println(s.nthUglyNumber(12) == 16);        // 16
    }
}
