package leetcode.bitmanipulation;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * */

public class N338countBits {
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];

        for (int i = 0; i <= num / 2; i++){
            dp[i * 2] = dp[i];
            if (i * 2 + 1 <= num)
                dp[i * 2 + 1] = dp[i] + 1;
        }
        return dp;
    }

    public static void main(String[] args){
        System.out.println(new N338countBits().countBits(11));
    }
}
