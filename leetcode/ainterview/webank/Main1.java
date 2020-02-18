package leetcode.ainterview.webank;

import java.util.Scanner;

public class Main1 {

    public int lastNoZeroNum(int n){
        int ans = 1;
        for (int i = n; i >= 2; i--){
            ans *= i;
            while (ans % 10 == 0){
                ans /= 10;
            }
            if (ans >= 100000){
                ans %= 100000;
            }
        }
        return ans % 10;
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(s.lastNoZeroNum(n));
        }
    }
}
