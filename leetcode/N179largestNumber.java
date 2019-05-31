package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

public class N179largestNumber {
    public String largestNumber(int[] nums){
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareTo(o1, o2);
            }
        });

        for (int num: nums){
            pq.add(Integer.toString(num));
        }

//        System.out.println(pq.toString());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            sb.append(pq.poll());
//            System.out.println(pq.toString());
        }

        String ans = sb.toString();
        while (ans.startsWith("0") && ans.length() > 1){
            ans = ans.substring(1);
        }
        return ans;
    }

    public int compareTo(String s1, String s2){
        String s12 = s1 + s2;
        String s21 = s2 + s1;

        return s21.compareTo(s12);
    }

    public static void main(String[] args){
        N179largestNumber s = new N179largestNumber();

        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(s.largestNumber(new int[]{0, 0}));
    }
}
