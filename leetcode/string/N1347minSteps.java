package leetcode.string;

/**
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 *
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 *
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 *
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 *
 * 输出：s = "friend", t = "family"
 * 输出：4
 *
 * 提示：
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s 和 t 只包含小写英文字母
 */
public class N1347minSteps {
    public int minSteps(String s, String t) {
        int[][] c = new int[26][2];

        for (char c1: s.toCharArray()){
            c[c1 - 'a'][0]++;
        }

        for (char c2: t.toCharArray()){
            c[c2 - 'a'][1]++;
        }

        int sum = 0;
//        System.out.println(Arrays.deepToString(c));
        for (int i = 0; i < 26; i++){
            sum += Math.abs(c[i][0] - c[i][1]);
        }

//        System.out.println(sum);

        return sum / 2;
    }

    public static void main(String[] args) {
        N1347minSteps s = new N1347minSteps();
        System.out.println(s.minSteps("bab", "aba"));  // 1
        System.out.println(s.minSteps("leetcode", "practice")); // 5
        System.out.println(s.minSteps("anagram", "mangaar")); // 0
        System.out.println(s.minSteps("xxyyzz", "xxyyzz")); // 0
        System.out.println(s.minSteps("friend", "family")); // 4
    }
}
