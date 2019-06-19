package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N279PerfectSquare {

    public int numSquares(int n){
        if (n == 0)
            return 0;

        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[n];
        queue.add(0);

        visited[0] = 1;
        int step = 0;

        while(!queue.isEmpty()){
            step ++;
            int size = queue.size();

            for (int i = 0; i< size; i++){
                int current = queue.peek();
                for (int j = 1; ; j++){
                    int total = current + j * j;

                    if(total > n)
                        break;
                    else if (total == n)
                        return step;

                    if(visited[total] == 0){
                        visited[total] = 1;
                        queue.offer(total);
                    }
                }
                queue.remove();
            }
        }
        return -1;
    }

    public int numSquares1(int n){
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

//        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    public static void main(String[] args){
        N279PerfectSquare s = new N279PerfectSquare();
        System.out.println(s.numSquares1(12));
    }
}
