package leetcode.ainterview.bytedance;

import java.util.Scanner;

public class Main1 {

    int[] parent;

    public int unionFind(int[][] nums){
        parent = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < nums.length; i++){
            parent[i] = i;
        }

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (nums[i][j] >= 3){
                    parent[find(i)] = find(j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < len; i++){
            if (i == parent[i])
                ans++;
        }
        return ans;
    }

    public int find(int x){
        int i = x;
        while (parent[i] != i){
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] nums = new int[n][n];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    nums[i][j] = sc.nextInt();
                }
            }

            System.out.println(s.unionFind(nums));

        }

//        System.out.println(s.unionFind(new int[][]{{0, 4, 0}, {4, 0, 0}, {0, 0, 0}}));  // 2
//        System.out.println(s.unionFind(new int[][]{{0, 4, 0}, {4, 0, 6}, {0, 6, 0}}));  // 1
    }
}
