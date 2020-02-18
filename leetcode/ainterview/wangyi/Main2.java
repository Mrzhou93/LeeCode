package leetcode.ainterview.wangyi;

import java.util.Scanner;

public class Main2 {

    public void getAns(int[][] nums){
        int A, B, p, q, ans;

        for (int[] num: nums){
            A = num[0];
            B = num[1];
            p = num[2];
            q = num[3];
            ans = 0;
            int lastp = p;

            while (A < B){
                if (A + p >= B){
                    A += p;
                    ans++;
                } else {
                    if (2 * p > p * q) {
                        A += 2 * p;
                    } else {
                        p = p * q;
                        A += p;

                    }
                    ans += 2;
                }
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] nums = new int[n][4];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < 4; j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            s.getAns(nums);
        }
    }
}
