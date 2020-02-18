package leetcode;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */

public class N5189maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        String balloon = "balloon";

        for (int i = 0; i < text.length(); i++){
            chars[text.charAt(i) - 'a']++;
        }

        int ans = 0;

        while (chars['b' - 'a']-- > 0){
            chars['a' - 'a']--;
            if (chars['a' - 'a'] < 0){
                break;
            }
            chars['l' - 'a']--;
            chars['l' - 'a']--;

            if (chars['l' - 'a'] < 0){
                break;
            }

            chars['o' - 'a']--;
            chars['o' - 'a']--;
            if (chars['o' - 'a'] < 0){
                break;
            }
            chars['n' - 'a']--;
            if (chars['o' - 'a'] < 0){
                break;
            }

            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        N5189maxNumberOfBalloons s = new N5189maxNumberOfBalloons();

        System.out.println(s.maxNumberOfBalloons("nlaebolko"));
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(s.maxNumberOfBalloons("leetcode"));
    }
}
