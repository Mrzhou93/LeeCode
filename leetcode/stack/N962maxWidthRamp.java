package leetcode.stack;

import java.util.Stack;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N962maxWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int len = A.length;

        for (int i = 0; i < len; i++){
            if (stack.isEmpty() || A[stack.peek()] >= A[i]){
                stack.push(i);
            }
        }
//        System.out.println(stack);
        int ans = 0;

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N962maxWidthRamp s = new N962maxWidthRamp();

        System.out.println(s.maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(s.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
}
