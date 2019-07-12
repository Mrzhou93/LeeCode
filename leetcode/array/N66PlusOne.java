package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N66PlusOne {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            System.out.println(Arrays.toString(digits));
            if (digits[i] != 0)
                return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusone1(int[] digits){
        int i = digits.length - 1;

        if (digits[i] != 9){
            digits[i]++;
            return digits;
        }

        boolean flag=true;

        while (i >= 0 && flag){
            digits[i--] = 0;
            if (i>=0 && digits[i] !=9 ) {
                digits[i]++;
                flag = false;
            } else if(i<0){
                int[] newdigits = new int[digits.length+1];
                newdigits[0]=1;
                for (int j=0; j<digits.length ;j++){
                    newdigits[j+1] = digits[j];
                }
                return newdigits;
            }

        }
        return digits;
    }

    public static void main(String[] args){
        int[] num = {1, 2, 3};
        int[] num1 = {4, 3, 2, 1};
        int[] num2 = {9};
        int[] num3 = {3, 2, 9};

        N66PlusOne s = new N66PlusOne();

        System.out.println(Arrays.toString(s.plusOne(num)));
        System.out.println(Arrays.toString(s.plusOne(num1)));
        System.out.println(Arrays.toString(s.plusOne(num2)));
        System.out.println(Arrays.toString(s.plusOne(num3)));
    }
}
