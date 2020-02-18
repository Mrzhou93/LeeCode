package leetcode.ainterview.wangyi;

import java.util.Scanner;

public class Main {

    public int pair(int[] nums, int[] copy, int low, int high){
        if (low == high){
            return 0;
        }

        int mid = (low + high) >> 1;
        int leftCount = pair(nums, copy, low, mid);
        int rightCount = pair(nums, copy, mid + 1, high);
        int ans = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid){
            if (nums[i] > nums[j]){
                ans = Math.abs(i - j);
                copy[locCopy--] = nums[i--];
            } else {
                copy[locCopy--] = nums[j--];
            }
        }
        for (; i >= low; i--){
            copy[locCopy--] = nums[i];
        }
        for (; j > mid; j--){
            copy[locCopy--] = nums[j];
        }
        for (int s = low; s <= high; s++){
            nums[s] = copy[s];
        }
        return leftCount + rightCount + ans;
    }

    public int ans(int[] nums){

        int[] copy = nums.clone();

        return pair(nums, copy, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(s.ans(nums));
        }
    }
}
