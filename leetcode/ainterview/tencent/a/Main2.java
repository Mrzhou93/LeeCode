package leetcode.ainterview.tencent.a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public int sati(int[][] nums){
        int len = nums.length;
        int ans = 0;

//        System.out.println(Arrays.deepToString(nums));

//        Arrays.sort(nums, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o2[0], o1[0]);
//            }
//        });

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                int i = Integer.compare(o1[0], o2[0]);


                if (o1[0] > o2[0])
                    return -1;
                else if (o1[0] == o2[0]){
                    if (o1[1] > o2[1])
                        return 1;
                    else if (o1[1] < o2[1])
                        return -1;
                    else
                        return -1;
                } else {
                    return 1;
                }
            }
        });


//        System.out.println(Arrays.deepToString(nums));

        for (int i = 0; i < len; i++){
            ans += nums[i][0] * ((i + 1) - 1) + nums[i][1] * (len - (i + 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        Main2 main = new Main2();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int num = sc.nextInt();
            int[][] nums = new int[num][2];

            for (int i = 0; i < num; i++){
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }

            System.out.println(main.sati(nums));
        }

//        System.out.println(main.sati(new int[][]{{1, 1}, {1, 3}, {4, 1}}));
//        System.out.println(main.sati(new int[][]{{1, 1}, {1, 3}, {4, 1}, {5, 1}, {4, 2}}));
//        System.out.println(main.sati(new int[][]{{1, 1}, {1, 3}, {1, 3}, {4, 1}}));
    }
}
