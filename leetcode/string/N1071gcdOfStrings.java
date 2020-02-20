package leetcode.string;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */

public class N1071gcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        while (!str1.equals("") && !str2.equals("")){
            if (str2.length() > str1.length()){
                String tmp = str1;
                str1 = str2;
                str2 = tmp;
            }

            if (str1.substring(0, str2.length()).equals(str2)){
                str1 = str1.substring(str2.length());
            }else{
                return "";
            }
        }
        return str2;
    }

    public static void main(String[] args){
        N1071gcdOfStrings s = new N1071gcdOfStrings();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(s.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(s.gcdOfStrings("LEET", "CODE"));
    }
}
