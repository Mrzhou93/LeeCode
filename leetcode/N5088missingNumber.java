package leetcode;

/**
 * 数组 arr 中的值符合等差数列的数值规律：在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
 *
 * 然后，我们从数组中删去一个 既不是第一个也不是最后一个的值 。
 *
 * 给你一个缺失值的数组，请你帮忙找出那个被删去的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,7,11,13]
 * 输出：9
 * 解释：原来的数组是 [5,7,9,11,13]。
 * 示例 2：
 *
 * 输入：arr = [15,13,12]
 * 输出：14
 * 解释：原来的数组是 [15,14,13,12]。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 10^5
 */

public class N5088missingNumber {

    public int missingNumber(int[] arr) {

        int sum = 0;
        for (int a: arr){
            sum += a;
        }

        int len = arr.length;
//        System.out.println(sum);
//
//        if (len % 2 == 0){
//            return sum - (arr[0] + arr[len - 1])
//        }

        return ((arr[0] + arr[len - 1]) * (len + 1) / 2) - sum;
    }

    public static void main(String[] args) {
        N5088missingNumber s = new N5088missingNumber();
        System.out.println(s.missingNumber(new int[]{5, 7, 11, 13}));
        System.out.println(s.missingNumber(new int[]{15, 13, 12}));
        System.out.println(s.missingNumber(new int[]{1, 2, 3, 5}));
    }
}
