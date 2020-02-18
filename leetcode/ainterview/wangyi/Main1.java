package leetcode.ainterview.wangyi;

import java.util.Scanner;

public class Main1 {

    public void findMin(int n){
        StringBuffer sb = new StringBuffer();
        while (n >= 9){
            sb.append(9);
            n -= 9;
        }
        if (n != 0){
            sb.append(n);
        }

        sb.reverse();

        for (int i = 0; i < sb.length(); i++){
            System.out.print(sb.charAt(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            s.findMin(n);
        }
    }
}
