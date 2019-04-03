package src;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * */


class N91numDecodings {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i< s.length(); i++){
            if (s.charAt(i) != '0')
                dp[i] = dp[i - 1];

            if ((s.charAt(i-1) == '1') ||
                    (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {  // 10 ~ 26
                if (i >= 2)
                    dp[i] += dp[i - 2];
                else
                    dp[i] += 1;
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args){
        N91numDecodings s= new N91numDecodings();
        System.out.println(s.numDecodings("2"));        // 1
        System.out.println(s.numDecodings("22"));       // 2
        System.out.println(s.numDecodings("221"));      // 3
        System.out.println(s.numDecodings("2212"));     // 5
        System.out.println(s.numDecodings("2227"));     // 3
        System.out.println(s.numDecodings("2220"));     // 2
        System.out.println(s.numDecodings("226"));      // 3
        System.out.println(s.numDecodings("0"));        // 0
        System.out.println(s.numDecodings("10"));       // 1        !!
        System.out.println(s.numDecodings("012"));      // 0
        System.out.println(s.numDecodings("100"));      // 0       !!
        System.out.println(s.numDecodings("101"));      // 1       !!
        System.out.println(s.numDecodings("27"));       // 1
    }
}
