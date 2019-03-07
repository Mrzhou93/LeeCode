package src;

import java.util.*;

class Nintersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // value, count 统计相同的元素有多少个
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums1.length; i++){
            map.putIfAbsent(nums1[i], 0);
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }

        for (int j =0 ; j < nums2.length; j++){
            //如果nums2里面有和nums1相同的元素
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                result.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int i=0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
