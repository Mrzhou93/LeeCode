package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 *
 * 提示：
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 */

public class N5168numSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] w = new int[11];

        for (int i = 0; i < words.length; i++){
            w[f(words[i])]++;
        }
        for (int i = 1; i < w.length; i++){
            w[i] += w[i - 1];
        }
        for (int i = 0; i < queries.length; i++){
            ans[i] = w[10] - w[f(queries[i])];
        }
        return ans;
    }

    public int f(String str){
        int[] list = new int[26];
        for (int i = 0; i < str.length(); i++){
            list[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (list[i] != 0){
                return list[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        N5168numSmallerByFrequency s =new N5168numSmallerByFrequency();

        System.out.println(
                Arrays.toString(s.numSmallerByFrequency(
                        new String[]{"cbd"}, new String[]{"zaaaz"})));

        System.out.println(
                Arrays.toString(s.numSmallerByFrequency(
                        new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }
}
