package leetcode.ainterview.kuaishou;

import java.util.Scanner;

public class Main3{
    public int longest(int[] nums){
        if (nums.length < 2){
            return 0;
        }
        int[][] dp = new int[nums.length][20001];
        int d;
        int ans = 0;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                d = nums[i] - nums[j] + 10000;
                if (dp[j][d] > 0){
                    dp[i][d] = Math.max(dp[j][d] + 1, dp[i][d]);
                } else {
                    dp[i][d] = 2;
                }
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main3 s =new Main3();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.longest(nums));
        }
    }
}