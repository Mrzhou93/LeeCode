package leetcode;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

public class N242isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        for (int i = 0; i < ss.length; i++){
            if (ss[i] != tt[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        N242isAnagram s = new N242isAnagram();

        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
