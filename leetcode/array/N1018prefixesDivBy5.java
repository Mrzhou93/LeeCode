package leetcode.array;
import java.util.*;

/**
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数
 * （从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N1018prefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {      // 有溢出的可能
        List<Boolean> result = new LinkedList<>();
        int toNum = 0;

        for (int i=0; i< A.length; i++){
            System.out.println(toNum);
            toNum = toNum * 2 + A[i];
            toNum %= 10;
            if (toNum % 5 == 0) {
                result.add(true);
            }
            else
                result.add(false);
        }
        return result;
    }

    public static void main(String[] args){

        int[] num1 = {0,1,1};
        int[] num2 = {1,1,1};
        int[] num3 = {0,1,1,1,1,1};
        int[] num4 = {1,1,1,0,1};
        int[] num5 = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};

        N1018prefixesDivBy5 s = new N1018prefixesDivBy5();
        System.out.println(s.prefixesDivBy5(num1));
        System.out.println(s.prefixesDivBy5(num2));
        System.out.println(s.prefixesDivBy5(num3));
        System.out.println(s.prefixesDivBy5(num4));
        System.out.println(s.prefixesDivBy5(num5));
    }
}
