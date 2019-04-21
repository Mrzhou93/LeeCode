package leetcode;

/***
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

class N70climbStairs {
    public int climbStairs1(int n) {  // 时间复杂度过高
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        else if(n > 2)
            return climbStairs1(n - 1) + climbStairs1(n - 2);

        return 0;
    }

    public int climbStairs(int n){      // 空间换时间，DP
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int dp1 = 1;
        int dp2 = 2;
        int res = 0;
        for (int i = 3; i<=n; i++){
            res = dp1 + dp2;
            dp1 = dp2;
            dp2 = res;
        }

        return res;
    }

    public static void main(String[] args){
        N70climbStairs s = new N70climbStairs();
        System.out.println(s.climbStairs(2));
//        System.out.println(s.climbStairs(3));
//        System.out.println(s.climbStairs(43));
    }
}
