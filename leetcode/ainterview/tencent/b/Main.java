package leetcode.ainterview.tencent.b;

/**
 * 2
 * 4
 * 5 9 4 7
 * 8
 * 9 13 18 10 12 4 18 3
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void sum(int[] nums){
        Arrays.sort(nums);
        int a = 0;
        int counta = 0;
        int b = 0;
        int countb = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            while (a < b && Math.abs(counta - countb) <= 1){
                if (a + nums[i] < b) {
                    a += nums[i++];
                    counta++;
                } else {
                    a += nums[j--];
                    counta++;
                }
            }
            while (a >= b && Math.abs(counta - countb) <= 1){
                if (b + nums[i] > a){
                    b += nums[i++];
                    countb++;
                } else {
                    b += nums[j--];
                    countb++;
                }
            }
        }

        if (a < b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);

        sc.nextInt();

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            s.sum(nums);
        }
    }
}
