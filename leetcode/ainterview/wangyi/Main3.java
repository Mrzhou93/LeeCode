package leetcode.ainterview.wangyi;

import java.util.Scanner;

public class Main3 {

    public void getAns(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;

        for (int i = 1; i <= nums.length; i++){
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        int ans = 0;
        for (int i = 1; i <= nums.length; i++){
            if (nums[i - 1] >= dp[i] - nums[i - 1]){
                ans = i;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Main3 s = new Main3();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){

            int t = sc.nextInt();

            for (int j = 0; j < t; j ++){
                int n = sc.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++){
                    nums[i] = sc.nextInt();
                }
                s.getAns(nums);
            }


//            System.out.println(Arrays.toString(nums));
        }
    }
}
