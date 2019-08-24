package leetcode.jzoffer;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0 ~ n-1的范围内。数组中1某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次，请找出数组中任意一个重复的数字。
 *
 *
 * 例：
 * {2, 3, 1, 0, 2, 5, 3}    2或3
 */

public class N3duplicateNum {
    public int findNum(int[] nums){
        if (nums.length == 0){
            return -1;
        }


        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    return nums[i];
                }

                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;

                System.out.println(Arrays.toString(nums));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        N3duplicateNum s = new N3duplicateNum();

        System.out.println(s.findNum(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
