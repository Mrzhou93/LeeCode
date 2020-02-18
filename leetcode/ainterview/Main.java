package leetcode.ainterview;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void getAns(int[][] path){
//        System.out.println(Arrays.deepToString(path));
//        int[][] ans = new int[path.length][path[0].length];
        for (int k= 0; k < path.length; k++){
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[0].length; j++) {
                    if (path[i][k] == Integer.MAX_VALUE || path[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    if (path[i][j] > path[i][k] + path[k][j]){
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Arrays.deepToString(path));

        for (int i = 0; i < path.length; i++){
            for (int j = 0; j < path[0].length; j++){
                if (i == j){
                    continue;
                }

                if (path[i][j] == Integer.MAX_VALUE) {
                    System.out.println(i + "到" + j + "之间没有路径");
                } else {
                    System.out.println(i + "到" + j + "之间的最短路径长度为：" + path[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            int m = Integer.valueOf(sc.nextLine());
            int[][] path = new int[n][m];
            for (int i = 0; i < n; i++){
                String[] str = sc.nextLine().split(" ");
                for (int j = 0; j < m; j++){
                    if (str[j].equals("a")){
                        path[i][j] = Integer.MAX_VALUE;
                    } else {
                        path[i][j] = Integer.valueOf(str[j]);
                    }
                }
            }
            s.getAns(path);
        }
    }
}

//        6
//        6
//        0 a a a 30 100
//        a 0 a a a a
//        1 a 0 50 a a
//        1 a a 0 a 10
//        a a a 20 0 60
//        a a 1 a a 0