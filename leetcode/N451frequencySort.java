package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */

public class N451frequencySort {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()){
            char key = pq.peek().getKey();
            int num = pq.remove().getValue();
            while (num > 0){
                num--;
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){

        N451frequencySort s = new N451frequencySort();
        System.out.println(s.frequencySort("Aabb"));
        System.out.println(s.frequencySort("tree"));
    }
}
