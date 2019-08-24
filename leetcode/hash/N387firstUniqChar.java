package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N387firstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                set.add(s.charAt(i));
            else {
                map.put(s.charAt(i), i);
            }
        }

        System.out.println(map);

        for (int i = 0; i<s.length(); i++){
            if (!set.contains(s.charAt(i)))
                return map.get(s.charAt(i));
        }
        return -1;
    }

    public static void main(String[] args) {
        N387firstUniqChar s = new N387firstUniqChar();

        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
    }
}
