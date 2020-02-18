package leetcode.ainterview.bytedance.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {

    public int happy(int[][] info, int money){
        int ans = 0;
        int pay = 0;
        int discount = 0;
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }
        });

//        System.out.println(Arrays.deepToString(info));

        for (int[] f: info){
            pay += f[1];
            discount += (f[0] - f[1]);
//            System.out.println(huade);

            if (pay < money){
//                System.out.println("in");
                ans += f[2];
            } else {
                if (discount >= (pay - money)){
                    ans += f[2];
                } else {
                    pay -= f[1];
                    discount -= (f[0] - f[1]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main4 s = new Main4();
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int money = sc.nextInt();
            int[][] nums = new int[n][3];
            for (int i = 0; i < n; i++){
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
                nums[i][2] = sc.nextInt();
            }

            System.out.println(s.happy(nums, money));
        }
    }
}
