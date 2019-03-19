package src;

class climbStairs {
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
        climbStairs s = new climbStairs();
//        System.out.println(s.climbStairs(2));
//        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(43));
    }
}
