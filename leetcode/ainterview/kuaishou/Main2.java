package leetcode.ainterview.kuaishou;

import java.util.Scanner;

public class Main2 {

    public long diff(long[] nums){
        long ans = Long.MAX_VALUE;
        long[] helper = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++){
            helper[i + 1] = helper[i] + nums[i];
        }

        for (int i = 1; i <= nums.length; i++){
            ans = Math.min(ans, Math.abs(helper[nums.length] - helper[i - 1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            long[] nums = new long[n];
            for(int i = 0; i < n ; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.diff(nums));
        }
    }
}
