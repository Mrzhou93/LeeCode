package leetcode.ainterview.bytedance.a;

import java.util.*;

public class Main2 {

    int[][] arr;
    int[][] ans;

//    public void doRow(int i, int dir){
//        for ()
//    }

    public void doSome(int[][] arr, int dir){
        this.arr = arr;
        ans = new int[4][4];

        if (dir == 1 || dir == 2){
            for (int i = 0; i < 4; i++) {
                updown(i, dir);
            }
        } else {
            for (int i = 0; i < 4; i++){
                lr(i, dir);
            }
        }

        for (int[] a: ans){
            for (int n: a){
                System.out.print(n + " ");
            }
            System.out.println();
        }

//        System.out.println(Arrays.deepToString(ans));
    }

    public void updown(int n, int dir){
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        if (dir == 1){
            for (int j = 0; j < arr.length; j++){
                if (arr[j][n] != 0){
                    ((LinkedList<Integer>) queue).add(arr[j][n]);
                }
            }
            i = 0;
        } else if (dir == 2){
            for (int j = arr.length - 1; j >= 0; j--){
                if (arr[j][n] != 0){
                    ((LinkedList<Integer>) queue).add(arr[j][n]);
                }
            }
            i = arr.length - 1;
        }


        while (queue.size() >= 2){
            int one = queue.poll();
//            int two = queue.poll();
            if (one == queue.peek()){
                ans[i][n] = one + queue.poll();
            } else {
                ans[i][n] = one;
            }

//            ans[i][n] = newValue;
            if (dir == 1) i++;
            else i--;
        }
        if (!queue.isEmpty()){
            ans[i][n] = queue.poll();
        }
    }

    public void lr(int n, int dir){
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;

        if (dir == 3) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[n][j] != 0) {
                    ((LinkedList<Integer>) queue).add(arr[n][j]);
                }
            }
            i = 0;
        } else if (dir == 4){
            for (int j = arr.length - 1; j >= 0; j--){
                if (arr[n][j] != 0){
                    ((LinkedList<Integer>) queue).add(arr[n][j]);
                }
            }
            i = arr.length - 1;
        }

        while (queue.size() >= 2) {
            int one = queue.poll();
            if (one == queue.peek()) {
                ans[n][i] = one + queue.poll();
            } else {
                ans[n][i] = one;
            }
            if (dir == 3) {
                i++;
            } else {
                i--;
            }
        }
        if (!queue.isEmpty()){
            ans[n][i] = queue.poll();
        }
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int dir = sc.nextInt();
            int[][] arr = new int[4][4];
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            s.doSome(arr, dir);
        }
    }
}
// 1
//0 0 0 2
//0 0 0 2
//0 0 4 8
//0 0 4 8

//2
//        0 0 0 0
//        0 0 2 2
//        0 2 8 8
//        2 4 2 16