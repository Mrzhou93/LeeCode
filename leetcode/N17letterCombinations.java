package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * */

public class N17letterCombinations {

    public List<String> letterCombinations(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        tree(digits, dict, res, "");
        return res;
    }

    private void tree(String digits, String[] dict, List<String> res, String s) {
        if (digits.isEmpty()) {
            if (!s.isEmpty()) {
                res.add(s);
            }
            return;
        }
        int i = digits.charAt(0) - '0';
        for (char c : dict[i].toCharArray()) {
            tree(digits.substring(1), dict, res, s + c);
        }

    }

    public static void main(String[] args){
        N17letterCombinations s= new N17letterCombinations();

        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations(""));
    }
}
