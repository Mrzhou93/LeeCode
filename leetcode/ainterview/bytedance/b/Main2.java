package leetcode.ainterview.bytedance.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {

    public void getAns(int[][] fileInfo){
        int maxTime = 0;
        int file = 0;
        int maxFile = 0;
        Arrays.sort(fileInfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        for (int[] f: fileInfo){
            if (maxTime == 0){
                maxTime = f[0];
                file = f[1];
                maxFile = f[1];
            } else {
                int diff = f[0] - maxTime;
                if (diff > file){
                    file = 0;
                } else {
                    file -= diff;
                }

                file += f[1];
                maxFile = Math.max(maxFile, file);
                maxTime = f[0];
            }
        }

        System.out.println((maxTime + file) + " " + maxFile);
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] nums = new int[n][2];

            for (int i = 0; i < n; i++){
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            s.getAns(nums);
        }
    }
}
