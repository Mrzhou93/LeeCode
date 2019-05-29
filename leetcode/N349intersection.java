package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

class N349intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();

        for(int num: nums1){
            n1.add(num);
        }

        for (int num: nums2){
            if (n1.contains(num))
                n2.add(num);
        }

        int[] result = new int[n2.size()];
        int k = 0;

        for (int num: n2){
            result[k++] = num;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        N349intersection s = new N349intersection();

        System.out.println(Arrays.toString(s.intersection(nums1, nums2)));
    }
}
