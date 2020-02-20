package leetcode.array;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 */
public class N1346checkIfExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int i;
        int j = arr.length - 1;

        while (j > 0){
            i = j - 1;
            while (i > 0 && arr[i] * 2 != arr[j] && arr[j] * 2 != arr[i]){
                i--;
            }
//            System.out.println(i + " " + j);
            if (arr[i] * 2 == arr[j] || arr[j] * 2 == arr[i]){
                return true;
            }
            j--;
        }

        return false;
    }

    public static void main(String[] args) {
        N1346checkIfExist s = new N1346checkIfExist();
        System.out.println(s.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(s.checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(s.checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(s.checkIfExist(new int[]{-20,8,-10,-14,0,-19,14,4}));
        System.out.println(s.checkIfExist(new int[]{-20,-10,-14,0,-19}));
    }
}
