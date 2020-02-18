package leetcode.ainterview.tencent.a;

import java.util.Scanner;

public class Main3 {

    public int f(int[] nums){
        int ans = 0;
        int len = nums.length;
        int[] sum = new int[len + 1]; // 第i位上代表i和前面的数的和

        for (int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i -1];
        }

//        System.out.println(Arrays.toString(sum)); // (sum[j] - sum[i - 1]) * min
        // min为i到j中的最小值

        for (int i = 1; i < len; i++){
            for (int j = i + 1; j < len; j++) {
                int min = nums[i];
                for (int k = i; k < j; k++) {

                    min = Math.min(min, nums[k]);

//                    System.out.println(i + " " + j);
//                    System.out.println(min);
                }
                ans = Math.max(ans, (sum[j] - sum[i - 1]) * min);
            }
        }

//        System.out.println(min);

        return ans;
    }

    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
//            System.out.println(n);
//            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(main.f(nums));
        }
//        System.out.println(main.f(new int[]{7, 2, 4, 6, 5}));
    }
}

