package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N905sortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j){
            if (A[i] % 2 == 0){
                i++;
            }

            if (A[j] % 2 == 1){
                j--;
            }

            if (i < j){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        N905sortArrayByParity s = new N905sortArrayByParity();

        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
