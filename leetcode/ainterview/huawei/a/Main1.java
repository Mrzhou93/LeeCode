package leetcode.ainterview.huawei.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    private int MAX = 65536;

    public void findCombination(int[] A, int[] B, int R){
        int[] nums = new int[MAX];
        int[] ans = new int[A.length];

        for (int b: B){
            nums[b] = 1;
        }

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < MAX - A[i]; j++){
                if (A[i] + j < MAX && nums[A[i] + j] == 1){
                    ans[i] = A[i] + j;
                    break;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (ans[i] != 0) {
                System.out.print("(" + A[i] + "," + ans[i] + ")");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main1 s = new Main1();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();

            String[] ss = str.split("\\D");

            int i = 0;
            List<Integer> AContainer = new ArrayList<>();
            for (; i < ss.length; i++){
                if (AContainer.size() != 0 && ss[i].length() == 0){
                    break;
                }

                if (ss[i].length() != 0){
                    AContainer.add(Integer.valueOf(ss[i]));
                }
            }

            List<Integer> BContainer = new ArrayList<>();
            for (; i < ss.length; i++){
                if (BContainer.size() != 0 && ss[i].length() == 0){
                    break;
                }

                if (ss[i].length() != 0){
                    BContainer.add(Integer.valueOf(ss[i]));
                }
            }
            int[] A = new int[AContainer.size()];
            for (int j = 0; j < AContainer.size(); j++){
                A[j] = AContainer.get(j);
            }
            int[] B = new int[BContainer.size()];
            for (int j = 0; j < BContainer.size(); j++){
                B[j] = BContainer.get(j);
            }
            s.findCombination(A, B, Integer.valueOf(ss[ss.length - 1]));
        }
        // "A={1,3,5},B={2,4,6},R=1"
    }
}
