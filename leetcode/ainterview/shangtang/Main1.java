package leetcode.ainterview.shangtang;

import java.util.Scanner;

public class Main1 {

    public int path(int m, int n){
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(s.path(m, n));
        }
    }
}
