package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
 *
 * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。 由于施工需要，你必须将所有棒材连接成一根。
 *
 * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sticks = [2,4,3]
 * 输出：14
 * 解释：先将 2 和 3 连接成 5，花费 5；再将 5 和 4 连接成 9；总花费为 14。
 * 示例 2：
 *
 * 输入：sticks = [1,8,3,5]
 * 输出：30
 *
 *
 * 提示：
 *
 * 1 <= sticks.length <= 10^4
 * 1 <= sticks[i] <= 10^4
 */

public class N5062connectSticks {
    public int connectSticks(int[] sticks) {
        Arrays.sort(sticks);
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick: sticks){
            pq.add(stick);
        }

        while (pq.size() >= 2){
            int val = pq.poll() + pq.poll();
            ans += val;
            pq.add(val);
        }
        return ans;
    }

    public static void main(String[] args) {
        N5062connectSticks s = new N5062connectSticks();

        System.out.println(s.connectSticks(new int[]{2, 4, 3}));
        System.out.println(s.connectSticks(new int[]{1, 8, 3, 5}));
        System.out.println(s.connectSticks(new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009}));
    }
}
