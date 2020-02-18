package leetcode.ainterview.bytedance.a;

import java.util.Scanner;

public class Main3 {

    int MOD = 1000000007;

    public int dp(int n){
        int m = (n / 2) + 1;
        int[] dp = new int[m];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++){
            for (int j = 1; j < i; j++){
                dp[i] += (dp[i - 1 - j] * dp[j]);
                dp[i] %= MOD;
            }
            dp[i] += (dp[1] * dp[i - 1] * 2) % MOD;
            dp[i] %= MOD;
//            dp[i] = dp[i] % MOD;
        }

//        System.out.println(Arrays.toString(dp));
        return dp[m - 1];
    }

    public static void main(String[] args) {
        Main3 s = new Main3();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(s.dp(n));
        }

//        System.out.println(s.dp(4));  // 2
//        System.out.println(s.dp(6));  // 5
//        System.out.println(s.dp(8));  // 14
//        System.out.println(s.dp(10));  //
//        System.out.println(s.dp(12));  //
    }

}
