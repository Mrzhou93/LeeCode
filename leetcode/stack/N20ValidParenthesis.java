package leetcode.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */

class N20ValidParenthesis {
    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){

            char tempChar = s.charAt(i);

            if ( tempChar=='(' || tempChar == '[' || tempChar == '{') {
                stack.push(tempChar);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.peek();
                if ((topChar == '(' && tempChar==')') || (topChar=='[' && tempChar == ']') ||
                        (topChar == '{' && tempChar == '}')){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args){
        String s1 = "(([]){})";
        String s2 = "[()]";
        String s3 = "{[)}";

        N20ValidParenthesis s = new N20ValidParenthesis();
        System.out.println(s.isValid(s1));
        System.out.println(s.isValid(s2));
        System.out.println(s.isValid(s3));
    }
}
