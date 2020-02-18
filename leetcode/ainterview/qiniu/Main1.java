package leetcode.ainterview.qiniu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public void getAns(int[] nums, int m){
        Map<Integer, Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int key: map.keySet()){
            if (map.containsKey(m - key) && !map.get(key).equals(map.get(m - key))){
                int a = map.get(key);
                int b = map.get(m - key);
                if (a < b){
                    System.out.println(a + " " + b);
                } else {
                    System.out.println(b + " " + a);
                }
                return;
            }
        }
        System.out.print("-1 -1");
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            s.getAns(nums, m);
        }
    }
}
