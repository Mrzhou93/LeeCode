package leetcode;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * */

class N402removeKdigits {

    public String removeKdigits(String num, int k){
        if (k == num.length())
            return "0";

        int dig = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0){
                k--;
                top--;
            }
            stack[top++] = c;
        }

        int offset = 0;
        while (offset < dig && stack[offset] == '0')
            offset++;

        return offset==dig? "0": new String(stack, offset, dig-offset);
    }

    public String removeKdigits1(String num, int k) {

        if (num.charAt(0) == '0' && !num.equals("0"))
            return removeKdigits1(num.substring(1), k);

        if (num.length() == k)
            return "0";

        if (k > 0) {
            int i = 0;
            while (i + 1 < num.length() && num.charAt(i) <= num.charAt(i + 1))
                i++;

            return removeKdigits1(num.substring(0, i) + num.substring(i + 1), k-1);
        }
        return num;
    }

    public static void main(String [] args){
        N402removeKdigits s = new N402removeKdigits();

        System.out.println(s.removeKdigits("1432219", 3).equals("1219"));
        System.out.println(s.removeKdigits("10200", 1).equals("200"));
        System.out.println(s.removeKdigits("1000200", 1).equals("200"));
        System.out.println(s.removeKdigits("10", 2).equals("0"));
        System.out.println(s.removeKdigits("10", 1).equals("0"));
        System.out.println(s.removeKdigits("112", 1).equals("11"));
    }
}
