package leetcode;

import java.util.HashSet;
import java.util.Set;

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

        System.out.println(n1);
        System.out.println(n2);

        int[] result = new int[n2.size()];
        int k = 0;

        for (int num: n2){
            result[k++] = num;
            System.out.println("1"+num);
        }

        return result;
    }



    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        N349intersection s = new N349intersection();

        System.out.println(s.intersection(nums1, nums2));
        System.out.println(s.intersection(nums1, nums2));
    }
}
