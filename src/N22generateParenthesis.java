package src;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * */

public class N22generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        tree(n, 0, 0, "", res);

        return res;
    }

    private void tree(int max, int open, int close, String s, List<String> res) {   // m记录"("有多少个
        if (s.length() == max * 2) {
            res.add(s);
            return;
        }
        if (open < max) {
            tree(max, open + 1, close, s + "(", res);
        }
        if (close < open){
            tree(max, open, close + 1, s + ")", res);
        }
    }

    public static void main(String[] args){
        N22generateParenthesis s = new N22generateParenthesis();

        System.out.println(s.generateParenthesis(3));
    }
}
