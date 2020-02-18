package leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 
 * 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 * 注:
 *
 * 输入只包含小写字母。
 * 1 <= 字典单词数 <=1000
 * 1 <=  句中词语数 <= 1000
 * 1 <= 词根长度 <= 100
 * 1 <= 句中词语长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N648replaceWords {
    class TrieNode {
        boolean isLeaf;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dict, String sentence) {
        add(dict);
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : sentence.split(" ")){
            int index = search(s);
            String str = index > 0 ? s.substring(0, index) : s;
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private int search(String s) {
        TrieNode node = root;
        int index = 0;
        for(char c : s.toCharArray()){
            if(node.children[c-'a'] == null && !node.isLeaf) {
                return 0;
            }
            if(node.isLeaf) {
                return index;
            }
            index++;
            node = node.children[c-'a'];
        }
        return index;
    }

    private void add(List<String> dict) {
        for(String d : dict){
            TrieNode node = root;
            for (char c : d.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isLeaf = true;
        }
    }


    public static void main(String[] args) {
        N648replaceWords s = new N648replaceWords();

        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");

        System.out.println(s.replaceWords(list, "the cattle was rattled by the battery"));
    }
}
