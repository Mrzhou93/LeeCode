package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]  2  4
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]  3  5
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]   2  4
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]  8  6
 * 输出：[5,4]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N888fairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aTotal = 0, bTotal = 0;
        Set<Integer> set = new HashSet<>();

        for (int a: A) {
            aTotal += a;
            set.add(a);
        }

        for (int b: B){
            bTotal += b;
        }

        int delta = (aTotal - bTotal) / 2;

        // A要减去delta，B要加上delta
        for (int b: B){
            if (set.contains(b + delta))
                return new int[]{b + delta, b};
        }
        return null;
    }

    public static void main(String[] args) {
        N888fairCandySwap s = new N888fairCandySwap();

        System.out.println(Arrays.toString(s.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}
