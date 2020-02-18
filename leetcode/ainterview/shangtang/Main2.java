package leetcode.ainterview.shangtang;

import java.util.Scanner;

public class Main2 {

    public int sum(int[] nums){
        int maxSum = 0;
        int thisSum = 0;

        for (int i = 0; i < nums.length; i++){
            thisSum += nums[i];
            if (thisSum < 0){
                thisSum = 0;
            } else if (thisSum > maxSum){
                maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.sum(nums));
        }
    }
}
