package leetcode.string;

import java.util.Arrays;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 */

public class N1160countCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] cc = new int[26];
        int[] ccc = new int[26];
        int ans = 0;

        for (char c: chars.toCharArray()){
            cc[c - 'a']++;
        }

        System.out.println(Arrays.toString(cc));

        for (String word: words) {
            ccc = cc.clone();
            int i = 0;
            int len = word.length();
            char[] ww = word.toCharArray();

            while (i < len){
                if (ccc[ww[i] - 'a'] > 0){
                    ccc[ww[i] - 'a']--;
                    i++;
                } else {
                    break;
                }
            }
            if (i == len){
                ans += i;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        N1160countCharacters s = new N1160countCharacters();

        System.out.println(s.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        System.out.println(s.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyrl"));
    }
}
