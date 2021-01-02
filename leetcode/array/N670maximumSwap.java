package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N670maximumSwap {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int[] helper = new int[c.length];
        helper[c.length - 1] = c.length - 1;

        for (int i = c.length - 1; i >= 0; i--){  // 记下每一个位数字上，在其之后的最大数字的位置的索引
            int n = c[i] - '0';
            if (n > max){
                max = n;
                maxIndex = i;
            }
            helper[i] = maxIndex;
        }

        System.out.println(Arrays.toString(helper));
        System.out.println(maxIndex);

        for(int i = 0; i < c.length; i++){
            if (helper[i] != i  && c[helper[i]] != c[i]){ // 自己不是最大元素
                System.out.println(i);
                char tmp = c[i];
                c[i] = c[helper[i]];
                c[helper[i]] = tmp;
                break;
            }
        }

        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) {
        N670maximumSwap s = new N670maximumSwap();

        System.out.println(s.maximumSwap(2736));
        System.out.println(s.maximumSwap(9973));
        System.out.println(s.maximumSwap(98368));
    }
}
