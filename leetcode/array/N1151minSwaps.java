package leetcode.array;

/**
 * 给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,1,0,1]
 * 输出：1
 * 解释：
 * 有三种可能的方法可以把所有的 1 组合在一起：
 * [1,1,1,0,0]，交换 1 次；
 * [0,1,1,1,0]，交换 2 次；
 * [0,0,1,1,1]，交换 1 次。
 * 所以最少的交换次数为 1。
 * 示例 2：
 *
 * 输入：[0,0,0,1,0]
 * 输出：0
 * 解释：
 * 由于数组中只有一个 1，所以不需要交换。
 * 示例 3：
 *
 * 输入：[1,0,1,0,1,0,0,1,1,0,1]
 * 输出：3
 * 解释：
 * 交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
 *
 *
 * 提示：
 *
 * 1 <= data.length <= 10^5
 * 0 <= data[i] <= 1
 */

public class N1151minSwaps {
    public int minSwaps(int[] data) {
        int len = data.length;
        int[] helper = new int[len + 1];

        for (int i = 1; i <= len; i++){
            helper[i] = helper[i - 1] + data[i - 1];
        }

        int count = helper[len];
        int ans = count;
        for (int i = count; i <= len; i++){
            ans = Math.min(ans, count - (helper[i] - helper[i - count]));
        }

//        System.out.println(Arrays.toString(helper));

        return ans;
    }

    public static void main(String[] args) {
        N1151minSwaps s = new N1151minSwaps();

        System.out.println(s.minSwaps(new int[]{1,0,1,0,1}));
        System.out.println(s.minSwaps(new int[]{0,0,0,1,0}));
        System.out.println(s.minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
        System.out.println(s.minSwaps(new int[]{0,0,1,1,1}));
        System.out.println(s.minSwaps(new int[]{1,1,1,0,0}));
        System.out.println(s.minSwaps(new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1}));
    }
}
