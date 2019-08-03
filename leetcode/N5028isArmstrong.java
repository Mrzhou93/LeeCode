package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 *
 * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：153
 * 输出：true
 * 示例：
 * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 * 示例 2：
 *
 * 输入：123
 * 输出：false
 * 解释：
 * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^8
 */

public class N5028isArmstrong {
    public boolean isArmstrong(int N) {
        List<Integer> list = new ArrayList<>();
        int m = N;

        while (m != 0){
            list.add(m % 10);
            m = m / 10;
        }

        int size = list.size();
        int[] dp = cal(size);

        int res = 0;
        for (int n: list){
            res += dp[n];
        }
        System.out.println(N);
        System.out.println(size);
        System.out.println(Arrays.toString(dp));
        System.out.println(res);
        return res == N;
    }

    public int[] cal(int time){
        int[] res = new int[10];

        for (int i = 0; i < 10; i++){
            res[i] = i;
        }

        for (int num = 0; num < 10; num++){
            for (int i = 1; i < time; i++){
                res[num] *= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N5028isArmstrong s = new N5028isArmstrong();
        System.out.println(s.isArmstrong(153));
        System.out.println(s.isArmstrong(123));
        System.out.println(s.isArmstrong(1));
//        System.out.println(Arrays.toString(s.cal(2)));
//        System.out.println(Arrays.toString(s.cal(4)));
//        System.out.println(Arrays.toString(s.cal(5)));
    }
}
