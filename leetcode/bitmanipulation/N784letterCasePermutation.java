package leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * */

public class N784letterCasePermutation{
    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        res.add(S);

        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z'){
                if ((c >= 'a'))
                    c -= 32;
                else
                    c += 32;

                for (int j = 0; j < res.size(); j++){
                    String t = res.get(j).substring(0, i) + c + res.get(j).substring(i + 1, S.length());
                    if (!res.contains(t))
                        res.add(t);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        N784letterCasePermutation s = new N784letterCasePermutation();

        System.out.println(s.letterCasePermutation("a1b2"));
        System.out.println(s.letterCasePermutation("3z4"));
        System.out.println(s.letterCasePermutation("12345"));
    }
}
