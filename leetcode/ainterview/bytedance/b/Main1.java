package leetcode.ainterview.bytedance.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public int sati(int[] nums, int k){
        Arrays.sort(nums);
        int ans = 0;

        int length = nums.length;
        if (length < 3) {
            return ans;
        }

        for (int a = 0; a < nums.length - 3; a++){
            int b = a + 1;
            int c = nums.length - 1;

            while (b < c){
                if (nums[a] + nums[b] + nums[c] < k){
                    ans += c - b;
                    b++;
                } else {
                    c--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main1 soultion = new Main1();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }

            int k = sc.nextInt();

            System.out.println(soultion.sati(nums, k));
        }
//        System.out.println(soultion.sati(new int[]{-2, 0, 1, 2, 3, 6}, 2));
    }
}
