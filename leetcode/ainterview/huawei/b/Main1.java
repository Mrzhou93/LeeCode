package leetcode.ainterview.huawei.b;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortPath(int[][] path, int n){
        if (path[0][0] == 0) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(0);

        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        int size = 0;
        int step = 1;

        while (!queue.isEmpty()){
            size = queue.size();
            step++;
            for (int i = 0; i < size; i++){
                int x = queue.peek() / 100;
                int y = queue.peek() % 100;
               for (int j = 0; j < 4; j++){
                   int xx = x + dir[j][0];
                   int yy = y + dir[j][1];
                   if (xx >= 0 && xx < n && yy >= 0 && yy < n && path[xx][yy] != 0){
                       if (dp[xx][yy] == 0) {
                           dp[xx][yy] = step;
                       } else {
                           dp[xx][yy] = Math.min(dp[xx][yy], step);
                       }

                       ((LinkedList<Integer>) queue).add(xx * 100 + yy);
                   }
               }
               queue.poll();
            }
        }

        return dp[n - 1][n - 1] == 0? -1: dp[n - 1][n - 1] - 1;
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc =new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[][] path = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    path[i][j] = sc.nextInt();
                }
            }
            System.out.println(s.shortPath(path, n));
        }
    }
}
