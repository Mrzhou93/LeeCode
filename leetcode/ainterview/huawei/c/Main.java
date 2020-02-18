package leetcode.ainterview.huawei.c;

import java.util.Arrays;
import java.util.Scanner;

/**
12,12
12,15
16,17
12,20
19,20
20,20
-1,-1

[12, 13):2
[13, 14):2
[14, 15):2
[15, 16):1
[16, 17);2
[17, 18):1
[19, 20):1
[19, 20):1
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] people = new int[8];

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("-1,-1")) {
                break;
            }

            String[] ll = line.split(",");

            int start = Integer.valueOf(ll[0]);
            int end = Integer.valueOf(ll[1]);
            if (start < 12 && end > 20){
                continue;
            }
            for (int i = start; i < end; i++){
                people[i - 12]++;
            }

            System.out.println(Arrays.toString(people));
        }

        for (int i = 0; i < 8; i++){
            System.out.print("[" + (i + 12) + "," + (i + 13) + ")" + ":" + people[i]);
        }
    }
}
