package leetcode.trie;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class WordDictionary {
    private Trie root;

    private class Trie {
        boolean isWord;
        Trie[] next;

        public Trie() {
            next = new Trie[26];
        }
    }

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        char[] chs = word.toCharArray();
        for(char c : chs){
            Trie next = cur.next[c - 'a'];
            if(next == null){
                cur.next[c - 'a'] = new Trie();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(Trie root, String word, int index) {
        if (index == word.length()) {
            return root.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            root = root.next[c-'a'];
            if (root == null) {
                return false;
            }
            return search(root, word, index + 1);
        } else {
            Trie[] nextNodes = root.next;
            for (int i = 0; i < 26; i++) {
                if (nextNodes[i] != null &&
                        search(nextNodes[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary s = new WordDictionary();

        s.addWord("bad");
        s.addWord("dad");
        s.addWord("mad");
        System.out.println(s.search("pad"));
        System.out.println(s.search("bad"));
        System.out.println(s.search(".ad"));
        System.out.println(s.search("b.."));
    }
}
