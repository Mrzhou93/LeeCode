package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 */

public class N5109reverseParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> res = new Stack<>();
        Deque<Character> tmp = new LinkedList<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c != ')'){
                res.add(c);
            } else {
                while ('(' != res.peek()){
                    tmp.addLast(res.pop());
                }
                res.pop();
                while (!tmp.isEmpty()){
                    res.add(tmp.removeFirst());
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = res.size() - 1; i >= 0; i--){
            sb.append(res.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        N5109reverseParentheses s = new N5109reverseParentheses();

        System.out.println(s.reverseParentheses(("(abcd)")));
        System.out.println(s.reverseParentheses(("(u(love)i)")));
        System.out.println(s.reverseParentheses(("(ed(et(oc))el)")));
        System.out.println(s.reverseParentheses(("a(bcdefghijkl(mno)p)q")));

    }
}
