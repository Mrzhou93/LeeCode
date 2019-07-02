package leetcode.trie;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。
 * 如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MapSum {

    private int sum;
    private MapSum[] tries;

    public MapSum(){
        tries = new MapSum[26];
        sum = 0;
    }

    public void insert(String key, int val){
        char[] chars = key.toCharArray();
        MapSum node = this;
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (node.tries[c - 'a'] == null){
                node.tries[c - 'a'] = new MapSum();
            }
            node.sum += val;
            node = node.tries[c - 'a'];
        }
    }

    public int sum(String prefix){
        char[] chars = prefix.toCharArray();
        MapSum node = this;
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (node.tries[c - 'a'] == null){
                return 0;
            } else {
                node = node.tries[c - 'a'];
            }
            if (i == chars.length - 1)
                return node.sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        MapSum s = new MapSum();

        s.insert("apple", 3);
        System.out.println(s.sum("ap"));
        s.insert("app", 2);
        System.out.println(s.sum("ap"));
    }

}
