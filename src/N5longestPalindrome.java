package src;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 如果一个字符串是回文字符串，那么这个字符串左右各加一个相同的元素之后，新的字符串也是回文字符串。
 *
 *
 * */

class N5longestPalindrome {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i< s.length(); i++){
            for (int j = i; j >=0; j--){
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]) ){
                    dp[i][j] = true;
                }
                if (i - j + 1 > maxLength && dp[i][j]){
                    maxLength = i - j + 1;
                    startIndex = j;
                    endIndex = i + 1;
                }
            }
        }
        return s.substring(startIndex, endIndex);
    }
}
