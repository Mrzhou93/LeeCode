//package leetcode;
//
//import java.util.*;
//
///**
// * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// *
// * 每次转换只能改变一个字母。
// * 转换过程中的中间单词必须是字典中的单词。
// * 说明:
// *
// * 如果不存在这样的转换序列，返回 0。
// * 所有单词具有相同的长度。
// * 所有单词只由小写字母组成。
// * 字典中不存在重复的单词。
// * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
// * 示例 1:
// *
// * 输入:
// * beginWord = "hit",
// * endWord = "cog",
// * wordList = ["hot","dot","dog","lot","log","cog"]
// *
// * 输出: 5
// *
// * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// *      返回它的长度 5。
// * 示例 2:
// *
// * 输入:
// * beginWord = "hit"
// * endWord = "cog"
// * wordList = ["hot","dot","dog","lot","log"]
// *
// * 输出: 0
// *
// * 解释: endWord "cog" 不在字典中，所以无法进行转换。
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/word-ladder
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//
//public class N127ladderLength {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        int L = beginWord.length();
//
//        Map<String, ArrayList<String>> allComDict = new HashMap<>();
//
//        wordList.forEach(word -> {
//            for (int i = 0; i < L; i++){
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//                ArrayList<String> transformations = allComDict.getOrDefault(newWord, new ArrayList<>());
//                transformations.add(word);
//                allComDict.put(newWord, transformations);
//            }
//        });
//
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        ((LinkedList<Pair<String, Integer>>) queue).add(new Pair<>(beginWord, 1));
//
//        HashMap<String, Boolean> visited = new HashMap<>();
//        visited.put(beginWord, true);
//
//        while (!queue.isEmpty()){
//            Pair<String, Integer> node = queue.remove();
//            String word = node.getKey();
//
//            int level = node.getValue();
//            for (int i = 0; i < L; i++){
//                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
//
//                for (String adjacentWord: allComDict.getOrDefault(newWord, new ArrayList<>())){
//                    if (adjacentWord.equals(endWord)){
//                        return level + 1;
//                    }
//
//                    if (!visited.containsKey(adjacentWord)){
//                        visited.put(adjacentWord, true);
//                        ((LinkedList<Pair<String, Integer>>) queue).add(new Pair<>(adjacentWord, level + 1));
//                    }
//                }
//            }
//        }
//
//        return 0;
//    }
//
//    public static void main(String[] args){
//        N127ladderLength s = new N127ladderLength();
//
//        List<String> list = new ArrayList<>();
//        list.add("hot");
//        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
//        System.out.println(s.ladderLength("hit", "cog", list));
//    }
//}
