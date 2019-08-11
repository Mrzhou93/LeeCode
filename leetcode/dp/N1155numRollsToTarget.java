package leetcode.dp;

import java.util.Arrays;

/**
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 *
 * 示例 1：
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 *
 * 示例 2：
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 *
 * 示例 3：
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 *
 * 示例 4：
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 *
 * 示例 5：
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 *
 * 提示：
 *
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 */

public class N1155numRollsToTarget {

    int DDD = 1000000007;

    public int numRollsToTarget(int d, int f, int target){
        int dp[][] = new int[d + 1][target + 1];

        dp[0][0] = 1;

        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= d; i++){
            for (int j = 1; j <= f; j++){
                for (int k = j; k <= target; k++){
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % DDD;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[d][target];
    }

//    boolean[] visited;
//    int ans;
//    int f;
//    int d;
//    int DDD = 1000000007;
//
//    public int numRollsToTarget(int d, int f, int target) {
//         visited = new boolean[d];
//         ans = 0;
//         this.f = f;
//         this.d = d;
//
//         backTraceing(target, 0);
//
//         return ans;
//    }
//
//    public void backTraceing(int target, int index){  // 严重超时
//        if (target == 0){
//            ans++;
//            ans = ans % DDD;
//            return;
//        }
//
//        if (target < 0)
//            return;
//
//        for (int i = index; i < d; i++){
//            if (!visited[i]){
//                visited[i] = true;
//
//                for (int j = 1; j <= f; j++){
//                    int newtarget = target - j;
//                    if (newtarget < 0)
//                        break;
//                    backTraceing(newtarget, i + 1);
//
//                }
//
//                visited[i] = false;
//            }
//        }
//
//    }

    public static void main(String[] args) {
        N1155numRollsToTarget s = new N1155numRollsToTarget();

        System.out.println(s.numRollsToTarget(1, 6, 3));
        System.out.println(s.numRollsToTarget(2, 6, 7));
        System.out.println(s.numRollsToTarget(2, 5, 10));
        System.out.println(s.numRollsToTarget(1, 2, 3));
        System.out.println(s.numRollsToTarget(30, 30, 500));
//        System.out.println(s.numRollsToTarget(3, 6, 7));
    }
}
