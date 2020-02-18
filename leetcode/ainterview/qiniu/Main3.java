package leetcode.ainterview.qiniu;

import java.util.Scanner;

public class Main3 {

    public void getAns(int[] nums, int n){
        int start = -1;
        int i = 0;

        for (; i < nums.length; i++){
            if (nums[i] > n){
                break;
            } else if (nums[i] == n && start == -1){
                start = i;
            }
        }
        if(start == -1){
            System.out.println(-1 + " " + -1);
        } else {
            System.out.println(start + " " + (i - 1));
        }
    }

    public static void main(String[] args) {
        Main3 s = new Main3();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            s.getAns(nums, m);
        }
    }
}
