package leetcode.ainterview.tencent.a;

import java.util.Scanner;

public class Main1 {
    public int findBox(int[] a, int[] b){
        int ja = 0;
        int oa = 0;
        int jb = 0;
        int ob = 0;
        int ans = 0;
        for (int aa: a){
            if (aa % 2 == 1){
                ja++;
            }
        }

        for (int bb: b){
            if (bb % 2 == 1){
                jb++;
            }
        }

        oa = a.length - ja;
        ob = b.length - jb;

        ans += ja < ob? ja: ob;
        ans += jb < oa? jb: oa;

        return ans;
    }

    public static void main(String[] args) {
        Main1 main = new Main1();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int aLength = sc.nextInt();
            int bLength = sc.nextInt();

            int[] a = new int[aLength];
            int[] b = new int[bLength];

            for (int i = 0; i < aLength; i++){
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < bLength; i++){
                b[i] = sc.nextInt();
            }

            System.out.println(main.findBox(a, b));
        }

//        System.out.println(main.findBox(new int[]{1, 1}, new int[]{1, 1}));
//        System.out.println(main.findBox(new int[]{1, 2}, new int[]{2, 1}));
    }
}
